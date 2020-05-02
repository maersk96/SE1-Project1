Feature: Add activity
  Description: An activity is added by the project leader.
  Actors: Project leader

  Scenario: Add an activity successfully when project leader
    Given there is a project in the Project Manager
    And there is an activity
    And the user is Project Leader for the project
    When the user adds the activity to the project
    Then the activity exists on the project

  Scenario: Add an activity when not project leader
    Given there is a project in the Project Manager
    And there is an activity
    And the user is logged in as a registered employee
    When the user adds the activity to the project
    Then the activity does not exist on the project
    And the error message "Project Leader login required" is given

  Scenario: Creating activity with start time and duration
    Given there is an activity called "SE1" starting week 2 lasting for 13 weeks
    Then the activity ends in week 14

  Scenario: Creating activity around New Year
    Given there is an activity called "New Year release" starting week 52 lasting for 2 weeks
    Then the activity ends in week 1

