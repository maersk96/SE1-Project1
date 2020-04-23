Feature: See available employees
	Description: See employees that do not exceed their active activities limit
	Actors: Anyone

Scenario: An employee is available, then adds one more activity and becomes unavailable
	Given an employee registered in the Project Manager
	And the employee is assigned to 19 active activities
	And the employee is available
	When the employee is assigned to 1 more active activity
	Then the employee is unavailable

#Scenario: Check available employee in specific week

