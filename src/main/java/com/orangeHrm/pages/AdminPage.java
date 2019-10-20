package com.orangeHrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.orangeHrm.base.BaseClass;

public class AdminPage extends BaseClass {
	

	@FindBy(xpath="//div[@id='systemUser-information']//div//h1")
	WebElement systemUserLabel;
	
	@FindBy(id="btnAdd")
	WebElement addBtn;
	
	public AdminPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyLabel()
	{
		boolean status= systemUserLabel.isDisplayed();
		return status;
	}
	
	public boolean verifyUsername(String user)
	{
		WebElement username=driver.findElement(By.xpath("//a[contains(text(),'"+user+"')]"));
		return username.isDisplayed();	
	}
	public void deleteUsername(String user)
	{
		WebElement username=driver.findElement(By.xpath("//a[contains(text(),'"+user+"')]"
				+ "/parent::td//preceding-sibling::td//input"));
		username.click();
		driver.findElement(By.id("btnDelete")).click();
		WebElement okBtn=driver.findElement(By.id("dialogDeleteBtn"));
		okBtn.click();
	}
	public AddUserPage clickOnAddUserLink()
	{
		addBtn.click();
		return new AddUserPage();
	}

}
