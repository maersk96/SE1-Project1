Feature: Rename activity
    Description: An activity is renamed by the Project Leader
    Actors: Project Leader

Scenario: Rename an activity successfully
    Given there is a project in the Project Manager
    And there is an activity on the project
    And the user is logged in as Project Leader for the project
    When the user renames the activity to "Get code coverage to 100%"
    Then the activity has the name "Get code coverage to 100%"

Scenario: Rename an activity when not Project Leader
    Given there is a project in the Project Manager
    And there is an activity on the project
    And the user is logged in as a registered employee
    When the user renames the activity to "Get code coverage to 100%"
    Then the activity does not have the name "Get code coverage to 100%"
    And the error message "Project Leader login required" is given

Scenario: Rename an activity that does not exist
    Given there is a project in the Project Manager
    And the user is logged in as Project Leader for the project
    When the user renames the activity to "Get code coverage to 100%"
    Then the error message "Activity does not exist" is given