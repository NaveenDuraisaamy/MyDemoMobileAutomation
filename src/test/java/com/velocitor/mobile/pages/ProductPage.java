package com.velocitor.mobile.pages;
import com.velocitor.mobile.base.BasePage;import org.openqa.selenium.By;
public class ProductPage extends BasePage { private final By add=aid("test-ADD-TO-CART"); public void addToCart(){click(add);} }
