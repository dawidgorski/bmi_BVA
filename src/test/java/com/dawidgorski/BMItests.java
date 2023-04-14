package com.dawidgorski;

import com.dawidgorski.config.DriverSingleton;
import com.dawidgorski.pages.Main;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class BMItests {

    WebDriver driver = DriverSingleton.getInstance();


    @BeforeMethod
    public void setUp() {
        driver.get("https://www.calculator.net/bmi-calculator.html");

    }

    @Test
    public void should_return_severe_thinness() {
        Main main = new Main();
        double bmiResult = main.clickClearButton()
                .setFields("25", "170", "40")
                .clickCalculateButton()
                .getBmiResult();
        assertTrue(bmiResult < 16.00);
    }

    @Test
    public void should_return_moderate_thinness() {
        Main main = new Main();
        double bmiResult = main.clickClearButton()
                .setFields("25", "170", "47")
                .clickCalculateButton()
                .getBmiResult();
        assertTrue((bmiResult >= 16.00) && (bmiResult < 17));
    }

    @Test
    public void should_return_mild_thinness() {
        Main main = new Main();
        double bmiResult = main.clickClearButton()
                .setFields("25", "165", "47")
                .clickCalculateButton()
                .getBmiResult();
        assertTrue((bmiResult >= 17.00) && (bmiResult < 18.5));
    }

    @Test
    public void should_return_normal() {
        Main main = new Main();
        double bmiResult = main.clickClearButton()
                .setFields("25", "165", "55")
                .clickCalculateButton()
                .getBmiResult();
        assertTrue((bmiResult >= 18.5) && (bmiResult < 25));
    }

    @Test
    public void should_return_overweight() {
        Main main = new Main();
        double bmiResult = main.clickClearButton()
                .setFields("25", "165", "70")
                .clickCalculateButton()
                .getBmiResult();
        assertTrue((bmiResult >= 25) && (bmiResult < 30));
    }

    @Test
    public void should_return_obese_class_1() {
        Main main = new Main();
        double bmiResult = main.clickClearButton()
                .setFields("25", "170", "90")
                .clickCalculateButton()
                .getBmiResult();
        assertTrue((bmiResult >= 30) && (bmiResult < 35));
    }

    @Test
    public void should_return_obese_class_2() {
        Main main = new Main();
        double bmiResult = main.clickClearButton()
                .setFields("25", "170", "105")
                .clickCalculateButton()
                .getBmiResult();
        assertTrue((bmiResult >= 35) && (bmiResult < 40));

    }

    @Test
    public void should_return_obese_class_3() {
        Main main = new Main();
        double bmiResult = main.clickClearButton()
                .setFields("25", "170", "120")
                .clickCalculateButton()
                .getBmiResult();
        assertTrue(bmiResult > 40);
    }

    @Test
    public void to_low_age_should_return_age_error() {
        Main main = new Main();
        String errorText = main.clickClearButton()
                .setFields("1", "170", "120")
                .clickCalculateButton()
                .getNegativeErrorText();
        assertEquals(errorText, "Please provide an age between 2 and 120.");

    }

    @Test
    public void to_low_high_should_return_age_error() {
        Main main = new Main();
        String errorText = main.clickClearButton()
                .setFields("121", "170", "120")
                .clickCalculateButton()
                .getNegativeErrorText();
        assertEquals(errorText, "Please provide an age between 2 and 120.");

    }

    @Test
    public void negative_weight_should_return_weight_error() {
        Main main = new Main();
        String errorText = main.clickClearButton()
                .setFields("25", "170", "-33")
                .clickCalculateButton()
                .getNegativeErrorText();
        assertEquals(errorText, "Please provide positive weight value.");

    }

    @Test
    public void negative_height_should_return_height_error() {
        Main main = new Main();
        String errorText = main.clickClearButton()
                .setFields("25", "-170", "65")
                .clickCalculateButton()
                .getNegativeErrorText();
        assertEquals(errorText, "Please provide positive height value.");

    }

    @Test
    public void not_a_number_height_should_return_height_error() {
        Main main = new Main();
        String errorText = main.clickClearButton()
                .setFields("25", "asas", "65")
                .getNotNumberHeightAgeErrorText();
        assertEquals(errorText, "positive numbers only");

    }

    @Test
    public void not_a_number_weight_should_return_weight_error() {
        Main main = new Main();
        String errorText = main.clickClearButton()
                .setFields("25", "165", "wewe")
                .getNotNumberWeightErrorText();
        assertEquals(errorText, "positive numbers only");

    }

    @Test
    public void not_a_number_age_should_return_age_error() {
        Main main = new Main();
        String errorText = main.clickClearButton()
                .setFields("sdsd", "154", "65")
                .getNotNumberAgeErrorText();
        assertEquals(errorText, "positive numbers only");

    }

}
