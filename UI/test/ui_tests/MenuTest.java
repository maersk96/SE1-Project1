package ui_tests;

import user_interface.UserInterface;

import java.util.ArrayList;
import java.util.List;

import user_interface.MenuInfo;

public class MenuTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserInterface UI = new UserInterface();
		
		List<String> Options = new ArrayList<String>();
		Options.add("Arbejde videre");
		Options.add("Spille LoL");
		Options.add("Lave mad");
		Options.add("Se film");
		
		
		MenuInfo M = new MenuInfo(Options,"Anton");
		UI.PrintMenu(M);
	}

}
