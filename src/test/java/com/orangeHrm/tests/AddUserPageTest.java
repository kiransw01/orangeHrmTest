package com.orangeHrm.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.orangeHrm.base.BaseClass;
import com.orangeHrm.pages.AddUserPage;
import com.orangeHrm.pages.AdminPage;
import com.orangeHrm.pages.HomePage;
import com.orangeHrm.pages.LoginPage;
import com.orangeHrm.util.TestUtil;

public class AddUserPageTest extends BaseClass {

	LoginPage loginPage;
	HomePage homePage;
	AdminPage adminPage;
	AddUserPage addUserPage;
	String sheetName="AddUser";

	public AddUserPageTest()
	{
		super();
	}

	@BeforeMethod
	public void setUp() 
	{
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.validateLogin(prop.getProperty("username"), prop.getProperty("password"));
		adminPage = homePage.clickonAdminLink();
		addUserPage = adminPage.clickOnAddUserLink();
	}

	@Test(priority=0)
	public void VerifyPageUrlTest()
	{
		String expectedUrl = "https://opensource-demo.orangehrmlive.com/index.php/admin/saveSystemUser";
		String actualUrl = addUserPage.verifyPageUrl();
		Assert.assertEquals(actualUrl, expectedUrl, "Add User Page URL Mismatch");
	}

	@DataProvider
	//public Iterator<Object[]> getAddUserData() {
	public Object[][] getAddUserData() {
		//ArrayList<Object[]> addUserData = TestUtil.getData();
		Object[][] userData=TestUtil.getData(sheetName);
		//return addUserData.iterator();
		return userData;
	}

	@Test(priority=1,dataProvider = "getAddUserData")
	public void validateAddUserTest(String urole, String empname, String uname, String stus, String pwd, String cnfPwd) 
	{
		addUserPage.addUser(urole, empname, uname, stus, pwd, cnfPwd);
	}

	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
