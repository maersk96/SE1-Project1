Feature: Create project
	Description: A project is created by the Admin
	Actors: Admin

Scenario: Add a project successfully when logged in as admin
	Given the user logs in with initials "ADMIN"
	And there are no projects in the project manager
	When the user adds a project
	Then a project with the ID "2020-1" exists in the project manager

Scenario: Add a project when not admin
	Given the employee with initials "HBO" is registered
	And the user logs in with initials "HBO"
	When the user adds a project
	Then the error message "Administrator login required" is given

Scenario: Add multiple projects
	Given the user logs in with initials "ADMIN"
	And the user is logged in as admin
	And the user adds a project
	Then a project with the ID "2020-1" exists in the project manager
	When the user adds a project
	Then a project with the ID "2020-2" exists in the project manager
