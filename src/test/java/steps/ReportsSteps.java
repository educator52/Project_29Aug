package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.testng.Assert;
import poms.ReportsPOM;

public class ReportsSteps {
    ReportsPOM pom = new ReportsPOM();

    @Given("^I navigate to exel template screen$")
    public void iNavigateToExelTemplateScreen() {
        pom.waitAndClick(pom.reportsMenuLocator);
        pom.waitAndClick(pom.setupReportsElement);
        pom.waitAndClick(pom.exelTemplateMenuLocator);
        pom.waitLeastTwoElements(pom.menuRowsLocator);
    }

    @When("^I create a \"([^\"]*)\" template$")
    public void iCreateATemplate(String templateName) {
        pom.waitAndClick(pom.createButtonElement);
        pom.waitAndSendKeys(pom.nameInputElement, templateName);
        pom.waitAndClick(pom.saveButtonElement);
        pom.waitAndClick(pom.closeButton);
    }
}
