@checkDummyTable
Feature: Check the table
  Scenario: Checking the table is present and consist of some columns with a specified names

    Given I am on the Dummy sample rest api web page
    When the table with request examples is present
    Then the table have a specified columns with names
    | # | Route | Method | Type | Full route | Description | Details |

    And the contents of the Method column contains a correct data
    |  GET   |
    |  PUT   |
    |  POST  |
    | DELETE |

    And the contents of the Type column contains a correct data
    | JSON |
