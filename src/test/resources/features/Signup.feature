@signup
Feature: Sign up

  Background:
    Given I navigate to url "https://waesworks.bitbucket.io"
    And I click Sign up link

  Scenario Outline: Validate Sign up permutations
    Given I fill Username field with value <username>
    And I fill Password field with value <password>
    And I fill Name field with value <name>
    And I fill E-mail field with value <email>
    And I fill Date of Birth Day combo with value <day>
    And I fill Date of Birth Month combo with value <month>
    And I fill Date of Birth Year combo with value <year>
    When I click Submit button
    Then I should be on the User Profile page
    And I should see text "Welcome to your new profile page" on screen
    Examples:
      | username          | password      | name       | email             | day          | month          |    year         |
      | "abdc"            | "c"           | "d"        | "e@e.com"         | "1"          | "April"        | "1987"          |
      | "bddd"            | "c"           | "d"        | "e@e.com"         | "22"         | "July"         | "1978"          |
      | "cedf"            | "c"           | "d"        | "ee@e.com"        | "3"          | "November"     | "2018"          |

  Scenario Outline: Validate max size of each field

  Scenario Outline: Validate requirement of each field

  Scenario: Username should not allow whitespace

  Scenario Outline: Email mask validations

  Scenario: Date of Birth should not be in the future

