Feature: YahooMailTest
  Scenario: yahoo mail login
    Given User have open the browser
    When user navigates to yahoo mail page
    And click login button
    And enters user credentials
    Then yahoo mail page is displayed
