package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.DashBoardPage;
import pages.LoginPage;
import utils.CommonMethods;
import utils.ConfigReader;

public class LoginStepsTask extends CommonMethods {

    @Given("user is navigated to the hrms login page")
    public void user_is_navigated_to_the_hrms_login_page() {
        openBrowser();
    }

    @When("user has valid admin credentials")
    public void user_has_valid_admin_credentials() {
        LoginPage login = new LoginPage();
        sendText(login.usernameBox, ConfigReader.getPropertyValue("username"));
        sendText(login.passwordBox, ConfigReader.getPropertyValue("password"));
    }

    @And("user clicks login")
    public void user_clicks_login() {
        LoginPage login = new LoginPage();
        clickMethod(login.loginBtn);
    }

    @Then("the user should see the welcome admin screen")
    public void the_user_should_see_the_welcome_admin_screen() {
        DashBoardPage dash = new DashBoardPage();
        Assert.assertTrue(dash.welcomeMessage.isDisplayed());
        tearDown();
    }

    @When("the user has valid ess credentials")
    public void the_user_has_valid_ess_credentials() {
        LoginPage login = new LoginPage();
        sendText(login.usernameBox, "RomML1");
        sendText(login.passwordBox, ConfigReader.getPropertyValue("password"));
    }

    @Then("the user should see the welcome ess screen")
    public void the_user_should_see_the_welcome_ess_screen() {
        DashBoardPage dash = new DashBoardPage();
        Assert.assertTrue(dash.welcomeMessage.isDisplayed());
        tearDown();
    }

    @When("user has invalid credentials")
    public void user_has_invalid_credentials() {
        LoginPage login = new LoginPage();
        sendText(login.usernameBox, "sdtfvbj");
        sendText(login.passwordBox, "awe345tyghnjk");
    }

    @Then("the user should see invalid credentials message")
    public void the_user_should_see_invalid_credentials_message() {
        LoginPage login = new LoginPage();
        Assert.assertTrue(login.errorMessage.isDisplayed());
        tearDown();
    }
}
