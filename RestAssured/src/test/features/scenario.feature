Feature: Create an employee

  Scenario Outline: Create an employee with valid parameters

    When I create an employee "<NAME>" with age "<AGE>" and salary "<SALARY>"
    Then I should receive response 200 OK code
    And created employee has name "<NAME>" and age "<AGE>" and salary "<SALARY>"

    Examples:
      | NAME    | AGE | SALARY |
      | Petrov  | 23  | 1400   |
      | Sidorov | 45  | 2800   |
      | Zerov   | 0   | 1400   |
      | Salarov | 45  | 0      |
      | Nullov  | 0   | 0      |
