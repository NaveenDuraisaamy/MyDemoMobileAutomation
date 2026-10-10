package com.velocitor.mobile.tests;
import com.velocitor.mobile.base.DriverManager;import com.velocitor.mobile.pages.*;import org.testng.Assert;import org.testng.annotations.*;
public class MobileTests {
 private LoginPage login; private CatalogPage catalog;
 @BeforeMethod public void setUp(){DriverManager.start();login=new LoginPage();catalog=new CatalogPage();}
 @AfterMethod public void tearDown(){DriverManager.stop();}
 @Test public void validLogin(){
	 login.login("standard_user","secret_sauce");
	 //Assert.assertTrue(catalog.isDisplayed(),"Catalog should be displayed after valid login");
	 }
 @Test public void invalidLogin(){
	 login.login("invalid_user","wrong_password");Assert.assertTrue(login.isErrorDisplayed(),"Error should be displayed for invalid credentials");}
 @Test public void addItemAndVerifyCart(){
	 login.login("standard_user","secret_sauce");catalog.addFirstProduct();catalog.openCart();Assert.assertTrue(new CartPage().hasItem(),"Added item should appear in cart");}
 @Test public void checkoutFlow(){
	 login.login("standard_user","secret_sauce");catalog.addFirstProduct();catalog.openCart();
	 CartPage cart=new CartPage();
	 Assert.assertTrue(cart.hasItem());
	 cart.checkout();
	 CheckoutPage checkout=new CheckoutPage();
	 checkout.fill("Naveen","Tester","600001");
	 checkout.finish();
	 Assert.assertTrue(checkout.complete(),"Checkout should complete successfully");}
}
