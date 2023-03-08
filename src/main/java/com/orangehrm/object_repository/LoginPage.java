package com.orangehrm.object_repository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.base.BaseClass;

public class LoginPage extends BaseClass {
	
	@FindBy(xpath = "//input[@name='username']")
	private WebElement username;

	@FindBy(xpath = "//input[@name='password']")
	private WebElement password;

	@FindBy(xpath = "//button[text()=' Login ']")
	private WebElement loginButton;

	public LoginPage() {

		PageFactory.initElements(driver, this);

	}

	public void setUsername(String uname) {

		username.sendKeys(uname);

	}

	public void setPassword(String pwd) {

		password.sendKeys(pwd);
	}

	public void clickOnLoginButton() {
		loginButton.click();
	}

}
