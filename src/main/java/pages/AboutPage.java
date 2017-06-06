package pages;

import com.WebDriverManager;

import java.util.List;

/**
 * Created by Ibi on 30/05/2017.
 */
public class AboutPage extends WebDriverManager{



    public static boolean CheckAboutDetailsExist(List<String> location_table) {

        String source= driver.getPageSource();
        for (String section: location_table){
            if (!source.contains(section))
                return false;
        }
        return true;
    }
}
