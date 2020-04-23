Feature: Create project
	Description: A project is created by the Admin
	Actors: Admin
#
Scenario: Add a project successfully when logged in as admin
	Given there is a project named "Sample project"
	And the user is logged in as admin
	When the user adds the project to the project manager
	Then the project exists in the project manager

Scenario: Add a project when not admin
	Given there is a project named "Sample project"
	And the employee with initials "HBO" is registered
	And the user logs in with initials "HBO"
	When the user adds the project to the project manager
	Then the error message "Administrator login required" is given

Scenario: Add multiple projects
	Given the user is logged in as admin
	And there are no projects in the project manager
	When the user adds a project
	Then a project with the ID "2020-0001" exists in the Project Manager
	When the user adds another project
	Then a project with the ID "2020-0002" exists in the Project Manager
