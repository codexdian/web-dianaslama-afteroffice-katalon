Feature: Practice Form Automation

  Scenario: Fill form using multiple data from Excel
    Given User navigates to the Practice Form page
    When User fills and submits the form for each data
    Then Each form submission should show success message