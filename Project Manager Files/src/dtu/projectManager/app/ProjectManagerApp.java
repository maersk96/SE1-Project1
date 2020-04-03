package dtu.projectManager.app;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProjectManagerApp {
	Employee currentUser = null;

	public void login(Employee e) {
		currentUser = e;
	}
	public void logout() {
		currentUser = null;
	}
	public boolean adminLoggedIn() {
		return currentUser.getInitials().equals("ADMIN");
	}
}
