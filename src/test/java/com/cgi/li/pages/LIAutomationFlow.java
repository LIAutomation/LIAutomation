package com.cgi.li.pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class LIAutomationFlow {
    RemoteWebDriver driver;
    @FindBy(how=How.XPATH,using ="//div[@class='flex flex-col']/descendant::div[3]/input") public WebElement username_Field;
    @FindBy(how=How.XPATH,using ="//input[@id='username']") public WebElement Susername_Field;

    @FindBy(how=How.XPATH,using ="//div[@class='flex flex-col']/descendant::div[6]/input") public WebElement password_Field;
    @FindBy(how=How.XPATH,using ="//input[@id='password']") public WebElement Spassword_Field;

    @FindBy(how=How.XPATH,using = "//button[@type='submit']") public WebElement button_Login;
    @FindBy(how=How.XPATH,using = "//*[@id=\"app__container\"]/main/div[2]/form/div[3]/button") public WebElement Sbutton_Login;

    @FindBy(how=How.XPATH,using = "//li-icon[@type='home-active']//*[name()='svg']")
    public WebElement homepageUI;

    @FindBy(how=How.XPATH,using = "/html[1]/body[1]/div[5]/div[3]/div[2]/div[1]/div[1]/main[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[1]/div[1]/a[1]/div[1]/div[1]/div[1]/div[1]/div[1]/span[1]/span[1]/a[1]")
    public WebElement ClickonCompanyName2;

    @FindBy(how=How.XPATH,using = "//div[@class='search-nec__hero-kcard-v2-title']")
    public WebElement ClickonCompanyName;

    @FindBy(how=How.XPATH,using = "//span[@class='entity-result__title-line entity-result__title-line--2-lines pt1']")
    public WebElement ClickonCompanyName3;

    @FindBy(xpath = "(//button[normalize-space()='More'])[1]")
    public WebElement MoreButton;

    @FindBy(how=How.LINK_TEXT,using = "View in Sales Navigator")
    public WebElement ViewInSalesNavigatorLink;

    @FindBy(how=How.XPATH,using = "(//div[@id='ember448'])[1]")
    public WebElement ViewInSalesNavigatorLink1;

    @FindBy(how=How.XPATH,using = "//span[@class='_search-link_1no6tq _hide-with-narrow-screen_1no6tq _search-link--vertical-space_1no6tq']")
    public WebElement DecisionMakersLink;

    @FindBy(how=How.XPATH,using = "//fieldset[@title='Geography']//li-icon[@type='plus-icon']//*[name()='svg']")
    public WebElement GeographySetLink;

    @FindBy(how=How.XPATH,using = "//input[@placeholder='Add locations']")
    public WebElement GeographySearch;
    @FindBy(how=How.XPATH,using = "//button[@title='Include “United States” in Region filter']")
    public WebElement GeographySetUSACode;

    @FindBy(how=How.XPATH,using = "//fieldset[@title='Current job title']//button[@type='button']")
    public WebElement SetRoleJobLink;

    @FindBy(how=How.XPATH,using = "//input[@placeholder='Add current titles']")
    public WebElement RoleSearchBox;

    @FindBy(how=How.XPATH,using = "//button[@title='Include “Vice President” in Current job title filter']")
    public WebElement RoleSelectfromSearch;

    @FindBy(how=How.XPATH,using = "//span[normalize-space()='Vice President']")
    public WebElement CurrentRoleVPresidentChecked;

    @FindBy(how=How.XPATH,using = "//span[normalize-space()='Director']")
    public WebElement CurrentRoleDirectorChecked;


    @FindBy(how=How.XPATH,using = "//div[contains(@title,'CXO')]")
    public WebElement CurrentRoleCXOChecked;

    @FindBy(how=How.XPATH,using = "//div[@class='artdeco-entity-lockup__title ember-view']")
    public WebElement UserprofileNameSN;

    @FindBy(how=How.XPATH,using = "//span[contains(@title,'You have 0 unseen alerts')]")
    public WebElement SNavigatorHomeLink;

    @FindBy(how=How.XPATH,using = "//input[@id='global-typeahead-search-input']")
    public WebElement SNavigatorSearchBox;

    @FindBy(how=How.XPATH,using = "//span[normalize-space()='33 mutual connections']")
    public WebElement LastPageScroller;

    @FindBy(how=How.XPATH,using = "//div[@class='_6ltg']/a[@role='button']") public WebElement button_Create_new_account;

    @FindBy(how=How.NAME,using ="firstname") public WebElement field_firstname;

    @FindBy(how=How.NAME,using ="lastname") public WebElement field_lastname;

    @FindBy(how=How.NAME,using ="reg_email__") public WebElement field_email_mobileno;

    @FindBy(how=How.NAME,using ="reg_passwd__") public WebElement field_password;

    @FindBy(how=How.NAME,using ="birthday_day") public WebElement field_birthday_day;

    @FindBy(how=How.NAME,using ="birthday_month") public WebElement field_birthday_month;

    @FindBy(how=How.NAME,using ="birthday_year") public WebElement field_birthday_year;

    @FindBy(how=How.XPATH,using ="(//input[@type='radio'])[1]") public WebElement Radio_button_female;

    @FindBy(how=How.XPATH,using ="(//input[@type='radio'])[2]") public WebElement Radio_button_male;

    @FindBy(how=How.XPATH,using ="(//button[@type='submit'])[2]") public WebElement button_Signup;

    public LIAutomationFlow(RemoteWebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enter_Username(String username)
    {
        username_Field.sendKeys(username);
       // Susername_Field.sendKeys(username);
    }

    public void SearchDataforCompany(String TextDatafromExcel) throws InterruptedException
    {
        WebElement m =driver.findElement(By.xpath("//input[@placeholder='Search']"));
        m.sendKeys(TextDatafromExcel);
        Thread.sleep(3000);
        m.sendKeys(Keys.ENTER);
        Thread.sleep(6000);
        ClickonCompanyName.click();
        Thread.sleep(5000);
        MoreButton.click();
        Thread.sleep(4000);
        //ViewInSalesNavigatorLink.click();
        Thread.sleep(4000);
        boolean SalesNavigatorLink = ViewInSalesNavigatorLink.isDisplayed();

        if (SalesNavigatorLink == true){
            System.out.println("Web Element is displayed" + ViewInSalesNavigatorLink);
        }
        else {
            System.out.println("Web Element is not displayed" + ViewInSalesNavigatorLink);
        }
    }

    public void SearchDataforCompanyloop(String TextDatafromExcel) throws InterruptedException
    {
        WebElement m =driver.findElement(By.xpath("//input[@placeholder='Search']"));
        m.sendKeys(TextDatafromExcel);
        Thread.sleep(3000);
        m.sendKeys(Keys.DOWN);
        m.sendKeys(Keys.ENTER);
        Thread.sleep(8000);
        boolean ClickonCompanyNameLink = ClickonCompanyName3.isDisplayed();

        if (ClickonCompanyNameLink == true){
            System.out.println("Web Element is displayed" + ClickonCompanyName3);
            ClickonCompanyName3.click();
        } else {
            System.out.println("Web Element is not displayed" + ClickonCompanyName3);
            ClickonCompanyName2.click();
        }

        Thread.sleep(15000);
        MoreButton.click();
        Thread.sleep(4000);
        boolean SalesNavigatorLink = ViewInSalesNavigatorLink.isDisplayed();

        if (SalesNavigatorLink == true){
            System.out.println("Web Element is displayed" + ViewInSalesNavigatorLink);
            ViewInSalesNavigatorLink.click();
        } else {
            System.out.println("Web Element is not displayed" + ViewInSalesNavigatorLink);
        }

        Thread.sleep(15000);
        SNavigatorHomeLink.click();
        WebElement m1 =driver.findElement(By.xpath("//input[@id='global-typeahead-search-input']"));
        m1.sendKeys(TextDatafromExcel);
        Thread.sleep(3000);
        m1.sendKeys(Keys.DOWN);
        m1.sendKeys(Keys.DOWN);
        m1.sendKeys(Keys.ENTER);
        Thread.sleep(8000);

        DecisionMakersLink.click();
        Thread.sleep(8000);
        GeographySetLink.click();
        Thread.sleep(4000);
        GeographySearch.sendKeys("United States");
        Thread.sleep(4000);
        GeographySetUSACode.click();
        Thread.sleep(4000);

        SetRoleJobLink.click();
        Thread.sleep(2000);
        RoleSearchBox.sendKeys("Vice President");
        Thread.sleep(4000);
        RoleSelectfromSearch.click();
        Thread.sleep(4000);
    }

    public void SearchDatafromSNavigator(String TextDatafromExcel) throws InterruptedException
    {
        SNavigatorHomeLink.click();
        Thread.sleep(4000);
        WebElement m =driver.findElement(By.xpath("//input[@id='global-typeahead-search-input']"));
        m.sendKeys(TextDatafromExcel);
        Thread.sleep(3000);
        m.sendKeys(Keys.DOWN);
        m.sendKeys(Keys.DOWN);
        m.sendKeys(Keys.ENTER);
        Thread.sleep(15000);
        DecisionMakersLink.click();
        Thread.sleep(9000);
        GeographySetLink.click();
        Thread.sleep(8000);
        GeographySearch.sendKeys("United States");
        Thread.sleep(8000);
        GeographySetUSACode.click();
        Thread.sleep(4000);

        SetRoleJobLink.click();
        Thread.sleep(4000);
        Thread.sleep(4000);
        boolean CurrentRoleVPresident = CurrentRoleVPresidentChecked.isDisplayed();
        if (CurrentRoleVPresident == true){
            System.out.println("Web Element is displayed" + CurrentRoleVPresidentChecked);
        } else {
            RoleSearchBox.sendKeys("Vice President");
            Thread.sleep(4000);
            RoleSelectfromSearch.click();
            Thread.sleep(4000);
            System.out.println("Web Element is not displayed" + CurrentRoleVPresidentChecked);
        }

        Thread.sleep(4000);
        boolean CurrentRoleDirector = CurrentRoleDirectorChecked.isDisplayed();
        if (CurrentRoleDirector == true){
            System.out.println("Web Element is displayed" + CurrentRoleDirectorChecked);

        } else {
            RoleSearchBox.sendKeys("Director");
            Thread.sleep(4000);
            RoleSelectfromSearch.click();
            Thread.sleep(4000);
            System.out.println("Web Element is not displayed" + CurrentRoleDirectorChecked);
        }

        WebElement Element = driver.findElement(By.xpath("//div[@id='alerts-hoverable-outlet']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Scrolling down the page till the element is found
        js.executeScript("arguments[0].scrollIntoView();", Element);

        List<WebElement> allElements = driver.findElements(By.xpath("//*[@id=\"search-results-container\"]/div/ol"));
        WebElement ul = allElements.get(0);
        List<WebElement> liList = ul.findElements(By.tagName("li"));
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//div[@id='alerts-hoverable-outlet']")));

        for(WebElement li: liList)
        {
            actions.moveToElement(li);
            actions.sendKeys(Keys.DOWN).perform();
            List<WebElement> allElements1 = driver.findElements(By.xpath("//*[@id=\"search-results-container\"]/div/ol"));

            WebElement ul1 = allElements1.get(0);
            //Get element with tag a
            WebElement span = ul1.findElement(By.tagName("a"));
            System.out.println("Href Value = "+span.getAttribute("href"));
            String Liprofiledata = li.getText();
            String[] strSplit = Liprofiledata.split("\n");
            // Now convert string into ArrayList
            ArrayList<String> strList = new ArrayList<String>(Arrays.asList(strSplit));

            String leadName = null;
            String degreelevel = null;
            String mutualfactor = null;
            String dsignation = null;

            if(strList != null && strList.get(1) != null){
                leadName = strList.get(1);
            }
            if(strList != null && strList.get(2) != null){
                degreelevel = strList.get(2);
            }
            if(strList != null && strList.get(14) != null){
                mutualfactor = strList.get(14);
            }
            if(strList != null && strList.get(6) != null){
                dsignation = strList.get(6);
            }
            System.out.println("Lead Name = "+leadName+ " :: Degree Level = "+degreelevel);
            System.out.println("Mutual Factor = "+mutualfactor+ " :: Position = "+dsignation);

        }
    }
    public void enter_Password(String pswd)
    {
        password_Field.sendKeys(pswd);
    }
    public void click_Login()
    {
        button_Login.submit();
    }
    public void homepagescreen(){
      homepageUI.isDisplayed();
    }

    public void click_create_new_account()
    {
        button_Create_new_account.click();
    }

    public void Enter_Firstname(String firstname)
    {
        field_firstname.clear();
        field_firstname.sendKeys(firstname);
    }

    public void enter_Lastname(String lastname)
    {
        field_lastname.clear();
        field_lastname.sendKeys(lastname);
    }

    public void enter_Mobile_email(String mobileno)
    {
        field_email_mobileno.clear();
        field_email_mobileno.sendKeys(mobileno);
    }

    public void enter_password(String password)
    {
        field_password.clear();
        field_password.sendKeys(password);
    }

    public void select_Dataofbirth(String date)
    {
        Select s = new Select(field_birthday_day);
        s.selectByVisibleText(date);
    }

    public void select_Dataofmonth(String month)
    {
        Select s = new Select(field_birthday_month);
        s.selectByVisibleText(month);
    }

    public void select_Dataofyear(String year)
    {
        Select s = new Select(field_birthday_year);
        s.selectByVisibleText(year);
    }

    public void select_radio_button()
    {
        Radio_button_female.click();
    }

    public void select_maleradio_button()
    {
        Radio_button_male.click();
    }

    public void click_signup_button()
    {
        button_Signup.click();
    }
}