package dtu.projectManager.dto;

import dtu.projectManager.app.Employee;

public class EmployeeInfo {
	private String initials;
	private String name;
	
	public EmployeeInfo(String initials) {
		this.initials = initials;
		this.name = "";
	}
	
	public EmployeeInfo (Employee employee) {
		this.initials = employee.getInitials();
		this.name = employee.getName();
	}
	
    public String getInitials() {
        return this.initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }
    
    public String getName() {
    	return this.name;
    }
    
    public void setName(String name) {
    	this.name = name;
    }
    
    public EmployeeInfo copy() {
    	EmployeeInfo copy = new EmployeeInfo(this.initials);
    	copy.setInitials(this.initials);
    	copy.setName(this.name);
    	return copy;
    }
    
    public Employee asEmployee() {
    	return new Employee(this.initials,this.name);
    }


}

