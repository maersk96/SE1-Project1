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
