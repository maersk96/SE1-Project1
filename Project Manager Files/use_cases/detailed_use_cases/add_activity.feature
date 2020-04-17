Feature: Add activity
  Description: An activity is added by the project leader.
  Actors: Project leader

  Scenario: Add an activity successfully when project leader
    Given a project with the ID "2020-1" exists
    And the employee with initials "ABC" is registered
    And the employee with initials "ABC" is project leader for the project with the ID "2020-1"
    And the user logs in with initials "ABC"
    When the user adds an activity with the ID "0001" to the project with the ID "2020-1"
    Then an activity with the ID "0001" is added to the project with the ID "2020-1"

  Scenario: Add an activity when not project leader
    Given a project with the ID "2020-1" exists
    And the employee with initials "ABC" is registered
    And the employee with initials "ABC" is not project leader for the project with the ID "2020-1"
    And the user logs in with initials "ABC"
    When the user adds an activity with the ID "0001" to the project with the ID "2020-1"
    Then an activity with the ID "0001" is not added to the project with the ID "2020-1"
