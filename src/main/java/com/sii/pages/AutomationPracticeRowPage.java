package com.sii.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

public class AutomationPracticeRowPage {

    @FindBy(css = "th")
    private WebElement rank;
    @FindBy(xpath = "./td[1]")
    private WebElement peak;
    @FindBy(xpath = "./td[2]")
    private WebElement mountainRange;
    @FindBy(xpath = "./td[3]")
    private WebElement state;
    @FindBy(xpath = "./td[4]")
    private WebElement height;

    public AutomationPracticeRowPage(WebElement element) {
        PageFactory.initElements(
                new DefaultElementLocatorFactory(element), this);
    }

    public WebElement getRank() {
        return rank;
    }

    public WebElement getPeak() {
        return peak;
    }

    public WebElement getMountainRange() {
        return mountainRange;
    }

    public WebElement getState() {
        return state;
    }

    public WebElement getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return rank.getText() +
                ", Peak " + peak.getText() +
                ", Mountain Range " + mountainRange.getText() +
                ", State " + state.getText() +
                ", Height " + height.getText() + "\n";
    }
}
