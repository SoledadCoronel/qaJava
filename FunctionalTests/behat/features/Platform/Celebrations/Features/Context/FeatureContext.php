<?php
/**
 * @package GoIntegro
 * @subpackage Bundle\CelebrationsBundle\Features\Context
 *
 */

namespace GoIntegro\Bundle\CelebrationsBundle\Features\Context;

use Behat\Behat\Context\BehatContext,
    Behat\Behat\Exception\PendingException;
use Behat\Gherkin\Node\PyStringNode,
    Behat\Gherkin\Node\TableNode;

use Doctrine\Common\DataFixtures\Purger\ORMPurger;
use Doctrine\Common\DataFixtures\Executor\ORMExecutor;
use Symfony\Bridge\Doctrine\DataFixtures\ContainerAwareLoader;

use Behat\CommonContexts\DoctrineFixturesContext;
use Behat\CommonContexts\SymfonyDoctrineContext;

use GoIntegro\Context\FeatureContext as GoIntegroContext;

class FeatureContext extends GoIntegroContext
{
    /**
     * Datos básicos para aplicación de
     * celebraciones
     * Extiende de los datafixtures standard
     * @BeforeScenario @loadCelebrationsData
     */
    public function loadCelebrationsData()
    {
        $this->runDoctrineDataFixtures(['GoIntegro\Bundle\CelebrationsBundle\DataFixtures\ORM\Standard\Content\Fixture']);
    }
    /**
     * Datos básicos para la Home de la aplicación de celebraciones
     * @BeforeScenario @loadCelebrationsHomeData
     */
    public function loadCelebrationsHomeData()
    {
        $this->runDoctrineDataFixtures(['GoIntegro\Bundle\CelebrationsBundle\DataFixtures\ORM\Standard\Home\Fixture']);
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
