package hotel.beans;

import java.util.HashMap;

public class IDandPassword {
	
	HashMap<String,String> logininfo = new HashMap<String,String>();
	
	public IDandPassword() {
		logininfo.put("Alaoui", "Mohamed");
		logininfo.put("Touinsi", "Nouhaila");
		logininfo.put("Bounakhla", "Nada");
		logininfo.put("Cherraka", "Achraf");
		logininfo.put("admin", "admin");
		logininfo.put("a", "a");
	}
	
	protected HashMap getLoginInfo(){
		return logininfo;
	}
}
