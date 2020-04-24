package dtu.projectManager.presentation;

import java.util.ArrayList;
import java.util.List;

public abstract class Menu {
	
	
	
	
	public List<String> GetMenuText() {
		List<String> MenuText = new ArrayList<String>();
		List<String> startText = GetStartText();
		List<String> options = GetOptions();
		List<String> endText = GetEndText();
		
		if (startText != null) {
			for (String s : startText) {
				MenuText.add(s);
			}			
		}
		
		if (options != null) {
			int i=1;
			for (String s : options) {
				MenuText.add(i+". "+s);
				i++;
			}			
		}
		if (endText != null) {
			for (String s : endText) {
				MenuText.add(s);
			}			
		}
		return MenuText;
	}
	
	protected abstract List<String> GetStartText();
	protected abstract List<String> GetOptions();
	protected abstract List<String> GetEndText();
	protected abstract boolean HasOptions();


	public String[] GetApplicationRequest() {
		String[] input = GetMethodInput();
		int inputLength = input.length;
		String[] ApplicationRequest = new String[inputLength+1];
		ApplicationRequest[0] = GetMethodName();
		
		for (int i=0; i<inputLength; i++) {
			ApplicationRequest[i+1] = input[i];
		}
		return ApplicationRequest;
	}


	protected abstract String[] GetMethodInput();
	protected abstract void SetInput(String input);
	protected abstract String GetMethodName();
	
	
	public abstract List<String> GetInputSpecification();
	
	
	public boolean ValidateInput(String input) {
		boolean isInt = IsInt();
	
		if (isInt) {
			int i;
			try {
			i = Integer.parseInt(input);
			} catch (NumberFormatException e) {
			return false;
			}

			if (HasOptions())
					if (i<1 || i> GetOptions().size())
						return false;
		}
		
		return true;
	}
	
	protected abstract boolean IsInt();
	
	
	public abstract Menu GetNextState(Object[] result) throws Exception;
	public abstract Menu RewindState();
	
	public abstract boolean NeedsExecution();
}
