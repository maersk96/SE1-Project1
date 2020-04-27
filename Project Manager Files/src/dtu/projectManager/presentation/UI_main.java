package dtu.projectManager.presentation;

import java.util.Scanner;

import dtu.projectManager.app.ProjectManagerApp;

public class UI_main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		ProjectManagerApp App = new ProjectManagerApp();
		UserInterface UI = new UserInterface(sc,App);
		
		try {
			UI.appSession();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
