package com.sii.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.function.Consumer;

public class WebPageUtils {

    public static Consumer<WebDriver> maximiseWindow = d -> d.manage().window().maximize();

    public static void switchWindowOrTab(String baseWindow, WebDriver driver) {
        for (String windowHandle : driver.getWindowHandles()) {
            if (!baseWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }

    public static void closeWindowAndGetBackToBase(String baseWindow, WebDriver driver) {
        driver.close();
        driver.switchTo().window(baseWindow);
    }

    public static WebElement getRandomElement(List<WebElement> elementList) {
        return elementList.get(ArithmeticUtils.getRandomNumberInRange(0, elementList.size()));
    }
}
