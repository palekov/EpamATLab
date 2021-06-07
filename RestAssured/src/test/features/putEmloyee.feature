@UpdateOne
Feature: Update an employee

  Scenario Outline: Update an employee with parameters
    Given I get employee with <ID>
    When I update an employee with "<NAME>", "<AGE>" and "<SALARY>"
    Then I should receive response code 200
    And updated employee has some "<NAME>", "<AGE>" and "<SALARY>"

    Examples:
      | ID |    NAME    | AGE | SALARY |
      | 1  |   Petrov   | 55  |  700   |
