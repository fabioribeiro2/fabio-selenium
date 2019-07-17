@all
Feature: Login

  Background:
    Given I navigate to url "https://waesworks.bitbucket.io"
    And I click Login link in Login page
    Then I am in Login screen


  @login
  Scenario Outline: Validate Log in link not present after log in
    Given User <user> logs in using password <password>
    Then Log in link is not present on screen
    Examples:
      | user     | password   |
      | "admin"  | "hero"     |
      | "dev"    | "wizard"   |
      | "tester" | "maniac"   |

  @login
  Scenario Outline: Validate Sign up link not present after log in
    Given User <user> logs in using password <password>
    Then Sign up link is not present on screen
    Examples:
      | user     | password   |
      | "admin"  | "hero"     |
      | "dev"    | "wizard"   |
      | "tester" | "maniac"   |


  @login
  Scenario Outline: Validate Super Power
    Given User <user> logs in using password <password>
    Then the user has super power <superpower>
    Examples:
      | user   | password | superpower                        |
      | "admin"  | "hero"     | "Change the course of a waterfall"  |
      | "dev"    | "wizard"   | "Debug a repellent factory storage" |
      | "tester" | "maniac"   | "Voltage AND Current"               |

  @login
  Scenario Outline: Validate correct login by validating Logout link presence
    Given User <user> logs in using password <password>
    Then Log out link is present on screen
    Examples:
      | user     | password   |
      | "admin"  | "hero"     |
      | "dev"    | "wizard"   |
      | "tester" | "maniac"   |

  @login
  Scenario Outline: Validate correct login by validating Profile link presence
    Given User <user> logs in using password <password>
    Then Profile link is present on screen
    Examples:
      | user     | password   |
      | "admin"  | "hero"     |
      | "dev"    | "wizard"   |
      | "tester" | "maniac"   |

  @login
  Scenario Outline: Validate correct login by validating Details link presence
    Given User <user> logs in using password <password>
    Then Details link is present on screen
    Examples:
      | user     | password   |
      | "admin"  | "hero"     |
      | "dev"    | "wizard"   |
      | "tester" | "maniac"   |




  @login
  Scenario: Validate Log in link not present after logging in
    Given First Step
    When Second step
    Then Third Step

  @login
  Scenario: Validate Sign up link not present after logging in
    Given First Step
    When Second step
    Then Third Step

  @login
  Scenario: Validate logout behavior when user logged in
    Given First Step
    When Second step
    Then see "To get the full hero experience, you’ll need to log in" on screen
    And see "Log in" button

  @login
  Scenario: Validate username field label
    Given First Step
    When Second step
    Then Third Step

  @login
  Scenario: Validate password field label
    Given First Step
    When Second step
    Then Third Step

  @login
  Scenario: Validate Log in button label
    Given First Step
    When Second step
    Then Third Step

  @login
  Scenario: Validate Log in link label
    Given First Step
    When Second step
    Then Third Step

  @login
  Scenario: Validate Log heroes profile link label
    Given First Step
    When Second step
    Then Third Step

  @login
  Scenario: Validate Log heroes profile link landing
    Given First Step
    When Second step
    Then Third Step

  @login
  Scenario: Validate Sign up link label
    Given First Step
    When Second step
    Then Third Step

  @login
  Scenario: Validate Sign up link landing
    Given First Step
    When Second step
    Then Third Step