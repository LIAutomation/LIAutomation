package com.cgi.li.glucode;

import java.io.IOException;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.cgi.li.pages.LIAutomationFlow;
import com.cgi.li.utility.Utility;
import com.cgi.li.utility.ExcelFileUtility;
import com.cgi.li.utility.PropertiesFileUtility;

public class StepDefination {

    public Scenario s;
    public RemoteWebDriver driver;
    public WebDriverWait wait;
    public LIAutomationFlow page;
    public Utility t;
    public ExcelFileUtility excel;
    public PropertiesFileUtility propertyfile;

    @Before
    public void method1(Scenario s)
    {
        this.s = s;
        t = new Utility();
        excel = new ExcelFileUtility();
        propertyfile = new PropertiesFileUtility();
    }

    @Given("^User Launched LI Application$")
    public void LaunchingBrowser() throws InterruptedException, IOException {

        driver = t.openbrowser(propertyfile.getValueInPropertiesFile("browser"));
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 30);
        page = new LIAutomationFlow(driver);

    }

    @Then("^Launching Li Application url$")
    public void enter_url() throws InterruptedException, IOException {
        driver.get(propertyfile.getValueInPropertiesFile("url"));
        wait.until(ExpectedConditions.elementToBeClickable(page.username_Field));
        Thread.sleep(1000);
    }

    @When("^user enter userid and password into the application$")
    public void enteruseridandpwd() throws IOException, InterruptedException {
       Thread.sleep(1000);
       page.enter_Username(propertyfile.getValueInPropertiesFile("Username"));
       page.enter_Password(propertyfile.getValueInPropertiesFile("Password"));
       page.click_Login();
    }

    @Then("^User verifies Home Page of the Application$")
    public void user_verifies_LI_HomePage() throws IOException, InterruptedException {
        Thread.sleep(3000);
        try
        {
            page.homepagescreen();
            driver.navigate().to("https://www.linkedin.com/sales/home");
            Thread.sleep(8000);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    @Then("^User Verifies the data from ExcelFile \"(.*)\",\"(.*)\"$")
    public void user_verifies_ExcelData(String rowNum, String colNum) throws IOException, InterruptedException {
        Thread.sleep(3000);
        try
        {
            int row1 = Integer.parseInt(rowNum);
            int Col1 = Integer.parseInt(colNum);
            excel.open_Excelfile("C:\\Users\\bsreenivasa\\IdeaProjects\\LIDataFiles\\SalesNavigatorConnectionReq.xlsx");
            excel.open_excel_Sheet("LIJOBDetails");
            page.SearchDataforCompany(excel.getCellalue(row1,Col1));
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Then("^User Verifies the data from ExcelFile1 \"(.*)\"$")
    public void user_verifies_ExcelData1(String colNum) throws IOException, InterruptedException {
        Thread.sleep(3000);
        try{
            int row1;
            int Col1 = Integer.parseInt(colNum);
            excel.open_Excelfile("C:\\Users\\bsreenivasa\\IdeaProjects\\LIDataFiles\\SalesNavigatorConnectionReq.xlsx");
            excel.open_excel_Sheet("LIJOBDetails");

            for( row1=1;row1<=1;row1++)
            {
                page.SearchDatafromSNavigator(excel.getCellalue(row1, Col1));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}

