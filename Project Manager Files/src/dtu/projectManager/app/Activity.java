package dtu.projectManager.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Activity class: stores information about the activity, and handles most of the functionality revolving around activities

public class Activity {

	private String ID = "";
	private String name;
	private int startWeek;
	private int endWeek;
	private HashMap<Employee, Double> employeesAndRegisteredHours = new HashMap<Employee, Double>();
	private double budgetHours = 0.0;

	public Activity(String name, int startWeek, int weeks) {
		this.setStartWeek(startWeek);
		this.setDuration(weeks);
		this.name = name;
	}

	public void addAssignedEmployee(Employee e) throws OperationNotAllowedException {
		employeesAndRegisteredHours.put(e,0.0);
	}
	
	public boolean containsEmployeeWithInitials(String initials) {
		return getAssignedEmployees().stream().anyMatch(m -> m.getInitials().contentEquals(initials));
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
		List<Employee> employeeList = new ArrayList<>(employeesAndRegisteredHours.keySet());
		return employeeList;
	}

	public int adjustWeek(int week) {
		if (week < 1) return 1;
		return ((week - 1) % 52) + 1;
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

	public double getBudgetHours() {
		return budgetHours;
	}

	public void setBudgetHours(double bHours) {
		this.budgetHours = bHours;
	}

	public void registerHours(Employee e, double hours) throws OperationNotAllowedException {
		double newHours = employeesAndRegisteredHours.get(e) + hours;
		employeesAndRegisteredHours.replace(e, newHours);
	}

	public double getEmployeesRegisteredHours(Employee e) {
		if (employeesAndRegisteredHours.get(e) != null) {
			return employeesAndRegisteredHours.get(e);
		}
		return 0.0;
	}

	public double getTotalRegisteredHours() {
		double sum = 0;
		for (double hours : employeesAndRegisteredHours.values()) {
			sum += hours;
		}
		return sum;
	}
	
}
