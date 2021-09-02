@getOne
Feature: Get one employee

  Scenario Outline: Get one employee with some id
    When I requesting employee with <ID>
    Then I receive <RESPONSE> code

    Examples:
    | ID   | RESPONSE  |
    | 1    |   200     |
    | 0    |   400     |
    | -1   |   404     |