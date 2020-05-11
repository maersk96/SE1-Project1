# Work distribution:
# Lukas s183663

Feature: Assign employee to activity
  Description: An employee is assigned to an activity by the Project Leader
  Actors: Project Leader

  Scenario: Assign an employee to an activity successfully
    Given there is a project in the Project Manager
    And there is an activity on the project
    And the employee with initials "HBO" is registered
    And the user is logged in as Project Leader for the project
    When the user assigns the employee with initials "HBO" to the activity
    Then the employee with the initials "HBO" is assigned to the activity
    And the activity is assigned to the employee with initials "HBO"

  Scenario: Assign employee to activity when not Project Leader
    Given there is a project in the Project Manager
    And there is an activity on the project
    And the employee with initials "HBO" is registered
    And the user logs in with initials "HBO"
    When the user assigns the employee with initials "HBO" to the activity
    Then the employee with the initials "HBO" is not assigned to the activity
    And the activity is not assigned to the employee with initials "HBO"
    And the error message "Project Leader login required" is given

  Scenario: Assign employee to activity who's already assigned to the activity
    Given there is a project in the Project Manager
    And there is an activity on the project
    And the registered employee "HBO" is assigned to the activity
    And the user is logged in as Project Leader for the project
    When the user assigns the employee with initials "HBO" to the activity
    Then the error message "Employee is already assigned this activity" is given

  Scenario: Assigned employee asks for assistance with activity
    Given there is a project in the Project Manager
    And there is an activity on the project
    And the employee with initials "ABC" is registered
    And the registered employee "XYZ" is assigned to the activity
    And the user logs in with initials "XYZ"
    When the user asks the employee with initials "ABC" for help with the activity
    Then the employee with the initials "ABC" is assigned to the activity
    And the activity is assigned to the employee with initials "ABC"

  Scenario: Non-assigned employee asks for assistance with an activity
    Given there is a project in the Project Manager
    And there is an activity on the project
    And the employee with initials "ABC" is registered
    And the employee with initials "XYZ" is registered
    And the user logs in with initials "ABC"
    When the user asks the employee with initials "XYZ" for help with the activity
    Then the employee with the initials "XYZ" is not assigned to the activity
    And the activity is not assigned to the employee with initials "XYZ"
    And the error message "The employee is not assigned to this activity" is given