package com.velocitor.mobile.base;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;

public abstract class BasePage {
	
 protected AndroidDriver driver(){
	 return DriverManager.get();}
 
 protected WebElement visible(By by){
	 return new WebDriverWait(driver(),Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOfElementLocated(by));}
 
 protected void click(By by){
	 new WebDriverWait(driver(),Duration.ofSeconds(15)).until(ExpectedConditions.elementToBeClickable(by)).click();}
 
 protected void type(By by,String value){WebElement e=visible(by);e.clear();e.sendKeys(value);}
 
 protected boolean displayed(By by){
	 try{
		 return visible(by).isDisplayed();}
	 catch(TimeoutException e)
	 {
		 return false;}
	 }
 
 protected By aid(String aid){
	 return AppiumBy.accessibilityId(aid);
 }
 protected By id(String id){return AppiumBy.id(id);
 }
 
}
