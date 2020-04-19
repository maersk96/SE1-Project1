package dtu.projectManager.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Employee {

    private String initials;
    private List<Activity> assignedActivities = new ArrayList<>();

    public void addAssignedActivity(Activity a) throws OperationNotAllowedException {

        if (containsActivityWithID(a.getID())) {
            throw new OperationNotAllowedException("Activity already has this employee assigned");
        }

        assignedActivities.add(a);
    }

    public boolean containsActivityWithID(String ID) {
        return assignedActivities.stream().anyMatch(m -> m.getID().contentEquals(ID));
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

}
