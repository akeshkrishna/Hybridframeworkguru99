package tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import base.BaseClass;
import pages.LoginPage;
import utils.ExcelReader;
import utils.ExtentManager;

public class LoginTest
{
	ExtentReports report;
    ExtentTest test;

    @BeforeClass
    public void setupTest() {
        report = ExtentManager.getReportInstance();
        BaseClass.setup();
    }

    @Test
    public void testLoginUsingExcel() {
        test = report.createTest("Login Test Using Excel");

        // Load data from Excel
        String excelPath = "testdata/TestData.xlsx";
        ExcelReader reader = new ExcelReader(excelPath, "LoginData");

        String username = reader.getCellData(1, 0); // Row 1, Column 0
        String password = reader.getCellData(1, 1); // Row 1, Column 1

        LoginPage lp = new LoginPage(BaseClass.driver);
        lp.login(username, password);

        test.pass("Login successful using credentials from Excel: " + username);
    }

    @AfterClass
    public void tearDown() {
        BaseClass.tearDown();
        report.flush();
    }
}
