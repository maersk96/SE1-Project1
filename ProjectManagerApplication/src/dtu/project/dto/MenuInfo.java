package dtu.project.dto;

import java.util.ArrayList;
import java.util.List;

public class MenuInfo {
	
	private List<String> options;
	private String user_name;
	
	
	
	public MenuInfo(List<String> Options, String user_name) {
		this.options = new ArrayList<String>();
		for (String s : Options)
		{
			this.options.add(s);
		}
		this.user_name = user_name;
	}
	
	public void SetOptions(List<String> Options){
		this.options.clear();
		for (String s : Options)
		{
			this.options.add(s);
		}
	}

	public List<String> GetOptions(){
		List<String> Options = new ArrayList<String>();
		for (String s : this.options)
		{
			Options.add(s);
		}
		return Options;
	}
	
	public void SetUserName(String UserName) {
		this.user_name = UserName;
	}
	
	public String GetUserName() {
		return this.user_name;
	}
	
}
