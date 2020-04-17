package dtu.projectManager.app;

public class Activity {
	private String ID;
	private String name;
	
	public Activity(String ID, String name) {
        this.setID(ID);
        this.setName(name);
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
}
