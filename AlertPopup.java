package org.example;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class AlertPopup {
    public static void main(String[] args) throws InterruptedException {
        //giving path to where chrome driver is downloaded
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Pallavi.Arora\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //maximizing the window which opens
        driver.manage().window().maximize();
        //deleting all the cookies and cache
        driver.manage().deleteAllCookies();
        //adding pageLoadTimeout of 30secs so that the page is fully loaded before performing any action
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

        //1. getting url
        driver.get("https://chercher.tech/practice/practice-pop-ups-selenium-webdriver");

        //2. accepting alert
        driver.findElement(By.name("alert")).click();
        Alert alert = driver.switchTo().alert();
        Thread.sleep(1000);
        alert.accept();

        //3. getting text from confirmation box and cancelling it
        driver.findElement(By.name("confirmation")).click();
        Alert alert1 = driver.switchTo().alert();
        Thread.sleep(1000);
        String alerttext = alert1.getText();
        System.out.println(alerttext);
        alert1.dismiss();

        //4. sending name in prompt and accepting it
        driver.findElement(By.name("prompt")).click();
        Alert alert2 = driver.switchTo().alert();
        alert2.sendKeys("Pallavi");
        Thread.sleep(1000);
        alert2.accept();

        //5. double-clicking and accepting the alert
        Actions action = new Actions(driver);
        action.doubleClick(driver.findElement(By.id("double-click"))).perform();
        Alert alert3 = driver.switchTo().alert();
        System.out.println(alert3.getText());
        Thread.sleep(1000);
        alert3.accept();

        //6. hover and click on Google
        WebElement hover = driver.findElement(By.id("sub-menu"));
        Actions action1 = new Actions(driver);
        action1.moveToElement(hover).perform();
        driver.findElement(By.id("link2")).click();

        driver.quit();
    }
}
