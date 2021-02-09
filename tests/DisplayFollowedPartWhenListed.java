package tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import util2.UtilDBPCMarket;

public class DisplayFollowedPartWhenListed {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\brady\\Desktop\\CSCI4830\\chromedriver_win32\\chromedriver.exe");
	driver = new ChromeDriver();
    baseUrl = "https://www.google.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testDisplayFollowedPartWhenListed() throws Exception {
	UtilDBPCMarket.clearDB(); 
    driver.get("http://ec2-3-82-116-24.compute-1.amazonaws.com:8080/PCMarket/Sell.jsp");
    driver.findElement(By.name("email")).sendKeys("pcmarketuser1@gmail.com");
    driver.findElement(By.name("password")).sendKeys("pcmarket");
    driver.findElement(By.xpath("//input[@value='login']")).click();
    driver.findElement(By.xpath("(//input[@name='modelName'])[3]")).sendKeys("Hard Drive");
    driver.findElement(By.name("storage")).sendKeys("2");
    driver.findElement(By.name("rpm")).sendKeys("2");
    driver.findElement(By.xpath("(//input[@value='sell'])[3]")).click();
    driver.findElement(By.name("price")).sendKeys("2");
    driver.findElement(By.xpath("//input[@value='Sell']")).click();
    driver.findElement(By.xpath("//div")).click();
    driver.findElement(By.xpath("//button")).click();
    driver.findElement(By.xpath("//div[4]/a/button")).click();
    driver.findElement(By.name("email")).sendKeys("pcmarketuser1@gmail.com");
    driver.findElement(By.name("password")).sendKeys("pcmarket");
    driver.findElement(By.xpath("//input[@value='login']")).click();
    driver.findElement(By.xpath("//ul[3]/a/li")).click();
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("email")).sendKeys("pcmarketuser1@gmail.com");
    driver.findElement(By.name("password")).sendKeys("pcmarket");
    driver.findElement(By.xpath("//input[@value='login']")).click();
    driver.findElement(By.xpath("//div[3]/div[2]/a/button")).click();
    driver.findElement(By.name("type")).sendKeys("1");
    driver.findElement(By.name("capacity")).sendKeys("1");
    driver.findElement(By.name("speed")).sendKeys("1");
    driver.findElement(By.xpath("(//input[@name='price'])[5]")).sendKeys("1");
    driver.findElement(By.xpath("(//input[@value='Create'])[5]")).click();
    driver.findElement(By.xpath("//button")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
