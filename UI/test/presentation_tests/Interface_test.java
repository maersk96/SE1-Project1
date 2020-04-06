package presentation_tests;

import java.util.ArrayList;
import java.util.List;

import presentation.MenuInfo;
import presentation.UserInterface;

public class Interface_test {

	

	public static void main(String[] args) {

		String currentUser=null;
		List<String> employeeOptions = new ArrayList<String>();
		List<String> adminOptions = new ArrayList<String>();
		List<String> leaderOptions = new ArrayList<String>();
		
		employeeOptions.add("Register hours to an activity");
		employeeOptions.add("Edit your registered hours");
		employeeOptions.add("Apply for assistance for an activity");
		employeeOptions.add("Add an unassigned activity");
		employeeOptions.add("Edit an unassigned activity");
		

		leaderOptions.add("See registered hours on your projects");
		leaderOptions.add("Add employees to activities on your projects");
		leaderOptions.add("Budget time to activities on your projects");
		leaderOptions.add("Make project activities");
		leaderOptions.add("Edit project activities");

		adminOptions.add("Make project");
		adminOptions.add("Assign project leader to a project");
		adminOptions.add("Edit a project");
		

		for (String s : employeeOptions)
			leaderOptions.add(s);

		for (String s : leaderOptions)
			adminOptions.add(s);
		
		UserInterface UI = new UserInterface();
		
		// Test admin menu
		currentUser = "ADMIN";
		MenuInfo adminMenu = new MenuInfo(adminOptions,currentUser);
		UI.PrintMenu(adminMenu);
		
		UI.getOption(adminMenu);
		
		UI.getInput()
	}

}
