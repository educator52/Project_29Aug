package steps;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import poms.BasePOM;
import poms.HumanResourcesPOM;

import java.util.List;
import java.util.Map;

public class HumanResourcesSteps {

    HumanResourcesPOM pom = new HumanResourcesPOM();

    @Given("^I navigate to \"([^\"]*)\" screen in Human Resources$")
    public void iNavigateToScreenInHumanResources(String screenName){
        pom.waitAndClick(pom.humanResourcesMenuLocator);
        pom.waitAndClick(pom.setupHumanResourcesMenuLocator);
        switch (screenName) {
            case "salary constants":
                pom.waitAndClick(pom.salaryConstantMenuLocator);
                break;
            case "position salary":
                pom.waitAndClick(pom.positionSalaryMenuLocator);
                break;
            case "positions":
                pom.waitAndClick(pom.positionsMenuLocator);
                break;
            case "salary types":
                pom.waitAndClick(pom.salaryTypesMenuLocator);
                break;
            case "salary modifiers":
                pom.waitAndClick(pom.salaryModifiersMenuLocator);
                break;
            default:
                Assert.fail(screenName + " pom is not implement!");
        }
        pom.waitLeastTwoElements(pom.menuRowsLocator);

    }

    @When("^I create a \"([^\"]*)\" position salary$")
    public void iCreateAPositionSalary(String positionSalaryName){
        pom.waitAndClick(pom.createButtonElement);
        pom.waitAndSendKeys(pom.nameInputElement, positionSalaryName);
        pom.waitAndClick(pom.saveButtonElement);
    }

    @And("^\"([^\"]*)\" doesn't exist in \"([^\"]*)\" table$")
    public void doesnTExistInTable(String entityName, String type) {
        switch (type) {
            case "Type 1":
                pom.searchFor(entityName, pom.searchTextBoxElement1, pom.searchButtonElement1);
                break;
            case "Type 2":
                pom.searchFor(entityName, pom.searchTextBoxElement2, pom.searchButtonElement1);
                break;
            case "Type 3":
                pom.searchFor(entityName, pom.searchTextBoxElement2, pom.searchButtonElement2);
                break;
            case "Type 4":
                pom.waitAndSendKeys(pom.searchTextBoxElement2, entityName);
                pom.pressEnterKey();
                pom.waitForProgressBar();
                break;
            default:
                Assert.fail(type + " pom is not implement!");
        }
        pom.deleteAllElementsFromTable();
    }

    @When("^I edit  \"([^\"]*)\" to \"([^\"]*)\" in \"([^\"]*)\" table$")
    public void editPosition(String oldPosition, String newPosition, String type){
        switch (type) {
            case "Type 6":
                pom.searchFor(oldPosition, pom.searchTextBoxElement1, pom.searchButtonElement1);
                pom.waitAndClick(pom.editButtonElement);
                pom.waitAndSendKeys(pom.nameInputElement4, newPosition);
                break;
            case "Type 5":
                pom.searchFor(oldPosition, pom.searchTextBoxElement2, pom.searchButtonElement1);
                pom.waitAndClick(pom.editButtonElement);
                pom.waitAndSendKeys(pom.nameInputElement3, newPosition);
                break;
            case "Type 4":
                pom.waitAndSendKeys(pom.searchTextBoxElement2, oldPosition);
                pom.pressEnterKey();
                pom.waitForProgressBar();
                pom.waitAndClick(pom.editButtonElement);
                pom.waitAndSendKeys(pom.descriptionTextBoxElement, newPosition);
                break;
            case "Type 3":
                pom.searchFor(oldPosition, pom.searchTextBoxElement2, pom.searchButtonElement2);
                pom.waitAndClick(pom.editButtonElement);
                pom.waitAndSendKeys(pom.nameInputElement, newPosition);
                break;
            case "Type 2":
                pom.searchFor(oldPosition, pom.searchTextBoxElement2, pom.searchButtonElement1);
                pom.waitAndClick(pom.editButtonElement);
                pom.waitAndSendKeys(pom.nameInputElement, newPosition);
                break;
            case "Type 1":
                pom.searchFor(oldPosition, pom.searchTextBoxElement1, pom.searchButtonElement1);
                pom.waitAndClick(pom.editButtonElement);
                pom.waitAndSendKeys(pom.nameInputElement2, newPosition);
                break;
            default:
                Assert.fail(type + " pom is not implement!");
        }
        pom.waitAndClick(pom.saveButtonElement);
    }

    @When("^I delete \"([^\"]*)\" item from \"([^\"]*)\" table$")
    public void iDeleteItemFromHumanResources(String itemName, String type){
        switch (type) {
            case "Type 4":
                pom.waitAndSendKeys(pom.searchTextBoxElement2, itemName);
                pom.pressEnterKey();
                pom.waitForProgressBar();
                break;
            case "Type 3":
                pom.searchFor(itemName, pom.searchTextBoxElement2, pom.searchButtonElement2);
                break;
            case "Type 2":
                pom.searchFor(itemName, pom.searchTextBoxElement2, pom.searchButtonElement1);
                break;
            case "Type 1":
                pom.searchFor(itemName, pom.searchTextBoxElement1, pom.searchButtonElement1);
                break;
            default:
                Assert.fail(type + " pom is not implement!");
        }
        pom.deleteAllElementsFromTable();
    }

    @Then("^Table doesn't contain \"([^\"]*)\"$")
    public void tableDoesnTContain(String entityName){
        pom.searchFor(entityName, pom.searchTextBoxElement2, pom.searchButtonElement1);
        int numberOfElements = pom.getNumberOfElements(pom.rowLocator);
        Assert.assertEquals(numberOfElements, 0, "expecting number of entities to be zero");
    }

    @When("^I create a \"([^\"]*)\" position with \"([^\"]*)\" short name\\.$")
    public void iCreateAPositionWithShortName(String positionName, String shortName) {
        pom.waitAndClick(pom.createButtonElement);
        pom.waitAndSendKeys(pom.nameInputElement2, positionName);
        pom.waitAndSendKeys(pom.shortNameInputElement, shortName);
        pom.waitAndClick(pom.saveButtonElement);
    }

    @When("^I create a \"([^\"]*)\" as \"([^\"]*)\" role$")
    public void iCreateAAsA(String salaryType, String role) {
        pom.waitAndClick(pom.createButtonElement);
        pom.waitAndSendKeys(pom.nameInputElement, salaryType);
        pom.waitAndClick(pom.salaryTypeDropDawnElement);
        pom.waitAndClickItemByVisibleText(role);
        pom.waitAndClick(pom.saveButtonElement);
    }


    @When("^I create a \"([^\"]*)\"$")
    public void iCreateA(String description, DataTable table) {
        pom.waitAndClick(pom.createButtonElement);
        pom.waitAndSendKeys(pom.descriptionTextBoxElement, description);

        List<Map<String, String>> mapList = table.asMaps(String.class, String.class);
        for ( Map<String, String> row: mapList) {
            for (String key: row.keySet()) {
                enterDataTo(key,row.get(key));
            }
        }

        pom.waitAndClick(pom.saveButtonElement);
    }

    public void enterDataTo(String menu, String value) {
        switch (menu.toLowerCase()) {
            case "variable":
                pom.waitAndSendKeys(pom.variableTextBoxElement, value);
                break;
            case "priority":
                pom.waitAndSendKeys(pom.priorityTextBoxElement, value);
                break;
            case "amount":
                pom.waitAndSendKeys(pom.amountTextBoxElement, value);
                break;
            case "valid from":
                String day = value.substring(3,5);
                pom.waitAndClick(pom.validFromTextboxElement);
                pom.waitAndSendKeys(pom.validFromTextboxElement, value);
                pom.pressDayOnCalendar(day);
                break;
            case "key":
                pom.waitAndSendKeys(pom.keyTextboxElement, value);
                break;
            case "value":
                pom.waitAndSendKeys(pom.valueTextboxElement, value);
                break;
            default:
                Assert.fail(menu + " not yet implemented!");
        }
    }


    @When("^I create a \"([^\"]*)\" salary constant$")
    public void createSalaryConstant(String constantName, DataTable table ) {
        pom.waitAndClick(pom.createButtonElement);
        pom.waitAndSendKeys(pom.descriptionTextBoxElement, constantName);

        Map<String, String> map = table.asMap(String.class, String.class);
        for (String key: map.keySet()) {
            enterDataTo(key,map.get(key));
        }

        pom.waitAndClick(pom.saveButtonElement);
    }
}
