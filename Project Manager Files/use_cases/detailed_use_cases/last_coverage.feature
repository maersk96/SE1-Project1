Feature: Get full code coverage
	
Scenario: Budget hours to an activity successfully when project leader
    Given there is a project in the Project Manager
    And there is an activity on the project
    And the user is logged in as Project Leader for the project
    When the user renames the activity to "Doing code coverage"
    Then the activity has the name "Doing code coverage"

