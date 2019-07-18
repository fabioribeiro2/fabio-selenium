@all
Feature: Login

  Background:
    Given I navigate to url "https://waesworks.bitbucket.io"
    And I click Login link in Login page
    Then I am in Login screen

  @login
  Scenario Outline: Validate incorrect login credentials
    Given User <user> logs in using password <password>
    Then Wrong credentials message is shown on screen
    And Login button is present on screen
    Examples:
      | user     | password   |
      | "admin"  | "wrong"    |
      | "dev"    | "wrong"    |
      | "tester" | "wrong"    |
      | "insanelylongusernameeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee" | "insanelylongpasswordddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd"    |

  @login
  Scenario Outline: Validate correct logout behavior
    Given User <user> logs in using password <password>
    When Log out link is present on screen
    And I log out
    Then Sign up link is present on screen
    And Login link is present on screen
    And Login button is present on screen
    Examples:
      | user     | password   |
      | "admin"  | "hero"     |
      | "dev"    | "wizard"   |
      | "tester" | "maniac"   |

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
  Scenario: Validate Log heroes profile link landing
    Given First Step
    When Second step
    Then Third Step

  @login
    Scenario Outline: Validate labels
    Given User <user> logs in using password <password>
    Then Details link is present on screen
    Examples:
      | user     | password   |
      | "admin"  | "hero"     |
      | "dev"    | "wizard"   |
      | "tester" | "maniac"   |

