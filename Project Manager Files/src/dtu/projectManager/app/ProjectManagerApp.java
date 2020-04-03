package dtu.projectManager.app;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProjectManagerApp {
	String currentUser = "";

	public void login(String initials) {
		currentUser = initials;
	}
	public void logout() {
		currentUser = "";
	}
	public boolean isAdmin() {
		return currentUser.equals("ADMIN");
	}

	public boolean adminLoggedIn() {
		return false;
	}
}
