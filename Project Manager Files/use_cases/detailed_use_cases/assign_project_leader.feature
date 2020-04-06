Feature: Assign Project Leader
	Description: A project leader is assigned by the Admin.
	Actors: Admin

Scenario: Assign a project leader successfully when logged in as admin
	Given the employee with initials "ABC" is registered 
	And a project with the ID "2020-1" exists
	And the user is logged in as admin
	When the employee with initials "ABC" is assigned as project leader for the project with the ID "2020-1"
	Then the project with the ID "2020-1" has project leader with initials "ABC"

Scenario: Assign a project leader when not admin
	Given the employee with initials "HBO" is registered
	And a project with the ID "2020-1" exists
	And the employee with initials "ABC" is registered
	And the user logs in with initials "HBO"
	When the employee with initials "ABC" is assigned as project leader for the project with the ID "2020-1"
	Then the project with the ID "2020-1" does not have a project leader with initials "ABC"
	And the error message "Administrator login required" is given
