package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import poms.CountryPOM;

public class CountrySteps {

    CountryPOM pom = new CountryPOM();

    @Given("^I navigate to \"([^\"]*)\" screen$")
    public void i_navigate_to_country_screen(String screenName) {
        pom.waitAndClick(pom.setupMenuLocator);
        pom.waitAndClick(pom.parametersMenuLocator);
        switch (screenName) {
            case "country":
                pom.waitAndClick(pom.countriesMenuLocator);
                break;
            case "cities":
                pom.waitAndClick(pom.citiesMenuLocator);
                break;
            case "citizenship":
                pom.waitAndClick(pom.citizenshipMenuLocator);
                break;
            case "fee":
                pom.waitAndClick(pom.feeMenuLocator);
                break;
            case "discount":
                pom.waitAndClick(pom.discountMenuLocator);
                break;
            case "nationality":
                pom.waitAndClick(pom.nationalityMenuLocator);
                break;
            case "document types":
                pom.waitAndClick(pom.documentMenuLocator);
                break;
            default:
                Assert.fail(screenName + " pom is not implement!");
        }
        pom.waitLeastTwoElements(pom.menuRowsLocator);
    }

    @And("^\"([^\"]*)\" entity doesn't exist in table$")
    public void entityDoesNotExist(String entityName) {
        pom.searchFor(entityName);
        pom.deleteAllElementsFromTable();
    }

    @When("^I create a \"([^\"]*)\" country$")
    public void i_create_country(String countryName) {
        pom.waitAndClick(pom.createButtonElement);
        pom.waitAndSendKeys(pom.nameInputElement, countryName);
        pom.waitAndClick(pom.saveButtonElement);
    }

    @Then("^\"([^\"]*)\" is successfully \"([^\"]*)\"$")
    public void successfully_edited(String entityName, String outcome) {
        // Bug: sometimes alert is not appearing
        String actual=null;
        try{
            actual = pom.waitAndGetText(pom.alertDialogLocator);
        } catch (Exception e){ //if dialog box does nor appears
            // here I am checking name in table
            if(pom.hasNameOnTheTable(entityName))
                System.out.println(e.getMessage());
        }

        if(!actual.isEmpty()) {
            Assert.assertEquals(actual, entityName + " successfully " + outcome);
            pom.waitAndClick(pom.alertDialogLocator);
        }
    }

    @When("^I delete \"([^\"]*)\" item$")
    public void iDeleteCountry(String itemName){
        pom.searchFor(itemName);
        pom.deleteAllElementsFromTable();
    }

    @And("^Table doesn't contain the entity by name \"([^\"]*)\"$")
    public void tableDoesNotContain(String entityName) {
        pom.searchFor(entityName);
        int numberOfElements = pom.getNumberOfElements(pom.rowLocator);
        Assert.assertEquals(numberOfElements, 0, "expecting number of entities to be zero");
    }

    @When("^I create a \"([^\"]*)\" city in the \"([^\"]*)\" country\\.$")
    public void iCreateACityInTheCountry(String cityName, String countryName) {
        pom.waitAndClick(pom.createButtonElement);

        pom.waitAndSendKeys(pom.nameInputElement, cityName);
        try{
            pom.waitAndClick(pom.countryDropDawnElement);
            pom.waitAndClickItemByVisibleText(countryName);
        }catch (Exception e){
            pom.waitAndClick(pom.countryDropDawnElement);
            pom.waitAndClickItemByVisibleText(countryName);
        }
        pom.waitAndClick(pom.saveButtonElement);
    }

    @And("^I click to cities$")
    public void iClickToCities() {
        pom.waitAndClick(pom.citiesMenuLocator);
        pom.waitLeastTwoElements(pom.menuRowsLocator);
    }

    @When("^I get the error message when I delete \"([^\"]*)\" country$")
    public void iGetTheErrorMessageWhenIDeleteCountry(String countryName)  {
        try{
            pom.searchFor(countryName);
            pom.deleteFirstElementFromTable();
        } catch (Exception e) {
            String actual = pom.waitAndGetText(pom.errorDialogLocator);
            Assert.assertTrue(actual.toLowerCase().contains("error"));
            pom.waitAndClick(pom.errorDialogLocator);
        }

    }

    @And("^I click to country$")
    public void iClickToCountry() {
        pom.waitAndClick(pom.countriesMenuLocator);
        pom.waitLeastTwoElements(pom.menuRowsLocator);
    }
}
