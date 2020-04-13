package dtu.projectManager.presentation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Interface_test {

	

	public static void main(String[] args){

		
		
		Scanner sc = new Scanner(System.in);
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
		
		UserInterface UI = new UserInterface(sc);
		
		// Test admin menu
		currentUser = "ADMIN";
		MenuInfo adminMenu = new MenuInfo(adminOptions,currentUser);
		

		try {
			UI.test(adminMenu);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		sc.close();
	}

}
