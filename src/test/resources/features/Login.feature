@all
Feature: Login

  Background:
    Given I navigate to url "https://waesworks.bitbucket.io"
    And I click "Login" button

  @login
  Scenario Outline: Validate user logged in message
    Given User <user> logs in using password <password>
    Then message <Login Message> is present on screen
    Examples:
      | user     | password   | Login Message                                              |
      | "admin"  | "hero"     | Logged in as Amazing Admin (a.admin@wearewaes.com)!        |
      | "dev"    | "wizard"   | Logged in as Zuper Dooper Dev (zd.dev@wearewaes.com)!      |
      | "tester" | "maniac"   | Logged in as Al Skept-Cal Tester (as.tester@wearewaes.com) |

  @login
  Scenario: Validate user welcome message
    Given First Step
    When Second step
    Then see "How are you doing" on screen

  @login
  Scenario Outline: Validate Super Power
    Given User <user> logs in
    When Second step
    Then super power is <superpower>
    Examples:
      | user   | password | superpower                        |
      | admin  | hero     | Change the course of a waterfall  |
      | dev    | wizard   | Debug a repellent factory storage |
      | tester | maniac   | Voltage AND Current               |

  @login
  Scenario: Validate Profile link present after logging in
    Given First Step
    When Second step
    Then Third Step

  @login
  Scenario: Validate Details link present after logging in
    Given First Step
    When Second step
    Then Third Step

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