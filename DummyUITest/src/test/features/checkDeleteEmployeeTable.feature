@checkDeleteTable
Feature: Check delete employee table
  Scenario: Checking the table is present and consist of some columns with a specified names

    Given I am on the Dummy sample rest api web page
    When I click on Details link in 'Details' column on 'Delete an employee record' row
    Then I can see web page with table, contains specified columns
      | #	| Route	| Method | Sample Json | Results |