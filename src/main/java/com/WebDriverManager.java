package com;

import componentHelper.BrowserHelper;
import customException.NoSuitableDriverFound;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Created by Ibi on 30/05/2017.
 */
public class WebDriverManager {
    public static WebDriver driver=null;
    public static Properties p = new Properties();
    public static FileInputStream fi = null;


    public static void setUp() throws IOException, NoSuitableDriverFound {

        fi =new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\ObjectRepo\\global.properties");
        p.load(fi);

        if(p.getProperty("env.driver.browser").contains("firefox")){
            driver=new FirefoxDriver();

        }else if (p.getProperty("env.driver.browser").contains("chrome")){
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\main\\java\\browserDrivers\\chromedriver.exe");
            driver = new ChromeDriver(GetChromeOption());

        }else if(p.getProperty("env.driver.browser").contains("ie")){
            System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\src\\main\\java\\browserDrivers\\IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        }
        else {
            throw new NoSuitableDriverFound("Driver Not Found :" +driver.toString());
        }
        BrowserHelper.BrowserMaximize();
        driver.get(p.getProperty("url"));
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);//elements wait  Synchronization
        driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);//page load  Synchronization
    }

    private static ChromeOptions GetChromeOption(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addExtensions();
        return options;
    }

    public static void tearDown(){
        if(driver !=null){
            driver.close();
            driver.quit();
        }
    }
}
