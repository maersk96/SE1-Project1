Feature: Budget hours to an activity
  Description: The project leader budget hours to the activity
  Actors: Project leader

  Scenario: Budget hours to an activity successfully when project leader
    Given there is a project in the Project Manager
    And there is an activity on the project
    And the user is Project Leader for the project
    When the user budgets 10 hours to the activity
    Then the activity has a budget of 10 hours

  Scenario: Budget hours to an activity when not project leader
    Given there is a project in the Project Manager
    And there is an activity on the project
    And the user is logged in as a registered employee
    When the user budgets 10 hours to the activity
    Then the activity has no budget hours
    And the error message "Project Leader login required" is given

