package dtu.projectManager.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Activity {
	private String ID = "";
	private String name;
	private int startWeek;
	private int endWeek;
	private List<Employee> assignedEmployees = new ArrayList<>();

	public Activity(String name, int startWeek, int weeks) {
		this.setStartWeek(startWeek);
		this.setDuration(weeks);
		this.name = name;
	}


	public void addAssignedEmployee(Employee e) throws OperationNotAllowedException {
		if (containsEmployeeWithInitials(e.getInitials())) {
			throw new OperationNotAllowedException("Employee is already assigned this activity");
		}
		assignedEmployees.add(e);
	}

	public boolean containsEmployeeWithInitials(String initials) {
		return assignedEmployees.stream().anyMatch(m -> m.getInitials().contentEquals(initials));
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Employee> getAssignedEmployees() {
		return assignedEmployees;
	}

	public int adjustWeek(int week) {
		if (week < 1) return 1;
		if (week > 52) return week - 52;
		return week;
	}
	public void setStartWeek(int startWeek) { this.startWeek = adjustWeek(startWeek); }
	public void setEndWeek(int endWeek) {
		this.endWeek = adjustWeek(endWeek);
	}
	public void setDuration(int weeks) { setEndWeek(this.startWeek + weeks - 1); }

	public int getEndWeek() {
		return this.endWeek;
	}
	public int getStartWeek() {
		return this.startWeek;
	}
}
