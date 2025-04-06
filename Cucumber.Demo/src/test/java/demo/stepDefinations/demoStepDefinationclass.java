package demo.stepDefinations;

import org.junit.runner.RunWith;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
public class demoStepDefinationclass {

    @Given("^user is logged on login page$")
    public void user_is_logged_on_login_page() {
        System.out.println("user_is_logged_on_login_page");
    }

    @When("^user checks pay current dues$")
    public void user_checks_pay_current_dues() {
    	System.out.println("user_checks_pay_current_dues");
    }

    @Then("^verify payment complete message$")
    public void verify_payment_complete_message() {
    	System.out.println("verify_payment_complete_message");
    }

    @And("^logged into to application$")
    public void logged_into_to_application() {
    	System.out.println("logged_into_to_application");
    }

    @And("^clicks on submit button$")
    public void clicks_on_submit_button() {
    	System.out.println("clicks_on_submit_button");
    }

}