<?php

namespace GoIntegro\Bundle\SocialBundle\Features\Context;

use Composer\Script\ScriptEvents;
use GoIntegro\Context\FeatureContext as GoIntegroContext;
use Exception;

class FeatureContext extends GoIntegroContext
{
    /**
     * Load data from fixture to create a standard application instance running
     *
     * @BeforeScenario @loadStandardData
     */
    public function loadStandardData()
    {
        $this->runDoctrineDataFixtures([
            'GoIntegro\Bundle\SocialBundle\DataFixtures\ORM\Standard\Fixture'
        ]);
    }

    /**
     * Load data from fixture to create a standard application instance running
     *
     * @BeforeScenario @loadTags
     */
    public function loadTagData()
    {
        $this->runDoctrineDataFixtures([
            'GoIntegro\Bundle\SocialBundle\DataFixtures\ORM\Tags\LoadTags'
        ]);
    }

    /**
     * @Given /^espero a que la barra de progreso "([^"]*)" se cargue completamente$/
     */
    public function esperoAQueLabarradeProgresoSeCargueCompletamente($bar)
    {
        $script = "return $('$bar').hasClass('progress-success');";

        $start = 1000 * microtime(true);
        $end = $start + self::BEHAT_AJAX_TIMEOUT;

        while (1000 * microtime(true) < $end && !$this->getSession()->evaluateScript($script)) {
            sleep(1);
        }

        if (1000 * microtime(true) >= $end) {
            $this->getSession()->getDriver()->stop();
            throw new Exception("La barra de progreso no se cargó correctamente. El archivo no fue subido con éxito");
        }
    }

    /**
     * Se necesita este paso también en este bundle para modificar
     * la configuración de una plataforma por back office dentro
     * del mismo test.
     *
     * @Given /^que estoy en el detalle de la cuenta "([^"]*)"$/
     * @Given /^estoy en el detalle de la cuenta "([^"]*)"$/
     */
    public function queEstoyEnElDetalleDeLaCuenta($accountName)
    {
        $container     = $this->getKernel()->getContainer();
        $entityManager = $container->get('doctrine.orm.entity_manager');

        $account = $entityManager->getRepository('GoIntegro\Entity\Account')
            ->findOneBy(['name' => $accountName]);

        if (!$account){
            throw new Exception('Account not found');
        }

        $this->visit('/backoffice/account/' . $account->getId().'/view');
    }
}
