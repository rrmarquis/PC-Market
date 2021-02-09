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

public class ListRAM {
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
  public void testBuyGPU() throws Exception {
	UtilDBPCMarket.clearDB();
    driver.get("http://ec2-3-82-116-24.compute-1.amazonaws.com:8080/PCMarket/Account.jsp");
    driver.findElement(By.name("email")).sendKeys("pcmarketuser1@gmail.com");
    driver.findElement(By.name("password")).sendKeys("pcmarket");
    driver.findElement(By.xpath("//input[@value='login']")).click();
    driver.findElement(By.xpath("//html")).click();
    driver.findElement(By.xpath("//button")).click();
    driver.findElement(By.xpath("(//input[@name='modelName'])[5]")).sendKeys("G. Skills Ripjaw V Series");
    driver.findElement(By.name("type")).clear();
    driver.findElement(By.name("type")).sendKeys("DDR4");
    driver.findElement(By.name("capacity")).sendKeys("16 GB");
    driver.findElement(By.name("speed")).sendKeys("3200");
    driver.findElement(By.xpath("(//input[@value='sell'])[5]")).click();
    driver.findElement(By.name("price")).sendKeys("200");
    driver.findElement(By.xpath("//input[@value='Sell']")).click();
    driver.findElement(By.xpath("//button")).click();
    driver.findElement(By.xpath("//li")).click();
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
