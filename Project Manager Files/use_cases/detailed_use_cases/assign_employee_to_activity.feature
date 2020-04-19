Feature: Assign employee to activity
  Description: An employee is assigned to an activity
  Actors: Project leader

  Scenario: Successfully assign an employee to an activity
    Given a project with the ID "2020-1" exists
    And the employee with initials "HBO" is registered
    And the employee with initials "ABC" is registered
    And the employee with initials "ABC" is project leader for the project with the ID "2020-1"
    And the user logs in with initials "ABC"
    And an activity with the ID "0001" exists on the project with ID "2020-1"
    When the user assigns the employee with initials "HBO" to the activity with ID "0001" on the project with ID "2020-1"
    Then the employee with initials "HBO" is assigned to the activity with ID "0001" on the project with ID "2020-1"
    And the activity with ID "0001" is assigned to the employee with initials "HBO"

