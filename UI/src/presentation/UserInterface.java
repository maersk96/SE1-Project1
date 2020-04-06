package presentation;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {

	private Scanner sc;
	
	public UserInterface(Scanner sc) {
		this.sc = sc;
	}
	
	public void test(MenuInfo menu) {
			
//		ProjectManagerApp P = new ProjectManagerApp();
//		Login(P);
		
		while (true)
		{
//			MenuInfo menu = P.GetMenuInfo();
			PrintMenu(menu);
			String action = GetUserAction(menu);
			ExecuteAction(action);
			//PrintQuery(Q);
		}
			
		}
		
		
	public String GetUserAction(MenuInfo menu) {
		
		int n;
		int nOptions = menu.GetOptions().size();
 		while (true)
 		{
 	 		n = this.sc.nextInt();
 	 		this.sc.nextLine();
 			if (n > 0 && n < nOptions)
	 		{
	 			String action = menu.GetOptions().get(n-1);
	 			return action;
	 		}
	 		else
	 			System.out.println("Please enter a number between "+ (nOptions>0 ? 1 : 0) + " and "+nOptions);
 		}
 		
	}
	
	public void ExecuteAction(String action) {
		
		List<String> actionInfo = new ArrayList<String>();
		List<String> feedback = new ArrayList<String>();
		Boolean done = false;
		
		
		
		
		String inputLine;

		actionInfo.add("You have selected \""+action+"\"");
		actionInfo.add("");
		actionInfo.add("To do this, please enter the following information,");
		actionInfo.add("seperated by space:");
		actionInfo.add("");
			
		switch(action)
		{
		case "Register hours to an activity":
			actionInfo.add("Activity id");
			actionInfo.add("Number of hours");
			while (done == false)
			{
				PrintTextBox(actionInfo);
				inputLine = this.sc.nextLine();
				String[] arg = inputLine.split(" ");
				// Execute
				// p.RegisterHours(arg[0], Integer.parseInt(arg[1]));
				// Handle errors
				feedback.add(arg[1]+" hours have been registered for activity \""+arg[0]+"\"");
				feedback.add("Press enter to continue");
				PrintTextBox(feedback);
				feedback.clear();
				this.sc.nextLine();
				done = true;					
			}
			break;
		default:
			feedback.add("\""+action+"\" is not implemented yet.");
			feedback.add("Press enter to go back");
			PrintTextBox(feedback);
			feedback.clear();
			this.sc.nextLine();
			break;
		}
			
		return;		
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
