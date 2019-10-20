package com.orangeHrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangeHrm.base.BaseClass;

public class LoginPage extends BaseClass {

	@FindBy(id = "txtUsername")
	WebElement username;

	@FindBy(name = "txtPassword")
	WebElement password;

	@FindBy(id = "btnLogin")
	WebElement loginbtn;

	@FindBy(xpath = "//img[@src='/webres_5d6f937c9c7169.68307390/themes/default/images/login/logo.png']")
	WebElement logo;

	public LoginPage() {

		PageFactory.initElements(driver, this);
	}

	public String validateTitle() {
		return driver.getTitle();
	}

	public boolean validateLogo() {
		return logo.isDisplayed();
	}

	public HomePage validateLogin(String user, String pwd) {
		username.sendKeys(user);
		password.sendKeys(pwd);
		loginbtn.click();
		return new HomePage();
	}

}
