@all
@signup
Feature: Sign up

  Background:
    Given I navigate to url "https://waesworks.bitbucket.io"
    And I click Sign up link
    Then I should be on the Sign up page

  Scenario: Validate Birth Date is not allowed to be in the future
    Given I fill Username field with value "User1 with whitespaces"
    And I fill Password field with value "GoodPassword#"
    And I fill Name field with value "Name 1"
    And I fill E-mail field with value "email1@email.com"
    And I fill Birth Date with values that are in the future
    When I click Submit button
    Then I should not be on the User Profile page
    And I should be on the Sign up page

  Scenario Outline: Validate E-mail format complies with Industry standards
    Given I fill Username field with value <username>
    And I fill Password field with value <password>
    And I fill Name field with value <name>
    And I fill E-mail field with value <email>
    And I fill Date of Birth Day combo with value <day>
    And I fill Date of Birth Month combo with value <month>
    And I fill Date of Birth Year combo with value <year>
    When I click Submit button
    Then I should not be on the User Profile page
    And I should be on the Sign up page
    Examples:
      | username           | password              | name          | email                        | day          | month          |    year         |
      | "User1"            | "GoodPassword#"       | "Name"        | "wrong-email"                | "1"          | "April"        | "1987"          |
      | "User2"            | "GoodPassword#"       | "Name"        | "wrong-email@"               | "22"         | "July"         | "1978"          |
      | "User3"            | "GoodPassword#"       | "Name"        | "wrong-email@."              | "3"          | "November"     | "2018"          |
      | "User4"            | "GoodPassword#"       | "Name"        | "wrong-email@.a"             | "3"          | "November"     | "2018"          |
      | "User5"            | "GoodPassword#"       | "Name"        | "wrong-email@a."             | "3"          | "November"     | "2018"          |
      | "User6"            | "GoodPassword#"       | "Name"        | "wrong-email.@test.com"      | "3"          | "November"     | "2018"          |
      | "User7"            | "GoodPassword#"       | "Name"        | ".wrong-email@test.com"      | "3"          | "November"     | "2018"          |
      | "User8"            | "GoodPassword#"       | "Name"        | "wrong-email@test..com"      | "3"          | "November"     | "2018"          |
      | "User9"            | "GoodPassword#"       | "Name"        | "wrong..email@test.com"      | "3"          | "November"     | "2018"          |
      | "User10"           | "GoodPassword#"       | "Name"        | "wrong-email@test.com@"      | "22"         | "July"         | "1978"          |
      | "User11"           | "GoodPassword#"       | "Name"        | "wrong-email@@test.com"      | "22"         | "July"         | "1978"          |
      | "User12"           | "GoodPassword#"       | "Name"        | "wrong-email@test@test.com"  | "22"         | "July"         | "1978"          |
      | "User13"           | "GoodPassword#"       | "Name"        | "@wrong-email@test.com"      | "22"         | "July"         | "1978"          |

  Scenario Outline: Validate E-mail format complies with Industry standards
    Given I fill Username field with value <username>
    And I fill Password field with value <password>
    And I fill Name field with value <name>
    And I fill E-mail field with value <email>
    And I fill Date of Birth Day combo with value <day>
    And I fill Date of Birth Month combo with value <month>
    And I fill Date of Birth Year combo with value <year>
    When I click Submit button
    Then I should not be on the User Profile page
    And I should be on the Sign up page
    Examples:
      | username           | password              | name            | email                      | day          | month          |    year         |
      | "User1"            | "GoodPassword#"       | "Name 1"        | "wrong-email"              | "1"          | "April"        | "1987"          |
      | "User2"            | "GoodPassword#"       | "Name 2"        | "wrong-email@"             | "22"         | "July"         | "1978"          |
      | "User3"            | "GoodPassword#"       | "Name 3"        | "wrong-email@."            | "3"          | "November"     | "2018"          |
      | "User4"            | "GoodPassword#"       | "Name 3"        | "wrong-email@.a"           | "3"          | "November"     | "2018"          |
      | "User5"            | "GoodPassword#"       | "Name 3"        | "wrong-email@a."           | "3"          | "November"     | "2018"          |
      | "User6"            | "GoodPassword#"       | "Name 3"        | "wrong-email.@test.com"    | "3"          | "November"     | "2018"          |
      | "User7"            | "GoodPassword#"       | "Name 3"        | ".wrong-email@test.com"    | "3"          | "November"     | "2018"          |
      | "User8"            | "GoodPassword#"       | "Name 3"        | "wrong-email@test..com"    | "3"          | "November"     | "2018"          |
      | "User9"            | "GoodPassword#"       | "Name 3"        | "wrong..email@test.com"    | "3"          | "November"     | "2018"          |

  Scenario Outline: Validate Password Requirements of minimum 8 characters, 1 Upper case and 1 lower case characters, 1 special character
    Given I fill Username field with value <username>
    And I fill Password field with value <password>
    And I fill Name field with value <name>
    And I fill E-mail field with value <email>
    And I fill Date of Birth Day combo with value <day>
    And I fill Date of Birth Month combo with value <month>
    And I fill Date of Birth Year combo with value <year>
    When I click Submit button
    Then I should not be on the User Profile page
    And I should be on the Sign up page
    Examples:
      | username           | password                   | name            | email                      | day          | month          |    year         |
      | "User1"            | "$hortPw"                  | "Name 1"        | "email1@email.com"         | "1"          | "April"        | "1987"          |
      | "User2"            | "all-lower-case#"          | "Name 2"        | "email2@email.com"         | "22"         | "July"         | "1978"          |
      | "User3"            | "noSpecialCharacter"       | "Name 3"        | "email3@email.com"         | "3"          | "November"     | "2018"          |

  Scenario: Validate Username field should not allow whitespaces
    Given I fill Username field with value "User1 with whitespaces"
    And I fill Password field with value "GoodPassword#"
    And I fill Name field with value "Name 1"
    And I fill E-mail field with value "email1@email.com"
    And I fill Date of Birth Day combo with value "1"
    And I fill Date of Birth Month combo with value "April"
    And I fill Date of Birth Year combo with value "1987"
    When I click Submit button
    Then I should not be on the User Profile page
    And I should be on the Sign up page

  Scenario: Validate Username field required
    Given I fill Password field with value "GoodPassword#"
    And I fill Name field with value "Name 1"
    And I fill E-mail field with value "email1@email.com"
    And I fill Date of Birth Day combo with value "1"
    And I fill Date of Birth Month combo with value "April"
    And I fill Date of Birth Year combo with value "1987"
    When I click Submit button
    Then I should not be on the User Profile page
    And I should be on the Sign up page

  Scenario: Validate Password field required
    Given I fill Username field with value "User1"
    And I fill Name field with value "Name 1"
    And I fill E-mail field with value "email1@email.com"
    And I fill Date of Birth Day combo with value "1"
    And I fill Date of Birth Month combo with value "April"
    And I fill Date of Birth Year combo with value "1987"
    When I click Submit button
    Then I should not be on the User Profile page
    And I should be on the Sign up page

  Scenario: Validate Name field required
    Given I fill Username field with value "User1"
    And I fill Password field with value "GoodPassword#"
    And I fill E-mail field with value "email1@email.com"
    And I fill Date of Birth Day combo with value "1"
    And I fill Date of Birth Month combo with value "April"
    And I fill Date of Birth Year combo with value "1987"
    When I click Submit button
    Then I should not be on the User Profile page
    And I should be on the Sign up page

  Scenario: Validate E-mail field required
    Given I fill Username field with value "User1"
    And I fill Password field with value "GoodPassword#"
    And I fill Name field with value "Name 1"
    And I fill Date of Birth Day combo with value "1"
    And I fill Date of Birth Month combo with value "April"
    And I fill Date of Birth Year combo with value "1987"
    When I click Submit button
    Then I should not be on the User Profile page
    And I should be on the Sign up page

  Scenario: Validate Date of Birth Day field required
    Given I fill Username field with value "User1"
    And I fill Password field with value "GoodPassword#"
    And I fill Name field with value "Name 1"
    And I fill E-mail field with value "email1@email.com"
    And I fill Date of Birth Month combo with value "April"
    And I fill Date of Birth Year combo with value "1987"
    When I click Submit button
    Then I should not be on the User Profile page
    And I should be on the Sign up page

  Scenario: Validate Date of Birth Month field required
    Given I fill Username field with value "User1"
    And I fill Password field with value "GoodPassword#"
    And I fill Name field with value "Name 1"
    And I fill E-mail field with value "email1@email.com"
    And I fill Date of Birth Day combo with value "1"
    And I fill Date of Birth Year combo with value "1987"
    When I click Submit button
    Then I should not be on the User Profile page
    And I should be on the Sign up page

  Scenario: Validate Date of Birth Year field required
    Given I fill Username field with value "User1"
    And I fill Password field with value "GoodPassword#"
    And I fill Name field with value "Name 1"
    And I fill E-mail field with value "email1@email.com"
    And I fill Date of Birth Day combo with value "1"
    And I fill Date of Birth Month combo with value "April"
    When I click Submit button
    Then I should not be on the User Profile page
    And I should be on the Sign up page

  Scenario: Validate max size of 100 for field Username - Error with Username size of 101
    Given I fill Username field with value "reallylongusername-reallylongusername-reallylongusername-reallylongusername-reallylongusername-really"
    And I fill Password field with value "GoodPassword#"
    And I fill Name field with value "Name 1"
    And I fill E-mail field with value "email1@email.com"
    And I fill Date of Birth Day combo with value "1"
    And I fill Date of Birth Month combo with value "April"
    And I fill Date of Birth Year combo with value "1987"
    When I click Submit button
    Then I should not be on the User Profile page
    And I should be on the Sign up page

  Scenario: Validate max size of 100 for field Username - Success with Username size of 100
    Given I fill Username field with value "reallylongusername-reallylongusername-reallylongusername-reallylongusername-reallylongusername-reall"
    And I fill Password field with value "GoodPassword#"
    And I fill Name field with value "Name 1"
    And I fill E-mail field with value "email1@email.com"
    And I fill Date of Birth Day combo with value "1"
    And I fill Date of Birth Month combo with value "April"
    And I fill Date of Birth Year combo with value "1987"
    When I click Submit button
    Then I should be on the User Profile page
    And I should see text "Welcome to your new profile page" on screen

  Scenario: Validate max size of 30 for field Password - Error with Password size of 31
    Given I fill Username field with value "User1"
    And I fill Password field with value "reallylongpassword-Reallylongp#"
    And I fill Name field with value "Name 1"
    And I fill E-mail field with value "email1@email.com"
    And I fill Date of Birth Day combo with value "1"
    And I fill Date of Birth Month combo with value "April"
    And I fill Date of Birth Year combo with value "1987"
    When I click Submit button
    Then I should not be on the User Profile page
    And I should be on the Sign up page

  Scenario: Validate max size of 30 for field Password - Success with Password size of 30
    Given I fill Username field with value "User1"
    And I fill Password field with value "reallylongpassword-Reallylong#"
    And I fill Name field with value "Name 1"
    And I fill E-mail field with value "email1@email.com"
    And I fill Date of Birth Day combo with value "1"
    And I fill Date of Birth Month combo with value "April"
    And I fill Date of Birth Year combo with value "1987"
    When I click Submit button
    Then I should be on the User Profile page
    And I should see text "Welcome to your new profile page" on screen

  Scenario: Validate max size of 200 for field Name - Error with Name size of 201
    Given I fill Username field with value "User1"
    And I fill Password field with value "GoodPassword#"
    And I fill Name field with value "reallylongname-reallylongname-reallylongname-reallylongname-reallylongname-reallylongname-reallylongname-reallylongname-reallylongname-reallylongname-reallylongname-reallylongname-reallylongname-really"
    And I fill E-mail field with value "email1@email.com"
    And I fill Date of Birth Day combo with value "1"
    And I fill Date of Birth Month combo with value "April"
    And I fill Date of Birth Year combo with value "1987"
    When I click Submit button
    Then I should not be on the User Profile page
    And I should be on the Sign up page

  Scenario: Validate max size of 200 for field Name - Success with Name size of 200
    Given I fill Username field with value "User1"
    And I fill Password field with value "GoodPassword#"
    And I fill Name field with value "reallylongname-reallylongname-reallylongname-reallylongname-reallylongname-reallylongname-reallylongname-reallylongname-reallylongname-reallylongname-reallylongname-reallylongname-reallylongname-reall"
    And I fill E-mail field with value "email1@email.com"
    And I fill Date of Birth Day combo with value "1"
    And I fill Date of Birth Month combo with value "April"
    And I fill Date of Birth Year combo with value "1987"
    When I click Submit button
    Then I should be on the User Profile page
    And I should see text "Welcome to your new profile page" on screen

  Scenario: Validate max size of 300 for field E-mail - Error with E-mail size of 301
    Given I fill Username field with value "User1"
    And I fill Password field with value "GoodPassword#"
    And I fill Name field with value "Name 1"
    And I fill E-mail field with value "reallylongemail-reallylongemail-reallylongemail-rea@longdomainnamelongdomainnamelongdomalongdomainnamelongdomainnamelongdomainnamelongdomainnamelongdomainnamelongdomainnamelongdomainnamelongdomainnamelongdomainnamelongdomainnamelongdomainnamelongdomainnamelongdomainnamelongdomainnamelongdomainnam.com"
    And I fill Date of Birth Day combo with value "1"
    And I fill Date of Birth Month combo with value "April"
    And I fill Date of Birth Year combo with value "1987"
    When I click Submit button
    Then I should not be on the User Profile page
    And I should be on the Sign up page

  Scenario: Validate max size of 300 for field E-mail - Success with E-mail size of 300
    Given I fill Username field with value "User1"
    And I fill Password field with value "GoodPassword#"
    And I fill Name field with value "Name 1"
    And I fill E-mail field with value "reallylongemail-reallylongemail-reallylongemail-rea@longdomainnamelongdomainnamelongdomalongdomainnamelongdomainnamelongdomainnamelongdomainnamelongdomainnamelongdomainnamelongdomainnamelongdomainnamelongdomainnamelongdomainnamelongdomainnamelongdomainnamelongdomainnamelongdomainnamelongdomainna.com"
    And I fill Date of Birth Day combo with value "1"
    And I fill Date of Birth Month combo with value "April"
    And I fill Date of Birth Year combo with value "1987"
    When I click Submit button
    Then I should be on the User Profile page
    And I should see text "Welcome to your new profile page" on screen

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
      | username           | password                  | name            | email                      | day          | month          |    year         |
      | "User1"            | "GoodPassword#"           | "Name 1"        | "email1@email.com"         | "1"          | "April"        | "1987"          |
      | "User2"            | "GoodPassword#"           | "Name 2"        | "email2@email.com"         | "22"         | "July"         | "1978"          |
      | "User3"            | "GoodPassword#"           | "Name 3"        | "email3@email.com"         | "3"          | "November"     | "2018"          |
