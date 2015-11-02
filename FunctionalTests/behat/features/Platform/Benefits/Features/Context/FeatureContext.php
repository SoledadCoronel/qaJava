<?php

namespace GoIntegro\Bundle\BenefitsBundle\Features\Context;

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

class FeatureContext extends GoIntegroContext
{
    /**
     * @BeforeScenario @loadBenefitsFilterApplicationData
     */
    public function loadBenefitsFilterApplicationData()
    {
        $this->runDoctrineDataFixtures(array(
            'GoIntegro\Bundle\BenefitsBundle\DataFixtures\ORM\BenefitsFilterApp\Fixture'
        ));
    }

    /**
     * @BeforeScenario @loadBenefitsStandardData
     */
    public function loadStandardData()
    {
        $this->runDoctrineDataFixtures(array(
            'GoIntegro\Bundle\BenefitsBundle\DataFixtures\ORM\Standard\BenefitsStandardData',
            'GoIntegro\Bundle\BenefitsBundle\DataFixtures\ORM\UsesBenefitsCoupon\Fixture'
        ));
    }

    /**
     * @BeforeScenario @loadBenefitsCollectionData
     */
    public function loadBenefitsCollectionData()
    {
        $this->runDoctrineDataFixtures(array(
            'GoIntegro\Bundle\BenefitsBundle\DataFixtures\ORM\Collection\Fixture'
        ));
    }


    /**
     * @BeforeScenario @loadRankingWidgetData
     */
    public function loadRankingWidgetData()
    {
        $this->runDoctrineDataFixtures([
            'GoIntegro\Bundle\BenefitsBundle\DataFixtures\ORM\RankingWidget\Fixture'
        ]);
    }

    /**
     * @BeforeScenario @loadBenefitStoreData
     */
    public function loadBenefitStoreData()
    {
        $this->runDoctrineDataFixtures(array(
            'GoIntegro\Bundle\BenefitsBundle\DataFixtures\ORM\StoreBenefits\Fixture'
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

    /**
     * @BeforeScenario @loadBenefitCollectionWigetData
     */
    public function loadBenefitCollectionWidgetData()
    {
        $this->runDoctrineDataFixtures(array(
            'GoIntegro\Bundle\BenefitsBundle\DataFixtures\ORM\CollectionWidget\Fixture'
        ));
    }

    /**
     * @BeforeScenario @loadBenefitsCategoryWidget
     */
    public function loadBenefitsCategoryWidget()
    {
        $this->runDoctrineDataFixtures(array(
            'GoIntegro\Bundle\BenefitsBundle\DataFixtures\ORM\CategoryWidget\Fixture'
        ));
    }

    /**
     * @BeforeScenario @loadBenefitCollectionData
     */
    public function loadBenefitCollectionData()
    {
        $this->runDoctrineDataFixtures(array(
            'GoIntegro\Bundle\BenefitsBundle\DataFixtures\ORM\Collection\Fixture'
        ));
    }

    /**
     * @BeforeScenario @loadBenefitsPublicPlatform
     */
    public function loadBenefitsPublicPlatformData()
    {
        $this->runDoctrineDataFixtures(
            array(
                'GoIntegro\Bundle\BenefitsBundle\DataFixtures\ORM\PublicBenefitsPlatform\Fixture'
            )
        );
    }
    /**
     * @BeforeScenario @loadBenefitsRestrictedPlatformsData
     */
    public function loadBenefitsRestrictedPlatformsData()
    {
        $this->runDoctrineDataFixtures([
            "GoIntegro\Bundle\BenefitsBundle\DataFixtures\ORM\Category\RestrictedPlatforms\Fixture"
        ]);
    }

    /**
     * @BeforeScenario @loadGalleryBenefitsData
     */
    public function loadGalleryBenefitsData()
    {
        $this->runDoctrineDataFixtures([
            "GoIntegro\Bundle\BenefitsBundle\DataFixtures\ORM\Gallery\Fixture"
        ]);
    }

    /**
     * @BeforeScenario @loadSelectedBenefitsWidgetData
     */
    public function loadSelectedBenefitsWidgetData()
    {
        $this->runDoctrineDataFixtures([
            "GoIntegro\Bundle\BenefitsBundle\DataFixtures\ORM\SelectBenefitWidget\Fixture"
        ]);
    }

    /**
     * @BeforeScenario @loadBenefitsPlatformNoCupon
     */
    public function loadPlatformWithBenefitsNoCupon()
    {
        $this->runDoctrineDataFixtures([
            "GoIntegro\Bundle\BenefitsBundle\DataFixtures\BenefitTest\DontUsesCupon\Fixture"
        ]);
    }
}
