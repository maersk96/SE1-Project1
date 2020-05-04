package dtu.projectManager.presentation.menus;

import java.util.ArrayList;
import java.util.List;

import dtu.projectManager.dto.ActivityInfo;
import dtu.projectManager.dto.EmployeeInfo;
import dtu.projectManager.dto.ProjectInfo;
import dtu.projectManager.presentation.Menu;

public class ProjectProgressMenu extends Menu {

	private EmployeeInfo user;
	private ProjectInfo project;
	private ActivityInfo[] activities;
	
	public ProjectProgressMenu(EmployeeInfo user, ProjectInfo project, ActivityInfo[] activities) {
		this.user = user;
		this.project = project;
		this.activities = activities;
	}

	@Override
	protected List<String> getStartText() {
		List<String> startText = new ArrayList<String>();
		
		startText.add("Status of");
		startText.add(this.project.getID()+": "+this.project.getName());
		startText.add("");
		startText.add("");
		
		List<String> Progress = visualizeActivityProgress();
		for (String s : Progress) {
			startText.add(s);
		}
		startText.add("");
		startText.add("Press enter to go back");
		
		return startText;
	}
	
	
	private List<String> visualizeActivityProgress(){
		String activityLine;
		int lines = this.activities.length;
		String[] activityNames = new String[lines];

		for (int i=0; i<lines; i++) {
			activityLine = this.activities[i].getID()+": "+this.activities[i].getName();
			activityNames[i]=activityLine;
		}
		
		int[] lineLengths = new int[lines];
		int maxLineLength = 0;
		for (int i=0; i< lines; i++)
		{
			lineLengths[i] = activityNames[i].length();
			if (lineLengths[i]>maxLineLength)
				maxLineLength = lineLengths[i];
 		}
		
		List<String> activityProgress = new ArrayList<String>();

		double bHours, tHours;
		double bHoursSum=0;
		double tHoursSum=0;
		for (int i =0; i<lines; i++) {
			activityLine = addSpaces(activityNames[i],maxLineLength);
			bHours = this.activities[i].getBudgetHours();
			tHours = this.activities[i].getTotalHours();
			bHoursSum += bHours;
			tHoursSum += tHours;
			activityLine = addProgress(activityLine, bHours,tHours);
			activityProgress.add(activityLine);
		}
		activityProgress.add("");
		activityLine = "Total progress:";
		activityLine = addSpaces(activityLine,maxLineLength);
		activityLine = addProgress(activityLine,bHoursSum,tHoursSum);
	
		activityProgress.add(activityLine);
		return activityProgress;
		
	}
	
	private String addSpaces(String line, int targetLength) {
		int length = line.length();
		for (int i=length; i<targetLength; i++) {
			line+= " ";
		}
		return line;
	}
	
	private String addProgress(String line, double bHours, double tHours) {
		line += "|";
		int maxProgress=10;
		int currentProgress = (int)(bHours/tHours*(double)maxProgress);
		for (int i=0; i<maxProgress; i++) {
			if (i<= currentProgress) {
				line += "-";
			}
			else {
				line += " ";				
			}
		}
		line+= "| "+tHours+"/"+bHours+" hours";
		if (tHours>bHours+0.01) {
			line += " *Budget Exceeded!";
		}
		return line;
	}
	
	
	@Override
	protected List<String> getOptions() {
		return null;
	}

	@Override
	protected List<String> getEndText() {
		return null;
	}

	@Override
	protected boolean hasOptions() {
		return false;
	}

	@Override
	protected Object[] getMethodInput() {
		return null;
	}

	@Override
	protected void setInput(String choice) {
	}

	@Override
	protected String getMethodName() {
		return null;
	}

	@Override
	public List<String> getInputSpecification() {
		List<String> inputSpecification = new ArrayList<String>();
		inputSpecification.add("You somehow managed to not click enter");
		return inputSpecification;
	}

	@Override
	protected boolean isInt() {
		return true;
	}

	@Override
	public Menu getNextState(Object[] result) throws Exception {
			return rewindState();			
	}
	
	@Override
	public Menu rewindState() {
		return new ProjectLeaderMenu(this.user,this.project);
	}

	@Override
	public boolean needsExecution() {
		return false;
	}

}
