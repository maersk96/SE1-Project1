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

  Scenario: Assign employee to activity when not logged in as project leader
    Given there is a project in the Project Manager
    And there is an activity on the project
    And the employee with initials "HBO" is registered
    And the employee with initials "ABC" is registered
    And the employee with initials "ABC" is Project Leader for the project
    And the user logs in with initials "HBO"
    When the user assigns the employee with initials "HBO" to the activity
    Then the employee with the initials "HBO" is not assigned to the activity
    And the error message "Project Leader login required" is given

  Scenario: Assign employee to activity when already assigned to the activity
    Given there is a project in the Project Manager
    And there is an activity on the project
    And the employee with initials "HBO" is registered
    And the employee with initials "ABC" is registered
    And the employee with initials "ABC" is Project Leader for the project
    And the employee with initials "HBO" is assigned to the activity by the project leader "ABC"
    And the user logs in with initials "ABC"
    When the user assigns the employee with initials "HBO" to the activity
    Then the error message "Activity already has this employee assigned" is given