package dtu.projectManager.app;

import java.util.ArrayList;
import java.util.List;

public class Project {

    private String ID;
    private String name;
    private Employee projectLeader;
    private List<Activity> activities = new ArrayList<>();

    public Project(String ID) {
        this.ID = ID;
        this.name = "Unnamed";
        setProjectLeader(null);
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

	public Employee getProjectLeader() {
		return projectLeader;
	}

	public boolean hasProjectLeader() {
        return projectLeader != null;
    }

	public boolean isProjectLeader(Employee employee) {
        return employee.getInitials().equals(projectLeader.getInitials());
    }

	public void setProjectLeader(Employee projectLeader) {
		this.projectLeader = projectLeader;
	}

	public List<Activity> getActivities() {
		return activities;
	}

	public void addActivity(Activity activity) {
        activities.add(activity);
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

    public boolean containsActivityWithID(String activityID) {
        return getActivityWithID(activityID) != null;
    }
}
