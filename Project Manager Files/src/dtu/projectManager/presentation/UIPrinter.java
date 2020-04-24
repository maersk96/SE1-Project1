package dtu.projectManager.presentation;

import java.util.List;

public class UIPrinter {

	
	public UIPrinter() {
		
	}
	
	public void Print(List<String> Text) {
		PrintTextBox(Text);
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