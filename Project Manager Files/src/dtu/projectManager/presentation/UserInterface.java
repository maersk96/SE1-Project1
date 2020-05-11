package dtu.projectManager.presentation;

import java.util.List;
import java.util.Scanner;

import dtu.projectManager.app.ProjectManagerApp;
import dtu.projectManager.presentation.menus.LoginMenu;

// Work distribution for all of UI:
// Anton s164170

public class UserInterface {

	private Menu State;
	private Interpreter inputInterpreter;
	private UIPrinter printer;
	private UIScanner scanner;
	
	public UserInterface(Scanner sc, ProjectManagerApp App) {
		this.scanner = new UIScanner(sc);
		this.printer = new UIPrinter();
		this.inputInterpreter = new Interpreter(App);
		this.State = new LoginMenu();
		
	}

	public void appSession() throws Exception {
		
		String input;
		while (true)
		{
			this.printer.print(this.State.getMenuText());
			
			
			input = getUserInput();
			
			if (input.equals("exit")) {
				break;
			}
			
			if (input.equals("logout"))
			{
				resetState();
				continue;
			}
				
			
			this.State.setInput(input);
			
			Object[] result = null;
			
			if  (this.State.needsExecution()) {
				Object[] methodArguments = this.State.getApplicationRequest();
				result = this.inputInterpreter.callMethod(methodArguments);
				if (this.inputInterpreter.printFeedback()) {
					this.printer.print(this.inputInterpreter.getFeedback());
					this.scanner.waitForUserConfirmation();					
				}
			}
			updateState(result);
		}
	}
	
	
	private String getUserInput() {
		
		String input = this.scanner.getUserInput();
		
		
		while (true) {
			if (input.equals("logout") || input.equals("exit"))
				return input;

			if (this.State.validateInput(input)) {
				return input;
			}
			else {				
				printInputError();
				input = this.scanner.getUserInput();
			}
			
		}
	}


	private void printInputError() {
		List<String> errorMessage = this.State.getInputSpecification();
		this.printer.print(errorMessage);
	}
	
	
	private void updateState(Object[] result) throws Exception {
		if (this.inputInterpreter.hadError()) {
			this.inputInterpreter.resetErrorState();
			this.State = this.State.rewindState();
		}
		else {
			this.State = this.State.getNextState(result);
		}
	}
	
	private void resetState() {
		this.State = new LoginMenu();
	}
	
}