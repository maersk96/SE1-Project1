package dtu.projectManager.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;



public class MockData {

    // Helper class to store an activity ID with its project ID
    static class ProjectActivity {
        String pId;
        String aId;
        public ProjectActivity(String pId, String aId) {
            this.pId = pId;
            this.aId = aId;
        }
    }

    ProjectManagerApp projectManagerApp;

    // List of generated mock ID's
    List<String> mockEmployees = new ArrayList<String>();
    List<String> mockProjects = new ArrayList<String>();
    List<ProjectActivity> mockActivities = new ArrayList<ProjectActivity>();

    public MockData(ProjectManagerApp projectManagerApp) {
        this.projectManagerApp = projectManagerApp;
    }

    public void generate(int amount) throws OperationNotAllowedException {
        // Add some mock employees
        for (int i=0; i <= amount; i++) {
            addMockEmployee("Anonymous");
        }
        // Add some mock projects
        for (int i=0; i <= amount * 3 / 5; i++) {
            addMockProject("Sample project " + i);
        }
        // Add some activities to projects
        for (int i=0; i < mockProjects.size(); i++) {
            String pId = mockProjects.get(i);
            // Add between 10 and 90 activities
            int activities = rand(10,90);
            for (int j=0; j <= activities; j++) {
                addMockActivity(pId, "Sample activity " + j);
            }
        }
        // Assign employees to activities
        for (int i=0; i < mockActivities.size(); i++) {
            ProjectActivity pa = mockActivities.get(i);
            String randomEmployee = mockEmployees.get(rand(0, mockEmployees.size()-1));
            projectManagerApp.assignEmployeeToActivity(pa.pId, randomEmployee, pa.aId);
        }
    }

    public void addMockEmployee(String name) throws OperationNotAllowedException {
        String initials = "";
        for (int j=0; j < 3; j++) {
            initials += (char)('A' + rand(0,25));
        }
        if (!mockEmployees.contains(initials)) {
            Employee e = new Employee(initials, name);
            projectManagerApp.addEmployee(e);
            mockEmployees.add(initials);
        }
    }
    public void addMockProject(String name) throws OperationNotAllowedException {
        Project p = new Project(name);
        String pId = projectManagerApp.addProject(p);
        mockProjects.add(pId);
    }
    public void addMockActivity(String pId, String name) throws OperationNotAllowedException {
        Activity a = new Activity(name, rand(1,52), rand(1,6));
        String aId = projectManagerApp.addActivityToProject(pId, a);
        mockActivities.add(new ProjectActivity(pId, aId));
    }

    // Get random number between bounds (inclusive)
    public int rand(int min, int max) {
        Random r = new Random();
        return r.nextInt(max - min + 1) + min;
    }
}
