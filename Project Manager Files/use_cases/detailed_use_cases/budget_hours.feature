# Work distribution:
# Mikkel s164199

Feature: Budget hours to an activity
  Description: A Project Leader budgets hours to an activity
  Actors: Project Leader

  Scenario: Budget hours to an activity successfully
    Given there is a project in the Project Manager
    And there is an activity on the project
    And the user is logged in as Project Leader for the project
    When the user budgets 10 hours to the activity
    Then the activity has a budget of 10 hours

  Scenario: Budget hours to an activity when not Project Leader
    Given there is a project in the Project Manager
    And there is an activity on the project
    And the user is logged in as a registered employee
    When the user budgets 10 hours to the activity
    Then the activity has no budgeted hours
    And the error message "Project Leader login required" is given

