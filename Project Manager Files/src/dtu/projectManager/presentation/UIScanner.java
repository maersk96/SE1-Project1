package dtu.projectManager.presentation;

import java.util.Scanner;

public class UIScanner {

	private Scanner InputScanner;
	
	public UIScanner (Scanner sc) {
		this.InputScanner = sc;
	}
	
	public String GetUserInput() {
		String input = this.InputScanner.nextLine();
		
		return input;
	}
	
	public void WaitForUserConfirmation() {
		this.InputScanner.nextLine();
	}
	
}
