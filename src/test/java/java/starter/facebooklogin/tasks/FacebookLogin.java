package starter.facebooklogin.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.DriverTask;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WindowType;
import starter.facebooklogin.tasks.user_interface.FacebookLoginHomePage;
import starter.facebooklogin.tasks.user_interface.FacebookLoginElements;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import net.serenitybdd.screenplay.Performable;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;


public class FacebookLogin implements Task {

    private final String email_text;
    private final String password_text;

    @Step("{0} Login with email '#email_text' and password '#password_text'")
    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Click.on(FacebookLoginElements.FACEBOOK_BUTTON),
                Switch.toTheOtherWindow(),
                Click.on(FacebookLoginElements.EMAIL_FIELD),
                SendKeys.of(this.email_text).into(FacebookLoginElements.EMAIL_FIELD),
                Click.on(FacebookLoginElements.PASSWORD_FIELD),
                SendKeys.of(this.password_text).into(FacebookLoginElements.PASSWORD_FIELD)
                        .thenHit(Keys.ENTER)
        );


    }
    public static Performable toNewWindow(WindowType windowType) {
        return new DriverTask(driver -> driver.switchTo().newWindow(windowType));
    }

    public FacebookLogin(String email_text, String password_text){
        this.email_text = email_text;
        this.password_text = password_text;

    }



    public static FacebookLogin loginThePage(String email_text, String password_text) {
        return instrumented(FacebookLogin.class
                ,email_text,password_text);
    }

}

