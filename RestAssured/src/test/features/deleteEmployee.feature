@delOne
Feature: Delete one employee

  Scenario Outline: Delete one employee with some id
    When I requesting to delete employee with <ID>
    Then I receive <RESPONSE> status code
    And I receive 'Successfully! Record has been deleted' in answer body

    Examples:
      | ID | RESPONSE |
      |  1 |   200    |
      |  0 |   400    |
      | -1 |   400    |
      |9999|   400    |