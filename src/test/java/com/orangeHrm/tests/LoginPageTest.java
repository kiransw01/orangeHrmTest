package com.orangeHrm.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orangeHrm.base.BaseClass;
import com.orangeHrm.pages.LoginPage;

public class LoginPageTest extends BaseClass {
	
	LoginPage loginPage;
	
	public LoginPageTest()
	{
		super();
	}

	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginPage=new LoginPage();
	}
	@Test(priority=0)
	public void verifyTitleTest()
	{
		String expectedTitle="OrangeHRM";
		Assert.assertEquals(loginPage.validateTitle(), expectedTitle,"Title is not matching");
	}
	
	@Test(priority=1)
	public void verifyOrangeHrmLogoTest()
	{	
		Assert.assertTrue(loginPage.validateLogo());    
	}

	
	@Test(priority=2)
	public void verifyLoginTest()
	{
		loginPage.validateLogin(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
