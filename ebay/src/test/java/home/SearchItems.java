package home;

import base.CommonAPI;
import org.testng.annotations.Test;

/**
 * Created by salah on 5/13/17.
 */
public class SearchItems extends CommonAPI {

    @Test
    public void search() {
        typeByCss("#gh-ac", "TV");
        clickByCss("#gh-btn");
    }
}

