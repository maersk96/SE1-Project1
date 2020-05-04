Feature: Assign employee to activity
  Description: An employee is assigned to an activity
  Actors: Project leader

  Scenario: Successfully assign an employee to an activity
    Given there is a project in the Project Manager
    And there is an activity on the project
    And the employee with initials "HBO" is registered
    And the user is Project Leader for the project
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
    And the activity is not assigned to the employee with initials "HBO"
    And the error message "Project leader or assigned employee login required" is given

  Scenario: Assign employee to activity when already assigned to the activity
    Given there is a project in the Project Manager
    And there is an activity on the project
    And the registered employee "HBO" is assigned to the activity
    And the user is Project Leader for the project
    When the user assigns the employee with initials "HBO" to the activity
    Then the error message "Activity already has this employee assigned" is given

  Scenario: Assign help to activity that you are assigned to, when logged in as employee
    Given there is a project in the Project Manager
    And there is an activity on the project
    And the employee with initials "BOB" is registered
    And the registered employee "HBO" is assigned to the activity
    And the user logs in with initials "HBO"
    When the user assigns the employee with initials "BOB" to the activity
    Then the employee with the initials "BOB" is assigned to the activity
    And the activity is assigned to the employee with initials "BOB"

  Scenario: Assign help to activity that you are not assigned to, when logged in as employee
    Given there is a project in the Project Manager
    And there is an activity on the project
    And the employee with initials "HBO" is registered
    And the employee with initials "BOB" is registered
    And the user logs in with initials "HBO"
    When the user assigns the employee with initials "BOB" to the activity
    Then the employee with the initials "BOB" is not assigned to the activity
    And the activity is not assigned to the employee with initials "BOB"
    And the error message "Project leader or assigned employee login required" is given