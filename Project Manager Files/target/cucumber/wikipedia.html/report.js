$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:use_cases/detailed_use_cases/add_project.feature");
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
  "name": "there exists an employee with initials \"ADMIN\"",
  "keyword": "Given "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.LoginLogoutSteps.thereExistsAnEmployeeWithInitials(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user logs in with initials \"ADMIND\"",
  "keyword": "When "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.LoginLogoutSteps.theUserLogsInWithInitials(java.lang.String)"
});
formatter.result({
  "error_message": "dtu.projectManager.app.OperationNotAllowedException: Employee does not exist\n\tat dtu.projectManager.app.ProjectManagerApp.login(ProjectManagerApp.java:22)\n\tat dtu.projectManager.acceptance_tests.LoginLogoutSteps.theUserLogsInWithInitials(LoginLogoutSteps.java:53)\n\tat ✽.the user logs in with initials \"ADMIND\"(file:///Users/jonasmaersk/Documents/GitHub/SE1-Project1/Project%20Manager%20Files/use_cases/detailed_use_cases/user_login.feature:7)\n",
  "status": "failed"
});
formatter.step({
  "name": "the user is logged in as admin",
  "keyword": "Then "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.LoginLogoutSteps.theUserIsLoggedInAsAdmin()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "name": "User logs in as existing employee",
  "description": "",
  "keyword": "Scenario"
});
formatter.scenario({
  "name": "User logs in as non-existing employee",
  "description": "",
  "keyword": "Scenario"
});
formatter.scenario({
  "name": "User logs out",
  "description": "",
  "keyword": "Scenario"
});
});