package com.velocitor.mobile.pages;
import com.velocitor.mobile.base.BasePage;import org.openqa.selenium.By;
public class LoginPage extends BasePage {
	private final 
	By 
	 hamburgerIcon=aid("View menu")
	,loginIcon=aid("Login Menu Item")
	,username=id("com.saucelabs.mydemoapp.android:id/nameET")
	, password=id("com.saucelabs.mydemoapp.android:id/passwordET")
	, login=aid("Tap to login with given credentials")
	, error=aid("test-Error message");

	public void login(String user,String pass){
		click(hamburgerIcon);
		click(loginIcon);
		type(username,user);
		type(password,pass);
		click(login);
	}
	public boolean isErrorDisplayed(){
		return displayed(error);
	}
	public boolean isLoginDisplayed(){
		return displayed(username);
	}
}
