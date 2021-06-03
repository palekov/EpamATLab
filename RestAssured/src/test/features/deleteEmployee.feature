@delOne
Feature: Delete one employee

  Scenario Outline: Delete one employee with some id
    When I requesting to delete employee with <ID>
    Then I receive <RESPONSE> status code
    And I receive 'Successfully! Record has been deleted' in answer body

    Examples:
      | ID | RESPONSE |
      |  1 |   200    |
      | 10 |   200    |
      |999 |   200    |