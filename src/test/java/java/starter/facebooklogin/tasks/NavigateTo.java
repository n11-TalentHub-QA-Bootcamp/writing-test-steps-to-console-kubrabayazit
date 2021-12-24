package starter.facebooklogin.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import starter.facebooklogin.tasks.user_interface.FacebookLoginHomePage;

public class NavigateTo {

    public static Performable theFacebookLoginPage() {
        return Task.where("{0} opens the facebook login page",
                Open.browserOn().the(FacebookLoginHomePage.class));
    }

}
