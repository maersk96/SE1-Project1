package presentation;

import java.util.ArrayList;
import java.util.List;
	
public class MenuInfo {
		
	private List<Option> options;
	private String user_name;
		
		public MenuInfo(List<Option> Options, String user_name) {
			this.options = new ArrayList<Option>();
			for (Option o : Options)
			{
				this.options.add(o.Copy());
			}
			this.user_name = user_name;
		}
		
		public void SetOptions(List<Option> Options){
			this.options.clear();
			for (Option o : Options)
			{
				this.options.add(o.Copy());
			}
		}

		public List<Option> GetOptions(){
			List<Option> Options = new ArrayList<Option>();
			for (Option o : this.options)
			{
				Options.add(o.Copy());
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


