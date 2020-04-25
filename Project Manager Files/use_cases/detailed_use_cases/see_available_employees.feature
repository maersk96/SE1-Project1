Feature: See available employees
	Description: See employees that do not exceed their active activities limit
	Actors: Anyone

Scenario: An employee is available, then adds one more activity and becomes unavailable
	Given an employee registered in the Project Manager
	And the employee is assigned to 19 activities in week 3
	And the employee is available in week 3
	When the employee is assigned to 1 more activity in week 3
	Then the employee is unavailable in week 3

Scenario: An employee is assigned while unavailable
	Given an employee registered in the Project Manager
	And the employee is assigned to 20 activities in week 10
	When the employee is assigned to 1 more activity in week 10
	Then the employee is still assigned to 20 activities in week 10
	And the error message "The employee is not available in this period" is given

