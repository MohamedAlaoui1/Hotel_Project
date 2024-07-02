package hotel.beans;

import hotel_style.LoginForm;

public class Main {

	public static void main(String[] args) {
		
		IDandPassword idandpass = new IDandPassword();
		LoginForm login = new LoginForm(idandpass.getLoginInfo());
		
	}

}
