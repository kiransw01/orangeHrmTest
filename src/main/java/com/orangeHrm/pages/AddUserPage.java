package com.orangeHrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangeHrm.base.BaseClass;
import com.orangeHrm.util.TestUtil;

public class AddUserPage extends BaseClass{
	

	@FindBy(id="systemUser_userType")
	WebElement userRole;
	
	@FindBy(id="systemUser_employeeName_empName")
	WebElement employeeName;
	
	@FindBy(id="systemUser_userName")
	WebElement username;
	
	@FindBy(id="systemUser_status")
	WebElement status;
	
	@FindBy(id="systemUser_password")
	WebElement password;
	
	@FindBy(id="systemUser_confirmPassword")
	WebElement confirmPwd;
	
	@FindBy(id="btnSave")
	WebElement saveBtn;
	
	public AddUserPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyPageUrl()
	{
		return driver.getCurrentUrl();
	}
	
	public AdminPage addUser(String urole, String empname, String uname, String stus, String pwd, String cnfPwd )
	{
		TestUtil.selectDropDown(urole, userRole);
		employeeName.sendKeys(empname);
		username.sendKeys(uname);
		TestUtil.selectDropDown(stus, status);
		password.sendKeys(pwd);
		confirmPwd.sendKeys(cnfPwd);
		saveBtn.click();
		return new AdminPage();
	}
	

}
