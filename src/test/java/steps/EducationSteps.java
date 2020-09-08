package steps;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.testng.Assert;
import poms.EducationPOM;

public class EducationSteps {

    EducationPOM pom = new EducationPOM();

    @Given("^I navigate to \"([^\"]*)\" screen in Education$")
    public void iNavigateToScreenInEducation(String screenName){
        pom.waitAndClick(pom.educationMenuLocator);
        pom.waitAndClick(pom.setupEduMenuElement);
        switch (screenName) {
            case "subject categories":
                pom.waitAndClick(pom.subjectCategoriesMenuLocator);
                break;
            case "subjects":
                pom.waitAndClick(pom.subjectsMenuLocator);
                break;
            default:
                Assert.fail(screenName + " pom is not implement!");
        }
        pom.waitLeastTwoElements(pom.menuRowsLocator);
    }


    @When("^I create a \"([^\"]*)\" category with \"([^\"]*)\" code$")
    public void iCreateACategory(String categoryName, String code) {
        pom.waitAndClick(pom.createButtonElement);
        pom.waitAndSendKeys(pom.nameInputElement, categoryName);
        pom.waitAndSendKeys(pom.codeInputElement, code);
        pom.waitAndClick(pom.saveButtonElement);
    }


    @When("^I create a \"([^\"]*)\" subject with \"([^\"]*)\" code in \"([^\"]*)\"$")
    public void iCreateACategoryWithCodeIn(String subjectName, String code, String categoryName) {
        pom.waitAndClick(pom.createButtonElement);
        pom.waitAndSendKeys(pom.nameInputElement, subjectName);
        pom.waitAndSendKeys(pom.codeInputElement, code);

        pom.waitAndClick(pom.subjectCategoryDropDawnElement);
        pom.waitAndClickItemByVisibleText(categoryName);

        pom.waitAndClick(pom.saveButtonElement);
    }

    @And("^I click to subjects$")
    public void iClickToSubjects() {
        pom.waitAndClick(pom.subjectsMenuLocator);
        pom.waitLeastTwoElements(pom.menuRowsLocator);
    }
}
