package com.tcs.testLayer;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class SauceTest extends SauceLabBaseTest {
	
	
	
	public SauceTest() throws IOException {
		super();
		
	}

	public void doLogin() {
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		
	}
	
	@Test
	public void checkInventoryItem() {
		doLogin();
		System.out.println(driver.findElements(By.cssSelector("inventory_item")).size());
		
	}
	
	@Test
	public void checkAddToCart() {
		doLogin();
		System.out.println(driver.findElements(By.id("add-to-cart-sauce-labs-backpack")).size());
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
