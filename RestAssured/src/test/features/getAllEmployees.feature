@getAll
Feature: Get all existing employee

  Scenario: Get all existing employees with parameters
    When I requesting all existing employees
    Then I receive response 200 OK code
    And the number of employees received
