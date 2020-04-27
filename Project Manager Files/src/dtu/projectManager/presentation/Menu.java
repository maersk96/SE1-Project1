package dtu.projectManager.presentation;

import java.util.ArrayList;
import java.util.List;

public abstract class Menu {
	
	
	
	
	public List<String> getMenuText() {
		List<String> MenuText = new ArrayList<String>();
		List<String> startText = getStartText();
		List<String> options = getOptions();
		List<String> endText = getEndText();
		
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
	
	protected abstract List<String> getStartText();
	protected abstract List<String> getOptions();
	protected abstract List<String> getEndText();
	protected abstract boolean hasOptions();


	public String[] getApplicationRequest() {
		String[] input = getMethodInput();
		int inputLength = input.length;
		String[] ApplicationRequest = new String[inputLength+1];
		ApplicationRequest[0] = getMethodName();
		
		for (int i=0; i<inputLength; i++) {
			ApplicationRequest[i+1] = input[i];
		}
		return ApplicationRequest;
	}


	protected abstract String[] getMethodInput();
	protected abstract void setInput(String input);
	protected abstract String getMethodName();
	
	
	public abstract List<String> getInputSpecification();
	
	
	public boolean validateInput(String input) {
		boolean isInt = isInt();
	
		if (isInt) {
			int i;
			try {
			i = Integer.parseInt(input);
			} catch (NumberFormatException e) {
			return false;
			}

			if (hasOptions())
					if (i<1 || i> getOptions().size())
						return false;
		}
		
		return true;
	}
	
	protected abstract boolean isInt();
	
	
	public abstract Menu getNextState(Object[] result) throws Exception;
	public abstract Menu rewindState();
	
	public abstract boolean needsExecution();
}
