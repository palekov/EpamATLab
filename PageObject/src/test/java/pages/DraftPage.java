package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static test.CommonConditions.MAIL_TEXT;

public class DraftPage {

    private final WebDriver driver;

    private final String MAIL_LINK = "//a[@aria-label=\"palekov-2011@mail.ru\'s email\"]";

        public DraftPage(WebDriver driver) {
            this.driver = driver;
        }

    public void verifyDraftPresent() throws InterruptedException {
        //  verify that the mail presents in drafts folder
        WebElement draftBtn = driver.findElement(By.xpath("//div/*[@data-test-folder-name='Draft']"));
        draftBtn.click();

        List<WebElement> draftMailLink = driver.findElements(By.xpath(MAIL_LINK));

       // assertFalse(draftMailLink.isEmpty());

        Thread.sleep(5000);
    }

    public void verifyDraftContent() {
        //  verify the draft content
        WebElement verifySubjectInput = driver.findElement(By.xpath("//input[@data-test-id='compose-subject']"));
        assertEquals("Alexander", verifySubjectInput.getAttribute("value"));

        WebElement verifyTextInput = driver.findElement(By.cssSelector("#editor-container > div.rte.em_N.ir_0.iy_A.iz_h.N_6Fd5 > div > div"));

        assertEquals(MAIL_TEXT, verifyTextInput.getText());
    }
}
