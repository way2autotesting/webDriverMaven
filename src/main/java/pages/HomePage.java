package pages;

import com.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Ibi on 30/05/2017.
 */
public class HomePage extends WebDriverManager{
    /*
 Getting elements
 */
    @FindBy(xpath = ".//div[@id='navigationMenuWrapper']/descendant::span[position()=1]")
    private WebElement about;

    @FindBy(xpath = ".//div[@id='navigationMenuWrapper']/descendant::span[position()=3]")
    private WebElement services;

    @FindBy(xpath = ".//div[@id='navigationMenuWrapper']/descendant::span[position()=2]")
    private WebElement work;

    @FindBy(xpath = ".//a[@id='contacticon']/descendant::i[position()=1]")
    private WebElement contact;


    /*
   Creating Method
    */

    public void check_HomepageTitle() {
        assertEquals("Where Experiences are Engineered - Valtech", driver.getTitle());

    }

    public void SelectAbout(){

        about.click();
    }

    public void SelectWork(){

        work.click();
    }

    public void SelectService(){

        services.click();
    }

    public void SelectContact(){

        contact.click();
    }

    public static boolean CheckLatestNewsExist(List<String> location_table) {

        String source= driver.getPageSource();
        for (String section: location_table){
            if (!source.contains(section))
                return false;
        }
        return true;
    }
}
