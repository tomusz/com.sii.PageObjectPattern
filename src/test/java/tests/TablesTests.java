package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.sii.utils.TablesUtils;
import com.sii.utils.WebPageUtils;

import java.util.List;

public class TablesTests extends BaseTest {

    private final String tablesWebPageUrl = baseUrl + webAddresses.get("basic.table");
    private final int REQUIRED_MOUNTAIN_HEIGHT = 4000;

    @Test
    public void getRows() {
        driver.get(tablesWebPageUrl);
        WebPageUtils.maximiseWindow.accept(driver);

        List<WebElement> rowsWithSwitzerland = driver.findElements(By.xpath("//tr/td[contains(.,'Switzerland')]/.."));
        TablesUtils.printRowsWithHeightMoreThan(rowsWithSwitzerland, REQUIRED_MOUNTAIN_HEIGHT);
    }
}