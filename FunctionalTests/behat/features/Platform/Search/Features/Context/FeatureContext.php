<?php
namespace GoIntegro\Bundle\SearchBundle\Features\Context;

use Composer\Script\ScriptEvents;
use GoIntegro\Context\FeatureContext as GoIntegroContext;
use Symfony\Component\Config\Definition\Exception\Exception;

use Behat\Behat\Context\BehatContext,
    Behat\Behat\Exception\PendingException;
use Behat\Gherkin\Node\PyStringNode,
    Behat\Gherkin\Node\TableNode;

use Behat\CommonContexts\DoctrineFixturesContext;
use Behat\CommonContexts\SymfonyDoctrineContext;
// Nativas
use DateTime;

class FeatureContext extends GoIntegroContext
{
    /**
    * Load data from fixture to create a Platform with a default Environment
    *
    * @BeforeScenario @loadEnvironmentData
    */
    public function loadEnvironmentData()
    {
        $this->runDoctrineDataFixtures(array(
            'GoIntegro\DataFixtures\ORM\Standard\User\Fixture',
            'GoIntegro\DataFixtures\ORM\Standard\Platform\Fixture'
        ));
    }

    /**
     * @BeforeScenario @loadBenefitData
     */
    public function loadBenefitData()
    {
        $this->runDoctrineDataFixtures(array(
            'GoIntegro\Bundle\BenefitsBundle\DataFixtures\ORM\StoreBenefits\Fixture'
        ));
    }

    /**
     * @BeforeScenario @loadSearchData
     */
    public function loadSearchData()
    {
        $this->runDoctrineDataFixtures(array(
            'GoIntegro\Bundle\SearchBundle\DataFixtures\ORM\GeneralSearch\Fixture'
        ));
    }
    
    /**
     * @BeforeScenario @loadBenefitStoreDataUsesCard
     */
    public function loadBenefitStoreDataUsesCard()
    {
        $this->runDoctrineDataFixtures(array(
            'GoIntegro\Bundle\BenefitsBundle\DataFixtures\ORM\StoreBenefits\Fixture',
            'GoIntegro\Bundle\BenefitsBundle\DataFixtures\ORM\UsesBenefitsCard\Fixture',
            'GoIntegro\Bundle\BenefitsBundle\DataFixtures\ORM\UsesBenefitsCoupon\Fixture'
        ));
    }
}