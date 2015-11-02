<?php

/**
 * @package GoIntegro
 * @subpackage Bundle
 * @subpackage HelpCenterBundle
 * @subpackage Features
 * @subpackage Context
 *
 * @author Gabriel Alberto Sarmentero <gabriel.sarmentero@gointegro.com>
 */
namespace GoIntegro\Bundle\HelpCenterBundle\Features\Context;

use GoIntegro\Context\FeatureContext as GoIntegroContext;

class FeatureContext extends GoIntegroContext
{
    /**
     * @BeforeScenario @loadHelpCenterData
     */
    public function loadHelpCenterData()
    {
        $this->runDoctrineDataFixtures(
            array('GoIntegro\Bundle\HelpCenterBundle\DataFixtures\ORM\HelpCenterStandardData')
        );
    }
}
