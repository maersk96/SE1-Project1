$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:use_cases/detailed_use_cases/admin_login.feature");
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
  "status": "passed"
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
  "status": "passed"
});
});