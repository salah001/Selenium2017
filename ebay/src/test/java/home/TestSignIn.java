package home;

import base.CommonAPI;
import org.junit.Test;
import org.openqa.selenium.By;

/**
 * Created by salah on 5/14/17.
 */
public class TestSignIn extends CommonAPI {

    @Test
    public void signIn (){

        //clickLinks("Sign in");
        clickByCss(".gh-ug-guest");
    }
}
