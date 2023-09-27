package com.cgi.li.utility;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Utility {
    RemoteWebDriver driver;
    public Utility()
    {
        driver = null;
    }

    public RemoteWebDriver openbrowser(String bn)
    {
        if(bn.equalsIgnoreCase("chrome"))
        {
            WebDriverManager.chromedriver().setup();
            System.setProperty("webdriver.chrome.silentOutput","true");
            driver = new ChromeDriver();
        }
        return driver;
    }



    public void openurl(String url)
    {
        driver.get(url);
    }


}





