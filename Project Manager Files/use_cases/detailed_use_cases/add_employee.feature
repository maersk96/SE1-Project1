Feature: Create employee
	Description: An employee is created by the Admin
	Actors: Admin
#
Scenario: Add an employee successfully when logged in as admin
	Given the user logs in with initials "ADMIN"
	And there does not exist an employee with initials "ABC"
	When the user adds an employee with initials "ABC"
	Then there exists an employee with initials "ABC"

Scenario: Add an employee when not admin
	Given the employee with initials "HBO" is registered
	And the user logs in with initials "HBO"
	When the user adds an employee with initials "ABC"
	Then there does not exist an employee with initials "ABC" 
	And the error message "Administrator login required" is given

Scenario: Add existing employee
	Given the user logs in with initials "ADMIN"
	And the employee with initials "ABC" is registered
	When the user adds an employee with initials "ABC"
	Then the error message "Employee already exists" is given
