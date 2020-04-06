package presentation;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {


	
	
	public void main() {
			
		ProjectManagerApp P = new ProjectManagerApp();
		Login(P);
		
		while (true)
		{
			MenuInfo menu = P.GetMenuInfo();
			PrintMenu(menu);
			Object[] Action = GetUserAction(menu);
			
			PrintQuery(Q);
		}
		}
		
		
	public Object[] GetUserAction(MenuInfo menu) {
		
		int action;
		int nOptions = menu.GetOptions().size();
		Scanner sc = new Scanner(System.in);
 		action = sc.nextInt();  
 		if (action> 0 && action < nOptions)
 			System.out.println("You entered \""+menu.GetOptions().get(action-1).GetName()+"\"");
 			
 		else
 			System.out.println("Please enter a number between "+ (nOptions>0 ? 1 : 0) + " and "+nOptions);
 			
	}
		
	public void PrintMenu(MenuInfo Menu) {
		
			List<Option> Options = Menu.GetOptions();
			
			List<String> Menutext = new ArrayList<String>();
			
			Menutext.add("Welcome "+Menu.GetUserName()+".");
			Menutext.add("");
			
			Menutext.add("These are your options:");
			
			int i=1;
			for (Option o : Options)
			{
				Menutext.add(i+". "+o.GetName());
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
