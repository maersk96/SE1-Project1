# Work distribution:
# Mikkel s164199

Feature: Assign Project Leader
	Description: A Project Leader is assigned to a project by the Admin.
	Actors: Admin

Scenario: Assign a Project Leader successfully
	Given the employee with initials "ABC" is registered
	And there is a project in the Project Manager
	And the user is logged in as admin
	When the user assigns the employee with initials "ABC" as Project Leader for the project
	Then the Project Leader of the project has the initials "ABC"

Scenario: Assign a Project Leader when not admin
	Given there is a project in the Project Manager
	And the employee with initials "ABC" is registered
	And the user is logged in as a registered employee
	When the user assigns the employee with initials "ABC" as Project Leader for the project
	Then the Project Leader of the project does not have the initials "ABC"
	And the error message "Administrator login required" is given

Scenario: Assign a Project Leader to a non-existing project
	Given the user is logged in as admin
	And the employee with initials "ABC" is registered
	And there is a project named "Sample project"
	And the project does not exist in the Project Manager
	When the user assigns the employee with initials "ABC" as Project Leader for the project
	Then the error message "Project does not exist" is given
	
Scenario: Assign a non-existing employee as Project Leader
	Given the user is logged in as admin
	And there does not exist an employee with initials "ABC"
	And there is a project in the Project Manager
	When the user assigns the employee with initials "ABC" as Project Leader for the project
	Then the error message "Employee does not exist" is given
	
Scenario: Employee requests the projects it is leading
	Given there is a project in the Project Manager
	And the user is logged in as Project Leader for the project
 	When the user requests a list of projects lead by himself
	Then the project is contained in the list

Scenario: Employee requests the projects some other employee is leading
	Given the employee with initials "ABC" is registered
	And the employee with initials "XYZ" is registered
	And the user logs in with initials "ABC"
	When the user requests a list of projects lead by employee with initials "XYZ"
	Then the error message "You can only see projects that you are leading" is given

		
	