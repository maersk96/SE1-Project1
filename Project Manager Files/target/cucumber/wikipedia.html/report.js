$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:use_cases/detailed_use_cases/add_activity.feature");
formatter.feature({
  "name": "Add activity",
  "description": "  Description: An activity is added by the Project Leader\n  Actors: Project Leader",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Add an activity successfully",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "there is a project in the Project Manager",
  "keyword": "Given "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.thereIsAProjectInTheManager()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "there is an activity",
  "keyword": "And "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.thereIsAnActivity()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user is logged in as Project Leader for the project",
  "keyword": "And "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.theUserIsProjectLeaderForTheProject()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user adds the activity to the project",
  "keyword": "When "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.theUserAddsTheActivityToTheProject()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the activity exists on the project in the Project Manager",
  "keyword": "Then "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.theActivityExistsOnTheProject()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Add an activity when not Project Leader",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "there is a project in the Project Manager",
  "keyword": "Given "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.thereIsAProjectInTheManager()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "there is an activity",
  "keyword": "And "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.thereIsAnActivity()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user is logged in as a registered employee",
  "keyword": "And "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.EmployeeSteps.theUserIsARegisteredEmployee()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user adds the activity to the project",
  "keyword": "When "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.theUserAddsTheActivityToTheProject()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the activity does not exist on the project in the Project Manager",
  "keyword": "Then "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.theActivityDoesNotExistsOnTheProject()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the error message \"Project Leader login required\" is given",
  "keyword": "And "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.theErrorMessageIsGiven(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Creating an activity with start week and duration",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "there is an activity called \"SE1\" starting week 2 lasting for 13 weeks",
  "keyword": "Given "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.thereIsADetailedActivity(java.lang.String,int,int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the activity ends in week 14",
  "keyword": "Then "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.theActivityEndsInWeek(int)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Creating an activity around New Year",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "there is an activity called \"New Year release\" starting week 52 lasting for 2 weeks",
  "keyword": "Given "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.thereIsADetailedActivity(java.lang.String,int,int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the activity ends in week 1",
  "keyword": "Then "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.theActivityEndsInWeek(int)"
});
formatter.result({
  "status": "passed"
});
formatter.uri("file:use_cases/detailed_use_cases/add_employee.feature");
formatter.feature({
  "name": "Create employee",
  "description": "\tDescription: An employee is created by the Admin\n\tActors: Admin",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Add an employee successfully",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "the user is logged in as admin",
  "keyword": "Given "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.LoginLogoutSteps.theUserIsAlreadyLoggedInAsAdmin()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "there does not exist an employee with initials \"ABC\"",
  "keyword": "And "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.EmployeeSteps.thereDoesNotExistAnEmployeeWithInitials(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user adds an employee with initials \"ABC\"",
  "keyword": "When "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.EmployeeSteps.theUserAddsAnEmployeeWithInitials(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "there exists an employee with initials \"ABC\"",
  "keyword": "Then "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.EmployeeSteps.thereExistsAnEmployeeWithInitials(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the employee with initials \"ABC\" has a name",
  "keyword": "And "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.EmployeeSteps.theEmployeeHasAName(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Add an employee when not admin",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "the user is logged in as a registered employee",
  "keyword": "Given "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.EmployeeSteps.theUserIsARegisteredEmployee()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user adds an employee with initials \"ABC\"",
  "keyword": "When "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.EmployeeSteps.theUserAddsAnEmployeeWithInitials(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "there does not exist an employee with initials \"ABC\"",
  "keyword": "Then "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.EmployeeSteps.thereDoesNotExistAnEmployeeWithInitials(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the error message \"Administrator login required\" is given",
  "keyword": "And "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.theErrorMessageIsGiven(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Add existing employee",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "the employee with initials \"ABC\" is registered",
  "keyword": "Given "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.EmployeeSteps.theEmployeeWithInitialsIsRegistered(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user is logged in as admin",
  "keyword": "And "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.LoginLogoutSteps.theUserIsAlreadyLoggedInAsAdmin()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user adds an employee with initials \"ABC\"",
  "keyword": "When "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.EmployeeSteps.theUserAddsAnEmployeeWithInitials(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the error message \"Employee already exists\" is given",
  "keyword": "Then "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.theErrorMessageIsGiven(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.uri("file:use_cases/detailed_use_cases/add_mock_data.feature");
formatter.feature({
  "name": "Add mock data",
  "description": "  Description: Generated data is added to the Project Manager by the Admin\n  Actors: Admin",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "The admin adds mock data",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "the user is logged in as admin",
  "keyword": "Given "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.LoginLogoutSteps.theUserIsAlreadyLoggedInAsAdmin()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "mock data is generated",
  "keyword": "When "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.MockSteps.mockDataIsGenerated()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "there are some projects in the Project Manager",
  "keyword": "Then "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.someProjectsExist()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "A non-admin employee adds mock data unsuccessfully",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "the user is logged in as a registered employee",
  "keyword": "Given "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.EmployeeSteps.theUserIsARegisteredEmployee()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "mock data is generated",
  "keyword": "When "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.MockSteps.mockDataIsGenerated()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "there are no projects in the Project Manager",
  "keyword": "Then "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.noProjectsExist()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the error message \"Administrator login required\" is given",
  "keyword": "And "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.theErrorMessageIsGiven(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.uri("file:use_cases/detailed_use_cases/add_project.feature");
formatter.feature({
  "name": "Create project",
  "description": "\tDescription: A project is created by the Admin\n\tActors: Admin",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Add a project successfully",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "the user is logged in as admin",
  "keyword": "Given "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.LoginLogoutSteps.theUserIsAlreadyLoggedInAsAdmin()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user adds a project",
  "keyword": "When "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.theUserAddsAProject()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the project exists in the Project Manager",
  "keyword": "Then "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.theProjectExistsInTheProjectManager()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Add a project when not admin",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "the user is logged in as a registered employee",
  "keyword": "Given "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.EmployeeSteps.theUserIsARegisteredEmployee()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user adds a project",
  "keyword": "When "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.theUserAddsAProject()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the project does not exist in the Project Manager",
  "keyword": "Then "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.theProjectDoesNotExistInTheProjectManager()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the error message \"Administrator login required\" is given",
  "keyword": "And "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.theErrorMessageIsGiven(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Add multiple projects",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "the user is logged in as admin",
  "keyword": "Given "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.LoginLogoutSteps.theUserIsAlreadyLoggedInAsAdmin()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "there are no projects in the Project Manager",
  "keyword": "And "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.noProjectsExist()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user adds a project",
  "keyword": "When "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.theUserAddsAProject()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a project with the ID \"2020-0001\" exists in the Project Manager",
  "keyword": "Then "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.aProjectWithIDExists(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user adds another project",
  "keyword": "When "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.theUserAddsAProject()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a project with the ID \"2020-0002\" exists in the Project Manager",
  "keyword": "Then "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.aProjectWithIDExists(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.uri("file:use_cases/detailed_use_cases/assign_employee_to_activity.feature");
formatter.feature({
  "name": "Assign employee to activity",
  "description": "  Description: An employee is assigned to an activity by the Project Leader\n  Actors: Project Leader",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Assign an employee to an activity successfully",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "there is a project in the Project Manager",
  "keyword": "Given "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.thereIsAProjectInTheManager()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "there is an activity on the project",
  "keyword": "And "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.theProjectHasAnActivity()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the employee with initials \"HBO\" is registered",
  "keyword": "And "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.EmployeeSteps.theEmployeeWithInitialsIsRegistered(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user is logged in as Project Leader for the project",
  "keyword": "And "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.theUserIsProjectLeaderForTheProject()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user assigns the employee with initials \"HBO\" to the activity",
  "keyword": "When "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.theUserAssignsEmployeeToTheActivity(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the employee with the initials \"HBO\" is assigned to the activity",
  "keyword": "Then "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.theEmployeeWithInitialsIsAssignedToTheActivity(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the activity is assigned to the employee with initials \"HBO\"",
  "keyword": "And "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.theActivityIsAssignedToTheEmployeeWithInitials(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Assign employee to activity when not Project Leader",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "there is a project in the Project Manager",
  "keyword": "Given "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.thereIsAProjectInTheManager()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "there is an activity on the project",
  "keyword": "And "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.theProjectHasAnActivity()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the employee with initials \"HBO\" is registered",
  "keyword": "And "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.EmployeeSteps.theEmployeeWithInitialsIsRegistered(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user logs in with initials \"HBO\"",
  "keyword": "And "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.LoginLogoutSteps.theUserLogsInWithInitials(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user assigns the employee with initials \"HBO\" to the activity",
  "keyword": "When "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.theUserAssignsEmployeeToTheActivity(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the employee with the initials \"HBO\" is not assigned to the activity",
  "keyword": "Then "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.theEmployeeWithInitialsIsNotAssignedToTheActivity(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the activity is not assigned to the employee with initials \"HBO\"",
  "keyword": "And "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.theActivityIsNotAssignedTheEmployeeWithInitials(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the error message \"Project Leader login required\" is given",
  "keyword": "And "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.theErrorMessageIsGiven(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Assign employee to activity who\u0027s already assigned to the activity",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "there is a project in the Project Manager",
  "keyword": "Given "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.thereIsAProjectInTheManager()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "there is an activity on the project",
  "keyword": "And "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.theProjectHasAnActivity()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the registered employee \"HBO\" is assigned to the activity",
  "keyword": "And "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.theRegisteredEmployeeIsAssignedToTheActivity(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user is logged in as Project Leader for the project",
  "keyword": "And "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.theUserIsProjectLeaderForTheProject()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user assigns the employee with initials \"HBO\" to the activity",
  "keyword": "When "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.theUserAssignsEmployeeToTheActivity(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the error message \"Employee is already assigned this activity\" is given",
  "keyword": "Then "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.theErrorMessageIsGiven(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Assigned employee asks for assistance with activity",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "there is a project in the Project Manager",
  "keyword": "Given "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.thereIsAProjectInTheManager()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "there is an activity on the project",
  "keyword": "And "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.theProjectHasAnActivity()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the employee with initials \"ABC\" is registered",
  "keyword": "And "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.EmployeeSteps.theEmployeeWithInitialsIsRegistered(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the registered employee \"XYZ\" is assigned to the activity",
  "keyword": "And "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.theRegisteredEmployeeIsAssignedToTheActivity(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user logs in with initials \"XYZ\"",
  "keyword": "And "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.LoginLogoutSteps.theUserLogsInWithInitials(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user asks the employee with initials \"ABC\" for help with the activity",
  "keyword": "When "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.theUserAsksTheEmployeeWithInitialsForHelpWithTheActivity(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the employee with the initials \"ABC\" is assigned to the activity",
  "keyword": "Then "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.theEmployeeWithInitialsIsAssignedToTheActivity(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the activity is assigned to the employee with initials \"ABC\"",
  "keyword": "And "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.theActivityIsAssignedToTheEmployeeWithInitials(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Non-assigned employee asks for assistance with an activity",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "there is a project in the Project Manager",
  "keyword": "Given "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.thereIsAProjectInTheManager()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "there is an activity on the project",
  "keyword": "And "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.theProjectHasAnActivity()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the employee with initials \"ABC\" is registered",
  "keyword": "And "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.EmployeeSteps.theEmployeeWithInitialsIsRegistered(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the employee with initials \"XYZ\" is registered",
  "keyword": "And "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.EmployeeSteps.theEmployeeWithInitialsIsRegistered(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user logs in with initials \"ABC\"",
  "keyword": "And "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.LoginLogoutSteps.theUserLogsInWithInitials(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user asks the employee with initials \"XYZ\" for help with the activity",
  "keyword": "When "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.theUserAsksTheEmployeeWithInitialsForHelpWithTheActivity(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the employee with the initials \"XYZ\" is not assigned to the activity",
  "keyword": "Then "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.theEmployeeWithInitialsIsNotAssignedToTheActivity(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the activity is not assigned to the employee with initials \"XYZ\"",
  "keyword": "And "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.theActivityIsNotAssignedTheEmployeeWithInitials(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the error message \"The employee is not assigned to this activity\" is given",
  "keyword": "And "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.theErrorMessageIsGiven(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.uri("file:use_cases/detailed_use_cases/assign_project_leader.feature");
formatter.feature({
  "name": "Assign Project Leader",
  "description": "\tDescription: A Project Leader is assigned to a project by the Admin.\n\tActors: Admin",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Assign a Project Leader successfully",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "the employee with initials \"ABC\" is registered",
  "keyword": "Given "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.EmployeeSteps.theEmployeeWithInitialsIsRegistered(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "there is a project in the Project Manager",
  "keyword": "And "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.thereIsAProjectInTheManager()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user is logged in as admin",
  "keyword": "And "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.LoginLogoutSteps.theUserIsAlreadyLoggedInAsAdmin()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user assigns the employee with initials \"ABC\" as Project Leader for the project",
  "keyword": "When "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.theUserAssignsEmployeeWithInitialsAsProjectLeader(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the Project Leader of the project has the initials \"ABC\"",
  "keyword": "Then "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.theProjectLeaderOfTheProjectHasTheInitials(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Assign a Project Leader when not admin",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "there is a project in the Project Manager",
  "keyword": "Given "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.thereIsAProjectInTheManager()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the employee with initials \"ABC\" is registered",
  "keyword": "And "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.EmployeeSteps.theEmployeeWithInitialsIsRegistered(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user is logged in as a registered employee",
  "keyword": "And "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.EmployeeSteps.theUserIsARegisteredEmployee()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user assigns the employee with initials \"ABC\" as Project Leader for the project",
  "keyword": "When "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.theUserAssignsEmployeeWithInitialsAsProjectLeader(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the Project Leader of the project does not have the initials \"ABC\"",
  "keyword": "Then "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.theProjectLeaderOfTheProjectDoesNotHaveTheInitials(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the error message \"Administrator login required\" is given",
  "keyword": "And "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.theErrorMessageIsGiven(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Assign a Project Leader to a non-existing project",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "the user is logged in as admin",
  "keyword": "Given "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.LoginLogoutSteps.theUserIsAlreadyLoggedInAsAdmin()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the employee with initials \"ABC\" is registered",
  "keyword": "And "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.EmployeeSteps.theEmployeeWithInitialsIsRegistered(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "there is a project named \"Sample project\"",
  "keyword": "And "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.thereIsAProjectWithName(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the project does not exist in the Project Manager",
  "keyword": "And "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.theProjectDoesNotExistInTheProjectManager()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user assigns the employee with initials \"ABC\" as Project Leader for the project",
  "keyword": "When "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.theUserAssignsEmployeeWithInitialsAsProjectLeader(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the error message \"Project does not exist\" is given",
  "keyword": "Then "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.theErrorMessageIsGiven(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Assign a non-existing employee as Project Leader",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "the user is logged in as admin",
  "keyword": "Given "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.LoginLogoutSteps.theUserIsAlreadyLoggedInAsAdmin()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "there does not exist an employee with initials \"ABC\"",
  "keyword": "And "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.EmployeeSteps.thereDoesNotExistAnEmployeeWithInitials(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "there is a project in the Project Manager",
  "keyword": "And "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.thereIsAProjectInTheManager()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user assigns the employee with initials \"ABC\" as Project Leader for the project",
  "keyword": "When "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.theUserAssignsEmployeeWithInitialsAsProjectLeader(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the error message \"Employee does not exist\" is given",
  "keyword": "Then "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.theErrorMessageIsGiven(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Employee requests the projects it is leading",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "there is a project in the Project Manager",
  "keyword": "Given "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.thereIsAProjectInTheManager()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user is logged in as Project Leader for the project",
  "keyword": "And "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.theUserIsProjectLeaderForTheProject()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user requests a list of projects lead by himself",
  "keyword": "When "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.theUserRequestsLeaderList()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the project is contained in the list",
  "keyword": "Then "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.theProjectIsInTheList()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Employee requests the projects some other employee is leading",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "the employee with initials \"ABC\" is registered",
  "keyword": "Given "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.EmployeeSteps.theEmployeeWithInitialsIsRegistered(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the employee with initials \"XYZ\" is registered",
  "keyword": "And "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.EmployeeSteps.theEmployeeWithInitialsIsRegistered(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user logs in with initials \"ABC\"",
  "keyword": "And "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.LoginLogoutSteps.theUserLogsInWithInitials(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user requests a list of projects lead by employee with initials \"XYZ\"",
  "keyword": "When "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.theUserRequestsASpecificLeaderList(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the error message \"You can only see projects that you are leading\" is given",
  "keyword": "Then "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.theErrorMessageIsGiven(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.uri("file:use_cases/detailed_use_cases/budget_hours.feature");
formatter.feature({
  "name": "Budget hours to an activity",
  "description": "  Description: A Project Leader budgets hours to an activity\n  Actors: Project Leader",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Budget hours to an activity successfully",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "there is a project in the Project Manager",
  "keyword": "Given "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.thereIsAProjectInTheManager()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "there is an activity on the project",
  "keyword": "And "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.theProjectHasAnActivity()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user is logged in as Project Leader for the project",
  "keyword": "And "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.theUserIsProjectLeaderForTheProject()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user budgets 10 hours to the activity",
  "keyword": "When "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.budgetHoursToActivity(double)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the activity has a budget of 10 hours",
  "keyword": "Then "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.activityHasBudgetHours(double)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Budget hours to an activity when not Project Leader",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "there is a project in the Project Manager",
  "keyword": "Given "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.thereIsAProjectInTheManager()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "there is an activity on the project",
  "keyword": "And "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.theProjectHasAnActivity()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user is logged in as a registered employee",
  "keyword": "And "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.EmployeeSteps.theUserIsARegisteredEmployee()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user budgets 10 hours to the activity",
  "keyword": "When "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.budgetHoursToActivity(double)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the activity has no budgeted hours",
  "keyword": "Then "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.activityHasNoBudgetHours()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the error message \"Project Leader login required\" is given",
  "keyword": "And "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.theErrorMessageIsGiven(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.uri("file:use_cases/detailed_use_cases/register_hours_to_activity.feature");
formatter.feature({
  "name": "Register hours to an activity",
  "description": "  Description: An employee registers their hours to an activity\n  Actors: Employee",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Register hours to an activity successfully",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "there is a project in the Project Manager",
  "keyword": "Given "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.thereIsAProjectInTheManager()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "there is an activity on the project",
  "keyword": "And "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.theProjectHasAnActivity()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user is logged in as a registered employee assigned to the activity",
  "keyword": "And "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.userIsLoggedInAsRegisteredEmployeeAssignedToTheActivity()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user registers 2 hours to the activity",
  "keyword": "When "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.userRegistersHoursToActivity(double)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user has 2 hours registered to the activity",
  "keyword": "Then "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.activityHasNoRegisteredHoursWithEmployee(double)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Register hours to an activity the employee is not assigned to",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "there is a project in the Project Manager",
  "keyword": "Given "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.thereIsAProjectInTheManager()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "there is an activity on the project",
  "keyword": "And "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.theProjectHasAnActivity()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user is logged in as a registered employee",
  "keyword": "And "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.EmployeeSteps.theUserIsARegisteredEmployee()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user registers 2 hours to the activity",
  "keyword": "When "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.userRegistersHoursToActivity(double)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user has 0 hours registered to the activity",
  "keyword": "Then "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.activityHasNoRegisteredHoursWithEmployee(double)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the error message \"The employee is not assigned to this activity\" is given",
  "keyword": "And "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.theErrorMessageIsGiven(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Register more hours to an activity",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "there is a project in the Project Manager",
  "keyword": "Given "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.thereIsAProjectInTheManager()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "there is an activity on the project",
  "keyword": "And "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.theProjectHasAnActivity()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user is logged in as a registered employee assigned to the activity",
  "keyword": "And "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.userIsLoggedInAsRegisteredEmployeeAssignedToTheActivity()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user registers 2 hours to the activity",
  "keyword": "And "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.userRegistersHoursToActivity(double)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user registers 3 more hours to the activity",
  "keyword": "And "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.userRegistersHoursToActivity(double)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user requests his own total hours registered to the activity",
  "keyword": "When "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.userRequestsOwnTotalRegisteredHoursFromActivity()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user has 5 hours registered to the activity",
  "keyword": "Then "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.activityHasNoRegisteredHoursWithEmployee(double)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Multiple employees register hours to activity and the Project Leader requests the total",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "there is a project in the Project Manager",
  "keyword": "Given "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.thereIsAProjectInTheManager()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "there is an activity on the project",
  "keyword": "And "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.theProjectHasAnActivity()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the registered employee \"HBO\" is assigned to the activity",
  "keyword": "And "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.theRegisteredEmployeeIsAssignedToTheActivity(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the registered employee \"BOB\" is assigned to the activity",
  "keyword": "And "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.theRegisteredEmployeeIsAssignedToTheActivity(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user logs in with initials \"HBO\"",
  "keyword": "And "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.LoginLogoutSteps.theUserLogsInWithInitials(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user registers 2 hours to the activity",
  "keyword": "And "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.userRegistersHoursToActivity(double)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user logs in with initials \"BOB\"",
  "keyword": "And "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.LoginLogoutSteps.theUserLogsInWithInitials(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user registers 7 hours to the activity",
  "keyword": "And "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.userRegistersHoursToActivity(double)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user is now logged in as Project Leader for the project",
  "keyword": "And "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.theUserIsProjectLeaderForTheProject()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user requests the total hours registered to the activity",
  "keyword": "When "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.userRequestsTotalRegisteredHoursFromActivity()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the total hours registered to the activity is 9",
  "keyword": "Then "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.theTotalHoursRegisteredToTheActivityShouldBe(double)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "An assigned employee requests total registered hours unsuccessfully",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "there is a project in the Project Manager",
  "keyword": "Given "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.thereIsAProjectInTheManager()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "there is an activity on the project",
  "keyword": "And "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.theProjectHasAnActivity()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user is logged in as a registered employee assigned to the activity",
  "keyword": "And "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.userIsLoggedInAsRegisteredEmployeeAssignedToTheActivity()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user requests the total hours registered to the activity",
  "keyword": "When "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.userRequestsTotalRegisteredHoursFromActivity()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the error message \"Project Leader login required\" is given",
  "keyword": "Then "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.theErrorMessageIsGiven(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.uri("file:use_cases/detailed_use_cases/rename_activity.feature");
formatter.feature({
  "name": "Rename activity",
  "description": "    Description: An activity is renamed by the Project Leader\n    Actors: Project Leader",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Rename an activity successfully",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "there is a project in the Project Manager",
  "keyword": "Given "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.thereIsAProjectInTheManager()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "there is an activity on the project",
  "keyword": "And "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.theProjectHasAnActivity()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user is logged in as Project Leader for the project",
  "keyword": "And "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.theUserIsProjectLeaderForTheProject()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user renames the activity to \"Get code coverage to 100%\"",
  "keyword": "When "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.theUserRenamesActivity(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the activity has the name \"Get code coverage to 100%\"",
  "keyword": "Then "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.theActivityHasTheName(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Rename an activity when not Project Leader",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "there is a project in the Project Manager",
  "keyword": "Given "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.thereIsAProjectInTheManager()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "there is an activity on the project",
  "keyword": "And "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.theProjectHasAnActivity()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user is logged in as a registered employee",
  "keyword": "And "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.EmployeeSteps.theUserIsARegisteredEmployee()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user renames the activity to \"Get code coverage to 100%\"",
  "keyword": "When "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.theUserRenamesActivity(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the activity does not have the name \"Get code coverage to 100%\"",
  "keyword": "Then "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.theActivityDoesNotHaveName(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the error message \"Project Leader login required\" is given",
  "keyword": "And "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.theErrorMessageIsGiven(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Rename an activity that does not exist",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "there is a project in the Project Manager",
  "keyword": "Given "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.thereIsAProjectInTheManager()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user is logged in as Project Leader for the project",
  "keyword": "And "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.theUserIsProjectLeaderForTheProject()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user renames the activity to \"Get code coverage to 100%\"",
  "keyword": "When "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.theUserRenamesActivity(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the error message \"Activity does not exist\" is given",
  "keyword": "Then "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.theErrorMessageIsGiven(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.uri("file:use_cases/detailed_use_cases/rename_project.feature");
formatter.feature({
  "name": "Rename project",
  "description": "\tDescription: A project is renamed by the Admin\n\tActors: Admin",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Rename a project successfully",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "there is a project in the Project Manager",
  "keyword": "Given "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.thereIsAProjectInTheManager()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user is logged in as admin",
  "keyword": "And "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.LoginLogoutSteps.theUserIsAlreadyLoggedInAsAdmin()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user renames the project",
  "keyword": "When "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.theUserRenamesTheProject()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the projects name is changed",
  "keyword": "Then "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.theProjectsNameIsChanged()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Rename a project when not admin",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "there is a project in the Project Manager",
  "keyword": "Given "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.thereIsAProjectInTheManager()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user is logged in as a registered employee",
  "keyword": "And "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.EmployeeSteps.theUserIsARegisteredEmployee()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user renames the project",
  "keyword": "When "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.theUserRenamesTheProject()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the projects name is unchanged",
  "keyword": "Then "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.theProjectsNameIsUnchanged()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the error message \"Administrator login required\" is given",
  "keyword": "And "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.theErrorMessageIsGiven(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Rename a project that does not exist",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "the user is logged in as admin",
  "keyword": "Given "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.LoginLogoutSteps.theUserIsAlreadyLoggedInAsAdmin()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "there is a project named \"Sample project\"",
  "keyword": "And "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.thereIsAProjectWithName(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the project does not exist in the Project Manager",
  "keyword": "And "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.theProjectDoesNotExistInTheProjectManager()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user renames the project",
  "keyword": "When "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.theUserRenamesTheProject()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the error message \"Project does not exist\" is given",
  "keyword": "And "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.theErrorMessageIsGiven(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.uri("file:use_cases/detailed_use_cases/see_available_employees.feature");
formatter.feature({
  "name": "See available employees",
  "description": "\tDescription: See employees that do not exceed their active activities limit\n\tActors: Any",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "An employee is available, then adds one more activity and becomes unavailable",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "an employee registered in the Project Manager",
  "keyword": "Given "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.EmployeeSteps.anEmployeeRegisteredInTheProjectManager()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the employee is assigned to 19 activities in week 3",
  "keyword": "And "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.EmployeeSteps.theEmployeeIsAssignedToActivities(int,int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the employee is available in week 3",
  "keyword": "And "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.EmployeeSteps.theEmployeeIsAvailable(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the employee is assigned to 1 more activity in week 3",
  "keyword": "When "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.EmployeeSteps.theEmployeeIsAssignedToActivities(int,int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the employee is unavailable in week 3",
  "keyword": "Then "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.EmployeeSteps.theEmployeeIsUnavailable(int)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "An employee is assigned while unavailable",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "an employee registered in the Project Manager",
  "keyword": "Given "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.EmployeeSteps.anEmployeeRegisteredInTheProjectManager()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the employee is assigned to 20 activities in week 10",
  "keyword": "And "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.EmployeeSteps.theEmployeeIsAssignedToActivities(int,int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the employee is assigned to 1 more activity in week 10",
  "keyword": "When "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.EmployeeSteps.theEmployeeIsAssignedToActivities(int,int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the employee is still assigned to 20 activities in week 10",
  "keyword": "Then "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.EmployeeSteps.theEmployeeIsNowAssignedToActivities(int,int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the error message \"The employee is not available in this period\" is given",
  "keyword": "And "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.theErrorMessageIsGiven(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.uri("file:use_cases/detailed_use_cases/user_login.feature");
formatter.feature({
  "name": "User Login",
  "description": "\tDescription: A user (employee or Admin-employee) logs into the app\n\tActor: Employee",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "User logs in as admin",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "the user logs in with initials \"ADMIN\"",
  "keyword": "When "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.LoginLogoutSteps.theUserLogsInWithInitials(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user is now logged in as admin",
  "keyword": "Then "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.LoginLogoutSteps.theUserIsLoggedInAsAdmin()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "User logs in as existing employee",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "the employee with initials \"HBO\" is registered",
  "keyword": "Given "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.EmployeeSteps.theEmployeeWithInitialsIsRegistered(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user logs in with initials \"HBO\"",
  "keyword": "When "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.LoginLogoutSteps.theUserLogsInWithInitials(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user is logged in with initials \"HBO\"",
  "keyword": "Then "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.LoginLogoutSteps.theUserIsLoggedInWithInitials(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "User logs in as non-existing employee",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "there does not exist an employee with initials \"XXX\"",
  "keyword": "Given "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.EmployeeSteps.thereDoesNotExistAnEmployeeWithInitials(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user logs in with initials \"XXX\"",
  "keyword": "When "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.LoginLogoutSteps.theUserLogsInWithInitials(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user is not logged in",
  "keyword": "Then "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.LoginLogoutSteps.theUserIsNotLoggedIn()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the error message \"Employee does not exist\" is given",
  "keyword": "And "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.theErrorMessageIsGiven(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "User logs out",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "the employee with initials \"JFK\" is registered",
  "keyword": "Given "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.EmployeeSteps.theEmployeeWithInitialsIsRegistered(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user logs in with initials \"JFK\"",
  "keyword": "And "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.LoginLogoutSteps.theUserLogsInWithInitials(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user is logged in with initials \"JFK\"",
  "keyword": "And "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.LoginLogoutSteps.theUserIsLoggedInWithInitials(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user logs out",
  "keyword": "When "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.LoginLogoutSteps.theUserLogsOut()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user is not logged in",
  "keyword": "Then "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.LoginLogoutSteps.theUserIsNotLoggedIn()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "If no one is logged in, the admin is not logged in",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "the user is not logged in",
  "keyword": "When "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.LoginLogoutSteps.theUserIsNotLoggedIn()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user is not logged in as admin",
  "keyword": "Then "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.LoginLogoutSteps.theUserIsNotLoggedInAsAdmin()"
});
formatter.result({
  "status": "passed"
});
});