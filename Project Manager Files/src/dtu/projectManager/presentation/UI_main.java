package dtu.projectManager.presentation;

import java.util.Scanner;

import dtu.projectManager.app.ProjectManagerApp;

public class UI_main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		ProjectManagerApp App = new ProjectManagerApp();
		UserInterface UI = new UserInterface(sc,App);


		while (true) {
			System.out.println("Add mock data? (type \"yes\" or \"no\")");
			String input = sc.nextLine();
			if (input.equals("yes"))
			{
				try {
					App.login("ADMIN");
					System.out.println("Adding data to app...");
					App.addMockData(5);
					App.logout();
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			}
			if (input.equals("no")) {
				System.out.println("Starting app without data");
				break;
			}
			
		}
		
		try {
			UI.appSession();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
