Feature: Delete project
	Description: A project is deleted by the Admin
	Actors: Admin

Scenario: Delete a project successfully when logged in as admin
	Given there is a project in the Project Manager
	And the user is logged in as admin
	When the user deletes the project
	Then the project is removed from the Project Manager

Scenario: Delete a project when not admin
	Given there is a project in the Project Manager
	And the employee with initials "HBO" is registered
	And the user logs in with initials "HBO"
	When the user deletes the project
	Then the project is still in the Project Manager
	And the error message "Administrator login required" is given

Scenario: Delete a project that does not exist
	Given the user is logged in as admin
	And there is a project named "Sample project"
	And the project does not exist in the Project Manager
	When the user deletes the project
	And the error message "Project does not exist" is given
