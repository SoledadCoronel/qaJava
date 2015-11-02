<?php
/**
 * @package GoIntegro
 * @subpackage Bundle\CelebrationsBundle\Features\Context
 *
 */

namespace GoIntegro\Bundle\TournamentsBundle\Features\Context;

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

use Exception;

class FeatureContext extends GoIntegroContext
{
    /**
     * Datos básicos para aplicación de
     * torneos
     * Extiende de los datafixtures standard
     * @BeforeScenario @loadTournamentsStandardData
     */
    public function loadTournamentsStandardData()
    {
        $this->runDoctrineDataFixtures(
            array(
                'GoIntegro\Bundle\TournamentsBundle\DataFixtures\ORM\Standard\TournamentsStandardData'
            )
        );
    }

    /**
     * Datos básicos para aplicación de
     * torneos con score de usuarios para ranking
     * @BeforeScenario @loadUserScoreForRankingData
     */
    public function loadUserScoreForRankingData()
    {
        $this->runDoctrineDataFixtures(
            array(
                'GoIntegro\Bundle\TournamentsBundle\DataFixtures\ORM\UserScores\Fixture'
            )
        );
    }


    /**
     * @Given /^relleno el resultado del match "([^"]*)" con "([^"]*)" a "([^"]*)"$/
     */
    public function rellenoElResultadoDelMatchConA($match, $homeScore, $awayScore)
    {
        $script = <<<JS
            var homeScore = $("body").find("[data-match-prediction-home={$match}]");
            var awayScore = $("body").find("[data-match-prediction-away={$match}]");

            homeScore.val({$homeScore});
            awayScore.val({$awayScore});

            return homeScore.length > 0 && awayScore.length > 0;
JS;

        $success = $this->getSession()->evaluateScript($script);

        if (!$success) {
            throw new Exception('No se encontró el match correspondiente');
        }
    }

    /**
     * @Given /^el match "([^"]*)" tiene el resultado "([^"]*)" a "([^"]*)"$/
     */
    public function elMatchTieneElResultadoA($match, $homeScore, $awayScore)
    {
        $script = <<<JS
            var homeScore = $("body").find("[data-match-prediction-home={$match}]");
            var awayScore = $("body").find("[data-match-prediction-away={$match}]");

            return homeScore.val() == {$homeScore} && awayScore.val() == {$awayScore};
JS;

        $success = $this->getSession()->evaluateScript($script);

        if (!$success) {
            throw new Exception('El resultado del match no coincide ');
        }
    }

    /**
     * @Given /^debo acertar el resultado del match "([^"]*)" y ver "([^"]*)"$/
     */
    public function deboAcertarElResultadoDelMatchYVer($match, $title)
    {
        $script = <<<JS
            var prediction = $('.{$match}-predicted');

            if (prediction.length == 1 && prediction.parents('td').attr('title') == '{$title}') {
                return true;
            }
            return false;
JS;
        $success = $this->getSession()->evaluateScript($script);

        if (!$success) {
            throw new Exception('No se encuentra el hit de resultado');
        }
    }
}
