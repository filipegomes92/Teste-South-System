package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/reports/cucumberReport.json","html:target/reports/"},
        features = "src/test/resources/features",
        tags = {"~@Ignore"},
        glue = {"steps"}

)
public class RunCucumberTest {

    public static WebDriver driver;

    @BeforeClass
    public static void abreNavegador(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @AfterClass
    public static void encerraNavegador(){
        driver.quit();
    }

}
