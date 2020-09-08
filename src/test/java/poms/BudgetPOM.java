package poms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BudgetPOM extends BasePOM{


    public By budgetMenuLocator = By.xpath("//*[contains(text(),\"Budget\")]");
    public By setupBudgetMenuLocator = By.cssSelector("[class*=\"nav-item ng-star-inserted open\"] .nav-collapsable");
    public By budgetGroupsMenuLocator = By.xpath("//*[contains(text(),\"Budget Groups\")]");
    public By cocstCentersMenuLocator = By.xpath("//*[contains(text(),\"Cost Centers\")]");
    public By namesCostCenterTableLocator = By.cssSelector("tbody .mat-column-name");
    public By editButtonLocator = By.cssSelector("ms-edit-button > button");

    @FindBy(css = "#ms-text-field-3 input")
    public WebElement shortNameInputElement;

    @FindBy(id = "mat-input-5")
    public WebElement descriptionTextBoxElement;

    @FindBy(css = "[data-icon=\"save\"]")
    public WebElement saveButtonElement;

    @FindBy(id = "mat-input-7")
    public WebElement startDateTextboxElement;

    @FindBy(id = "mat-input-8")
    public WebElement endDateTextboxElement;

    @FindBy(css = "tbody [role=\"row\"]")
    public List<WebElement> rowsCostCenterTableElements;

    @FindBy(css = ".mat-tab-body-wrapper .mat-form-field-invalid")
    public WebElement typeDropDawnElement;

    @FindBy(css = "#ms-text-field-2 input")
    public WebElement orderTextBoxElement;

    @FindBy(css = "#mat-chip-list-0 input")
    public WebElement prefixesTextBoxElement;






}
