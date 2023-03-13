package com.orangehrm.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReporterClass {

	public static ExtentReports report = new ExtentReports();

	public static ExtentReports createExtentReport() throws IOException {

		File file = new File("ExtentReport\\report.html");
//		ExtentSparkReporter sparkreporter = new ExtentSparkReporter(file);
		ExtentHtmlReporter sparkreporter = new ExtentHtmlReporter(file);
//		sparkreporter.config().setTheme(Theme.DARK);
		sparkreporter.config().setReportName("OrangeHRM TestCase Execution report");
		sparkreporter.config().setDocumentTitle("Test_Report");
		sparkreporter.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");

		report.attachReporter(sparkreporter);

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("Configuration\\config.properties");
		prop.load(fis);

		report.setSystemInfo("OS", "Windows");
		report.setSystemInfo("Application URL", prop.getProperty("baseUrl"));
		report.setSystemInfo("Tester", "Random_tester");
		report.setSystemInfo("Browser Name", prop.getProperty("browser"));

		// returning report to whoever is calling this method will get this report
		// having all this configurations

		return report;

	}

}
