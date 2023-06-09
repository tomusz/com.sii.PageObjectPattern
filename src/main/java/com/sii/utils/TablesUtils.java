package com.sii.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.sii.constants.TestHeaderConstants.*;

public class TablesUtils {

    public static void printRowsWithHeightMoreThan(List<WebElement> rows, int height) {
        for (WebElement row : rows) {
            if (Integer.parseInt(row.findElement(By.xpath(TABLE_HEIGHT_HEADER.getXpath())).getText()) > height) {
                printCellValueWithCellName(TABLE_RANK_HEADER.getName(),
                        row.findElement(By.xpath(TABLE_RANK_HEADER.getXpath())).getText());
                printCellValueWithCellName(TABLE_PEAK_HEADER.getName(),
                        row.findElement(By.xpath(TABLE_PEAK_HEADER.getXpath())).getText());
                printCellValueWithCellName(TABLE_MOUNTAIN_RANGE_HEADER.getName(),
                        row.findElement(By.xpath(TABLE_MOUNTAIN_RANGE_HEADER.getXpath())).getText());
                printCellValueWithCellName(TABLE_STATE_HEADER.getName(),
                        row.findElement(By.xpath(TABLE_STATE_HEADER.getXpath())).getText());
                printCellValueWithCellName(TABLE_HEIGHT_HEADER.getName(),
                        row.findElement(By.xpath(TABLE_HEIGHT_HEADER.getXpath())).getText());
                System.out.print("\n");
            }
        }
    }

    private static void printCellValueWithCellName(String cellName, String cellValue) {
        System.out.print(cellName + " : " + cellValue + " ");
    }
}