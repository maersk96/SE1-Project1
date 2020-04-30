package dtu.projectManager.dtu;

import dtu.projectManager.app.Employee;

public class EmployeeInfo {
	private String initials;
	
	
	public EmployeeInfo(String initials) {
		this.initials = initials;
	}
	
    public String getInitials() {
        return this.initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }
    
    
    public Employee asEmployee() {
    	return new Employee(this.initials);
    }


}

