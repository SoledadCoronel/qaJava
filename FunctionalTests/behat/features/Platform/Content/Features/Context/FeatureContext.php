<?php

namespace GoIntegro\Bundle\ContentBundle\Features\Context;

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
     * Carga Artículos y categorias para testear
     * funcionalidades del area de Contenidos/artículos
     *
     * @BeforeScenario @loadArticlesAndCategories
     */
    public function loadArticlesAndCategories()
    {
        $this->runDoctrineDataFixtures([
            'GoIntegro\DataFixtures\ORM\Deprecated\ArticlesApp\LoadAccountData',
            'GoIntegro\DataFixtures\ORM\Deprecated\ArticlesApp\Accounts\LoadAccountsStandaloneData',
            'GoIntegro\Bundle\ContentBundle\DataFixtures\ORM\ArticleHomeAndDetail\LoadArticlesWithCategories'
        ]);
    }

    /**
     * Carga la estructura básica para crear un article content.
     * @BeforeScenario @loadArticleContentApp
     */
    public function loadArticleContentApp()
    {
        $this->runDoctrineDataFixtures([
            'GoIntegro\Bundle\ContentBundle\DataFixtures\ORM\ArticleContent\LoadAccountData'
        ]);
    }
}
