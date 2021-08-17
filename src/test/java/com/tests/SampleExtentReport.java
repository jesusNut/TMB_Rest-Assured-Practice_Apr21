package com.tests;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class SampleExtentReport {

	@Test

	public void sampleExtentReport() {

		// Initial setup
		ExtentReports extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter(System.getProperty("user.dir") + "//index.html");
		spark.config().setDocumentTitle("A Sample Extent Report");
		spark.config().setTheme(Theme.DARK);
		extent.attachReporter(spark);

		// create a sample test case

		ExtentTest test1 = extent.createTest("Test number 1");
		test1.log(Status.INFO, "This a sample test case for extent practice");
		test1.pass("The test case is passing....");

		ExtentTest test2 = extent.createTest("Test number 1");
		test2.log(Status.INFO, "This a sample test case for extent practice");
		test2.fail("The test case is failing....");

		ExtentTest test3 = extent.createTest("Test number 1");
		test3.log(Status.INFO, "This a sample test case for extent practice");
		test3.skip("The test case is Skipping");

		// flush the reports

		extent.flush();

	}

}