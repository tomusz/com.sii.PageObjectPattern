package com.sii.pages;

import com.sii.constants.Continents;
import com.sii.constants.Genders;
import com.sii.utils.ArithmeticUtils;
import com.sii.utils.WebPageUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FormPage extends BasePage {

    @FindBy(css = "#inputFirstName3")
    private WebElement firstNameInput;
    @FindBy(css = "#inputLastName3")
    private WebElement lastNameInput;
    @FindBy(css = "#inputEmail3")
    private WebElement emailInput;
    @FindBy(name = "gridRadiosSex")
    private List<WebElement> gendersRadio;
    @FindBy(css = "#inputAge3")
    private WebElement ageInput;
    @FindBy(name = "gridRadiosExperience")
    private List<WebElement> yearsOfExperienceRadio;
    @FindBy(id = "selectContinents")
    private WebElement selectContinents;
    @FindBy(css = ".checkbox-profession")
    private List<WebElement> professionCheckBoxes;
    @FindBy(id = "selectSeleniumCommands")
    private WebElement selectSeleniumCommands;
    @FindBy(id = "chooseFile")
    private WebElement attachFileButton;
    @FindBy(className = "btn-primary")
    private WebElement signInButton;
    @FindBy(id = "validator-message")
    private WebElement validatorMessageLabel;

    public FormPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void confirmForm() {
        signInButton.click();
    }


    public void attachFileByPath(String path) {
        attachFileButton.sendKeys(path);
    }

    public void selectContinents(String continentValue) {
        selectByValue(selectContinents, continentValue);
    }

    public void selectRandomProfession() {
        WebElement randomProfession = WebPageUtils.getRandomElement(professionCheckBoxes);
        randomProfession.click();
    }

    public void selectSelectSeleniumCommands(String value) {
        selectByValue(selectSeleniumCommands, value);
    }

    public void selectRandomContinent() {
        Object randomObjectFromList = ArithmeticUtils.getRandomObjectFromList(
                Arrays.stream(Continents.values()).collect(Collectors.toList()));
        selectContinents(((Continents) randomObjectFromList).getValue());
    }

    public void selectRandomYearsOfExperience() {
        WebPageUtils.getRandomElement(yearsOfExperienceRadio).click();
    }

    //genders
    public void setFirstName(String firstName) {
        firstNameInput.sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        lastNameInput.sendKeys(lastName);
    }

    public void setEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void setAge(int age) {
        ageInput.sendKeys(String.valueOf(age));
    }

    public String getValidationMsgLabel() {
        return validatorMessageLabel.getText();
    }

    public void pickRandomGender() {
        WebPageUtils.getRandomElement(gendersRadio).click();
    }

    public void selectGender(Genders genders) {
        switch (genders) {
            case MALE -> selectMale();
            case FEMALE -> selectFemale();
            default -> selectOther();
        }
    }

    private void selectOther() {
        gendersRadio.get(Genders.OTHER.getNumber()).click();
    }

    private void selectFemale() {
        gendersRadio.get(Genders.FEMALE.getNumber()).click();
    }

    public void selectMale() {
        gendersRadio.get(Genders.MALE.getNumber()).click();
    }
}
