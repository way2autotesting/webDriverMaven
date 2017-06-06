package componentHelper;

import com.WebDriverManager;

/**
 * Created by Ibi on 30/05/2017.
 */
public class BrowserHelper extends WebDriverManager {
    public static void BrowserMaximize() {

        driver.manage().window().maximize();
    }



}
