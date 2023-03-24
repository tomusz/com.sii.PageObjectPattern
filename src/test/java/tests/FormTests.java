package tests;

import com.sii.constants.FileConstants;
import com.sii.pages.AutomationPracticeFormPage;
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

        AutomationPracticeFormPage formPage = new AutomationPracticeFormPage(driver);
        File file = FileConstants.getPathToSomeFile().toFile();

        formPage.setFirstName("John")
                .setLastName("Bluebox")
                .setEmail("realemail@real.com")
                .pickRandomGender()
                .setAge(20)
                .selectRandomContinent()
                .selectRandomYearsOfExperience()
                .selectRandomProfession()
                .selectSelectSeleniumCommands("switch-commands")
                .selectSelectSeleniumCommands("wait-commands")
                .attachFileByPath(file.getAbsolutePath())
                .confirmForm();

        assertThat(formPage.getValidationMsgLabel())
                .isEqualTo(FormsExpectedMsg.getFormLabelMsg());
    }
}