Feature: Register hours to an activity
  Description: An employee registers their hours to an activity
  Actors: Employee

  Scenario: Register hours to an activity successfully
    Given there is a project in the Project Manager
    And there is an activity on the project
    And the user is logged in as a registered employee assigned to the activity
    When the user registers 2 hours to the activity
    Then the user has 2 hours registered to the activity

  Scenario: Register hours to an activity the employee is not assigned to
    Given there is a project in the Project Manager
    And there is an activity on the project
    And the user is logged in as a registered employee
    When the user registers 2 hours to the activity
    Then the user has 0 hours registered to the activity
    And the error message "The employee is not assigned to this activity" is given

  Scenario: Register more hours to an activity
    Given there is a project in the Project Manager
    And there is an activity on the project
    And the user is logged in as a registered employee assigned to the activity
    And the user registers 2 hours to the activity
    And the user registers 3 more hours to the activity
    When the user requests his own total hours registered to the activity
    Then the user has 5 hours registered to the activity

  Scenario: Multiple employees register hours to activity and the Project Leader requests the total
    Given there is a project in the Project Manager
    And there is an activity on the project
    And the registered employee "HBO" is assigned to the activity
    And the registered employee "BOB" is assigned to the activity
    And the user logs in with initials "HBO"
    And the user registers 2 hours to the activity
    And the user logs in with initials "BOB"
    And the user registers 7 hours to the activity
    And the user is now logged in as Project Leader for the project
    When the user requests the total hours registered to the activity
    Then the total hours registered to the activity is 9


Scenario: An assigned employee requests total registered hours unsuccessfully
    Given there is a project in the Project Manager
    And there is an activity on the project
    And the user is logged in as a registered employee assigned to the activity
    When the user requests the total hours registered to the activity
    Then the error message "Project Leader login required" is given
