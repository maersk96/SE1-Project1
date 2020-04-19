package dtu.projectManager.app;

import java.util.ArrayList;
import java.util.List;

public class Project {

    private String ID;
    private String name;
    private Employee projectleader;
    private List<Activity> activities = new ArrayList<>();

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

	public List<Activity> getActivities() {
		return activities;
	}

	public Activity getActivityWithID(String activityID) {
        return activities.stream()
                .filter(activity -> activityID.equals(activity.getID()))
                .findFirst()
                .orElse(null);
    }

	public void setActivities(List<Activity> activities) {
		this.activities = activities;
	}

}
