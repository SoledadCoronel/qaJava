<?php

namespace GoIntegro\Bundle\NewsBundle\Features\Context;

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

/**
 * Feature context.
 */
class FeatureContext extends GoIntegroContext
{
    /**
     * @BeforeScenario @newsStandardData
     */
    public function loadStandardData()
    {
        $this->runDoctrineDataFixtures([
            'GoIntegro\Bundle\NewsBundle\DataFixtures\ORM\Standard\NewsStandardData'
        ]);
    }

    /**
     * @BeforeScenario @loadEmptyData
     */
    public function loadEmptyData()
    {
        $this->runDoctrineDataFixtures([
            'GoIntegro\Bundle\NewsBundle\DataFixtures\ORM\EmptyData\NewsEmptyData'
        ]);
    }
}
