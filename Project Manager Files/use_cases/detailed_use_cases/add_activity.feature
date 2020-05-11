# Work distribution:
# Mikkel s164199

Feature: Add activity
  Description: An activity is added by the Project Leader
  Actors: Project Leader

  Scenario: Add an activity successfully
    Given there is a project in the Project Manager
    And there is an activity
    And the user is logged in as Project Leader for the project
    When the user adds the activity to the project
    Then the activity exists on the project in the Project Manager

  Scenario: Add an activity when not Project Leader
    Given there is a project in the Project Manager
    And there is an activity
    And the user is logged in as a registered employee
    When the user adds the activity to the project
    Then the activity does not exist on the project in the Project Manager
    And the error message "Project Leader login required" is given

  Scenario: Creating an activity with start week and duration
    Given there is an activity called "SE1" starting week 2 lasting for 13 weeks
    Then the activity ends in week 14

  Scenario: Creating an activity around New Year
    Given there is an activity called "New Year release" starting week 52 lasting for 2 weeks
    Then the activity ends in week 1

