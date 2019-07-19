@all
@profile
Feature: Profile

  Background:
    Given I navigate to url "https://waesworks.bitbucket.io"
    And I click Login link in Login page
    Then I am in Login screen

  Scenario: Validate Positive Access to Administrator Data
    Given User "admin" logs in using password "hero"
    Then I should be on the User Profile page
    And User Table List should be present

  Scenario Outline: Validate Negative Access to Administrator Data
    Given User <username> logs in using password <password>
    Then I should be on the User Profile page
    And User Table List should not be present
    Examples:
    | username         | password       |
    | "dev"            | "wizard"       |
    | "tester"         | "maniac"       |
