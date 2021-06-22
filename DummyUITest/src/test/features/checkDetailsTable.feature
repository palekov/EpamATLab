@checkGetAllTable
Feature: Check get all employees table

  Scenario Outline: Checking the table is present and consist of some columns with a specified names

    Given I am on the main Dummy sample rest api web page
    When I click on Details link in 'Details' column on row with some "<DESCRIPTION>"
    Then I can see web page with table, contains specified columns
      | # | Route | Method | Sample Json | Results |
    And the text in Route column equals to Route column text in main table

    Examples:
      | DESCRIPTION                   |
      | Get all employee data         |
      | Get a single employee data    |
      | Create new record in database |
      | Update an employee record     |
      | Delete an employee record     |
