package dtu.projectManager.presentation;

import java.util.ArrayList;
import java.util.List;

import dtu.projectManager.app.OperationNotAllowedException;
import dtu.projectManager.app.ProjectManagerApp;

public class Action {

	private String option; 
	private List<String> info;
	private List<String> feedback;
	private Object[] arg;
	private boolean[] argIsInt;
	private int argLength;
	private boolean executed;
	
	public Action(String option)
	{
		this.option = option;
		this.info = new ArrayList<String>();
		this.feedback = new ArrayList<String>();
		this.executed = false;
		this.info.add("You have selected \""+this.option+"\"");
		this.info.add("");
		this.info.add("To do this, please enter the following information,");
		this.info.add("seperated by space:");
		this.info.add("");

		switch(this.option)
		{
		case "Make project":
			this.info.add("Project name");
			this.argLength = 1;
			this.argIsInt = new boolean[this.argLength];
			break;
		case "Assign project leader to a project":
			this.info.add("Initials of the employee to become project leader");
			this.info.add("Project id");
			this.argLength = 2;
			this.argIsInt = new boolean[this.argLength];
			break;
		case "Edit a project":
			this.info.add("Project id");
			this.argLength = 1;
			this.argIsInt = new boolean[this.argLength];
			break;
		case "See registered hours on your project":
			this.info.add("Project id");
			this.argLength = 1;
			this.argIsInt = new boolean[this.argLength];
			break;			
		case "Register hours to an activity":
			this.info.add("Activity id");
			this.info.add("Number of hours");
			this.argLength = 2;
			this.argIsInt = new boolean[this.argLength];
			this.argIsInt[1]=true;
			break;
		
			
		default:
			this.info.add("Not implemented yet");
		}
	}
	
	public void SetArg(Object[] arg) throws Exception{
		
		if (arg.length != this.argLength)
			throw new Exception("Input has wrong length");

		Object[] tmp = new Object[this.argLength];

		for (int i=0; i<this.argLength; i++)
		{
			if (!(arg[i] instanceof Integer || arg[i] instanceof String))
				throw new Exception("Input was neither string nor int");
			else if (!(arg[i] instanceof Integer) && this.argIsInt[i]==true) {
				throw new Exception("Input type was not int");
			}
			else if (arg[i] instanceof Integer && this.argIsInt[i]==false){
				throw new Exception("Input type was not supposed to be int");
			}
			else {
				tmp[i] = arg[i];
			}
		}
		
		this.arg = tmp;
		
	}
	
	public Object[] GetArg() {
		Object[] array = new Object[this.argLength];
		for (int i=0; i<this.argLength; i++) {
			array[i] = this.arg[i];
		}
		return array;
	}
	
	public String GetOption() {
		return this.option;
	}
	
	public List<String> GetInfo() {
		return this.info;
	}
	
	public List<String> GetFeedback() {
		return this.feedback;
	}
	
	public boolean[] GetArgIsInt() {
		boolean[] array = new boolean[this.argLength];
		for (int i=0; i<this.argLength; i++) {
			array[i] = this.argIsInt[i];
		}
		return array;
	}
	
	public int GetArgLength() {
		return this.argLength;
	}
	
	public boolean GetExecuted() {
		return this.executed;
	}

	public void SetExecuted(boolean b) {
		this.executed = b;
	}

	public void AddSuccessFeedback() throws Exception{
	
		if (this.executed = false)
			throw new Exception("Cannot add feedback because the action has not been executed yet");
		switch (this.option) {

		case "Make project":
			this.feedback.add("A project with name \""+arg[0]+"\" has been added"); break;
		case "Assign project leader to a project":
			this.feedback.add("Employee "+this.arg[1]+" has been added to project "+this.arg[0]); break;
		case "Register hours to an activity":
			this.feedback.add(this.arg[1]+" hours have been registered for activity \""+this.arg[0]+"\""); break;
			
		default:
			this.feedback.add("Action not recognized");
		}
		this.feedback.add("Press enter to continue");

	}
	
	public void AddErrorFeedback(OperationNotAllowedException e) throws Exception{
		if (this.executed = false)
			throw new Exception("Cannot add feedback because the action has not been executed yet");
		 this.feedback.add("An error occured: "+e.getMessage());
		 this.feedback.add("");
		 this.feedback.add("Press enter to got back to the menu");
	}

}
