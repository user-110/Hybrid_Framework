package com.orangehrm.test_cases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.orangehrm.base.BaseClass;
import com.orangehrm.object_repository.HomePage;
import com.orangehrm.object_repository.LoginPage;
import com.orangehrm.utility.ReadFromExcel;

public class LoginTest_TC1 extends BaseClass {

	LoginPage login;
	HomePage homepage;

	@Test(dataProvider = "supplyData")
	public void loginToApplication(String Username, String Password) throws InterruptedException {
		Thread.sleep(4000);

		login = new LoginPage();
		login.setUsername(Username);
		login.setPassword(Password);
		login.clickOnLoginButton();
		Thread.sleep(4000);

		if (driver.getCurrentUrl().equals("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login")) {
			Assert.assertTrue(false);

		}

	}

	@DataProvider
	public String[][] supplyData() throws IOException {
		ReadFromExcel read = new ReadFromExcel();

		return read.readData();
	}

}
