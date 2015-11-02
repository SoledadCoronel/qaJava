<?php

namespace GoIntegro\Context;

use Symfony\Component\HttpKernel\KernelInterface;
use Behat\Symfony2Extension\Context\KernelAwareInterface;
use Behat\MinkExtension\Context\MinkContext;

use Behat\Behat\Context\BehatContext,
    Behat\Behat\Exception\PendingException;
use Behat\Gherkin\Node\PyStringNode,
    Behat\Gherkin\Node\TableNode;

use Doctrine\Common\DataFixtures\Purger\ORMPurger;
use Doctrine\Common\DataFixtures\Executor\ORMExecutor;
use Symfony\Bridge\Doctrine\DataFixtures\ContainerAwareLoader;

use Behat\CommonContexts\DoctrineFixturesContext;
use Behat\CommonContexts\SymfonyDoctrineContext;

use Behat\Mink\Exception\ElementNotFoundException;

use Symfony\Bundle\FrameworkBundle\Console\Application,
    Symfony\Component\Console\Input\ArrayInput;

use Exception;

/**
 * Feature context.
 */
class FeatureContext extends MinkContext
                  implements KernelAwareInterface
{
    private $kernel;
    private $parameters;

    const BEHAT_AJAX_TIMEOUT = 30000; // 30"

    /**
     * Initializes context with parameters from behat.yml.
     *
     * @param array $parameters
     */
    public function __construct(array $parameters)
    {
        $this->parameters = $parameters;

        // To use DoctrineFixturesContext in your steps
        $this->useContext('doctrine_fixtures_context', new DoctrineFixturesContext());
    }

    /**
     * Sets HttpKernel instance.
     * This method will be automatically called by Symfony2Extension ContextInitializer.
     *
     * @param KernelInterface $kernel
     */
    public function setKernel(KernelInterface $kernel)
    {
        $this->kernel = $kernel;
    }

    public function getKernel()
    {
        return $this->kernel;
    }

    /**
     * @BeforeScenario
     */
    public function resizeExplorerWindow()
    {
        try{
            $this->getSession()->getDriver()->resizeWindow(1600,1200);
        } catch (\Exception $e) {
            return false;
        }
    }

    /**
     * @AfterScenario
     */
    public function refreshDriver()
    {
        $this->getSession()->getDriver()->stop();
    }

    /**
     * Ejecuta las fixtures que se pasan en $fixtures
     * @param array $fixtures
     */
    protected function runDoctrineDataFixtures($fixtures) {
        $container = $this->kernel->getContainer();
        $loader = new ContainerAwareLoader($container);

        $this->getMainContext()
            ->getSubcontext('doctrine_fixtures_context')
            ->loadFixtureClasses($loader, $fixtures);

        $em = $container->get('doctrine.orm.entity_manager');
        $purger = new ORMPurger();
        $executor = new ORMExecutor($em, $purger);

        if ($container->getParameter('search_engine.index_documents_testing') === TRUE) {
            $solrService = $container->get('gointegro.solr');
            $solrService->clearIndex();
        }

        $executor->purge();
        $executor->execute($loader->getFixtures(), true);
    }

    /**
     * Index existent data in SOLR
     *
     * @BeforeScenario @Solr
     */
    public function indexExistentData()
    {
        $container = $this->kernel->getContainer();
        if ($container->getParameter('search_engine.index_documents_testing') === TRUE) {
            
            $this->runTask(array('command' => 'gointegro:search:index-existent-data'));           
        }
    }

    /*
     * Pasos comunes. (Esto no es un docblock.)
     * @todo Mover a un rasgo.
     */

    public function iAmOnHomepage()
    {
        $this->getSession()->visit($this->locatePath('/?_lang=es'));
    }

    /**
     * @Given /^espero (\d+)$/
     * @deprecated
     */
    public function espero($segundos)
    {
        $this->getSession()->wait($segundos);
    }

    /**
     * @Given /^espero "([^"]*)" segundos$/
     * @deprecated
     */
    public function esperoSegundos($segundos)
    {
        $this->espero($segundos);
    }

    /**
     * @when /^confirmo el popup$/
     */
    public function confirmoPopup()
    {
        $this->getSession()->getDriver()->getWebDriverSession()->accept_alert();
    }


    /**
     * @Then /^debe cambiar la URL$/
     * @Given /^espero a que cambie la URL$/
     */
    public function esperoAQueCambieLaUrl()
    {
        $currentUrl = $this->getSession()->getDriver()->getCurrentUrl();
        $start = 1000 * microtime(true);
        $end = $start + self::BEHAT_AJAX_TIMEOUT;
        while (1000 * microtime(true) < $end && $currentUrl==$this->getSession()->getDriver()->getCurrentUrl()) {
            sleep(1);
        }
        if (1000 * microtime(true) >= $end) {
            $this->getSession()->getDriver()->stop();
            throw new Exception("La URL no cambió");
        }
    }

    /**
     * @Given /^espero a que aparezca el contenedor dinámico "([^"]*)" por ([0-9]+) segundos$/
     * @Given /^debe aparecer el contenedor dinámico "([^"]*)" por ([0-9]+) segundos$/
     */
    private function esperoAQueAparezcaElContenedorDinamicoPorSegundos($container, $seconds)
    {
        $script = "return $('$container').length > 0";
        $start = 1000 * microtime(true);
        $end = $start + $seconds * 1000;
        while (1000 * microtime(true) < $end && !$this->getSession()->evaluateScript($script)) {
            sleep(1);
        }
        if (1000 * microtime(true) >= $end) {
            $this->getSession()->getDriver()->stop();
            throw new Exception("El elemento aún no está visible");
        }
    }

    /**
     * @Given /^espero a que aparezca el contenedor dinámico "([^"]*)"$/
     * @Given /^debe aparecer el contenedor dinámico "([^"]*)"$/
     */
    public function esperoAQueAparezcaElContenedorDinamico($container)
    {
        $this->esperoAQueAparezcaElContenedorDinamicoPorSegundos(
            $container, self::BEHAT_AJAX_TIMEOUT / 1000
        );
    }

    /**
     * @Then /^debe aparecer el contenido dinámico "([^"]*)" en "([^"]*)" por ([0-9]+) segundos$/
     * @Given /^espero a que aparezca el contenido dinámico "([^"]*)" en "([^"]*)" por ([0-9]+) segundos$/
     */
    public function esperoAQueAparezcaElContenidoDinamicoEnPorSegundos($content, $container, $seconds)
    {
        $script = "return $(\"$container:contains(\\\"$content\\\")\").length > 0";
        $start = 1000 * microtime(true);
        $end = $start + $seconds * 1000;

        while (1000 * microtime(true) < $end && !$this->getSession()->evaluateScript($script)) {
            sleep(1);
        }

        if (1000 * microtime(true) >= $end) {
            $this->getSession()->getDriver()->stop();
            throw new Exception("El elemento ".$content." aún no está visible");
        }
    }

    /**
     * @Then /^debe aparecer el contenido dinámico "([^"]*)" en "([^"]*)"$/
     * @Given /^espero a que aparezca el contenido dinámico "([^"]*)" en "([^"]*)"$/
     */
    public function esperoAQueAparezcaElContenidoDinamicoEn($content, $container)
    {
        $this->esperoAQueAparezcaElContenidoDinamicoEnPorSegundos(
            $content, $container, self::BEHAT_AJAX_TIMEOUT / 1000
        );
    }

    /**
     * @Given /^espero a que desaparezca el contenido dinámico "([^"]*)" en "([^"]*)"$/
     * @Then /^debe desaparecer el contenido dinámico "([^"]*)" en  "([^"]*)"$/
     */
    public function esperoAQueDesaparezcaElContenidoDinamicoEn($content, $container)
    {
        $script = "return  $(\"$container:contains(\\\"$content\\\")\").length > 0 ";
        $start = 1000 * microtime(true);
        $end = $start + self::BEHAT_AJAX_TIMEOUT;
        while (1000 * microtime(true) < $end && $this->getSession()->evaluateScript($script)) {
            sleep(1);
        }
        if (1000 * microtime(true) >= $end) {
            $this->getSession()->getDriver()->stop();
            throw new Exception("El elemento aún esta visible");
        }
    }


    /**
     * @Then /^debe desaparecer "([^"]*)"$/
     * @Given /^espero a que desaparezca "([^"]*)"$/
     */
    public function debeDesaparecer($selector)
    {
        $element = $this->getSession()->getPage()->find('css', $selector);
        if (!empty($element)) {
            $start = 1000 * microtime(true);
            $end = $start + self::BEHAT_AJAX_TIMEOUT;
            while (1000 * microtime(true) < $end && $this->getSession()->getDriver()->isVisible($element->getXpath())) {
                sleep(1);
            }
            if (1000 * microtime(true) >= $end) {
                $this->getSession()->getDriver()->stop();
                throw new Exception("El elemento aún está visible");
            }
        } else {
            $this->getSession()->getDriver()->stop();
            throw new Exception("No existe elemento");
        }
    }

    /**
     * @Then /^debe aparecer "([^"]*)"$/
     * @Given /^espero a que aparezca "([^"]*)"$/
     */
    public function debeAparecer($selector)
    {
        $element = $this->getSession()->getPage()->find('css', $selector);
        if (!empty($element)) {
            $start = 1000 * microtime(true);
            $end = $start + self::BEHAT_AJAX_TIMEOUT;
            while (1000 * microtime(true) < $end && !$this->getSession()->getDriver()->isVisible($element->getXpath())) {
                sleep(1);
            }
            if (1000 * microtime(true) >= $end) {
                $this->getSession()->getDriver()->stop();
                throw new Exception("El elemento aún no está visible");
            }
        } else {
            $this->getSession()->getDriver()->stop();
            throw new Exception("No existe elemento");
        }
    }


    /**
     * @Given /^no debo ver el contenedor dinámico "([^"]*)"$/
     */
    public function noDeboVer($selector)
    {
        $element = $this->getSession()->getPage()->find('css', $selector);
        return empty($element) || !$this->getSession()->getDriver()->isVisible($element->getXpath());
    }

    /**
     * @Given /^relleno la fecha "([^"]*)" con la fecha actual$/
     */
    public function rellenoLaFechaConLaFechaActual($name)
    {
        $now = new \DateTime();
        $date = $now->format('d/m/Y');
        $this->rellenoLaFechaCon($name, $date);
    }

    /**
     * @Given /^relleno la fecha "([^"]*)" con "([^"]*)"$/
     */
    public function rellenoLaFechaCon($name, $value)
    {
        $this->getSession()->executeScript(
            "$(\"input[name='$name']\").val(\"$value\");"
        );
    }

    /**
     * @Given /^relleno "([^"]*)" con la fecha de hoy$/
     */
    public function rellenoConLaFechaDeHoy($name)
    {
        $script = <<<JS
            var date = new Date();
            date = date.getDate() + '/' + (date.getMonth() + 1) + '/' + date.getFullYear();
            $('input[name="{{NAME}}"]').val(date);
JS;
        $script = str_replace("{{NAME}}", $name, $script);
        $result = $this->getSession()->executeScript($script);
    }

    /**
     *
     * @Given /^relleno "([^"]*)" con la fecha de hoy en el año "([^"]*)"$/
     * @param string $selector Valid jquery selector
     * @param string $year
     */
    public function rellenoConLaFechaDeHoyOtroAno($selector, $year) {
        $now = new \DateTime();
        $date = $now->format('d') . '/' . $now->format('m') . '/' . $year;
        $this->rellenoLaFechaCon($selector, $date);
    }

    /**
     * @Given /^el campo "([^"]*)" debe estar vacio$/
     */
    public function elCampoDebeEstarVacio($field)
    {
        $script = "return $('*[name=$field]').val() != ''";
        $start = 1000 * microtime(true);
        $end = $start + self::BEHAT_AJAX_TIMEOUT;
        while (1000 * microtime(true) < $end && $this->getSession()->evaluateScript($script)) {
            sleep(1);
        }
        if (1000 * microtime(true) >= $end) {
            $this->getSession()->getDriver()->stop();
            throw new Exception("El elemento no esta vacio.");
        }
    }

    /**
     * Dispara el evento click utilizando jquery
     * esto permite hacer un click sobre cualquier
     * elemento no solo sobre links
     *
     * @Given /^hago click en "([^"]*)"$/
     * @Given /^hago clic en "([^"]*)"$/
     * @param string $selector Valid jquery selector
     *
     */
    public function hagoClickEn($selector)
    {
        $selector = str_replace('\'','"', $selector);

        $elementExists = $this->getSession()->evaluateScript("return $('{$selector}').length > 0");

        if (!$elementExists) {
            throw new Exception('No existe el selector ' . $selector);
        }

        $this->getSession()->executeScript("$('{$selector}').trigger('click');");
    }

    /**
     * Dispara el evento click utilizando jquery,
     * además para algunos casos es necesario
     * redireccionar al href del link
     * (sólo para <a></a>)
     *
     * @Given /^hago click y sigo "([^"]*)"$/
     * @Given /^hago clic y sigo "([^"]*)"$/
     * @param string $selector valid jquery selector
     *
     */
    public function hagoClickYSigo($selector)
    {
        $selector = str_replace('\'','"', $selector);

        $elementExists = $this->getSession()->evaluateScript("return $('{$selector}').length > 0");

        if (!$elementExists) {
            throw new Exception('No existe el selector ' . $selector);
        }

        $this->getSession()->executeScript("
            var link = $('{$selector}');
            link.trigger('click');
            window.location.href = link.prop('href');
        ");
    }

    /**
     * Permite interactuar con cualquier elemento que contenga un texto
     * específico y se encuentre dentro de otro con un determinado selector.
     *
     * @Given /^hago clic en el elemento "([^"]*)" que contiene el texto "([^"]*)"$/
     * @Given /^hago click en el elemento "([^"]*)" que contiene el texto "([^"]*)"$/
     *
     * @param string $selector
     * @param string $text
     */
    public function hagoClickElementoQueContieneTexto($selector, $text)
    {
        $selector = str_replace("'", '"', $selector);
        $text = str_replace("'", '"', $text);

        $selectorExists = $this->getSession()->evaluateScript(
            "return $('{$selector}').length > 0"
        );

        if (!$selectorExists) {
            throw new Exception("El selector $selector no fue encontrado.");
        }

        $script = <<<JS
            var element = $('{selector}').filter(function() {
                return $(this).text() == '{text}';
            });
            if (element.length > 0) {
                $(element).trigger('click');
                return true;
            }
            return;
JS;

        $script = str_replace('{selector}', $selector, $script);
        $script = str_replace('{text}', $text, $script);

        $result = $this->getSession()->evaluateScript($script);

        if (!$result) {
            throw new Exception("El texto \"$text\" no fue encontrado dentro de ningún elemento con el selector especificado.");
        }
    }


    /**
     * Permite agregar un tag a un elemento del tipo TagInput.
     *
     * @Given /^Agrego tag "([^"]*)" en el elemento "([^"]*)"$/
     * @Given /^agrego tag "([^"]*)" en el elemento "([^"]*)"$/
     *
     * @param string $tag
     * @param string $selector
     */
    public function agregoTag($tag, $selector)
    {
        $selector = str_replace("'", '"', $selector);
        $tag = str_replace("'", '"', $tag);

        $selectorExists = $this->getSession()->evaluateScript(
            "return $('{$selector}').length > 0"
        );

        if (!$selectorExists) {
            throw new Exception('No existe el selector ' . $selector);
        }

        $script = <<<JS
            var element = $('{selector}');
            element.tagit('createTag', '{tag}');
JS;
        $script = str_replace('{selector}', $selector, $script);
        $script = str_replace('{tag}', $tag, $script);

        $this->getSession()->executeScript($script);
    }

    /**
     * Permite rellenar un elemento específico con un determinado texto
     * y posteriormente simula la ejecución de un salto de línea.
     *
     * Nota: La versión 1.4.* de Mink no soporta la simulación de saltos
     * de línea en JavaScript.
     *
     * @Given /^relleno "([^"]*)" con "([^"]*)" y presiono enter$/
     *
     * @param string $field name|id|label
     * @param string $text
     */
    public function rellenoPresionoEnter($field, $text)
    {
        $node = $this->getSession()->getPage()->findField($field);

        if (null === $node) {
            throw new Exception($field . ' not found');
        }

        $node->setValue($text);

        $this->getSession()->getDriver()->focus($node->getXpath());

        $this->getSession()->getDriver()->keyDown($node->getXpath(), 13);
    }

    /**
     * @Given /^sigo el link "([^"]*)"$/
     */
    public function sigoLink($selector)
    {
        $selector = str_replace('\'','\\\'', $selector);
        $script = <<<JS
            var link = $("a:contains('{{SELECTOR}}'):visible:first");
            if (link.length > 0) {
                link.trigger("click");
                if (link.prop("href") && link.prop("href").length > 1) {
                    window.location.href = link.prop("href");
                }
                return true;
            } else {
                return false;
            }
JS;
        $script = str_replace("{{SELECTOR}}", $selector, $script);
        $result = $this->getSession()->evaluateScript($script);
        if (!$result) {
            throw new Exception('El link no existe o no es visible.');
        }
    }

    /**
     * @Given /^"([^"]*)" debe estar activo$/
     */
    public function debeEstarActivo($link)
    {
        $active = $this->getSession()->evaluateScript(
            "return $('a:contains(\"$link\"):first').parent().hasClass('active');"
        );
        if (!$active) {
            throw new \Exception("El elemento no existe o no está activo");
        }
    }

    /**
     * @Given /^debo ver la imagen "([^"]*)"$/
     */
    public function deboVerLaImagen($alt)
    {
        $deboVerLaImagen = $this->getSession()->evaluateScript(
            "return $('img[alt=\"$alt\"]').length > 0;"
        );

        if (!$deboVerLaImagen) {
            throw new \Exception("La imagen no existe");
        }
    }

    /**
     * @Given /^no debo ver la imagen "([^"]*)"$/
     */
    public function noDeboVerLaImagen($alt)
    {
        $imageExists = $this->getSession()->evaluateScript(
            "return $('img[alt=\"$alt\"]').length == 0;"
        );

        if ($imageExists) {
            throw new \Exception("La imagen existe");
        }
    }

    /**
     * @Given /^muevo "([^"]*)" a "([^"]*)"$/
     * @Given /^muevo "([^"]*)" a "([^"]*)" en "([^"]*)"$/
     */
    public function muevoA($item, $target, $context = null)
    {
        $script = <<<JS
requirejs(['jquery-simulate'], function() {
    var target = $("{{CONTEXT}}*").filter(function(index) {
        return $(this).text() === "{{TARGET}}";
    });
    var item = $("{{CONTEXT}}*").filter(function(index) {
        return $(this).text() === "{{ITEM}}";
    });
    var offset = target.offset();
    item.simulate( "drag", {
        dx: offset.left,
        dy: offset.top - item.offset().top
    });
});
JS;
        $script = str_replace("{{CONTEXT}}", $context.' ', $script);
        $script = str_replace("{{TARGET}}", $target, $script);
        $script = str_replace("{{ITEM}}", $item, $script);
        $this->getSession()->executeScript($script);
    }

    /**
     * @Given /^el orden de "([^"]*)" debe ser "([^"]*)"$/
     */
    public function elOrdenDeDebeSer($css, $items)
    {
        $items = explode(",",$items);
        $session = $this->getSession();
        $page = $session->getPage();
        $asserts_items = $page->findAll("css",$css);
        foreach ($asserts_items as $key => $item) {
            if (isset($items[$key])) {
                if ($item->getText() != trim($items[$key])) {
                    $sort = $key + 1;
                    throw new \Exception("El orden no coincide con el esperado: el {$sort}° elemento debería ser '{$items[$key]}' y es '{$item->getText()}'.");
                }
            }
        }
    }

    /**
     * @Given /^hago visible "([^"]*)"$/
     */
    public function hagoVisible($selector)
    {
        $script = <<<JS
    $('#{{FIELD}}').css("visible", "visible")
        .css("display", "block")
        .css("opacity", "1")
        .css("transform", "none")
        .css("position", "static");
JS;
        $script = str_replace("{{FIELD}}", $selector, $script);
        $this->getSession()->executeScript($script);
    }

    /**
     * @Given /^la casilla de selección "([^"]*)" debe estar marcada$/
     */
    public function laCasillaDeSeleccionDebeEstarMarcada($name)
    {
        $this->getSession()->executeScript(
            "$(\"input[name='$name']\").is(':checked');"
        );
    }

    /**
     * @Given /^el checkbox "([^"]*)" debe estar marcado$/
     */
    public function elCheckboxDebeEstarMarcado($name)
    {
        $this->getSession()->executeScript(
            "$(\"$name\").is(':checked');"
        );
    }


    /**
     * @Given /^el checkbox "([^"]*)" no debe estar marcado$/
     */
    public function elCheckboxNoDebeEstarMarcado($name)
    {
        $this->getSession()->executeScript(
            "$(\"$name\").is(':checked') == false;"
        );
    }

    /**
     * @Given /^selecciono del radio "([^"]*)" el valor "([^"]*)"$/
     */
    public function seleccionoDelRadioElValor($name, $value)
    {
        $this->getSession()->executeScript(
            "$(\"input[name='$name'][value='$value']:radio\").prop('checked', true);"
        );
    }

    /**
     * @Given /^tildo el checkbox "([^"]*)"$/
     */
    public function tildoCheckbox($checkbox)
    {
        $this->getSession()->executeScript(
            "$('#$checkbox').prop('checked', true); $('#$checkbox').change();"
        );
    }

    /**
     * @Given /^destildo el checkbox "([^"]*)"$/
     */
    public function destildoCheckbox($checkbox)
    {
        $this->getSession()->executeScript(
            "$('#$checkbox').prop('checked', false); $('#$checkbox').change();"
            );
    }

    /**
     * @Given /^escroleo "([^"]*)" hacia abajo (\d+) px$/
     */
    public function escroleoPx($contenedor, $pixels)
    {
        $this->getSession()->executeScript(
            "$(\"$contenedor\").animate({scrollTop: $pixels});"
        );
    }

    /**
     * @Given /^El botón "([^"]*)" debe estar deshabilitado$/
     */
    public function elBotonDebeEstarDeshabilitado($buttonSelector)
    {
        $button = $this->getSession()->getPage()->findButton($buttonSelector);
        if (empty($button)) {
            throw new ElementNotFoundException(
                $this->getSession(), 'button', 'id|name|title|alt|value'
            );
        }

        $attribute = $button->getAttribute('disabled');

        if (empty($attribute)) {
            throw new Exception("Button {$buttonSelector} is not disabled");
        }
    }

    /**
     * @Given /^lleno el WYSIWYG "([^"]*)" con "([^"]*)"$/
     */
    public function llenoElWysiwygCon($identifier, $text)
    {
        $start = 1000 * microtime(true);
        $end = $start + self::BEHAT_AJAX_TIMEOUT;
        $script = <<<JS
            if (typeof tinyMCE == 'undefined') {
                return false;
            }

            var container = tinyMCE.get("{$identifier}");
            if (!container) {
                return false;
            }
            container.setContent("{$text}");
            return true;
JS;
        while (1000 * microtime(true) < $end && !$this->getSession()->evaluateScript($script)) {
            sleep(1);
        }

        $result = $this->getSession()->evaluateScript($script);
        if (!$result) {
            throw new Exception('Error en la asignación del WYSIWYG.');
        }

        if (1000 * microtime(true) >= $end) {
            $this->getSession()->getDriver()->stop();
            throw new Exception("El elemento aún no está visible");
        }
    }

    /**
     * @Given /^lleno el WYSIWYG "([^"]*)" con más de 32 mil caracteres$/
     */
    public function llenoElWysiwygConMasDe32000Caracteres($identifier)
    {
        $start = 1000 * microtime(true);
        $end = $start + self::BEHAT_AJAX_TIMEOUT;
        /**
         * Es necesario utilizar un array debido a que el texto supera la longitud
         * máxima permitida en una variable.
         */
        $content = [];
        $content['text'] = '';
        $text = 'Nel mezzo del cammin di nostra vita mi ritrovai per una selva oscura, ché la diritta via era smarrita.';
        $i = 0;
        do {
            $content['text'] .= $text;
            $i++;
        } while ($i < 320);
        $script = <<<JS
            if (typeof tinyMCE == 'undefined') {
                return false;
            }
            var container = tinyMCE.get("{$identifier}");
            if (!container) {
                return false;
            }
            container.setContent("{$content['text']}");
            return true;
JS;
        while (1000 * microtime(true) < $end && !$this->getSession()->evaluateScript($script)) {
            sleep(1);
        }

        $result = $this->getSession()->evaluateScript($script);
        if (!$result) {
            throw new Exception('Error en la asignación del WYSIWYG.');
        }

        if (1000 * microtime(true) >= $end) {
            $this->getSession()->getDriver()->stop();
            throw new Exception("El elemento aún no está visible.");
        }
    }

    /**
     * Alternativa para obtener el "id" dinámico del WYSIWYG mediante el atributo
     * "name" del textarea.
     *
     * @Given /^completo el WYSIWYG "([^"]*)" con "([^"]*)"$/
     */
    public function completoElWysiwygCon($name, $text)
    {
        $script = <<<JS
            $(document).ready(function() {
                var id = $("textarea[name={$name}]")[0].id;
                var container = tinyMCE.get(id);
                container.setContent("{$text}");
            });
JS;
        $result = $this->getSession()->executeScript($script);
    }

    /*
     * Este step es utilizado para testear el funcionamiento del widget SelectionOverlay
     * de Backbone.Form.
     * El valor de $itemText puede ser un string de textos separados por coma,
     * resultará en un array que hará seleccionar varios items.
     *
     * @Given /^selecciono "([^"]*)" del widget de selección "([^"]*)"$/
     */
    public function seleccionoDelWidgetDeSeleccion($itemsText, $selectionOverlayWidgetName)
    {
        $items = explode(',', $itemsText);

        $this->getSession()->executeScript(
            "$('div[name=\"{$selectionOverlayWidgetName}\"]').find('button.btn-selection-list-overlay').click();"
        );

        $this->getSession()->wait(5000, "$('#itemsList tr').length > 0");

        foreach ($items as $item) {
            $this->getSession()->executeScript(
                "$('#itemsList').find('tr:contains(\'{$item}\')').find('button.btn-select-item').eq(0).click();"
            );
        }

        $this->getSession()->executeScript("$('#btn-add').click();");
    }

    /**
     * @Given /^confirmo la eliminación presionando "([^"]*)"$/
     */
    public function confirmoLaEliminacionPresionando($buttonElement)
    {
        $this->pressButton($buttonElement);
        $this->getSession()->executeScript("$('button').find('{$buttonElement}').click();");
    }

    /**
     * @Given /^completo campo "([^"]*)" con "([^"]*)"$/
     */
    public function completoCampoCon($selector, $text)
    {
        $script = <<<JS
            var element = $('{$selector}');
            var tagName = element.get(0).tagName;
            if (tagName == 'INPUT' || tagName == 'TEXTAREA') {
                element.val('{$text}');
                element.trigger('blur');
            } else {
                element.html('{$text}');
            }
JS;
        $this->getSession()->executeScript($script);
    }

    /**
     * @Given /^debo ver "([^"]*)" en el campo "([^"]*)"$/
     */
    public function deboVerEnElCampo($content, $selector)
    {
        $this->getSession()->executeScript(
            "$(\"$selector\").val() == \"$content\""
        );
    }

    /**
     * Obtiene un elemento <a> y hace click sobre el mismo en base al índice de ocurrencias
     * del texto provisto.
     *
     * Ejemplo:
     *
     * Y hago click en el índice "3" del elemento que contiene el texto "GoIntegro"
     *
     * Referencias:
     *
     * 3 > Índice de ocurrencia del texto GoIntegro dentro de elementos <a>.
     * GoIntegro > Texto con una o más ocurrencias dentro de elementos <a>.
     *
     * @Given /^hago click en el índice "([^"]*)" del elemento que contiene el texto "([^"]*)"$/
     */
    public function hagoClickEnElIndiceDelElementoQueContieneElTexto($index, $text)
    {
        $index = intval($index);
        $text = str_replace("'", '"', $text);

        $elementIndexExists = $this->getSession()->evaluateScript(
            "return $('a').length >= $index"
        );

        if (!$elementIndexExists) {
            throw new Exception("El índice especificado no existe.");
        }

        $script = <<<JS
            var element = $('a:contains({text})');
            if (element.length > 0) {
                window.location.href = $(element).eq({index}).prop('href');
                return true;
            }
            return;
JS;

        $script = str_replace('{text}', $text, $script);
        $script = str_replace('{index}', $index, $script);

        $result = $this->getSession()->evaluateScript($script);

        if (!$result) {
            throw new Exception("No fue encontrado ningún elemento <a> que contenga el texto \"$text\".");
        }
    }

    /**
     * @Given /^cierro el modal "([^"]*)"$/s
     */
    public function cierroElModal($selector)
    {
        $script = <<<JS
            var element = $('{$selector}');
            element.modal('hide');
            return element.length > 0;
JS;

        $success = $this->getSession()->evaluateScript($script);

        if (!$success) {
            throw new Exception("No se encuentra el modal");
        }
    }

    /**
     * @Then /^debe estar seleccionado "([^"]*)" en "([^"]*)"$/
     */
    public function inShouldBeSelected($optionValue, $select)
    {
        $this->assertSession()->fieldValueEquals($select, $optionValue);
    }

    /**
     * @Then /^no debe estar seleccionado "([^"]*)" en "([^"]*)"$/
     */
    public function inShouldNotBeSelected($optionValue, $select) {
        $this->assertSession()->fieldValueNotEquals($select, $optionValue);
    }

    /**
     * @Then /^el campo "([^"]*)" debe estar deshabilitado$/
     */
    public function fieldShouldBeDisabled($inputSelector)
    {
        $field = $this->getSession()->getPage()->findField($inputSelector);
        if (empty($field)) {
            throw new ElementNotFoundException(
                $this->getSession(), 'field', 'id|name|title|alt|value'
            );
        }

        $disabled = $field->getAttribute('disabled');

        if (empty($disabled)) {
            throw new Exception("Field {$inputSelector} is not disabled");
        }
    }

    /**
     * @BeforeScenario @loadStandardUserData
     */
    public function loadStandardUserData()
    {
        $this->runDoctrineDataFixtures(['GoIntegro\DataFixtures\ORM\Standard\User\Fixture']);
    }

    /**
     *
     * @Given /^seteo el datepicker "([^"]*)" con la fecha de hoy$/
     * @param string $selector Valid jquery selector
     */
    public function seteoElDatepickerHoy($selector) {
        $now = new \DateTime();
        $this->seteoElDatepicker($selector, $now->format('Y'), $now->format('M'), $now->format('d'));
    }

    /**
     *
     * @Given /^seteo el datepicker "([^"]*)" con "([^"]*)", "([^"]*)", "([^"]*)"$/
     * @param string $selector Valid jquery selector
     * @param string $year
     * @param string $month
     * @param string $day
     */
    public function seteoElDatepicker($selector, $year, $month, $day)
    {
        //este fix es para que busque los días sin el 0 al principio cuando tienen un sólo dígito
        $day = (int)$day;

        $check = function($selector) {
            $elementExists = $this->getSession()
                ->evaluateScript("return $('{$selector}').length > 0");
            if (!$elementExists) {
                throw new Exception('No existe el selector ' . $selector);
            }
        };
        $click = function($selector) {
            $this->getSession()
                ->executeScript("$('{$selector}').click()");
        };

        $check($selector);
        $switchSelector = "{$selector} .datepicker-switch";
        $check($switchSelector);
        $click($switchSelector);
        $check($switchSelector);
        $click($switchSelector);
        $yearSelector = "{$selector} span:contains({$year})";
        $check($yearSelector);
        $click($yearSelector);
        $monthSelector = "{$selector} span:contains({$month})";
        $check($monthSelector);
        $click($monthSelector);
        $daySelector = "{$selector} td:contains({$day})";
        $check($daySelector);
        $click($daySelector);
    }

    /**
     * @Given /^hago click en la pestaña "([^"]*)"$/
     */
    public function hagoClickEnLaPestana($selector)
    {
        $selectorExists = $this->getSession()->evaluateScript(
            "return $('{$selector}').length > 0"
        );

        if (!$selectorExists) {
            throw new Exception("El selector $selector no fue encontrado.");
        }

        $script = <<<JS
            var element = $('{$selector}');

            /**
             * Fuerza la ejecución del evento para que se despliegue el modal
             * de advertencia ligado a la pérdida de información de los pronósticos
             * cargados en la aplicación de Torneos.
             */
            $('input[type=text]').trigger('change');

            element.trigger('click');
JS;

        $this->getSession()->executeScript($script);
    }
    
    /**
     * Run a symfony2 task
     * @param array $options
     */
    protected function runTask(array $options)
    {
        $application = new Application($this->getKernel());

        $application->setAutoExit(false);

        $application->run(new ArrayInput($options));        
    }
}
