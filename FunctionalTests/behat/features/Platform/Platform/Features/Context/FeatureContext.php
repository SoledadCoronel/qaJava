<?php

namespace GoIntegro\Bundle\PlatformBundle\Features\Context;

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
    * @BeforeScenario @LoadEnvironmentData
    */
    public function loadEnvironmentData()
    {
        $this->runDoctrineDataFixtures(array(
            'GoIntegro\Bundle\PlatformBundle\DataFixtures\Environment\LoadStandardData'
        ));
    }

    /**
     * Carga los fixtures para el test de lista de colaboradores.
     * @BeforeScenario @loadCollaboratorData
     */
    public function loadCollaboratorData()
    {
        $this->runDoctrineDataFixtures(array(
            'GoIntegro\Bundle\PlatformBundle\DataFixtures\ORM\Collaborators\LoadAccountData'
        ));
    }

    /**
    * Load data from fixture to create a Platform without a default Environment
    *
    * @BeforeScenario @LoadNonEnvironmentData
    */
    public function loadNonEnvironmentData()
    {
        $this->runDoctrineDataFixtures(array(
            'GoIntegro\Bundle\PlatformBundle\DataFixtures\Environment\LoadNonEnvironmentData'
        ));
    }

    /**
    * Load data from fixture to create a Platform with an Environment, Workspaces and Apps
    *
    * @BeforeScenario @loadWorkspaceListData
    */
    public function loadWorkspaceListData()
    {
        $this->runDoctrineDataFixtures(array(
            'GoIntegro\Bundle\PlatformBundle\DataFixtures\Environment\LoadWorkspaceListData'
        ));
    }

    /**
     * Load data from fixture to create a Platform with an Environment, Workspaces and Apps
     *
     * @BeforeScenario @loadWorkspaceSortData
     */
    public function loadWorkspaceSortData()
    {
        $this->runDoctrineDataFixtures(array(
            'GoIntegro\Bundle\PlatformBundle\DataFixtures\SortWorkspace\LoadStandardData'
        ));
    }

    /**
     * Load data from fixture to create a Platform with an Environment, Workspaces and Apps
     *
     * @BeforeScenario @loadWorkspaceWithCollaborators
     */
    public function loadWorkspaceWithCollaborators()
    {
        $this->runDoctrineDataFixtures(array(
            'GoIntegro\Bundle\PlatformBundle\DataFixtures\Workspace\JoinCollaborators\LoadWorkspaceWithCollaborators'
        ));
    }

    /**
     * @BeforeScenario @loadPlatformStandardUserVisibilityData
     */
    public function loadPlatformStandardUserVisibilityData()
    {
        $this->runDoctrineDataFixtures(['GoIntegro\DataFixtures\ORM\Standard\Platform\UserVisibility\Fixture']);
    }

     /**
     *
     * @BeforeScenario @loadPlatformAndEnvironments
     */
    public function loadPlatformAndEnvironments()
    {
        $this->runDoctrineDataFixtures(array(
            'GoIntegro\DataFixtures\ORM\Standard\Platform\Fixture',
            'GoIntegro\DataFixtures\ORM\Standard\User\Fixture',
            'GoIntegro\DataFixtures\ORM\Standard\Environment\Fixture'
        ));
    }


    /**
     * @Given /^debo ver el espacio "([^"]*)" activado$/
     */
    public function deboVerElEspacioActivado($space)
    {
        $script = <<<JS
var space = $("ul.spaces:contains('{{SPACE}}')");
if (space) {
    return !space.hasClass("off");
} else {
    return false;
}
JS;
        $script = str_replace("{{SPACE}}", $space, $script);
        if(!$this->getSession()->evaluateScript($script)){
            sleep(10);
            throw new \Exception("El espacio no esta activo");
        }
    }

    /**
     * @Given /^debo ver el espacio "([^"]*)" desactivado$/
     */
    public function deboVerElEspacioDesactivado($space)
    {
        $script = <<<JS
var space = $("ul.spaces:contains('{{SPACE}}')");
if (space) {
    return space.hasClass("off");
} else {
    return false;
}
JS;
        $script = str_replace("{{SPACE}}", $space, $script);
        if(!$this->getSession()->evaluateScript($script)){
            sleep(10);
            throw new \Exception("El espacio no esta inactivo");
        }
    }

    /**
     * Load data from fixture to create a Platform with an Environment
     *
     * @BeforeScenario @loadWorkspaceStandardData
     */
    public function loadWorkspaceStandardData()
    {
        $this->runDoctrineDataFixtures(array(
            'GoIntegro\Bundle\PlatformBundle\DataFixtures\Workspace\LoadWorkspaceStandardData\Fixture'
        ));
    }

    /**
     * @Given /^selecciono "([^"]*)" en el combo "([^"]*)"$/
     */
    public function seleccionoEnElCombo($label, $selectElement)
    {
        $select = $this->fixStepArgument($selectElement);
        $option = $this->fixStepArgument($label);
        $this->getSession()->getPage()->selectFieldOption($select, $option);
        $this->getSession()->executeScript("$('select[name=\"{$selectElement}\"]').change();");
    }

    /**
     * Load data from fixture to User Workspace Overlay
     *
     * @BeforeScenario @loadUsersWorkspaceData
     */
    public function loadUsersWorkspaceData()
    {
        $this->runDoctrineDataFixtures(array(
            'GoIntegro\Bundle\PlatformBundle\DataFixtures\UsersWorkspace\LoadStandardData'
        ));
    }

    /**
     * @Given /^no debo ver el espacio "([^"]*)" en "([^"]*)"$/
     */
    public function noDeboVerElEspacioEn($workspaceName, $container)
    {
        $this->getSession()->wait(self::BEHAT_AJAX_TIMEOUT,
            "$('$container').find(':contains($workspaceName)').length === 0"
        );
    }

    /**
     * Load data from fixture to Redirect Empty Workspace
     *
     * @BeforeScenario @loadRedirectWorkspaceData
     */
    public function loadRedirectWorkspaceData()
    {
        $this->runDoctrineDataFixtures(array(
            'GoIntegro\Bundle\PlatformBundle\DataFixtures\Workspace\LoadRedirectWorkspaceData'
        ));
    }

    /**
     * Load data from fixture to create Home widgets
     *
     * @BeforeScenario @loadHomeData
     */
    public function loadHomeData()
    {
        $this->runDoctrineDataFixtures(array(
            'GoIntegro\Bundle\PlatformBundle\DataFixtures\Home\LoadHomeData'
        ));
    }

    /**
     * @BeforeScenario @loadTermsAndConditionsData
     */
    public function loadTermsAndConditionsData()
    {
        $this->runDoctrineDataFixtures(array(
            'GoIntegro\DataFixtures\ORM\Standard\User\Fixture'
        ));
    }

    /**
     * @BeforeScenario @loadInstallApplicationWidgetData
     */
    public function loadInstallApplicationWidgetData()
    {
        $this->runDoctrineDataFixtures(
            array(
                'GoIntegro\DataFixtures\ORM\Standard\Platform\Fixture',
                'GoIntegro\DataFixtures\ORM\Standard\Environment\Fixture'
            )
        );
    }

    /**
     * @BeforeScenario @loadLanguageTestData
     */
    public function loadLanguageTestData()
    {
        $this->runDoctrineDataFixtures([
            'GoIntegro\Bundle\PlatformBundle\DataFixtures\ORM\Language\LoadLanguageTestData'
        ]);
    }

    /**
     * @BeforeScenario @loadShowUserEmail
     */
    public function loadShowUserEmail()
    {
        $this->runDoctrineDataFixtures(array(
            'GoIntegro\Bundle\PlatformBundle\DataFixtures\ORM\Standard\ShowUserEmail'
        ));
    }

    /**
     * @Given /^Selecciono idioma (\S+)$/
     */
    public function seleccionoIdioma($language)
    {

        $langMapping = array('Español' => 'es_ES', 'English' => 'en_US', 'Português' => 'pt_BR');

        if (!empty($langMapping[$language])) {
            $selector = sprintf('$(".locale-selection ul li a[data-locale=\'%s\']")', $langMapping[$language]);

            $this->getSession()->executeScript($selector.'.click();');
        }

    }
}
