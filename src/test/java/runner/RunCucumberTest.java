package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/reports/cucumberReport.json","html:target/reports/"},
        features = "src/test/resources/features",
        tags = {"~@Ignore"},
        glue = {"steps"}

)
public class RunCucumberTest {

    public static WebDriver driver;

    /*@BeforeClass
    public static void abreNavegador(){

        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }*/
    @BeforeClass
    public static void setUp() {
        String downloadFilepath = System.getProperty("downloadFilepath");
        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", downloadFilepath);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);
        options.addArguments("--no-sandbox");
        options.addArguments("--headless"); //should be enabled for Jenkins
        options.addArguments("--disable-dev-shm-usage"); //should be enabled for Jenkins
        options.addArguments("--window-size=1920x1080"); //should be enabled for Jenkins
        driver = new ChromeDriver(options);

        Point point = new Point(-1000, 0);
        String baseUrl = System.getProperty("testUrl");
        driver.get(baseUrl);
    }

    @AfterClass
    public static void encerraNavegador(){
        driver.quit();
    }

}
