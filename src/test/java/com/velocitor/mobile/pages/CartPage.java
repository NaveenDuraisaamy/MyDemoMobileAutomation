package com.velocitor.mobile.pages;
import com.velocitor.mobile.base.BasePage;
import org.openqa.selenium.By;
public class CartPage extends BasePage { 
	private final By checkout=aid("test-CHECKOUT"), item=aid("test-Item title"); 
	public boolean hasItem(){
		return displayed(item);
		}
	public void checkout(){
		click(checkout);} 
	}
