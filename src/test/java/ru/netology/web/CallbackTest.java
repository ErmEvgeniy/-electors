package ru.netology.web;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CallbackTest {
    private WebDriver driver;

    @BeforeAll
    static void setUpAll() {
        System.setProperty("webdriver.chrome.driver", "./driver/Linux/chromedriver");

    }

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
    }

    @AfterEach
    void tearDown() {
        driver.quit();
        driver = null;
    }

    @Test
   public void shouldTestV1() {
        driver.get("http://localhost:9999");
        List<WebElement> elements = driver.findElements(By.className("input__control"));
        elements.get(0).sendKeys("Василий Иванович");
        elements.get(1).sendKeys("+79270000000");
        driver.findElement(By.className("checkbox__box")).click();
        driver.findElement(By.className("button")).click();
        String text = driver.findElement(By.className("paragraph")).getText();
        assertEquals("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.", text.trim());
    }

    //    @Test
//    void shouldTestV2() {
//        driver.get("http://localhost:9999");
//        WebElement form = driver.findElement(By.cssSelector("[enctype=application/x-www-form-urlencoded]"));
//        form.findElement(By.cssSelector("[data-test-id=name] input")).sendKeys("Василий");
//        form.findElement(By.cssSelector("[data-test-id=phone] input")).sendKeys("+79270000000");
//        form.findElement(By.cssSelector("[data-test-id=agreement]")).click();
//        form.findElement(By.cssSelector("[data-test-id=submit]")).click();
//        String text = driver.findElement(By.className("alert-success")).getText();
//        assertEquals("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.", text.trim());
//     }

}

