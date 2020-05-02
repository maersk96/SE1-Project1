Feature: Rename project
	Description: A project is renamed by the Admin
	Actors: Admin

Scenario: Rename a project successfully when logged in as admin
	Given there is a project in the Project Manager
	And the user is logged in as admin
	When the user renames the project
	Then the projects name is changed

Scenario: Rename a project when not admin
	Given there is a project in the Project Manager
	And the user is logged in as a registered employee
	When the user renames the project
	Then the projects name is unchanged
	And the error message "Administrator login required" is given

Scenario: Rename a project that does not exist
	Given the user is logged in as admin
	And there is a project named "Sample project"
	And the project does not exist in the Project Manager
	When the user renames the project
	And the error message "Project does not exist" is given
