Feature: Fill Practice Form on DemoQA

  Scenario: User fills out the practice form successfully
    Given User navigates to the Practice Form page
    When User fills in the form with valid data
    And User submits the form
    Then The form should be submitted successfully
