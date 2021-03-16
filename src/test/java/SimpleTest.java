//import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;


public class SimpleTest {

    WebDriver driver;

    @BeforeEach
    void setUp(){
        //WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        //options.setCapability("acceptInsecureCerts", "true"); ---- ??? test doesn't work when this is uncommented
        options.addArguments("start-fullscreen");
        //options.setExperimentalOption("w3c", false);


        driver = new ChromeDriver(options);

        System.out.println(((HasCapabilities) driver).getCapabilities());
    }

    @AfterEach
    void tearDown(){

        driver.quit();
    }

    @Test
    void firstSeleniumTest(){
        driver.get("http://google.com");
        driver.findElement(By.name("q")).sendKeys("Selenium" + Keys.ENTER);
        Assertions.assertTrue(driver.findElement(By.cssSelector("h3")).getText().toLowerCase().contains("selenium"),"Selenium not found");
    }
}