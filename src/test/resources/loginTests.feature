Feature: Login
  Scenario: User should be able to login
    Given The user opens the login page
    When The user inputs the username "Admin" and password "admin123"
    And hits enter
    Then The user should login into application
    Then Quit driver

  Scenario: User should not be able to login
    Given The user opens the login page
    When The user inputs the invalid credentials
    And hits enter
    Then The user should not login into application
    Then Quit driver

  Scenario: User should not be able to login with different wrong credentials
    Given The user opens the login page
    When The user inputs the credentials and hits login button
    |UserName|Password|
    |Valog   |asdffgf |
    |logval  |asasas  |
    Then Quit driver