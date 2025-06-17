Feature: Practice Form Negative Submission

  Scenario: User submits the form without filling any fields
    Given User navigates to the Practice Form page for negative tc
    When User submits form with required fields empty
    Then The required fields should show red borders
