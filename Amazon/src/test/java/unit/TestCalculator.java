package unit;

import org.junit.Assert;

/**
 * Created by PIIT_NYA on 5/6/2017.
 */
public class TestCalculator {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int total = calculator.addition(5,10);
        Assert.assertEquals(total, 15);
    }
}
