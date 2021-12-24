package starter.facebooklogin.tasks.user_interface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class FacebookLoginElements {

    // facebook butonuna tıklanır
    public static Target FACEBOOK_BUTTON =
            Target.the("Facebook button")
                    .locatedBy(".facebook_large medium facebookBtn  btnLogin");
    // email textbox
    public static Target EMAIL_FIELD = Target.the("email textbox").located(By.name("email"));

    //password textbox
    public static Target PASSWORD_FIELD = Target.the("pass textbox").located(By.name("pass"));

    //login butonu
    public static Target LOGIN_BUTTON = Target.the("login button").located(By.name("login"));


}
