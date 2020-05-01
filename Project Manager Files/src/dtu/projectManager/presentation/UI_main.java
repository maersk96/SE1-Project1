package dtu.projectManager.presentation;

import java.util.Scanner;

import dtu.projectManager.app.ProjectManagerApp;

public class UI_main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		ProjectManagerApp App = new ProjectManagerApp();
		UserInterface UI = new UserInterface(sc,App);
		
		
		System.out.println("Add mock data? (type \"yes\")");
		String input = sc.nextLine();
		if (input.equals("yes"))
		{
			try {
				System.out.println("Adding data to app...");
				App.addMockData(5);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		try {
			UI.appSession();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
