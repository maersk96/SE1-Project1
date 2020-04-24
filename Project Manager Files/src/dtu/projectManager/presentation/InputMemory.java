package dtu.projectManager.presentation;

import java.util.ArrayList;
import java.util.List;

public class InputMemory {

	
	private int length;
	private List<String> arguments;
	private List<Boolean> isInt;
	
	public InputMemory() {
		this.length = 0;
		this.arguments = new ArrayList<String>();
		this.isInt = new ArrayList<Boolean>();
	}
	
	public int GetLength() {
		return this.length;
	}

	public void AddArgument(String input) {
		this.arguments.add(input);
		this.length += 1;
	}
	
	public void Rewind() {
		this.arguments.remove(this.length-1);
		this.length -= 1;
	}

	public List<String> GetArguments() {
		List<String> arg = new ArrayList<String>();
	
		for (String s : this.arguments) {
			arg.add(s);
		}
		return arg;
	}


	public List<Boolean> GetIsInt() {
		List<Boolean> bool = new ArrayList<Boolean>();
		for (Boolean b : this.isInt) {
			bool.add(b);
		}
		return bool;
	}

}
