Feature: Add mock data
  Description: Test data is added to the app.
  Actors: Administrator

  Scenario: The administrator adds test data in the UI
    Given the user is logged in as admin
    When mock data is generated
    Then there are some projects in the Project Manager

  Scenario: A non-admin tries to add test data
    Given the user is logged in as a registered employee
    When mock data is generated
    Then there are no projects in the Project Manager
    And the error message "Administrator login required" is given
