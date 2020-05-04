package dtu.projectManager.presentation;


import java.util.List;
import java.util.Scanner;

import dtu.projectManager.app.ProjectManagerApp;
import dtu.projectManager.presentation.menus.LoginMenu;


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
			input = this.scanner.GetUserInput();
			
			if (input.equals("exit")) {
				break;
			}
			
			if (input.equals("logout"))
			{
				ResetState();
				continue;
			}
				
			if (!this.State.validateInput(input)) {
				PrintInputError();
				continue;
			}
			
			this.State.setInput(input);
			
			Object[] result = null;
			if  (this.State.needsExecution()) {
				Object[] methodArguments = this.State.getApplicationRequest();
				result = this.inputInterpreter.callMethod(methodArguments);
				if (this.inputInterpreter.printFeedback()) {
					this.printer.print(this.inputInterpreter.getFeedback());
					this.scanner.WaitForUserConfirmation();					
				}
			}
			UpdateState(result);
		}
	}
	
	
	private void PrintInputError() {
		List<String> errorMessage = this.State.getInputSpecification();
		this.printer.print(errorMessage);
		this.scanner.WaitForUserConfirmation();
	}
	
	
	private void UpdateState(Object[] result) throws Exception {
		if (this.inputInterpreter.hadError()) {
			this.inputInterpreter.resetErrorState();
			this.State = this.State.rewindState();
		}
		else {
			this.State = this.State.getNextState(result);
		}
	}
	
	private void ResetState() {
		this.State = new LoginMenu();
	}
	
}