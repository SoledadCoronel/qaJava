<?php
/**
 * @package GoIntegro
 * @subpackage Bundle\RewardsBundle\Features\Context
 */

namespace GoIntegro\Bundle\RewardsBundle\Features\Context;


use GoIntegro\Context\FeatureContext as GoIntegroContext;


class FeatureContext extends GoIntegroContext
{

    /**
     * Extiende de los datafixtures standard
     * @BeforeScenario @loadStandardData
     */
    public function loadStandardData()
    {
        $this->runDoctrineDataFixtures(
            array(
                'GoIntegro\Bundle\PlatformBundle\DataFixtures\ORM\Standard\Environment\Fixture'
            )
        );
    }
}