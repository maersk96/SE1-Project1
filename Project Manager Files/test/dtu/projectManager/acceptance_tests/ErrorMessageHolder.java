package dtu.projectManager.acceptance_tests;

public class ErrorMessageHolder {
	private String errorMessage = "";

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
		System.out.println("Caught error: " + errorMessage);
	}
}
