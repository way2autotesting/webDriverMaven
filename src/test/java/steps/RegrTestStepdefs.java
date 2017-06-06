package steps;

import com.WebDriverManager;
import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import customException.NoSuitableDriverFound;
import org.openqa.selenium.support.PageFactory;
import pages.*;

import java.io.IOException;
import java.util.List;

import static com.WebDriverManager.driver;
import static org.junit.Assert.assertTrue;

/**
 * Created by Ibi on 30/05/2017.
 */
public class RegrTestStepdefs extends CommonSteps{

    @Before
    public void initialise() throws IOException, NoSuitableDriverFound {
        WebDriverManager.setUp();
        homePage = PageFactory.initElements(driver, HomePage.class);
        contactPage = PageFactory.initElements(driver, ContactPage.class);
        aboutPage = PageFactory.initElements(driver, AboutPage.class);
        servicePage = PageFactory.initElements(driver, ServicePage.class);
        workPage = PageFactory.initElements(driver, WorkPage.class);
    }


    @Given("^I navigate to Home page$")
    public void iNavigateToHomePage() throws Throwable {

        homePage.check_HomepageTitle();
    }

    @And("^I click About link$")
    public void iClickAboutLink() throws Throwable {
       homePage.SelectAbout();
    }

    @And("^I click Service link$")
    public void iClickServiceLink() throws Throwable {
        homePage.SelectService();
    }

    @And("^I click Work link$")
    public void iClickWorkLink() throws Throwable {
      homePage.SelectWork();
    }

    @And("^I click Contact link$")
    public void iClickContactLink() throws Throwable {
      homePage.SelectContact();
    }

    @And("^I finally tear out$")
    public void iFinallyTearOut() throws Throwable {
      WebDriverManager.tearDown();
    }

    @Then("^I can see the following About page header$")
    public void iCanSeeTheFollowingAboutPageHeader(List<String> location) throws Throwable {

        assertTrue("User unable to display about header", aboutPage.CheckAboutDetailsExist(location));
    }

    @Then("^I can see the following Service page header$")
    public void iCanSeeTheFollowingServicePageHeader(List<String> location) throws Throwable {
        assertTrue("User unable to display service header", servicePage.CheckServiceDetailsExist(location));
    }

    @Then("^I can see the following work page header$")
    public void iCanSeeTheFollowingWorkPageHeader(List<String> location) throws Throwable {
        assertTrue("User unable to display work header", workPage.CheckWorkDetailsExist(location));
    }

    @Then("^I can see the following contact page header$")
    public void iCanSeeTheFollowingContactPageHeader(List<String> location) throws Throwable {
        assertTrue("User unable to display work header", contactPage.CheckContactDetailsExist(location));
    }

    @Then("^I can see the latest News display$")
    public void iCanSeeTheLatestNewsDisplay(List<String> location) throws Throwable {
        assertTrue("User unable to display latest News", homePage.CheckLatestNewsExist(location));
    }
}
