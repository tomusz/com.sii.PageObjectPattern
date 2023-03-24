package tests;

import com.sii.constants.FileConstants;
import com.sii.pages.FormPage;
import com.sii.utils.WebPageUtils;
import expectedMsg.FormsExpectedMsg;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FormTests extends BaseTest {

    private final String formWebPageUrl = baseUrl + webAddresses.get("basic.form");


    @Test
    public void fillInForm() {
        driver.get(formWebPageUrl);
        WebPageUtils.maximiseWindow.accept(driver);

        FormPage formPage = new FormPage(driver);

        formPage.setFirstName("John");
        formPage.setLastName("Bluebox");
        formPage.setEmail("realemail@real.com");
        formPage.pickRandomGender();
        formPage.setAge(20);
        formPage.selectRandomContinent();
        formPage.selectRandomYearsOfExperience();
        formPage.selectRandomProfession();
        formPage.selectSelectSeleniumCommands("switch-commands");
        formPage.selectSelectSeleniumCommands("wait-commands");

        File file = FileConstants.getPathToSomeFile().toFile();
        formPage.attachFileByPath(file.getAbsolutePath());

        formPage.confirmForm();

        String actualLabel = formPage.getValidationMsgLabel();
        String expectedLabel = FormsExpectedMsg.getFormLabelMsg();
        assertThat(actualLabel).isEqualTo(expectedLabel);
    }
}