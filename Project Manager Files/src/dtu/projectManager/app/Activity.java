package dtu.projectManager.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Activity {
	private String ID;
	private String name;
	private List<Employee> assignedEmployees = new ArrayList<>();

	public Activity(String ID, String name) {
        this.setID(ID);
        this.setName(name);
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

}
