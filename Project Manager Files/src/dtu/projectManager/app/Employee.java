package dtu.projectManager.app;


import java.util.ArrayList;
import java.util.List;

import dtu.projectManager.dto.EmployeeInfo;

public class Employee {

    private int ACTIVE_ACTIVITIES_LIMIT = 20;
    private String initials;
    private String name;
    private List<Activity> assignedActivities = new ArrayList<>();

    public Employee(String initials, String name) {
        this.initials = initials;
        this.name = name.equals("") ? "Anonymous" : name;
    }

    public void addAssignedActivity(Activity a) throws OperationNotAllowedException {

        if (containsActivityWithID(a.getID())) {
            throw new OperationNotAllowedException("Activity already has this employee assigned");
        }

        assignedActivities.add(a);
    }

    public boolean containsActivityWithID(String activityID) {
        return assignedActivities.stream().anyMatch(m -> m.getID().contentEquals(activityID));
    }


    public String getInitials() {
        return initials;
    }
    public boolean hasInitials(String initials) {
        return this.initials.equals(initials);
    }
    public String getName() { return name; }

    public List<Activity> getAssignedActivities() {
        return assignedActivities;
    }
    
	public Activity getActivityWithID(String activityID) {
        return assignedActivities.stream()
                .filter(activity -> activityID.equals(activity.getID()))
                .findFirst()
                .orElse(null);
    }

    public List<Activity> getActivitiesInWeekInterval(int weekFrom, int weekTo) {
        List<Activity> activities = new ArrayList<Activity>();
        for (Activity a : assignedActivities) {
            if (weekTo >= a.getStartWeek() && weekFrom <= a.getEndWeek()) {
                activities.add(a);
            }
        }
        return activities;
    }
    public List<Activity> getActivitiesInWeek(int week) {
        return getActivitiesInWeekInterval(week, week);
    }

    public boolean isAvailableInWeekInterval(int startWeek, int endWeek) {
        return getActivitiesInWeekInterval(startWeek, endWeek).size() < ACTIVE_ACTIVITIES_LIMIT;
    }

    public boolean isAvailableForActivity(Activity activity) {
        return isAvailableInWeekInterval(activity.getStartWeek(), activity.getEndWeek());
    }

    public boolean isProjectLeader(Project p) {
    	if (p == null || !p.hasProjectLeader())
    		return false;
    	else
    		return p.getProjectLeader().getInitials().equals(this.initials);
    }

    public boolean isAvailableInWeek(int week) {
        return getActivitiesInWeek(week).size() < ACTIVE_ACTIVITIES_LIMIT;
    }

    public EmployeeInfo asEmployeeInfo() {
    	EmployeeInfo employee = new EmployeeInfo(this.initials);
    	employee.setName(this.name);
    	return employee;
    }
}
