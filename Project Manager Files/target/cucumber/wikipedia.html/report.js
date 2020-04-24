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
  "name": "the employee with initials \"ABC\" is Project Leader for the project",
  "keyword": "And "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.givenTheEmployeeWithInitialsIsProjectLeader(java.lang.String)"
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
  "name": "the activity exists on the project",
  "keyword": "Then "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.theActivityExistsOnTheProject()"
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
  "name": "the activity does not exist on the project",
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
  "name": "Creating activity with start time and duration",
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
  "name": "Creating activity around New Year",
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
  "name": "there is a project named \"Sample project\"",
  "keyword": "Given "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.thereIsAProjectWithName(java.lang.String)"
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
  "name": "the user adds the project to the project manager",
  "keyword": "When "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.theUserAddsTheProject()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the project exists in the project manager",
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
  "name": "there is a project named \"Sample project\"",
  "keyword": "Given "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.thereIsAProjectWithName(java.lang.String)"
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
  "name": "the user adds the project to the project manager",
  "keyword": "When "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.theUserAddsTheProject()"
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
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.theUserAddsAnotherProject()"
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
  "description": "  Description: An employee is assigned to an activity\n  Actors: Project leader",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Successfully assign an employee to an activity",
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
  "name": "the employee with initials \"ABC\" is Project Leader for the project",
  "keyword": "And "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.givenTheEmployeeWithInitialsIsProjectLeader(java.lang.String)"
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
  "name": "the user assigns the employee with initials \"ABC\" as Project Leader of the project",
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
  "name": "Assign a project leader when not admin",
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
  "name": "the user assigns the employee with initials \"ABC\" as Project Leader of the project",
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
formatter.uri("file:use_cases/detailed_use_cases/budget_hours.feature");
formatter.feature({
  "name": "Budget hours to an activity",
  "description": "  Description: The project leader budget hours to the activity\n  Actors: Project leader",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Budget hours to an activity successfully when project leader",
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
  "name": "the employee with initials \"ABC\" is Project Leader for the project",
  "keyword": "And "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.givenTheEmployeeWithInitialsIsProjectLeader(java.lang.String)"
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
  "name": "the budget 10 hours to the activity",
  "keyword": "When "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.budgetHoursToActivity(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the activity has a budget of 10 hours",
  "keyword": "Then "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.activityHasBudgetHours(int)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Budget hours to an activity when not project leader",
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
  "name": "the employee with initials \"ABC\" is Project Leader for the project",
  "keyword": "And "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.givenTheEmployeeWithInitialsIsProjectLeader(java.lang.String)"
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
  "name": "the budget 10 hours to the activity",
  "keyword": "When "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.budgetHoursToActivity(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the activity has no budget hours",
  "keyword": "Then "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.ProjectSteps.activityHasNoBudgetHours()"
});
formatter.result({
  "status": "passed"
});
formatter.uri("file:use_cases/detailed_use_cases/see_available_employees.feature");
formatter.feature({
  "name": "See available employees",
  "description": "\tDescription: See employees that do not exceed their active activities limit\n\tActors: Anyone",
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
  "name": "the employee is assigned to 19 active activities",
  "keyword": "And "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.EmployeeSteps.theEmployeeIsAssignedToActivities(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the employee is available",
  "keyword": "And "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.EmployeeSteps.theEmployeeIsAvailable()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the employee is assigned to 1 more active activity",
  "keyword": "When "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.EmployeeSteps.theEmployeeIsAssignedToActivities(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the employee is unavailable",
  "keyword": "Then "
});
formatter.match({
  "location": "dtu.projectManager.acceptance_tests.EmployeeSteps.theEmployeeIsUnavailable()"
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