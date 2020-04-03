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
	public boolean isAdmin() {
		// currentUser.initials...
		return currentUser.equals("ADMIN");
	}

	public boolean adminLoggedIn() {
		return false;
	}
}
