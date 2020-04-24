Feature: Budget hours to an activity
  Description: The project leader budget hours to the activity
  Actors: Project leader

  Scenario: Budget hours to an activity successfully when project leader
    Given there is a project in the Project Manager
    And there is an activity on the project
    And the employee with initials "ABC" is registered
    And the employee with initials "ABC" is Project Leader for the project
    And the user logs in with initials "ABC"
    When the budget 10 hours to the activity
    Then the activity has a budget of 10 hours

  Scenario: Budget hours to an activity when not project leader
    Given there is a project in the Project Manager
    And there is an activity on the project
    And the employee with initials "HBO" is registered
    And the employee with initials "ABC" is registered
    And the employee with initials "ABC" is Project Leader for the project
    And the user logs in with initials "HBO"
    When the budget 10 hours to the activity
    Then the activity has no budget hours

