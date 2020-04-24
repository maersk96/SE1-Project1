package dtu.projectManager.app;

import io.cucumber.java.en_old.Ac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Employee {

    private int ACTIVE_ACTIVITIES_LIMIT = 20;
    private String initials;
    private List<Activity> assignedActivities = new ArrayList<>();

    public void addAssignedActivity(Activity a) throws OperationNotAllowedException {

        if (containsActivityWithID(a.getID())) {
            throw new OperationNotAllowedException("Activity already has this employee assigned");
        }

        assignedActivities.add(a);
    }

    public boolean containsActivityWithID(String activityID) {
        return assignedActivities.stream().anyMatch(m -> m.getID().contentEquals(activityID));
    }

    public Employee(String initials) {
        this.initials = initials;
    }

    public String getInitials() {
        return initials;
    }

    public List<Activity> getAssignedActivities() {
        return assignedActivities;
    }

    public boolean isAvailable() {
        return assignedActivities.size() < 20;
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

    public boolean canBeAssignedToActivity(Activity activity) {
        return getActivitiesInWeekInterval(activity.getStartWeek(), activity.getEndWeek()).size() < ACTIVE_ACTIVITIES_LIMIT;
    }

    public boolean isAvailableInWeek(int week) {
        return getActivitiesInWeek(week).size() < ACTIVE_ACTIVITIES_LIMIT;
    }

}
