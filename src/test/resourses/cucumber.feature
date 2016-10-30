Feature: PageObjectCheckingWithCucumber

  Scenario Outline: Page objects checking login
    Given I am have login object
    When check Some quantity of pairs Login: <login> and Password: <password>
    Then having Result: <statement> of authorizing with different logins and passwords
    Examples:
    |login|password|statement|
    |"epam"|"123"  |"false"  |
    |"login"|"1234"|"false   |
    |"epam" |"1234"|"true"   |

  Scenario Outline: Page objects checking CheckBoxes
    Given I am have page with checkboxes
    When I have checkboxes value: <value>
    Then check this checkbox
    Examples:
      |value|
      |"Water"|
      |"Earth"|
      |"Wind"|
      |"Fire"|

  Scenario Outline: Page objects checking RadioButtons
    Given I am have page with radiobuttons
    When I have radiobuttons value: <value>
    Then check this radiobutton
    Examples:
      |value|
      |"Gold"|
      |"Silver"|
      |"Bronze"|
      |"Selen"|