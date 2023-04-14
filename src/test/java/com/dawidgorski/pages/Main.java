package com.dawidgorski.pages;

import com.dawidgorski.config.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Main {

    WebDriver driver;

    @FindBy(css = ".clearbtn")
    WebElement clearButton;

    @FindBy(css = "#cage")
    WebElement ageField;

    @FindBy(css = "#cheightmeter")
    WebElement heightField;

    @FindBy(css = "#ckg")
    WebElement weightField;

    @FindBy(css = "[value='Calculate']")
    WebElement calculateButton;

    @FindBy(css = ".bigtext b")
    WebElement bmiResultText;

    @FindBy(css = ".rightresult font")
    WebElement negative_number_errorText;

    @FindBy(css = "#cageifcErr")
    WebElement not_a_number_age_errorText;

    @FindBy(css = "#cheightmeterifcErr")
    WebElement not_a_number_height_errorText;


    @FindBy(css = "#ckgifcErr")
    WebElement not_a_number_weight_errorText;

    public Main() {
        driver = DriverSingleton.getInstance();
        PageFactory.initElements(driver, this);
    }

    public Main clickClearButton(){
        clearButton.click();
        return this;
    }
    public Main setFields(String age, String height, String weight){
        ageField.sendKeys(age);
        heightField.sendKeys(height);
        weightField.sendKeys(weight);
        return this;

    }
    public Main clickCalculateButton(){
        calculateButton.click();
        return this;

    }

    public Double getBmiResult(){
        return Double.parseDouble(bmiResultText.getText().split(" ")[2]);
    }

    public String getNegativeErrorText(){
        return negative_number_errorText.getText();
    }

    public String getNotNumberAgeErrorText(){
        return not_a_number_age_errorText.getText();
    }

    public String getNotNumberWeightErrorText(){
        return not_a_number_weight_errorText.getText();
    }

    public String getNotNumberHeightAgeErrorText(){
        return not_a_number_height_errorText.getText();
    }

}
