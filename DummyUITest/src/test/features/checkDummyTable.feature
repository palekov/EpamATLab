@checkDummyTable
Feature: Check the table

  Scenario: Checking the table is present and consist of some columns with a specified names
    Given I am on the Dummy sample rest api web page
    When the table with some examples is present
    Then the table contains specified columns "#, Route, Method, Type, Full route, Description, Details"
    And the contents of the Method column contains a correct data "GET, PUT, POST, DELETE"
    And the contents of the Type column contains a "JSON" text

  Scenario Outline: Checking the table is present and consist of some columns names
    Given I am on the Dummy sample rest api web page
    When I click on Details link in 'Details' column on row with some "<DESCRIPTION>"
    Then the table with some examples is present
    And the table contains specified columns "#, Route, Method, Sample Json, Results"
    And the text in Route column equals to Route column text in main table
    And the text in Method column equals to Method column text in main table

    Examples:
      | DESCRIPTION                   |
      | Get all employee data         |
      | Get a single employee data    |
      | Create new record in database |
      | Update an employee record     |
      | Delete an employee record     |
