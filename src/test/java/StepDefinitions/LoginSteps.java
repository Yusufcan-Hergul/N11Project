package StepDefinitions;

import Pages.DialogContent;
import Utilities.GWD;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
    DialogContent dc=new DialogContent();


    @Given("Navigate to N{int}")
    public void navigateToN(int arg0) {
        GWD.getDriver().get("https://www.n11.com/");
        GWD.getDriver().manage().window().maximize();
    }

    @And("Click to Sign In Button")
    public void clickToSignInButton() {
        dc.findAndClick("signInBtn");
    }


    @When("Enter username and password and click login button")
    public void enterUsernameAndPasswordAndClickLoginButton() {
        dc.findAndSend("email","venusn11test@gmail.com");
        dc.findAndSend("password","ehj68qaTr");
        dc.findAndClick("loginBtn");

    }

    @Then("User should login successfully")
    public void userShouldLoginSuccessfully() {
//        dc.waitUntilVisible(dc.dashboard);
//        Assert.assertTrue(dc.dashboard.getText().contains("Dashboard"));

        dc.assertElementVisible("dashboard");

    }
}
