package dtu.projectManager.presentation;

import java.util.Scanner;

// Work distribution for all of UI:
// Anton s164170

public class UIScanner {

	private Scanner InputScanner;
	
	public UIScanner (Scanner sc) {
		this.InputScanner = sc;
	}
	
	public String getUserInput() {
		String input = this.InputScanner.nextLine();
		
		return input;
	}
	
	public void waitForUserConfirmation() {
		this.InputScanner.nextLine();
	}
	
}
