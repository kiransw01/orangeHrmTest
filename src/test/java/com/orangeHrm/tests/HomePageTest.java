package com.orangeHrm.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orangeHrm.base.BaseClass;
import com.orangeHrm.pages.AdminPage;
import com.orangeHrm.pages.HomePage;
import com.orangeHrm.pages.LoginPage;

public class HomePageTest extends BaseClass {

	LoginPage loginPage;
	HomePage homePage;
	AdminPage adminPage;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		adminPage=new AdminPage();
		homePage = loginPage.validateLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority = 0)
	public void verifyHomePageTitleTest() {
		String expectedTitle = homePage.verifyTitle();
		Assert.assertEquals(driver.getTitle(), expectedTitle, "Home Page Title Mismatch");
	}

	@Test(priority = 1)
	public void verifyUserNameDetailTest() {
		Assert.assertTrue(homePage.verifyUserNameDetail());
	}

	@Test(priority = 2)
	public void verifyClickOnAdminLinkTest() {
		adminPage=homePage.clickonAdminLink();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
