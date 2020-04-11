Feature: User Login
	Description: A user (Employee or Admin-Employee) logs into the app
	Actor: Employee

Scenario: User logs in as administrator
	When the user logs in with initials "ADMIN"
	Then the user is now logged in as admin

Scenario: User logs in as existing employee
 	Given the employee with initials "HBO" is registered
 	When the user logs in with initials "HBO"
	Then the user is logged in with initials "HBO"

Scenario: User logs in as non-existing employee
	Given there does not exist an employee with initials "XXX"
 	When the user logs in with initials "XXX"
 	Then the user is not logged in
	And the error message "Employee with initials XXX does not exist" is given

Scenario: User logs out
	Given the employee with initials "JFK" is registered
	And the user logs in with initials "JFK"
	And the user is logged in with initials "JFK"
	When the user logs out
	Then the user is not logged in