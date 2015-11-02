<?php
/**
 * @package GoIntegro
 * @subpackage Bundle\GalleryBundle\GalleryBundle\Features\Context
 *
 * @author Gabriel Alberto Sarmentero <gabriel.sarmentero@gointegro.com>
 */
namespace GoIntegro\Bundle\GalleryBundle\Features\Context;

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
     * @BeforeScenario @loadGalleryData
     */
    public function loadGalleryData()
    {
        $this->runDoctrineDataFixtures(
            array(
                'GoIntegro\DataFixtures\ORM\Standard\Platform\Fixture',
                'GoIntegro\DataFixtures\ORM\Standard\Environment\Fixture',
                'GoIntegro\Bundle\GalleryBundle\DataFixtures\ORM\GalleryStandardData'
            )
        );
    }

    /**
     * @BeforeScenario @loadAlbumsData
     */
    public function loadAlbumsData()
    {
        $this->runDoctrineDataFixtures(
            array(
                'GoIntegro\DataFixtures\ORM\Standard\Environment\Fixture', // Esto no está de más???
                'GoIntegro\Bundle\GalleryBundle\DataFixtures\ORM\GalleryStandardData',
                'GoIntegro\Bundle\GalleryBundle\DataFixtures\ORM\Albums\LoadGalleryAlbumsData'
            )
        );
    }

    /**
     * TODO: esto se tiene que ir con el refactor
     * @BeforeScenario @loadGalleryDataProvisional
     */
    public function loadGalleryDataProvisional()
    {
        $this->runDoctrineDataFixtures(array(
            'GoIntegro\DataFixtures\ORM\Deprecated\GalleryApp\Accounts\LoadAccountsStandaloneData'
        ));
    }

    /**
     * @Given /^debo ver una foto del álbum$/
     */
    public function deboVerUnaFotoDelAlbum()
    {
        $result = $this->getSession()->evaluateScript("
            return $('div.pic img').length > 0;
        ");

        if (!$result) {
            throw new Exception('No se encontró la imagen.');
        }
    }
}
