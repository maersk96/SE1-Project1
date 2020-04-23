package dtu.projectManager.app;

import java.util.ArrayList;
import java.util.List;

public class Project {

    private String ID;
    private String name;
    private Employee projectLeader;
    private List<Activity> activities = new ArrayList<>();
    private int activityNumber = 0;

    public Project(String name) {
        this.ID = "";
        this.name = name.equals("") ? "Untitled Project" : name;
        setProjectLeader(null);
    }

    public String generateActivityID() {
        return ID + "_" + String.format("%0" + 4 + "d", activityNumber);
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
        if (projectLeader != null) {
            return employee.getInitials().equals(projectLeader.getInitials());
        }
        return false;
    }

	public void setProjectLeader(Employee projectLeader) {
		this.projectLeader = projectLeader;
	}

	public List<Activity> getActivities() {
		return activities;
	}

	public String addActivity(Activity activity) {
        String activityId = generateActivityID();
        activity.setID(activityId);
        activities.add(activity);
        activityNumber++;
        return activityId;
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
