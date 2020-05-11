# Work distribution:
# Jonas s183635

Feature: Create project
	Description: A project is created by the Admin
	Actors: Admin

Scenario: Add a project successfully
	Given the user is logged in as admin
	When the user adds a project
	Then the project exists in the Project Manager

Scenario: Add a project when not admin
	Given the user is logged in as a registered employee
	When the user adds a project
	Then the project does not exist in the Project Manager
	And the error message "Administrator login required" is given

Scenario: Add multiple projects
	Given the user is logged in as admin
	And there are no projects in the Project Manager
	When the user adds a project
	Then a project with the ID "2020-0001" exists in the Project Manager
	When the user adds another project
	Then a project with the ID "2020-0002" exists in the Project Manager
