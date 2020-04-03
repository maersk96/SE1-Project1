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




package dtu.project.presentation;
import dtu.project.dto.MenuInfo;

import java.util.ArrayList;
import java.util.List;

public class UserInterface {



	public UserInterface() {
		
	}
	
	
	
	public void PrintMenu(MenuInfo Menu) {
		
		List<String> Options = Menu.GetOptions();
		
		List<String> Menutext = new ArrayList<String>();
		
		Menutext.add("Welcome "+Menu.GetUserName()+".");
		Menutext.add("");
		
		Menutext.add("These are your options:");
		
		int i=1;
		for (String s : Options)
		{
			Menutext.add(i+". "+s);
			i++;
		}
		
		Menutext.add("");
		Menutext.add("Press a number to proceed.");
		
		PrintMenuBox(Menutext);
	}
	
	
	public void PrintQuery() {
		
	}
	
	
	
	private void PrintMenuBox(List<String> S) {
		
		int lines = S.size();
		if (lines<1)
			return;
		
		int i,j;
		int l[] = new int[lines];
		int l_max=0;
		for (i=0; i< lines; i++)
		{
			l[i] = S.get(i).length();
			if (l[i]>l_max)
				l_max = l[i];
 		}
		
		PrintBoxLine(l_max);
		
		for (i=0; i<lines; i++)
		{
			System.out.print("| "+S.get(i));
			for (j=0; j< (l_max-l[i]); j++)
				System.out.print(" ");
			System.out.print(" |\n");
		}
		
		PrintBoxLine(l_max);
				

	}

	private void PrintBoxLine(int length) {
		System.out.print("+");
		int i;
		for (i=0; i<length+2; i++)
			System.out.print("-");
		System.out.print("+\n");		
	}
}
