package com.velocitor.mobile.pages;
import com.velocitor.mobile.base.BasePage;
import org.openqa.selenium.By;

public class CatalogPage extends BasePage {
 private final By products=aid("test-PRODUCTS"), backpack=aid("test-Item"), cart=aid("test-Cart");
 public boolean isDisplayed(){return displayed(products);}
 public void addFirstProduct(){click(backpack);}
 public void openCart(){click(cart);}
}
