package com.orangeHrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangeHrm.base.BaseClass;

public class HomePage extends BaseClass {
	
	
	@FindBy(xpath="//a[contains(text(), 'Welcome Admin')]")
	WebElement username;
	
	@FindBy(id="menu_admin_viewAdminModule")
	WebElement adminTab;
	
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyTitle()
	{
		return driver.getTitle();
	}
	
	public boolean verifyUserNameDetail()
	{
		return username.isDisplayed();
	}
	
	public AdminPage clickonAdminLink()
	{
		adminTab.click();
		return new AdminPage();
	}

}	
