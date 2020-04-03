#Feature: 
#	Description: The administrator logs out from the library system
#	Actor: Administrator
	
#Scenario: Administrator logs out
#	Given that the administrator is logged in
#	When the administrator logs out
#	Then the administrator is not logged in
	
	
Feature: Assign Project Leader
	Description: A project leader is assigned by the Admin
	Actors: Admin
	
Scenario: Add a project leader successfully
	Given that the admin is logged in
	And there is a project with the ID ”2020-0001”
	And there is an employee with the initials ”HBO”
	When the employee is assigned as project leader
	Then the project with the ID ”2020-0001” has the project leaderwith the initials ”HBO”
	
Scenario: Add a project leader when not logged in as admin
	Given that the admin is not logged in
	And there is a project with the ID ”2020-0001”
	And there is an employee with the initials ”HBO”
	When the employee is assigned as project leader
	Then the project with the ID ”2020-0001” does not have the project leader with the initials ”HBO”.