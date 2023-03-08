package com.orangehrm.object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.base.BaseClass;

public class HomePage extends BaseClass {

	@FindBy(xpath = "//span[@class='oxd-userdropdown-tab']")
	private WebElement paul_addam;

	@FindBy(xpath = "//a[text()='Logout']")
	private WebElement logout;

	@FindBy(xpath = "//span[text()='My Info']")
	private WebElement myInforText;

	@FindBy(xpath = "//span[text()='Directory']")
	private WebElement drirectoryText;

	public HomePage() {

		PageFactory.initElements(driver, this);

	}

	public void clickOnPaulGaddamText() {

		paul_addam.click();

	}

	public void logout() {
		logout.click();
	}

	public void clickOnMyInfo() {

		myInforText.click();
	}

	public void clickOnDirectory() {

		drirectoryText.click();
	}

}
