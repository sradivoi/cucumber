Feature: Google
  Google test

  Scenario: Test google output
    Given Google troubleshoot
    When Input appears
    Then Title contains "Real"
    Then Close