package com.sii.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AutomationPracticeTablePage {

    @FindBy(xpath = "//table//tbody/tr")
    private List<WebElement> rows;

    public AutomationPracticeTablePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public List<AutomationPracticeRowPage> getMountains() {
        return rows.stream()
                .map(AutomationPracticeRowPage::new)
                .collect(Collectors.toList());
    }

    public void printMountains(List<AutomationPracticeRowPage> rowPages) {
        System.out.println(Arrays.toString(
                rowPages.stream().map(AutomationPracticeRowPage::toString).toArray()));
    }
}
