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

	
	public void AppSession() throws Exception {
		
		String input;
		while (true)
		{
			this.printer.Print(this.State.GetMenuText());
			input = this.scanner.GetUserInput();
			
			if (input.equals("exit")) {
				break;
			}
			
			if (input.equals("logout"))
			{
				ResetState();
				continue;
			}
				
			if (!this.State.ValidateInput(input)) {
				PrintInputError();
				continue;
			}
			
			this.State.SetInput(input);
			
			Object[] result = null;
			if  (this.State.NeedsExecution()) {
				String[] methodArguments = this.State.GetApplicationRequest();
				result = this.inputInterpreter.CallMethod(methodArguments);
				if (this.inputInterpreter.PrintFeedback()) {
					this.printer.Print(this.inputInterpreter.GetFeedback());
					this.scanner.WaitForUserConfirmation();					
				}
			}
			UpdateState(result);
		}
	}
	
	
	private void PrintInputError() {
		List<String> errorMessage = this.State.GetInputSpecification();
		this.printer.Print(errorMessage);
		this.scanner.WaitForUserConfirmation();
	}
	
	
	private void UpdateState(Object[] result) throws Exception {
		if (this.inputInterpreter.HadError()) {
			this.State = this.State.RewindState();
		}
		else {
			this.State = this.State.GetNextState(result);
		}
	}
	
	private void ResetState() {
		this.State = new LoginMenu();
	}
	
}