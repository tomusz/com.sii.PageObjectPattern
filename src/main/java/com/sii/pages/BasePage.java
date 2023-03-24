package com.sii.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BasePage {

    protected static void selectByValue(WebElement element, String value) {
        new Select(element).selectByValue(value);
    }

}
