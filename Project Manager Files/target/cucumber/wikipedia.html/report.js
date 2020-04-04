$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:use_cases/detailed_use_cases/add_employee.feature");
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
  "name": "the user logs in with initials \"ADMIN\"",
  "keyword": "Given "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.LoginLogoutSteps.theUserLogsInWithInitials(java.lang.String)"
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
  "name": "the user logs in with initials \"ADMIN\"",
  "keyword": "Given "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.LoginLogoutSteps.theUserLogsInWithInitials(java.lang.String)"
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
  "name": "the user logs in with initials \"ADMIN\"",
  "keyword": "Given "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.LoginLogoutSteps.theUserLogsInWithInitials(java.lang.String)"
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
  "name": "the user logs in with initials \"ADMIN\"",
  "keyword": "Given "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.LoginLogoutSteps.theUserLogsInWithInitials(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user is logged in as admin",
  "keyword": "And "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.LoginLogoutSteps.theUserIsLoggedInAsAdmin()"
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
  "name": "the user is logged in as admin",
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