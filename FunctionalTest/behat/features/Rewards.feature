# login feature

Feature: Rewards
  Navigate to Page
  Select an item from catalog

  Background:
    Given I am on "/auth/signin?_lang=es"
    When I fill in "_username" with " soledad.coronel@gointegro.com"
    When I fill in "_password" with "coquito25"
    When I press "_submit"

@javascript
  Scenario: Go to Rewards
    Given I am on "/auth/signin?_lang=es"
    When I fill in "_username" with " soledad.coronel@gointegro.com"
    When I fill in "_password" with "coquito25"
    And I press "_submit"
    And I wait for "Configurar" to appear
    Then I should see "Configurar" in the "header.app-name" element




