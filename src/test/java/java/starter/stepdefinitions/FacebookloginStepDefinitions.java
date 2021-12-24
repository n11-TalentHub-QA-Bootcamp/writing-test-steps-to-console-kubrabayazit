package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

import starter.facebooklogin.tasks.FacebookLogin;
import starter.facebooklogin.tasks.NavigateTo;
import starter.facebooklogin.tasks.user_interface.FacebookLoginHomePageElements;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.containsText;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;


public class FacebookloginStepDefinitions {

    Actor actor = Actor.named("facebooklogin");

    @Managed
    WebDriver webDriver;

    @Given("user launch browser and open the main page")
     public void userLaunchBrowserAndOpenTheMainPage(){

        actor.can(BrowseTheWeb.with(webDriver));
        actor.wasAbleTo(NavigateTo.theFacebookLoginPage());


     //email ve password textbox'ları doldurulur

    }
    @When("user logged in with valid credentials")
    public void userLoggedInWithValidCredentials() {

        actor.attemptsTo(FacebookLogin.loginThePage("test@gmail.com","test"));

    }

    //facebook login olduktan sonra doğruluğunu kontrol eder

    @Then("user logged in successfully")
    public void userLoggedInSuccessfully() {

        actor.attemptsTo(
                Ensure.that(FacebookLoginHomePageElements.USERNAME_LINK).isDisplayed(),
                Ensure.that(FacebookLoginHomePageElements.USERNAME_LINK).value().startsWith("test")

        );
    }
    }
