package com.wrike;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by Daniil on 20.09.2019.
 */
public class FirstTest {

    @Test
    public void firstTest() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver" , "C:/Users/Даниил/Downloads/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        // 1 //
        driver.get("https://www.wrike.com");
        // 2 //
        driver.findElement(By.xpath("/html/body/div[1]/header/div[3]/div[2]/div/div/div[2]/div/form/button")).click();
        // 3 //
        String generatedString = RandomStringUtils.randomAlphabetic(10);
        String email = generatedString;
        driver.findElement(By.xpath("//*[@id=\"modal-pro\"]/form/label[1]/input")).sendKeys(email + "+wpt@wriketask.qa");
        // 4 //
        driver.findElement(By.xpath("//*[@id=\"modal-pro\"]/form/label[2]/button")).click();
        WebDriverWait wait = new WebDriverWait(driver , 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/main/div/div/div[2]/div/div[1]/h1")));
        String title = driver.getTitle();
        Assert.assertTrue(title.equals("Thank you for choosing Wrike!"));
        // 5 //
        WebElement but1 = driver.findElement(By.xpath("/html/body/div[1]/main/div/div/div[2]/div/div[2]/div/form/div[1]/label[1]/button"));
        WebElement but2 = driver.findElement(By.xpath("/html/body/div[1]/main/div/div/div[2]/div/div[2]/div/form/div[1]/label[2]/button"));
        WebElement but3 = driver.findElement(By.xpath("/html/body/div[1]/main/div/div/div[2]/div/div[2]/div/form/div[2]/label[3]/button"));
        WebElement but4 = driver.findElement(By.xpath("/html/body/div[1]/main/div/div/div[2]/div/div[2]/div/form/div[2]/label[4]/button"));
        WebElement but5 = driver.findElement(By.xpath("/html/body/div[1]/main/div/div/div[2]/div/div[2]/div/form/div[2]/label[5]/button"));
        List<WebElement> two_buttons = Arrays.asList(but1 , but2);
        Random random = new Random();
        two_buttons.get(random.nextInt(two_buttons.size())).click();
        but1 = driver.findElement(By.xpath("/html/body/div[1]/main/div/div/div[2]/div/div[2]/div/form/div[2]/label[1]/button"));
        but2 = driver.findElement(By.xpath("/html/body/div[1]/main/div/div/div[2]/div/div[2]/div/form/div[2]/label[2]/button"));
        List<WebElement> five_buttons = Arrays.asList(but1 , but2 , but3 , but4 , but5);
        five_buttons.get(random.nextInt(five_buttons.size())).click();
        but1 = driver.findElement(By.xpath("/html/body/div[1]/main/div/div/div[2]/div/div[2]/div/form/div[3]/label[1]/button"));
        but2 = driver.findElement(By.xpath("/html/body/div[1]/main/div/div/div[2]/div/div[2]/div/form/div[3]/label[2]/button"));
        but3 = driver.findElement(By.xpath("/html/body/div[1]/main/div/div/div[2]/div/div[2]/div/form/div[3]/label[3]/button"));
        List<WebElement> three_buttons = Arrays.asList(but1 , but2 , but3);
        WebElement button = three_buttons.get(random.nextInt(three_buttons.size()));
        button.click();
        if (button.equals(but3)) driver.findElement(By.xpath("//html/body/div[1]/main/div/div/div[2]/div/div[2]/div/form/div[3]/label[3]/button/span/input")).sendKeys(email);
        driver.findElement(By.xpath("/html/body/div[1]/main/div/div/div[2]/div/div[2]/div/form/button")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/main/div/div/div[2]/div/div[2]/div/div")));
        // 6 //
        WebElement twit_but = driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div/div[1]/div/ul/li[1]"));
        twit_but.isDisplayed();
        twit_but.click();
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "https://twitter.com/wrike" );
        driver.quit();

    }
}
