package dtu.projectManager.dto;

import dtu.projectManager.app.Project;

public class ProjectInfo {

	
    private String ID;
    private String name;
    private EmployeeInfo projectLeader;

    public ProjectInfo (String name) {
    	this.name = name;
    }
    
    public String getID() {
        return ID;
    }

    public void setID(String id) {
        this.ID=id;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	public EmployeeInfo getProjectLeader() {
		return projectLeader;
	}

	public void setProjectLeader(EmployeeInfo projectLeader) {
		this.projectLeader = projectLeader;
	}
	
	public ProjectInfo copy() {
		ProjectInfo copy = new ProjectInfo(this.name);
		copy.setID(this.ID);
		copy.setProjectLeader(this.projectLeader);
		return copy;
	}
	
	public Project asProject() {
		return new Project(this.name);
	}

}
