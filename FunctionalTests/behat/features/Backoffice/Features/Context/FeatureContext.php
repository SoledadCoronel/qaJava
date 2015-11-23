<?php

namespace GoIntegro\Bundle\BackofficeBundle\Features\Context;

use GoIntegro\Context\FeatureContext as GoIntegroContext;
use Behat\Behat\Context\BehatContext,
    Behat\Behat\Exception\PendingException;
use Behat\Gherkin\Node\PyStringNode,
    Behat\Gherkin\Node\TableNode;
use Doctrine\Common\DataFixtures\Purger\ORMPurger;
use Doctrine\Common\DataFixtures\Executor\ORMExecutor;
use Symfony\Bridge\Doctrine\DataFixtures\ContainerAwareLoader;

use Behat\CommonContexts\DoctrineFixturesContext;
use Behat\CommonContexts\SymfonyDoctrineContext;
use Exception;

/**
 * Feature context.
 */
class FeatureContext extends GoIntegroContext {

    /**
     * Carga datos necesarios para testear
     * todos los listados del backoffice
     * cuentas, plataformas, usuarios
     *
     * @BeforeScenario @loadDataForLists
     */
    public function loadDataForLists() {
        $this->runDoctrineDataFixtures(array(
            'GoIntegro\Bundle\BackofficeBundle\DataFixtures\ORM\Lists\LoadDataForLists'
        ));
    }

    /**
     * @BeforeScenario @loadBenefitsData
     */
    public function loadBenefitsData() {
        $this->runDoctrineDataFixtures(array(
            'GoIntegro\Bundle\BenefitsBundle\DataFixtures\ORM\Benefit\Fixture'
        ));
    }

    /**
     * @BeforeScenario @loadBenefitsBenefitData
     */
    public function loadBenefitsBenefitData() {
        $this->runDoctrineDataFixtures(array(
            'GoIntegro\DataFixtures\ORM\Standard\Platform\Fixture',
            'GoIntegro\Bundle\BenefitsBundle\DataFixtures\ORM\Category\Data\Fixture',
            'GoIntegro\Bundle\BenefitsBundle\DataFixtures\ORM\Collection\Fixture',
            'GoIntegro\Bundle\BenefitsBundle\DataFixtures\ORM\Company\Fixture',
            'GoIntegro\Bundle\BenefitsBundle\DataFixtures\ORM\Day\Fixture',
            'GoIntegro\Bundle\BenefitsBundle\DataFixtures\ORM\PaymentMethod\Fixture',
            'GoIntegro\Bundle\BenefitsBundle\DataFixtures\ORM\RedeemingMethod\Fixture',
            'GoIntegro\Bundle\BenefitsBundle\DataFixtures\ORM\Tag\Fixture',
            'GoIntegro\Bundle\BenefitsBundle\DataFixtures\ORM\Store\Fixture',
            'GoIntegro\Bundle\BenefitsBundle\DataFixtures\ORM\StoreBenefits\Fixture',
        ));
    }

    /**
     * @BeforeScenario @loadCollectionData
     */
    public function loadCollectionData() {
        $this->runDoctrineDataFixtures(array(
            'GoIntegro\Bundle\BenefitsBundle\DataFixtures\ORM\Benefit\Fixture',
            'GoIntegro\Bundle\BenefitsBundle\DataFixtures\ORM\Collection\Fixture'
        ));
    }

    /**
     * @BeforeScenario @loadCollectionBenefitsData
     */
    public function loadCollectionBenefitsData() {
        $this->runDoctrineDataFixtures([
            'GoIntegro\DataFixtures\ORM\Standard\Platform\Fixture',
            'GoIntegro\Bundle\BenefitsBundle\DataFixtures\ORM\Collection\Fixture',
            'GoIntegro\Bundle\BenefitsBundle\DataFixtures\ORM\Company\Fixture'
        ]);
    }

    /**
     * @BeforeScenario @loadStoreBenefitsData
     */
    public function loadStoreBenefitsData() {
        $this->runDoctrineDataFixtures([
            'GoIntegro\Bundle\BenefitsBundle\DataFixtures\ORM\StoreBenefits\Fixture'
        ]);
    }

    /**
     * @BeforeScenario @loadPaymentMachinesAndStoreBenefitData
     */
    public function loadPaymentMachinesAndStoreBenefitsData() {
        $this->runDoctrineDataFixtures(array(
            'GoIntegro\Bundle\BenefitsBundle\DataFixtures\ORM\PaymentMachine\Fixture'
        ));
    }

    /**
     * @BeforeScenario @loadTranslations
     */
    public function loadTranslations() {
        $this->runDoctrineDataFixtures(array(
            'GoIntegro\Bundle\BackofficeBundle\DataFixtures\ORM\Translation\TranslationData'
        ));
    }

    /**
     * Carga los fixtures para testear la edicion de una cuenta regional.
     * @BeforeScenario @createRegionalAccounts
     */
    public function loadEditRegionalAccountData() {
        /* @todo REFACTORIZAR DATAFIXTURES!!!!
         * El fixture CreateBackofficeUser esta agregado aca
         * y no como dependencia a CreateAccounts porque sino entra
         * en conflicto con otro (LoadDataForLists) que se carga junto con este en un test de api
         * asi que lo agregue aca directamente para que no pinche ni este test, ni el otro
         */
        $this->runDoctrineDataFixtures(array(
            'GoIntegro\Bundle\BackofficeBundle\DataFixtures\ORM\BackofficeUser\CreateBackofficeUser',
            'GoIntegro\Bundle\BackofficeBundle\DataFixtures\ORM\Account\CreateAccounts'
        ));
    }

    /**
     * Carga los fixtures para testear visualizacion de una cuenta regional e hijas
     * @BeforeScenario @createRegionalChildViewableAccount
     */
    public function loadRegionalChildAccountData() {
        $this->runDoctrineDataFixtures(array(
            'GoIntegro\Bundle\BackofficeBundle\DataFixtures\ORM\Account\RegionalView\RegionalChildAccountViewTest'
        ));
    }

    /**
     * Carga los fixtures para testear visualizacion de una cuenta regional e hijas
     * @BeforeScenario @createRegionalViewableAccounts
     */
    public function loadRegionalAccountData() {
        $this->runDoctrineDataFixtures(array(
            'GoIntegro\Bundle\BackofficeBundle\DataFixtures\ORM\Account\RegionalView\RegionalAccountViewTest'
        ));
    }

    /**
     * Carga una cuenta, un usuario y una plataforma para poder editarla.
     *
     * @BeforeScenario @createAccountAndUserAndPlatform
     */
    public function loadAccountAndUserAndPlatformData() {
        $this->runDoctrineDataFixtures(array(
            'GoIntegro\Bundle\BackofficeBundle\DataFixtures\ORM\Platform\CreateAccountAndUserAndPlatform\Fixture'
        ));
    }

    /**
     * Carga una cuenta, un usuario y una plataforma para poder editarla.
     *
     * @BeforeScenario @createAccountAndUserAndPlatformAndEnvironment
     */
    public function loadAccountAndUserAndPlatformDataAndEnvironment() {
        $this->runDoctrineDataFixtures(array(
            'GoIntegro\Bundle\BackofficeBundle\DataFixtures\ORM\Environment\CreateAccountAndUserAndPlatformAndEnvironment'
        ));
    }

    /**
     * Carga una cuenta, una plataforma y roles.
     *
     * @BeforeScenario @loadAccountPlatformRoles
     */
    public function loadAccountPlatformRoles() {
        $this->runDoctrineDataFixtures(array(
            'GoIntegro\Bundle\BackofficeBundle\DataFixtures\Platform\LoadAccountPlatformRoles'
        ));
    }

    /**
     * Carga datos de torneos
     *
     * @BeforeScenario @loadTournamentsStandardData
     */
    public function loadTournamentsData() {
        $this->runDoctrineDataFixtures(array(
            'GoIntegro\Bundle\TournamentsBundle\DataFixtures\ORM\Standard\TournamentsStandardData'
        ));
    }

    /**
     * @BeforeScenario @createPlatformAndAccountAndOneUser
     */
    public function createPlatformAndAccount() {
        $this->runDoctrineDataFixtures(array(
            'GoIntegro\Bundle\BackofficeBundle\DataFixtures\ORM\User\CreateBackofficeEnvironment'
        ));
    }

    /**
     * @Given /^espero a que aparezca el formulario$/
     */
    public function esperoAQueAparezcaElFormulario() {
        $this->esperoAQueAparezcaElContenidoDinamicoEn('.form-horizontal', '#content');
    }

    /**
     * Carga una cuenta regional con una cuenta hija y una plataforma.
     *
     * @BeforeScenario @createRegionalAccountWithPlatform
     */
    public function loadRegionalAccountWithPlatformData() {
        $this->runDoctrineDataFixtures(array(
            'GoIntegro\Bundle\BackofficeBundle\DataFixtures\ORM\Platform\RegionalAccount\CreateRegionalAccountWithPlatform'
        ));
    }

    /**
     * Carga los datos standard para una plataforma con usuarios
     *
     * @BeforeScenario @loadStandardData
     */
    public function loadStandardData() {
        $this->runDoctrineDataFixtures(array(
            'GoIntegro\DataFixtures\ORM\Standard\User\Fixture'
        ));
    }

    /**
     * @Given /^que estoy en el detalle de la cuenta "([^"]*)"$/
     * @Given /^estoy en el detalle de la cuenta "([^"]*)"$/
     */
    public function queEstoyEnElDetalleDeLaCuenta($accountName) {
        $container = $this->getKernel()->getContainer();
        $entityManager = $container->get('doctrine.orm.entity_manager');

        $account = $entityManager->getRepository('GoIntegro\Entity\Account')
                ->findOneBy(array('name' => $accountName));

        if (!$account) {
            throw new Exception('Account not found');
        }


        $this->visit('/backoffice/account/' . $account->getId() . '/view');
    }

    /**
     * Usa simulate pero sin utilizar requireJs (solo backoffice)
     * @Given /^muevo del listado dinamico "([^"]*)" a "([^"]*)"$/
     */
    public function muevoListadoDinamico($item, $target) {

        $script = <<<'JS'
    var offset = $("*").filter(function(index){
        return $(this).text() === "{{TARGET}}";
    }).first().offset();
    var item = $("*").filter(function(index){
        return $(this).text() === "{{ITEM}}";
    }).first();
    item.simulate( "drag", {
        dx: offset.left,
        dy: offset.top - item.offset().top
    });
JS;
        $script = str_replace("{{TARGET}}", $target, $script);
        $script = str_replace("{{ITEM}}", $item, $script);
        $this->getSession()->executeScript($script);
    }

    /**
     * @Given /^el orden del listado dinamico de "([^"]*)" debe ser "([^"]*)"$/
     */
    public function elOrdenDebeSer($selector, $items) {
        $items = explode(",", $items);

        $matchItems = '[';

        foreach ($items as $key => $value) {

            if ($key > 0) {
                $matchItems .= ',';
            }

            $matchItems .= "'{$value}'";
        }

        $matchItems .= "]";

        $selector = str_replace('\'', '"', $selector);

        $script = "
            var items = $('{$selector}');
            var matchItems = {$matchItems};

            var result = true;

            items.each(function(index, item) {

                if ( typeof(matchItems[index]) != 'undefined') {
                    if ( $(item).text() != matchItems[index]) {
                        result = false;
                    }
                }

            });

            return result;
        ";

        $result = $this->getSession()->evaluateScript($script);

        if (!$result) {
            throw new Exception("El orden de los elementos no es el esperado");
        }
    }

    /**
     * @Given /^selecciono "([^"]*)" del widget de selección "([^"]*)"$/
     */
    public function seleccionoDelWidgetDeSeleccion($itemsText, $selectionOverlayWidgetName) {
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
     * @Given /^el breadcrumb debe ser "([^"]*)"$/
     */
    public function elBreadcrumbDebeSer($breadcrumb) {
        $items = explode(" > ", $breadcrumb);

        $script = "return $(\".breadcrumb li:contains(\\\"{content}\\\")\").length > 0";

        foreach($items as $item) {
            $success = $this->getSession()->evaluateScript(str_replace("{content}", $item, $script));
            if(!$success) {
                throw new Exception("El breadcrumb no coincide");
            }
        }
    }

    /**
     * Carga listado de torneos Pro.
     *
     * @BeforeScenario @createTournament
     */
    public function loadLotOfTournamentsData() {
        $this->runDoctrineDataFixtures(array(
            'GoIntegro\Bundle\TournamentsBundle\DataFixtures\ORM\LotOfTournaments\LotOfTournamentsData'
        ));
    }

    /**
     * Carga datos básicos para torneo.
     *
     * @BeforeScenario @loadStandardTournamentData
     */
    public function loadStandardTournamentData() {
        $this->runDoctrineDataFixtures(array(
            'GoIntegro\Bundle\TournamentsBundle\DataFixtures\ORM\Standard\TournamentsStandardData'
        ));
    }


    /**
     * Datafixture sin torneos asociados para
     * poder testear features de asociar torneos
     * @BeforeScenario @loadNoAssociatedTournamentsData
     */
    public function loadNoAssociatedTournamentsData()
    {
        $this->runDoctrineDataFixtures(
            array(
                'GoIntegro\Bundle\TournamentsBundle\DataFixtures\ORM\NoAssociatedTournaments\NoAssociatedData'
            )
        );
    }

    /**
     * Selecciona todos los checkbox de un bloque
     * @Given /^selecciono todos los checkbox de "([^"]*)"$/
     */
    public function selectAllCheckboxFromBlock($selector) {

        $this->getSession()->executeScript(
                "$('$selector input[type=checkbox]').attr('checked', true);"
        );
    }

    /**
     * @BeforeScenario @loadInvitationRequestData
     */
    public function loadInvitationRequestData() {
        $this->runDoctrineDataFixtures(array(
            'GoIntegro\DataFixtures\ORM\DependentUser\Fixture'
        ));
    }

    /**
     * @BeforeScenario @loadGalleryData
     */
    public function loadGalleryData() {
        $this->runDoctrineDataFixtures(array(
            'GoIntegro\Bundle\BenefitsBundle\DataFixtures\ORM\Gallery\Fixture'
        ));
    }

    /**
     * Aplicación de celebraciones instalada en espacio privado con
     * colaboradores asociados y cumpleaños de los mismos cargados.
     * También se genera un cumpleaños en el espacio público para otro usuario.
     * @BeforeScenario @loadPrivateWSCelebrationApp
     */
    public function loadPrivateWSCelebrationApp()
    {
      $this->runDoctrineDataFixtures(['GoIntegro\Bundle\CelebrationsBundle\DataFixtures\ORM\PrivateWorkspace\Fixture']);
    }
}
