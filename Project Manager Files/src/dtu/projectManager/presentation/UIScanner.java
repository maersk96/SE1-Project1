package dtu.projectManager.presentation;

import java.util.Scanner;

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
