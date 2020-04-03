Feature: User Login
	Description: A user (Employee or Admin-Employee) logs into the app
	Actor: Employee

Scenario: User logs in as administrator
	Given there exists an employee with initials "ADMIN"
	When the user logs in with initials "ADMIN"
	Then the user is logged in as admin

Scenario: User logs in as existing employee
#	Given there is a user with initials "HBO"
# 	And there is an employee with initials "HBO"
# 	When the user logs in
#	Then the user is logged in

Scenario: User logs in as non-existing employee
#	Given there is a user with initials "XXX"
# 	And there is not an employee with initials "XXX"
# 	When the user logs in
# 	Then the user is not logged in

Scenario: User logs out
#   Given the user is logged in
#   When the user logs out
#   Then the user is not logged in
