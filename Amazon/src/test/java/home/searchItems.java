package home;

import base.CommonAPI;
import org.testng.annotations.Test;
import utility.ExtentReport.TestLogger;

/**
 * Created by salah on 5/13/17.
 */


public class searchItems extends CommonAPI {

    @Test
    public void search() {
        typeByCss("#twotabsearchtextbox", "TV");
        clickByCss(".nav-input");

    }
}
