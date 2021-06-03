Feature: Get existing employee

  Scenario: Get existing employee with parameters

    When I requesting all existing employees
    Then I receive response 200 OK code
    And the number of employees received must be more than one
