package com.orangeHrm.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orangeHrm.base.BaseClass;
import com.orangeHrm.pages.AddUserPage;
import com.orangeHrm.pages.AdminPage;
import com.orangeHrm.pages.HomePage;
import com.orangeHrm.pages.LoginPage;
import com.orangeHrm.util.TestUtil;

public class AdminPageTest extends BaseClass{
	
	LoginPage loginPage;
	HomePage homePage;
	AdminPage adminPage;
	AddUserPage addUserPage;
	
	public AdminPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginPage=new LoginPage();
		addUserPage=new AddUserPage();
		homePage=loginPage.validateLogin(prop.getProperty("username"), prop.getProperty("password"));
		adminPage=homePage.clickonAdminLink();
	}
	
	@Test(priority=0)
	public void verifyAdminPageLabelTest()
	{
		Assert.assertTrue(adminPage.verifyLabel());
	}
	
	@Test(priority=1)
	
	public void verifyUserAvailabilityTest()
	{
		String user=prop.getProperty("user");
		boolean status=adminPage.verifyUsername(user);
		TestUtil.putData(user, status);
		Assert.assertTrue(status);
	}
	
	@Test(priority=2)
	public void verifyDeleteUserTest()
	{
		String user=prop.getProperty("deleteUser");
		adminPage.deleteUsername(user);
	}
	
	@Test(priority=3)
	
	public void verifyAddUserClickTest()
	{
		addUserPage=adminPage.clickOnAddUserLink();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	

}
