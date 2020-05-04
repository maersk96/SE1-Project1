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
            addMockEmployee(generateName());
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
        
        
        
        // For testing purposes
        Employee e = new Employee("AAA", "Anton Stockmarr");
        projectManagerApp.addEmployee(e);
        projectManagerApp.assignEmployeeProjectLeader(mockProjects.get(0),e.getInitials());
        projectManagerApp.assignEmployeeToActivity(mockActivities.get(0).pId, e.getInitials(), mockActivities.get(0).aId);
        
        
    }

    private void addMockEmployee(String name) throws OperationNotAllowedException {
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
    private void addMockProject(String name) throws OperationNotAllowedException {
        Project p = new Project(name);
        String pId = projectManagerApp.addProject(p);
        String randomEmployee = mockEmployees.get(rand(0, mockEmployees.size()-1));
        projectManagerApp.assignEmployeeProjectLeader(pId, randomEmployee);
        mockProjects.add(pId);
    }
    private void addMockActivity(String pId, String name) throws OperationNotAllowedException {
        Activity a = new Activity(name, rand(1,52), rand(1,6));
        String aId = projectManagerApp.addActivityToProject(pId, a);
//        double hours = randDouble(0.0f,100.0f);
//        projectManagerApp.budgetHours(aId, pId, hours);
        mockActivities.add(new ProjectActivity(pId, aId));
    }

    // Get random number between bounds (inclusive)
    private int rand(int min, int max) {
        Random r = new Random();
        return r.nextInt(max - min + 1) + min;
    }

    private double randDouble(double min, double max) {
        Random r = new Random();
        return min +r.nextDouble()*max;
    }
    private String generateName() {
    	String[] data = new String[] {
    		 "Arsenio Morrison" ,
    		 "Tiger Bauer" ,
    		 "Keefe Bryan" ,
    		 "Tyrone Moss" ,
    		 "Griffith Reed" ,
    		 "Lane Kaufman" ,
    		 "Harlan Joyce" ,
    		 "Arthur Bond" ,
    		 "Kamal Bowers" ,
    		 "Elliott Harrington" ,
    		 "Bernard Kerr" ,
    		 "Reece Gates" ,
    		 "Emery Pennington" ,
    		 "Colby Bailey" ,
    		 "Rashad Collins" ,
    		 "Prescott Flynn" ,
    		 "Benedict Santos" ,
    		 "Harlan Bean" ,
    		 "Magee Whitehead" ,
    		 "Fletcher Whitney" ,
    		 "Jin Mckenzie" ,
    		 "Tad Salazar" ,
    		 "Axel Daniels" ,
    		 "Alvin Ellis" ,
    		 "Amir Rojas" ,
    		 "Kennedy Booker" ,
    		 "Plato Beard" ,
    		 "Kenneth Daniel" ,
    		 "Joshua Dean" ,
    		 "Lewis Golden" ,
    		 "Ishmael Townsend" ,
    		 "Keegan Buchanan" ,
    		 "Rahim Patterson" ,
    		 "Victor Sanchez" ,
    		 "Zachary Maddox" ,
    		 "Raymond Green" ,
    		 "Kane Hyde" ,
    		 "Keith Winters" ,
    		 "Sean Mcdowell" ,
    		 "Brett Stone" ,
    		 "Kyle Salinas" ,
    		 "Vincent Bond" ,
    		 "Ross Walsh" ,
    		 "Raphael Vance" ,
    		 "Adam Prince" ,
    		 "Henry Riddle" ,
    		 "Sawyer Morse" ,
    		 "Cooper Hamilton" ,
    		 "Kasimir Justice" ,
    		 "Cade Conway" ,
    		 "Nathaniel Whitfield" ,
    		 "Abbot Farley" ,
    		 "Preston Church" ,
    		 "Curran Ruiz" ,
    		 "Kato Mullins" ,
    		 "Clarke Klein" ,
    		 "Alec Battle" ,
    		 "Jonas Myers" ,
    		 "Ferris Randolph" ,
    		 "Dominic Daniel" ,
    		 "George Newton" ,
    		 "Cullen Salas" ,
    		 "Tyrone Allison" ,
    		 "Wallace Winters" ,
    		 "Ian Morrison" ,
    		 "Felix Sloan" ,
    		 "Hunter Fischer" ,
    		 "Nasim Burns" ,
    		 "Edan Preston" ,
    		 "Arden Powers" ,
    		 "Duncan Pennington" ,
    		 "Samuel Stanley" ,
    		 "Troy Delacruz" ,
    		 "Leonard Huff" ,
    		 "Chaim Keller" ,
    		 "Ali Pace" ,
    		 "Philip Calhoun" ,
    		 "Honorato Ayala" ,
    		 "Oleg Nieves" ,
    		 "Uriah Richard" ,
    		 "Lee Moran" ,
    		 "Ralph Mckenzie" ,
    		 "August Wallace" ,
    		 "Asher Griffith" ,
    		 "Chadwick Allen" ,
    		 "Baxter West" ,
    		 "Coby Swanson" ,
    		 "Drake Dalton" ,
    		 "Rajah Hernandez" ,
    		 "Ryder Cline" ,
    		 "Mason Tran" ,
    		 "Wing Martinez" ,
    		 "Brian Barlow" ,
    		 "Caldwell Heath" ,
    		 "Rogan Sargent" ,
    		 "Vance Sykes" ,
    		 "Edan Woodward" ,
    		 "Wayne Garza" ,
    		 "Ferris Hart" ,
    		 "Carlos Meyer"};
    	
    	int i= rand(0,data.length-1);
    	return data[i];
    	};
}
