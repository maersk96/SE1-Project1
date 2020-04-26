Feature: Register hours to an activity
  Description: An employee registers their hours to an activity
  Actors: Employee

  Scenario: Successfully register hours to an activity
    Given there is a project in the Project Manager
    And there is an activity on the project
    And the employee with initials "HBO" is registered
    And the employee with initials "ABC" is registered
    And the employee with initials "ABC" is Project Leader for the project
    And the employee with initials "HBO" is assigned to the activity by the project leader "ABC"
    And the user is already logged in with initials "HBO"
    When the user registers 2 hours to the activity
    Then the activity has 2 hours registered with the employee with initials "HBO"

  Scenario: Try to register hours when not assigned to activity
    Given there is a project in the Project Manager
    And there is an activity on the project
    And the employee with initials "HBO" is registered
    And the employee with initials "ABC" is registered
    And the employee with initials "ABC" is Project Leader for the project
    And the employee with initials "HBO" is assigned to the activity by the project leader "ABC"
    And the user is already logged in with initials "ABC"
    When the user registers 2 hours to the activity
    Then the activity has 0 hours registered with the employee with initials "HBO"
    And the error message "Employee is not assigned this activity" is given

  Scenario: Register more hours to an activity
    Given there is a project in the Project Manager
    And there is an activity on the project
    And the employee with initials "HBO" is registered
    And the employee with initials "ABC" is registered
    And the employee with initials "ABC" is Project Leader for the project
    And the employee with initials "HBO" is assigned to the activity by the project leader "ABC"
    And the user is already logged in with initials "HBO"
    And the use has registered 2 hours to the activity
    When the user registers 3 hours to the activity
    Then the activity has 5 hours registered with the employee with initials "HBO"