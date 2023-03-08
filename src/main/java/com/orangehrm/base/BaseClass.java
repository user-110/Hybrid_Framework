package com.orangehrm.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author AmirP : Base Class consists all the initialization methods and configurations 
 *
 */
public class BaseClass {

	public static WebDriver driver;
	public static Properties prop;

	@BeforeMethod
	public void openBrowser() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream("Configuration\\config.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");

		if (browserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if (browserName.equalsIgnoreCase("FireFox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if (browserName.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}

		driver.get(prop.getProperty("baseUrl"));
		driver.manage().window().maximize();

	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
}
