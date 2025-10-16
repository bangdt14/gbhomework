@regression
Feature: VAT Calculator Functionality

  Background:
    Given user is on the VAT Calculator webpage

  Scenario: Verify VAT calculation using Net amount
    When user selects country "Germany"
    And user selects VAT rate "19"
    And user enters net amount "100"
    Then VAT amount should be "19.00"
    And Gross amount should be "119.00"

  Scenario: Verify error message for negative input
    When user selects country "Germany"
    And user selects VAT rate "7"
    And user enters net amount "-50"
    Then error message should contain "Negative values are invalid for a pie chart."
