package dtu.projectManager.app;

public class Project {

    private String ID;
    private String name;

    public Project(String ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

}
