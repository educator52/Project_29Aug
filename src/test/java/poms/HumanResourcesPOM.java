package poms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HumanResourcesPOM extends BasePOM{


    public By humanResourcesMenuLocator = By.xpath("//*[contains(text(),\"Human Resources\")]");
    public By setupHumanResourcesMenuLocator = By.cssSelector("[class*=\"nav-item ng-star-inserted open\"] .nav-collapsable");
    public By positionSalaryMenuLocator = By.xpath("//*[text()='Position Salary']");
    public By positionsMenuLocator = By.xpath("//*[text()='Positions']");
    public By salaryTypesMenuLocator = By.xpath("//*[text()='Salary Types']");
    public By salaryModifiersMenuLocator = By.xpath("//*[text()='Salary Modifiers']");
    public By salaryConstantMenuLocator = By.xpath("//*[text()='Salary Constants']");


    @FindBy(css = "#ms-text-field-0 input")
    public WebElement nameInputElement;

    @FindBy(css = "[id*=\"ms-text-field\"] .ng-invalid")
    public WebElement nameInputElement2;

    @FindBy(id = "mat-input-5")
    public WebElement nameInputElement3;

    @FindBy(css = "#ms-text-field-1 input")
    public WebElement nameInputElement4;

    @FindBy(css = "#ms-text-field-3 input")
    public WebElement shortNameInputElement;

    @FindBy(css = "[id*=\"ms-text-field\"] input")
    public WebElement searchTextBoxElement1;

    @FindBy(id = "mat-input-4")
    public WebElement searchTextBoxElement2;

    @FindBy(tagName = "ms-search-button")
    public WebElement searchButtonElement1;

    @FindBy(css = "[class=\"control-full mat-form-button\"] span")
    public WebElement searchButtonElement2;

    @FindBy(id = "mat-input-6")
    public WebElement descriptionTextBoxElement;

    @FindBy(css = "input[name=\"variable\"]")
    public WebElement variableTextBoxElement;

    @FindBy(css = "input[name=\"priority\"]")
    public WebElement priorityTextBoxElement;

    @FindBy(css = "input[data-placeholder=\"Amount\"]")
    public WebElement amountTextBoxElement;

    @FindBy(css = "[data-icon=\"save\"]")
    public WebElement saveButtonElement;

    @FindBy(css = "ms-edit-button > button")
    public WebElement editButtonElement;

    @FindBy(css = "#mat-chip-list-input-0")
    public WebElement salaryTypeDropDawnElement;

    @FindBy(id = "mat-input-7")
    public WebElement validFromTextboxElement;

    @FindBy(css = "#ms-text-field-0 input")
    public WebElement keyTextboxElement;

    @FindBy(css = "#ms-integer-field-0 input")
    public WebElement valueTextboxElement;

    @FindBy(css = "[aria-label=\"Open calendar\"]")
    public WebElement openClendarButtonElement;

    @FindBy(xpath = "//div[contains(text(),\"16\")]")
    public WebElement dayOnCalendarElement;


}
