package steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import poms.BudgetPOM;

import java.util.Map;

public class BudgetSteps {

    BudgetPOM pom = new BudgetPOM();

    @Given("^I navigate to \"([^\"]*)\" screen in Budget$")
    public void navigateToBudget(String screenName) {
        pom.waitAndClick(pom.budgetMenuLocator);
        pom.waitAndClick(pom.setupBudgetMenuLocator);
        switch (screenName.toLowerCase()) {
            case "budget groups":
                pom.waitAndClick(pom.budgetGroupsMenuLocator);
                break;
            case "cost centers":
                pom.waitAndClick(pom.cocstCentersMenuLocator);
                break;

            default:
                Assert.fail(screenName + " pom is not implement!");
        }
        pom.waitLeastOneElement(pom.menuRowsLocator);
    }

    @When("^I create a \"([^\"]*)\" in budget groups$")
    public void createBudgetGroups(String description, DataTable table) {
        pom.waitAndClick(pom.createButtonElement);
        pom.waitAndSendKeys(pom.descriptionTextBoxElement, description);

        Map<String, String> map = table.asMap(String.class, String.class);
        for (String key: map.keySet()) {
            enterDataTo(key,map.get(key));
        }

        pom.waitAndClick(pom.saveButtonElement);

    }

    public void enterDataTo(String menu, String value) {
        String day = value.substring(3,5);
        switch (menu.toLowerCase()) {
            case "start date":
                pom.waitAndClick(pom.startDateTextboxElement);
                pom.waitAndSendKeys(pom.startDateTextboxElement, value);
                pom.pressDayOnCalendar(day);
                break;
            case "end date":

                pom.waitAndClick(pom.endDateTextboxElement);
                pom.waitAndSendKeys(pom.endDateTextboxElement, value);
                pom.pressDayOnCalendar(day);
                break;
            default:
                Assert.fail(menu + " not yet implemented!");
        }
    }

    @And("^\"([^\"]*)\" doesn't exist in budget groups table$")
    public void doesnTExistInBudgetGroupsTable(String budgetGroupName) {
        String text=null;
        WebElement element=null;
        pom.waitLeastOneElement(pom.namesCostCenterTableLocator);
        for (WebElement row:pom.rowsCostCenterTableElements) {
            try{
                element = row.findElement(pom.namesCostCenterTableLocator);
                text = pom.getText(element);
                if(text.equals(budgetGroupName)){
                    row.findElement(pom.deleteButtonLocator).click();
                    pom.waitAndClick(pom.dialogSubmitButtonElement);
                    try{
                        pom.waitAndClick(pom.alertDialogLocator);
                    } catch(Exception e){ }
                }
            }catch (org.openqa.selenium.StaleElementReferenceException e){
//                System.out.println("This exception appears but the code is working properly.");
            }
        }

    }

    @When("^I create a \"([^\"]*)\" in cost centers$")
    public void iCreateAInCostCenters(String costCenterName) {
        pom.waitAndClick(pom.createButtonElement);
        pom.waitAndSendKeys(pom.nameInputElement, costCenterName);
        pom.waitAndSendKeys(pom.codeInputElement, "Ms52");
        pom.pressTabKey();
        pom.pressEnterKey();
        pom.pressEnterKey();
        pom.waitAndSendKeys(pom.orderTextBoxElement,"123");
        pom.waitAndSendKeys(pom.prefixesTextBoxElement, "2.1 | Персонал");
        pom.pressEnterKey();
        pom.waitAndClick(pom.saveButtonElement);
    }

    @When("^I edit  \"([^\"]*)\" to \"([^\"]*)\" in budget groups table$")
    public void iEditToInBudgetGroupsTable(String oldName, String newName) throws StaleElementReferenceException {
        String text=null;
        WebElement element=null;
        pom.waitLeastOneElement(pom.namesCostCenterTableLocator);
        for (WebElement row:pom.rowsCostCenterTableElements) {
            try{
                element = row.findElement(pom.namesCostCenterTableLocator);
                text = pom.getText(element);
                if(text.equals(oldName)){
                    row.findElement(pom.editButtonLocator).click();
                    pom.waitAndSendKeys(pom.nameInputElement, newName);
                    pom.waitAndClick(pom.saveButtonElement);
                }
            }catch (org.openqa.selenium.StaleElementReferenceException e){
//                System.out.println("This exception appears but the code is working properly.");
            }
        }

    }
}
