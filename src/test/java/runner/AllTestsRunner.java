package runner;

import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import utils.ThreadLocalBaseDriver;

@CucumberOptions(
        plugin = {
                "html:target/cucumber-report",
                "com.cucumber.listener.ExtentCucumberFormatter:target/extent_report/index.html"
        },
        features = {
                "src/test/java/featureFiles/CountryPart.feature",
                "src/test/java/featureFiles/EducationPart.feature",
                "src/test/java/featureFiles/humanResourcesPositionSalary.feature",
                "src/test/java/featureFiles/humanResourcesPositions.feature",
                "src/test/java/featureFiles/reportsExelTemplate.feature",
                "src/test/java/featureFiles/humanResourcesSalaryTypes.feature",
                "src/test/java/featureFiles/humanResourcesSalaryModifiers.feature",
                "src/test/java/featureFiles/humanResourcesSalaryConstants.feature",
                "src/test/java/featureFiles/budgetGroups.feature",
                "src/test/java/featureFiles/budgetCostCenters.feature",

        },
        glue = {"steps"}
)
public class AllTestsRunner extends AbstractTestNGCucumberTests {
    @Parameters("browser")
    @BeforeClass
    public void configureBrowser(@Optional("chrome") String browser) {

        ThreadLocalBaseDriver.setBrowser(browser);

    }

    @AfterClass
    public void quiteDriver() {

        ThreadLocalBaseDriver.quitDriver();

    }
    @AfterClass
    public void configReport(){
        Reporter.loadXMLConfig("src/test/java/runner/reportConfig/report.xml");
        Reporter.setSystemInfo("Author", "Mersys");
        Reporter.setSystemInfo("Application name", "Basqar");
        Reporter.setSystemInfo("Operating System", System.getProperty("os.name"));
        Reporter.setSystemInfo("Environment", "test");

    }
}
