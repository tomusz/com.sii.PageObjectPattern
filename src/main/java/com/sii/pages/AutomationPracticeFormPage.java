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

public class AutomationPracticeFormPage extends BasePage {

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

    public AutomationPracticeFormPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void confirmForm() {
        signInButton.click();
    }


    public AutomationPracticeFormPage attachFileByPath(String path) {
        attachFileButton.sendKeys(path);
        return this;
    }

    public AutomationPracticeFormPage selectContinents(String continentValue) {
        selectByValue(selectContinents, continentValue);
        return this;
    }

    public AutomationPracticeFormPage selectRandomProfession() {
        WebElement randomProfession = WebPageUtils.getRandomElement(professionCheckBoxes);
        randomProfession.click();
        return this;
    }

    public AutomationPracticeFormPage selectSelectSeleniumCommands(String value) {
        selectByValue(selectSeleniumCommands, value);
        return this;
    }

    public AutomationPracticeFormPage selectRandomContinent() {
        Object randomObjectFromList = ArithmeticUtils.getRandomObjectFromList(
                Arrays.stream(Continents.values()).collect(Collectors.toList()));
        selectContinents(((Continents) randomObjectFromList).getValue());
        return this;
    }

    public AutomationPracticeFormPage selectRandomYearsOfExperience() {
        WebPageUtils.getRandomElement(yearsOfExperienceRadio).click();
        return this;
    }

    //genders
    public AutomationPracticeFormPage setFirstName(String firstName) {
        firstNameInput.sendKeys(firstName);
        return this;
    }

    public AutomationPracticeFormPage setLastName(String lastName) {
        lastNameInput.sendKeys(lastName);
        return this;
    }

    public AutomationPracticeFormPage setEmail(String email) {
        emailInput.sendKeys(email);
        return this;
    }

    public AutomationPracticeFormPage setAge(int age) {
        ageInput.sendKeys(String.valueOf(age));
        return this;
    }

    public String getValidationMsgLabel() {
        return validatorMessageLabel.getText();
    }

    public AutomationPracticeFormPage pickRandomGender() {
        WebPageUtils.getRandomElement(gendersRadio).click();
        return this;
    }

    public AutomationPracticeFormPage selectGender(Genders genders) {
        switch (genders) {
            case MALE -> selectMale();
            case FEMALE -> selectFemale();
            default -> selectOther();
        }
        return this;
    }

    private AutomationPracticeFormPage selectOther() {
        gendersRadio.get(Genders.OTHER.getNumber()).click();
        return this;
    }

    private AutomationPracticeFormPage selectFemale() {
        gendersRadio.get(Genders.FEMALE.getNumber()).click();
        return this;
    }

    public AutomationPracticeFormPage selectMale() {
        gendersRadio.get(Genders.MALE.getNumber()).click();
        return this;
    }
}
