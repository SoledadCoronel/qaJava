<?php
/**
 * GoIntegro\Bundle\ProfileBundle\Features\Context\FeatureContext
 *
 * @author Gabriel Alberto Sarmentero <gabriel.sarmentero@gointegro.com>
 */
namespace GoIntegro\Bundle\ProfileBundle\Features\Context;

use GoIntegro\Context\FeatureContext as GoIntegroContext;

class FeatureContext extends GoIntegroContext
{
    /**
     * @BeforeScenario @loadUserAndPostData
     */
    public function loadUserAndPostData()
    {
        $this->runDoctrineDataFixtures(['GoIntegro\Bundle\ProfileBundle\DataFixtures\ORM\Profile\ProfileStandardData']);
    }

    /**
     * @BeforeScenario @loadProfileWithoutMail
     */
    public function loadProfileWithoutMail()
    {
        $this->runDoctrineDataFixtures(['GoIntegro\Bundle\ProfileBundle\DataFixtures\ORM\Profile\ProfileWithoutMail']);
    }

    /**
     * @BeforeScenario @loadWorkspaceData
     */
    public function loadWorkspaceData()
    {
        $this->runDoctrineDataFixtures(['GoIntegro\Bundle\ProfileBundle\DataFixtures\ORM\UserWorkspaces\LoadStandardData']);
    }
}
