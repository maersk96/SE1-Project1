Feature: Assign Project Leader
	Description: A project leader is assigned by the Admin.
	Actors: Admin

Scenario: Assign a project leader successfully when logged in as admin
	Given the employee with initials "ABC" is registered
	And there is a project in the Project Manager
	And the user is logged in as admin
	When the user assigns the employee with initials "ABC" as Project Leader of the project
	Then the Project Leader of the project has the initials "ABC"

Scenario: Assign a project leader when not admin
	Given there is a project in the Project Manager
	And the employee with initials "HBO" is registered
	And the employee with initials "ABC" is registered
	And the user logs in with initials "HBO"
	When the user assigns the employee with initials "ABC" as Project Leader of the project
	Then the Project Leader of the project does not have the initials "ABC"
	And the error message "Administrator login required" is given

Scenario: Assign a project leader to unexisting project
	Given the user is logged in as admin
	And the employee with initials "ABC" is registered
	And there is a project named "Sample project"
	And the project does not exist in the Project Manager
	When the user assigns the employee with initials "ABC" as Project Leader of the project
	Then the error message "Project does not exist" is given
	
Scenario: Assign an non-existing employee as project leader
	Given the user is logged in as admin
	And there does not exist an employee with initials "ABC"
	And there is a project in the Project Manager
	When the user assigns the employee with initials "ABC" as Project Leader of the project
	Then the error message "Employee does not exist" is given
	
Scenario: See what projects you lead as employee
	Given there is a project in the Project Manager
	And the user is Project Leader for the project
  When the user accesses his leader list
	Then the user sees a list of projects that he leads

		
	