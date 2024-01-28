package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class Hooks {
    private static WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(30000));
    }


    @After
    public void tearDown() {
        driver.quit();
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
