package dtu.projectManager.app;

public class Project {

    private String ID;
    private String name;
    private Employee projectleader;

    public Project(String ID, String name) {
        this.ID = ID;
        this.name = name;
        setProjectleader(null);
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

	public Employee getProjectleader() {
		return projectleader;
	}

	public void setProjectleader(Employee projectleader) {
		this.projectleader = projectleader;
	}

}
