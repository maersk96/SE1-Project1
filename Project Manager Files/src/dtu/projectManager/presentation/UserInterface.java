package dtu.projectManager.presentation;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dtu.projectManager.app.OperationNotAllowedException;
import dtu.projectManager.app.ProjectManagerApp;

//import dtu.projectManager.app.OperationNotAllowedException;

public class UserInterface {

	private Scanner sc;
	ProjectManagerApp p;
	
	public UserInterface(Scanner sc) {
		this.sc = sc;
		this.p = new ProjectManagerApp();

	}
	
	public void test(MenuInfo menu) throws Exception {

		try {
			this.p.login("ADMIN");
		} catch(OperationNotAllowedException e) {
			e.printStackTrace();
		}

		while (true)
		{
			
//			MenuInfo menu = P.GetMenuInfo();
			PrintMenu(menu);

			Action a = new Action(GetUserAction(menu));
			PrintTextBox(a.GetInfo());

			Object[] v = GetUserArguments(a);		
			a.SetArg(v);
			
			ExecuteAction(a);
			
			PrintTextBox(a.GetFeedback());

			this.sc.nextLine();

		}
			
	}
		
		
	public String GetUserAction(MenuInfo menu) {
		
		String line;
		int n;
		int nOptions = menu.GetOptions().size();
 		while (true)
 		{
 	 		line = this.sc.nextLine();
 	 		try {
 	 			n = Integer.parseInt(line.trim());
 	 	 		if (n > 0 && n < nOptions)
 		 		{
 		 			String action = menu.GetOptions().get(n-1);
 		 			return action;
 		 		}
 		 		else
 		 			System.out.println("Please enter a number between "+ (nOptions>0 ? 1 : 0) + " and "+nOptions); 	 		
 	 		}
 	 		catch (NumberFormatException nfe)
 	 	    {
 	 			System.out.println("Please enter a number between "+ (nOptions>0 ? 1 : 0) + " and "+nOptions); 	 	    }
 		}
 		
	}
	
	public Object[] GetUserArguments(Action a) {
		
		Object[] v = new Object[a.GetArgLength()];
		while(true) {
			String inputLine = this.sc.nextLine();
			String[] arg = inputLine.split(" ");
			if (arg.length == v.length) {
				for (int i=0; i<v.length; i++) {
					if (a.GetArgIsInt()[i]==true) {
						try {
							v[i]=Integer.parseInt(arg[i]);
						} catch (NumberFormatException nfe) {
			 	 			System.out.println("Input "+(i+1)+" has to be a number");
			 			}
					}
					else
					{
						v[i]=arg[i];						
					}
				}
				return v;
			}
			else
				System.out.println("Please enter "+v.length+" different arguments, seperated by space");
		}
	}
	
		
	
	public void ExecuteAction(Action a) throws Exception {
		
		try {
			switch(a.GetOption()) {
			case "Make project":
				this.p.addProject();
				break;
			case "Assign project leader to a project":
				this.p.assignEmployeeProjectLeader(a.GetArg()[0].toString(), a.GetArg()[1].toString());
				break;
			case "Register hours to an activity":  //this.p.registerHours(a.GetArg()[0],a.GetArg()[1]);
				break;
				
				
			default: throw new Exception("Action "+a.GetOption()+" not recognized");
			}
			
			a.AddSuccessFeedback();
		} catch (OperationNotAllowedException e) {
			a.AddErrorFeedback(e);
		}
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
			
			PrintTextBox(Menutext);
		}
		
		
		public void PrintQuery() {
			
		}
		
		
		
		private void PrintTextBox(List<String> S) {
			
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
