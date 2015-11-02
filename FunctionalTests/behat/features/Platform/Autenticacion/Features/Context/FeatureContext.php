<?php

namespace GoIntegro\Bundle\AuthBundle\Features\Context;

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
     * Load data from fixture to create a Platform with mail and password auth strategy
     *
     * @BeforeScenario @mailAndPasswordPlatform
     */
    public function loadMailAndPasswordPlatformData()
    {
        $this->runDoctrineDataFixtures(array(
            'GoIntegro\Bundle\AuthBundle\DataFixtures\ORM\Account\LoadStandardData',
            'GoIntegro\Bundle\AuthBundle\DataFixtures\ORM\Platform\LoadStandardData',
            'GoIntegro\Bundle\AuthBundle\DataFixtures\ORM\AuthStrategy\LoadMailAndPasswordPlatformStrategy',
            'GoIntegro\Bundle\AuthBundle\DataFixtures\ORM\User\LoadCommonUserData',
        ));
    }

    /**
     * Load data from fixture to create a Platform with mail and password auth strategy and user to change password
     *
     * @BeforeScenario @forgotPassword
     */
    public function loadForgotPasswordData()
    {
        $this->runDoctrineDataFixtures(array(
            'GoIntegro\Bundle\AuthBundle\DataFixtures\ORM\RecoverPassword\LoadStandardData'
        ));
    }

    /**
     * Load data from fixture to create a Platform with mail and password auth strategy and user to change password but expired
     *
     * @BeforeScenario @forgotPasswordExpired
     */
    public function loadForgotPasswordExpiredData()
    {
        $this->runDoctrineDataFixtures(array(
            'GoIntegro\Bundle\AuthBundle\DataFixtures\ORM\RecoverPassword\LoadExpiredData'
        ));
    }

    /**
     * Load data from fixture to create a Document Only Platform environment
     *
     * @BeforeScenario @usernameOnlyPlatform
     */
    public function loadUsernameOnlyPlatform()
    {
        $this->runDoctrineDataFixtures(array(
            'GoIntegro\Bundle\AuthBundle\DataFixtures\ORM\Account\LoadStandardData',
            'GoIntegro\Bundle\AuthBundle\DataFixtures\ORM\Platform\LoadStandardData',
            'GoIntegro\Bundle\AuthBundle\DataFixtures\ORM\AuthStrategy\LoadUsernameOnlyPlatformStrategy',
            'GoIntegro\Bundle\AuthBundle\DataFixtures\ORM\User\LoadWithoutPasswordUserData',
        ));
    }

    /**
     * Load data from fixture to create a Platform with mail and password auth strategy
     *
     * @BeforeScenario @documentAndPasswordPlatform
     */
    public function loadDocumentAndPasswordPlatformData()
    {
        $this->runDoctrineDataFixtures(array(
            'GoIntegro\Bundle\AuthBundle\DataFixtures\ORM\Account\LoadStandardData',
            'GoIntegro\Bundle\AuthBundle\DataFixtures\ORM\Platform\LoadStandardData',
            'GoIntegro\Bundle\AuthBundle\DataFixtures\ORM\AuthStrategy\LoadDocumentAndPasswordPlatformStrategy',
            'GoIntegro\Bundle\AuthBundle\DataFixtures\ORM\User\LoadCommonUserData',
        ));
    }

    /**
     * Load data from fixture to create a Regional Company with mail and password auth strategy
     *
     * @BeforeScenario @documentAndPasswordRegional
     */
    public function loadDocumentAndPasswordRegionalData()
    {
        $this->runDoctrineDataFixtures(array(
            'GoIntegro\Bundle\AuthBundle\DataFixtures\ORM\RegionalAccount\LoadRegionalData',
            'GoIntegro\Bundle\AuthBundle\DataFixtures\ORM\Account\LoadRegionalData',
            'GoIntegro\Bundle\AuthBundle\DataFixtures\ORM\Platform\LoadRegionalData',
            'GoIntegro\Bundle\AuthBundle\DataFixtures\ORM\AuthStrategy\LoadDocumentAndPasswordRegionalCompanyStrategy',
            'GoIntegro\Bundle\AuthBundle\DataFixtures\ORM\User\LoadRegionalUserData',
        ));
    }

    /**
     * Load data from fixture to create a Regional Company with mail and password auth strategy and same user un two platforms
     *
     * @BeforeScenario @documentAndPasswordRegionalWithTwoUsers
     */
    public function loadDocumentAndPasswordRegionalWithTwoUsersData()
    {
        $this->runDoctrineDataFixtures(array(
            'GoIntegro\Bundle\AuthBundle\DataFixtures\ORM\RegionalAccount\LoadRegionalData',
            'GoIntegro\Bundle\AuthBundle\DataFixtures\ORM\Account\LoadRegionalData',
            'GoIntegro\Bundle\AuthBundle\DataFixtures\ORM\Platform\LoadRegionalData',
            'GoIntegro\Bundle\AuthBundle\DataFixtures\ORM\AuthStrategy\LoadDocumentAndPasswordRegionalCompanyStrategy',
            'GoIntegro\Bundle\AuthBundle\DataFixtures\ORM\User\LoadRegionalTwoSameUsersData',
        ));
    }

    /**
     * @BeforeScenario @registerSimpleSignupEmail
     */
    public function loadSimpleSignupEmail()
    {
        $this->runDoctrineDataFixtures(array(
            'GoIntegro\Bundle\AuthBundle\DataFixtures\ORM\SimpleSignup\LoadSimpleSignupEmail',
        ));
    }

    /**
     * @BeforeScenario @registerSimpleSignupEmailAndPassword
     */
    public function loadSimpleSignupEmailAndPassword()
    {
        $this->runDoctrineDataFixtures(array(
            'GoIntegro\Bundle\AuthBundle\DataFixtures\ORM\SimpleSignup\LoadSimpleSignupEmailPassword',
        ));
    }

    /**
     *
     *
     * @BeforeScenario @registerSimpleSignupDocument
     */
    public function loadSimpleSignupDocument()
    {
        $this->runDoctrineDataFixtures(array(
            'GoIntegro\Bundle\AuthBundle\DataFixtures\ORM\SimpleSignup\LoadSimpleSignupDocument',
        ));
    }

    /**
     * @BeforeScenario @registerSimpleSignupDocumentPassword
     */
    public function loadSimpleSignupDocumentAndPassword()
    {
        $this->runDoctrineDataFixtures(array(
            'GoIntegro\Bundle\AuthBundle\DataFixtures\ORM\SimpleSignup\LoadSimpleSignupDocumentPassword',
        ));
    }

    /**
     * @BeforeScenario @registerSimpleSignupId
     */
    public function loadSimpleSignupId()
    {
        $this->runDoctrineDataFixtures(array(
            'GoIntegro\Bundle\AuthBundle\DataFixtures\ORM\SimpleSignup\LoadSimpleSignupId',
        ));
    }

    /**
     * @BeforeScenario @registerSimpleSignupIdPassword
     */
    public function loadSimpleSignupIdAndPassword()
    {
        $this->runDoctrineDataFixtures(array(
            'GoIntegro\Bundle\AuthBundle\DataFixtures\ORM\SimpleSignup\LoadSimpleSignupIdPassword'
        ));
    }


    /**
     * @BeforeScenario @registerSimpleSignupEmailAndGender
     */
     public function loadSignUpEmailVariableFieldGender()
     {
         $this->runDoctrineDataFixtures(array(
            'GoIntegro\Bundle\AuthBundle\DataFixtures\ORM\SignupVariablFields\LoadSignUpEmailVariableFieldGender'
        ));
     }

    /**
     * @BeforeScenario @registerSimpleSignupEmailAndBirthDate
     */
     public function loadSignUpEmailVariableFieldBirthDate()
     {
        $this->runDoctrineDataFixtures(array(
            'GoIntegro\Bundle\AuthBundle\DataFixtures\ORM\SignupVariablFields\LoadSignUpEmailVariableFieldBirthDate'
        ));
     }

    /**
     * @BeforeScenario @registerSimpleSignupEmailAndBirthDateAndGenderAndCard
     */
     public function loadSignUpEmailVariableFieldBirthDateAndGender()
     {
        $this->runDoctrineDataFixtures(array(
            'GoIntegro\Bundle\AuthBundle\DataFixtures\ORM\SignupVariablFields\LoadSignUpEmailVariableFieldBirthDateAndGenderAndCard'
        ));
     }

     /**
     * @BeforeScenario @@registerSimpleSignupEmailAndCard
     */
     public function loadSignUpEmailVariableFieldCard()
     {
        $this->runDoctrineDataFixtures(array(
            'GoIntegro\Bundle\AuthBundle\DataFixtures\ORM\SignupVariablFields\LoadSignUpEmailVariableFieldCard'
        ));
     }

    /**
     *  Load data from fixture to create platforms with simple verification
     *
     * @BeforeScenario @simpleVerificationData
     */
    public function loadSimpleVerificationData()
    {
        $this->runDoctrineDataFixtures(array(
            'GoIntegro\Bundle\AuthBundle\DataFixtures\ORM\Account\LoadStandardData',
            'GoIntegro\Bundle\AuthBundle\DataFixtures\ORM\Platform\LoadSimpleVerificationData',
            'GoIntegro\Bundle\AuthBundle\DataFixtures\ORM\VerificationStrategy\LoadSimpleVerificationData',
            'GoIntegro\Bundle\AuthBundle\DataFixtures\ORM\SignupConfig\LoadSignupVerificationData',
            'GoIntegro\Bundle\AuthBundle\DataFixtures\ORM\AuthStrategy\LoadSimpleVerificationData',
            'GoIntegro\Bundle\AuthBundle\DataFixtures\ORM\User\LoadCommonUsersVerificationData'
        ));
    }
    /**
     * Load data from fixture to create platforms with double verification
     *
     * @BeforeScenario @doubleVerificationData
     */
    public function loadDoubleVerificationData()
    {
        $this->runDoctrineDataFixtures(array(
            'GoIntegro\Bundle\AuthBundle\DataFixtures\ORM\Account\LoadStandardData',
            'GoIntegro\Bundle\AuthBundle\DataFixtures\ORM\Platform\LoadDoubleVerificationData',
            'GoIntegro\Bundle\AuthBundle\DataFixtures\ORM\SignupConfig\LoadSignupDoubleVerificationData',
            'GoIntegro\Bundle\AuthBundle\DataFixtures\ORM\VerificationStrategy\LoadDoubleVerificationData',
            'GoIntegro\Bundle\AuthBundle\DataFixtures\ORM\AuthStrategy\LoadDoubleVerificationData',
            'GoIntegro\Bundle\AuthBundle\DataFixtures\ORM\User\LoadCommonUsersDoubleVerificationData'
        ));
    }

    /**
     * Load data from fixture to create regional platforms with verification
     *
     * @BeforeScenario @regionalVerificationData
     */
    public function loadRegionalVerificationData()
    {
        $this->runDoctrineDataFixtures(array(
            'GoIntegro\Bundle\AuthBundle\DataFixtures\ORM\RegionalAccount\LoadRegionalVerificationData',
            'GoIntegro\Bundle\AuthBundle\DataFixtures\ORM\Account\LoadRegionalVerificationData',
            'GoIntegro\Bundle\AuthBundle\DataFixtures\ORM\Platform\LoadRegionalVerificationData',
            'GoIntegro\Bundle\AuthBundle\DataFixtures\ORM\VerificationStrategy\LoadRegionalVerificationData',
            'GoIntegro\Bundle\AuthBundle\DataFixtures\ORM\AuthStrategy\LoadRegionalVerificationData',
            'GoIntegro\Bundle\AuthBundle\DataFixtures\ORM\User\LoadCommonUsersRegionalVerificationData'
        ));
    }

    /**
     * Load data from fixture to create regional platforms with verification
     *
     * @BeforeScenario @regionalSignupData
     */
    public function loadRegionalSignupData()
    {
         $this->runDoctrineDataFixtures(array(
            'GoIntegro\Bundle\AuthBundle\DataFixtures\ORM\SignupRegional\LoadRegionalSignupEnvironment\Fixture'
        ));
    }

    /**
     * Load data from fixture to create regional platforms with verification
     *
     * @BeforeScenario @regionalVerificationSignupData
     */
    public function loadRegionalVerificationSignupData()
    {
        $this->runDoctrineDataFixtures(array(
            'GoIntegro\Bundle\AuthBundle\DataFixtures\ORM\SignupRegional\LoadRegionalVerificationSignupEnvironment'
        ));
    }
}
