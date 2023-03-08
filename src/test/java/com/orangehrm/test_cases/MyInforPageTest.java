package com.orangehrm.test_cases;

import org.testng.annotations.Test;

import com.orangehrm.base.BaseClass;
import com.orangehrm.object_repository.HomePage;
import com.orangehrm.object_repository.LoginPage;

public class MyInforPageTest extends BaseClass {

	HomePage homepage;
	LoginPage login;

	@Test
	public void verifyMyInfo() throws InterruptedException {
		homepage = new HomePage();
		login = new LoginPage();

		Thread.sleep(4000);

		login = new LoginPage();
		login.setUsername("Admin");
		login.setPassword("admin123");
		login.clickOnLoginButton();
		Thread.sleep(4000);

		homepage.clickOnMyInfo();
		Thread.sleep(2000);
		homepage.clickOnPaulGaddamText();
		Thread.sleep(2000);
		homepage.logout();

		Thread.sleep(2000);

	}

}
