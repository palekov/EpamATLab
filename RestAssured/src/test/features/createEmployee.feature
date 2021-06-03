Feature: Create an employee

  Scenario Outline: Create an employee with parameters
    When I create an employee "<NAME>" with age "<AGE>" and salary "<SALARY>"
    Then I should receive response 200 OK code
    And created employee has some id number

    Examples:
      | NAME    | AGE | SALARY |
      | Petrov  | 23  | 1400   |
      | Zerov   | 0   | 1400   |
      | Salarov | 45  | 0      |
      | Nullov  | 0   | 0      |
      | Negaage | -1  | 1000   |
      | Negasal | 10  | -1     |
      |         | 10  | 1000   |
      | Emptage |     | 1000   |
      | Emptsal | 10  |        |
      | Aaaaaa  | xx  | zzz    |
      |         |     |        |

