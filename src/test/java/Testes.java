import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.openqa.selenium.support.ui.ExpectedConditions.alertIsPresent;

public class Testes {


    @Test
    void deve() {
        ChromeDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 2);

        driver.get("http://localhost:3000/create");
        driver.findElement(By.id("name")).sendKeys("Teste 1");
        driver.findElement(By.id("email")).sendKeys("teste@teste.com");
//        driver.findElement(By.id("phone")).sendKeys("45000000000");
        driver.findElement(By.id("save")).click();

        assertNotNull(wait.until(alertIsPresent()));
        assertEquals("This email is already in use", driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

        driver.close();

    }
}
