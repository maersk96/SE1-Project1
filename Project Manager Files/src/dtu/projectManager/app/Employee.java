package dtu.projectManager.app;


import java.util.ArrayList;
import java.util.List;

// Employee class: stores information about the employee, and handles most of the functionality revolving around employees

// Work distribution:
// Mainly Jonas, Mikkel and Lukas have contributed to this class and its methods. It would be incorrect to put individual names on any method, as they have all been developed, or reviewed and edited by everyone, also Anton

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

        // Pre-conditions:
        assert weekFrom >= 0 && weekTo >= 0 /* &&  weekTo >= weekFrom */;

        List<Activity> activities = new ArrayList<Activity>();
        for (Activity a : assignedActivities) {                               // 1
            if (weekTo >= a.getStartWeek() && weekFrom <= a.getEndWeek()) {   // 2
                activities.add(a);
            }
        }

        // Post-conditions:
        for (Activity a : activities) {
            assert a.getStartWeek() <= weekTo && a.getEndWeek() >= weekFrom;
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
        return p.getProjectLeader().getInitials().equals(this.initials);
    }

    public boolean isAvailableInWeek(int week) {
        return getActivitiesInWeek(week).size() < ACTIVE_ACTIVITIES_LIMIT;
    }

}
