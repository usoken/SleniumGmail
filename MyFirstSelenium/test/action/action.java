package MyFirstSelenium.test.action;

import MyFirstSelenium.test.action.cssSelectors.selectors;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.concurrent.TimeUnit;

public class action extends selectors {

  WebDriver driver;
  String MyEmailAddress = "kaimongw@gmail.com";

  public void navigate2URL(String url) {
    //open firefox
    System.setProperty("webdriver.gecko.driver", "/Users/Chalmer/Desktop/selenium/geckodriver");
    driver = new FirefoxDriver();

    //navigate to Gmail login page
    driver.navigate().to(url);
  }

  public void waitASecond(int sec) {
    driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
  }


  public void visible(String component, int sec) {
    WebDriverWait wait = new WebDriverWait(driver, sec);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(component)));
  }

  public void login() {
    //send email account
    driver.findElement(By.cssSelector(emailAddress)).sendKeys(MyEmailAddress);

    //click on "Next" button
    driver.findElement(By.cssSelector(nextButton1)).click();

    //wait until element is visible
    visible(password, 30);

    //send password
    driver.findElement(By.cssSelector(password)).sendKeys("moemoe2sky");

    //click on "Next" button
    driver.findElement(By.cssSelector(nextButton2)).click();
  }



  public void validCompose() {
    //click on "compose" to compose a new message
    visible(compose, 60);
    driver.findElement(By.cssSelector(compose)).click();

    //"To" with a invalid email address
    waitASecond(3);
    visible(to, 30);
    driver.findElement(By.cssSelector(to)).sendKeys("kaimongw@gmail.com");
    driver.findElement(By.cssSelector(to)).sendKeys(Keys.ENTER);

    //"Subject"
    waitASecond(10);
    visible(subject, 30);
    driver.findElement(By.cssSelector(subject)).sendKeys("My First Selenium");

    //"Content Body"
    waitASecond(3);
    visible(contentBody, 10);
    driver.findElement(By.cssSelector(contentBody)).sendKeys("Hello ALL");
    //insert emoji
    driver.findElement(By.cssSelector(contentBody)).sendKeys("\uD83D\uDE0B\uD83D\uDE0C\uD83D\uDE06\uD83D\uDE05");
//    upload image
//    driver.findElement(By.cssSelector(fileUpload)).sendKeys("/Users/Chalmer/IdeaProjects/Selenium_Guru99/googleEg.jpg");


    waitASecond(3);
    visible(sendButton, 15);
    driver.findElement(By.cssSelector(sendButton)).click();
//
//

  }

  public void invalidEmailAddress() {
    visible(compose, 60);
    driver.findElement(By.cssSelector(compose)).click();

    //"To" with a invalid email address
    waitASecond(3);
    visible(to, 30);
    driver.findElement(By.cssSelector(to)).sendKeys("k");

    //"Subject"
    waitASecond(10);
    visible(subject, 30);
    driver.findElement(By.cssSelector(subject)).sendKeys("My First Selenium");

    //Handling invalid pop up window
    waitASecond(10);
    visible(sendButton, 30);
    driver.findElement(By.cssSelector(sendButton)).click();
    waitASecond(60);
    String MainWindow = driver.getWindowHandle();
    driver.switchTo().window(MainWindow);
    visible(ok,30);
    driver.findElement(By.cssSelector(ok)).click();


  }

  public void closeDriver() {
    waitASecond(60);
    driver.close();
  }


}
