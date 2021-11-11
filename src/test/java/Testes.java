import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.openqa.selenium.support.ui.ExpectedConditions.alertIsPresent;

public class Testes {


    @Test
    void deve() {
        ChromeDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 2);

        driver.get("http://localhost:3000");

        if (driver.getPageSource().contains("teste@teste.com")) {
            WebElement tableRow = driver.findElement(By.xpath("//*[text()='teste@teste.com']"));
            tableRow.getAttribute("id");
            String idNumber = Objects.requireNonNull(tableRow.getAttribute("id")).replaceAll("\\D+", "");
            driver.findElement(By.id("delete-".concat(idNumber))).click();
        }

        driver.findElement(By.id("new")).click();
        driver.findElement(By.id("name")).sendKeys("Teste 1");
        driver.findElement(By.id("email")).sendKeys("teste@teste.com");
        driver.findElement(By.id("phone")).sendKeys("45000000000");
        driver.findElement(By.id("save")).click();


        WebElement buttonNew1 = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.id("new")));
        buttonNew1.click();
        driver.findElement(By.id("name")).sendKeys("Teste 1");
        driver.findElement(By.id("email")).sendKeys("teste@teste.com");
        driver.findElement(By.id("phone")).sendKeys("45000000000");
        driver.findElement(By.id("save")).click();


        assertNotNull(wait.until(alertIsPresent()));
        assertEquals("This email is already in use", driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

        driver.close();

    }
}
