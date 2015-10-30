#  login test case
Feature: login
   As a user I would like to be able to enter Go Application
  given a username and a password

  Scenario: List 2 files in a directory
    Given I am in a directory "test"
    And I have a file named "foo"
    And I have a file named "bar"
    When I run "ls"
    Then I should get:
      """
      bar
      foo
      """

