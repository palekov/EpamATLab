@checkGetAllTable
Feature: Check get all employees table
  Scenario: Checking the table is present and consist of some columns with a specified names

    Given I am on the main Dummy sample rest api web page
    When I click on Details link in 'Details' column on 'Get all employee data' row
    Then I can see web page with table, contains specified columns
      | #	| Route	| Method | Sample Json | Results |
    And the text in Route column equals to Route column text in main table