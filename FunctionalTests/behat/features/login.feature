# login feature

Feature: Search
  In order to see a word definition
  As a website user
  I need to be able to search for a word

@javascript
  Scenario: Login into automation site
    Given I am on "/auth/signin?_lang=es"
    When I fill in "_username" with " soledad.coronel@gointegro.com"
    When I fill in "_password" with "coquito25"
    And I press "_submit"
    And I wait for "Configurar" to appear
    Then I should see "Configurar" in the "header.app-name" element




