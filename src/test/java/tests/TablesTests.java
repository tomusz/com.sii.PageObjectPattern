package tests;

import com.sii.pages.AutomationPracticeTablePage;
import com.sii.pages.AutomationPracticeRowPage;
import com.sii.utils.WebPageUtils;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

public class TablesTests extends BaseTest {

    private final String tablesWebPageUrl = baseUrl + webAddresses.get("basic.table");
    private final int REQUIRED_MOUNTAIN_HEIGHT = 4000;
    private final String REQUIRED_STATE = "Switzerland";

    @Test
    public void getRows() {
        driver.get(tablesWebPageUrl);
        WebPageUtils.maximiseWindow.accept(driver);

        AutomationPracticeTablePage aPTablePage = new AutomationPracticeTablePage(driver);

        List<AutomationPracticeRowPage> higherThanRequiredAndInSwitzerland = aPTablePage.getMountains().stream()
                .filter(x -> Integer.parseInt(x.getHeight().getText()) > REQUIRED_MOUNTAIN_HEIGHT)
                .filter(x -> x.getState().getText().contains(REQUIRED_STATE))
                .collect(Collectors.toList());

        aPTablePage.printMountains(higherThanRequiredAndInSwitzerland);
    }
}