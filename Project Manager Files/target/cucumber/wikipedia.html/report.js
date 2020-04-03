$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:use_cases/detailed_use_cases/AddProject.feature");
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
  "name": "that the user is logged in as admin",
  "keyword": "Given "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.LoginLogoutSteps.thatTheUserIsLoggedInAsAdmin()"
});
formatter.result({
  "error_message": "java.lang.NullPointerException\r\n\tat dtu.projectManager.app.ProjectManagerApp.adminLoggedIn(ProjectManagerApp.java:20)\r\n\tat dtu.projectManager.acceptance_tests.LoginLogoutSteps.thatTheUserIsLoggedInAsAdmin(LoginLogoutSteps.java:42)\r\n\tat ✽.that the user is logged in as admin(file:///C:/Users/Lukas%20Andreasen/Documents/GitHub/SE1-Project1/Project%20Manager%20Files/use_cases/detailed_use_cases/AddProject.feature:7)\r\n",
  "status": "failed"
});
formatter.uri("file:use_cases/detailed_use_cases/admin_login.feature");
formatter.feature({
  "name": "Admin login",
  "description": "\tDescription: The administrator logs into the library system and also logs out\n\tActor: Administrator",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Administrator can login",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "that the administrator is not logged in",
  "keyword": "Given "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.LoginLogoutSteps.thatTheAdministratorIsNotLoggedIn()"
});
formatter.result({
  "error_message": "java.lang.NullPointerException\r\n\tat dtu.projectManager.app.ProjectManagerApp.adminLoggedIn(ProjectManagerApp.java:20)\r\n\tat dtu.projectManager.acceptance_tests.LoginLogoutSteps.thatTheAdministratorIsNotLoggedIn(LoginLogoutSteps.java:37)\r\n\tat ✽.that the administrator is not logged in(file:///C:/Users/Lukas%20Andreasen/Documents/GitHub/SE1-Project1/Project%20Manager%20Files/use_cases/detailed_use_cases/admin_login.feature:6)\r\n",
  "status": "failed"
});
formatter.scenario({
  "name": "Administrator has the wrong password",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "that the administrator is not logged in",
  "keyword": "Given "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.LoginLogoutSteps.thatTheAdministratorIsNotLoggedIn()"
});
formatter.result({
  "error_message": "java.lang.NullPointerException\r\n\tat dtu.projectManager.app.ProjectManagerApp.adminLoggedIn(ProjectManagerApp.java:20)\r\n\tat dtu.projectManager.acceptance_tests.LoginLogoutSteps.thatTheAdministratorIsNotLoggedIn(LoginLogoutSteps.java:37)\r\n\tat ✽.that the administrator is not logged in(file:///C:/Users/Lukas%20Andreasen/Documents/GitHub/SE1-Project1/Project%20Manager%20Files/use_cases/detailed_use_cases/admin_login.feature:12)\r\n",
  "status": "failed"
});
});