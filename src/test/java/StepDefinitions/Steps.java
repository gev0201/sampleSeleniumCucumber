package StepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import sample.qa.base.TestBase;
import sample.qa.pages.LandingPage;
import sample.qa.util.TestUtil;

import java.util.List;
import java.util.Map;

public class Steps extends TestBase {

    LandingPage landingPage;
    TestUtil testUtil;

    @Given("The user opens the login page")
    public void theUserOpensTheLoginPage() throws InterruptedException {
        initialization();
        landingPage = new LandingPage();
        testUtil = new TestUtil();
    }

    @When("The user inputs the username {string} and password {string}")
    public void theUserInputsTheUsernameAndPassword(String userName, String password) {
        landingPage.verifyPageLable();
        landingPage.inputCredentials(userName, password);
    }

    @When("hits enter")
    public void hitsEnter() {
        landingPage.clickLogin();
    }

    @Then("The user should login into application")
    public void theUserShouldLoginIntoApplication() {
        landingPage.isLoggedIn();
        driver.quit();
    }

    @When("The user inputs the invalid credentials")
    public void theUserInputsTheInvalidCredentials() {
        landingPage.verifyPageLable();
        landingPage.inputCredentials("Admi", "admin12");
    }

    @Then("The user should not login into application")
    public void theUserShouldNotLoginIntoApplication() {
        landingPage.verifyErrorMessage();
    }

    @When("The user inputs the credentials and hits login button")
    public void theUserInputsTheCredentials(DataTable dataTable){
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : rows) {
            String userName = row.get("UserName");
            String password = row.get("Password");
            landingPage.inputCredentials(userName, password);
            landingPage.clickLogin();
            landingPage.verifyErrorMessage();
        }
    }

    @Then("Quit driver")
    public void quitDriver() {
        driver.quit();
    }
}
