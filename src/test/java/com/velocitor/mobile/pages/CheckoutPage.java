package com.velocitor.mobile.pages;
import com.velocitor.mobile.base.BasePage;
import org.openqa.selenium.By;
public class CheckoutPage extends BasePage { 
	private final By first=aid("test-First Name"),last=aid("test-Last Name"),zip=aid("test-Zip/Postal Code"),continueBtn=aid("test-CONTINUE"),finish=aid("test-FINISH"),complete=aid("test-CHECKOUT: COMPLETE! - BUTTON"); public void fill(String f,String l,String z){type(first,f);type(last,l);type(zip,z);click(continueBtn);} public void finish(){click(finish);} public boolean complete(){return displayed(complete);} }
