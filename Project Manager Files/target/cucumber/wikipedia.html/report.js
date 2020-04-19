$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:use_cases/detailed_use_cases/add_activity.feature");
formatter.feature({
  "name": "Add activity",
  "description": "  Description: An activity is added by the project leader.\n  Actors: Project leader",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Add an activity successfully when project leader",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "a project with the ID \"2020-1\" exists",
  "keyword": "Given "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.aProjectWithIDGiven(java.lang.String)"
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
  "name": "the employee with initials \"ABC\" is project leader for the project with the ID \"2020-1\"",
  "keyword": "And "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.givenEmployeeIsProjectLeader(java.lang.String,java.lang.String)"
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
  "name": "the user adds an activity with the ID \"0001\" to the project with the ID \"2020-1\"",
  "keyword": "When "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.userAddsActivityToProject(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "an activity with the ID \"0001\" is added to the project with the ID \"2020-1\"",
  "keyword": "Then "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.activityExists(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Add an activity when not project leader",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "a project with the ID \"2020-1\" exists",
  "keyword": "Given "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.aProjectWithIDGiven(java.lang.String)"
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
  "name": "the employee with initials \"ABC\" is not project leader for the project with the ID \"2020-1\"",
  "keyword": "And "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.givenEmployeeIsNotProjectLeader(java.lang.String,java.lang.String)"
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
  "name": "the user adds an activity with the ID \"0001\" to the project with the ID \"2020-1\"",
  "keyword": "When "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.userAddsActivityToProject(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "an activity with the ID \"0001\" is not added to the project with the ID \"2020-1\"",
  "keyword": "Then "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.activityExistsNot(java.lang.String,java.lang.String)"
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
  "name": "Add an employee successfully when logged in as admin",
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
formatter.scenario({
  "name": "Add an employee when not admin",
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
  "keyword": "And "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.LoginLogoutSteps.theUserLogsInWithInitials(java.lang.String)"
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
formatter.uri("file:use_cases/detailed_use_cases/add_project.feature");
formatter.feature({
  "name": "Create project",
  "description": "\tDescription: A project is created by the Admin\n\tActors: Admin",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Add a project successfully when logged in as admin",
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
  "name": "there are no projects in the project manager",
  "keyword": "And "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.thereAreNoProjectsInTheManager()"
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
  "name": "a project with the ID \"2020-1\" exists in the project manager",
  "keyword": "Then "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.aProjectWithIDExists(java.lang.String)"
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
  "keyword": "And "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.LoginLogoutSteps.theUserLogsInWithInitials(java.lang.String)"
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
  "name": "the error message \"Administrator login required\" is given",
  "keyword": "Then "
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
  "name": "the user adds a project",
  "keyword": "And "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.theUserAddsAProject()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a project with the ID \"2020-1\" exists in the project manager",
  "keyword": "Then "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.aProjectWithIDExists(java.lang.String)"
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
  "name": "a project with the ID \"2020-2\" exists in the project manager",
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
  "description": "  Description: An employee is assigned to an activity\n  Actors: Project leader",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Successfully assign an employee to an activity",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "a project with the ID \"2020-1\" exists",
  "keyword": "Given "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.aProjectWithIDGiven(java.lang.String)"
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
  "name": "the employee with initials \"ABC\" is project leader for the project with the ID \"2020-1\"",
  "keyword": "And "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.givenEmployeeIsProjectLeader(java.lang.String,java.lang.String)"
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
  "name": "an activity with the ID \"0001\" exists on the project with ID \"2020-1\"",
  "keyword": "And "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.activityExistsOnProject(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user assigns the employee with initials \"HBO\" to the activity with ID \"0001\" on the project with ID \"2020-1\"",
  "keyword": "When "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.userAssignsEmployeeToActivity(java.lang.String,java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the employee with initials \"HBO\" is assigned to the activity with ID \"0001\" on the project with ID \"2020-1\"",
  "keyword": "Then "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.employeeIsAssignedToActivity(java.lang.String,java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the activity with ID \"0001\" is assigned to the employee with initials \"HBO\"",
  "keyword": "And "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.employeeIsAssignedToActivity(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.uri("file:use_cases/detailed_use_cases/assign_project_leader.feature");
formatter.feature({
  "name": "Assign Project Leader",
  "description": "\tDescription: A project leader is assigned by the Admin.\n\tActors: Admin",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Assign a project leader successfully when logged in as admin",
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
  "name": "a project with the ID \"2020-1\" exists",
  "keyword": "And "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.aProjectWithIDGiven(java.lang.String)"
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
  "name": "the employee with initials \"ABC\" is assigned as project leader for the project with the ID \"2020-1\"",
  "keyword": "When "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.employeeAssignedProjectLeader(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the project with the ID \"2020-1\" has project leader with initials \"ABC\"",
  "keyword": "Then "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.employeeIsProjectLeader(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Assign a project leader when not admin",
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
  "name": "a project with the ID \"2020-1\" exists",
  "keyword": "And "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.aProjectWithIDGiven(java.lang.String)"
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
  "name": "the employee with initials \"ABC\" is assigned as project leader for the project with the ID \"2020-1\"",
  "keyword": "When "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.employeeAssignedProjectLeader(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the project with the ID \"2020-1\" does not have a project leader with initials \"ABC\"",
  "keyword": "Then "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.employeeIsNotProjectLeader(java.lang.String,java.lang.String)"
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
formatter.uri("file:use_cases/detailed_use_cases/user_login.feature");
formatter.feature({
  "name": "User Login",
  "description": "\tDescription: A user (Employee or Admin-Employee) logs into the app\n\tActor: Employee",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "User logs in as administrator",
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
  "name": "the error message \"Employee with initials XXX does not exist\" is given",
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
});