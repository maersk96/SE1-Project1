Feature: Assign employee to activity
  Description: An employee is assigned to an activity
  Actors: Project leader

  Scenario: Successfully assign an employee to an activity
    Given there is a project in the Project Manager
    And there is an activity on the project
    And the employee with initials "HBO" is registered
    And the employee with initials "ABC" is registered
    And the employee with initials "ABC" is Project Leader for the project
    And the user logs in with initials "ABC"
    When the user assigns the employee with initials "HBO" to the activity
    Then the employee with the initials "HBO" is assigned to the activity
    And the activity is assigned to the employee with initials "HBO"