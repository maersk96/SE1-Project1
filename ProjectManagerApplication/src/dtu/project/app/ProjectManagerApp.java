package dtu.project.app;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This class represents the business logic associated with the library application.
 * @author Hubert
 *
 */
public class ProjectManagerApp {

	private boolean loggedIn = false;

	/**
	 * @return true if the administrator is logged in, false otherwise.
	 */
	public boolean adminLoggedIn() {
		return loggedIn;
	}

	/**
	 * Logs in the administrator provided that the correct password is supplied.
	 * @param password
	 * @return true if the administrator could be logged in, false otherwise.
	 */
	public boolean adminLogin(String password) {
		loggedIn = password.equals("adminadmin");
		return loggedIn;
	}


	/**
	 * Logs out the administrator.
	 */
	public void adminLogout() {
		loggedIn = false;
	}
	

	public void assignProjectLeader(Project p, Employee e) {
		//p.SetLeader(e);
	}
	
}
