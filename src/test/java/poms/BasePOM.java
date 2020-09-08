package poms;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ThreadLocalBaseDriver;

import java.util.List;

public class BasePOM {
    protected WebDriverWait wait;
    protected WebDriver driver;

    public BasePOM() {
        driver = ThreadLocalBaseDriver.getDriver();
        wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public By progressBarLocator = By.tagName("mat-progress-bar");
    public By rowLocator = By.cssSelector("ms-browse-table tbody > tr");
    public By deleteButtonLocator = By.cssSelector("ms-delete-button > button");
    public By menuRowsLocator = By.cssSelector("[role=\"row\"]");
    public By alertDialogLocator = By.cssSelector("div[role='alertdialog']");
    public By errorDialogLocator = By.xpath("//*[contains(text(), \"Error!\")]");

    @FindBy(css = "ms-browse-table tbody > tr")
    public List<WebElement> rowElement;

    @FindBy(css = "mat-dialog-actions button[type='submit']")
    public WebElement dialogSubmitButtonElement;

    @FindBy(css = "ms-search-button button")
    public WebElement searchButtonElement;

    @FindBy(css = "[id*=\"ms-text-field\"] input")
    public WebElement nameSearchElement;

    @FindBy(css = "span svg[data-icon=\"plus\"]")
    public WebElement createButtonElement;

    @FindBy(css = "[formcontrolname=\"name\"] > input")
    public WebElement nameInputElement;

    @FindBy(css = "[id*=\"ms-text-field\"] .ng-invalid")
    public WebElement codeInputElement;

    @FindBy(tagName = "ms-save-button")
    public WebElement saveButtonElement;

    @FindBy(css = "[aria-label=\"dismiss cookie message\"]")
    public WebElement cookiesElement;

    public void waitAndClickItemByVisibleText(String itemName) {
        waitAndClick(By.xpath("//span[contains(text(),\"" + itemName + "\")]"));
    }

    public void waitLeastTwoElements(By locator) {
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(locator, 1));
    }

    public void waitLeastOneElement(By locator) {
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(locator, 0));
    }

    public void waitAndClick(By locator) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).click();
    }

    public void waitAndClick(WebElement element) {
        WebElement webElement = wait.until(ExpectedConditions.visibilityOf(element));
        webElement.click();
    }

    public void waitAndSendKeys(By locator, String text) {
        WebElement webElement = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        webElement.clear();
        webElement.sendKeys(text);
    }

    public void waitAndSendKeys(WebElement element, String text) {
        WebElement webElement = wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
        element.clear();
        element.sendKeys(text);
    }

    public String waitAndGetText(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
    }

    public String getText(WebElement element) {
        return element.getText();
    }

    public void waitForProgressBar() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(progressBarLocator));
            wait.until(ExpectedConditions.invisibilityOfElementLocated(progressBarLocator));
        } catch (TimeoutException e) {
            System.out.println("There's no progress bar continue");
        }
    }

    public void searchFor(String searchText) {
        waitAndSendKeys(nameSearchElement, searchText);
        waitAndClick(searchButtonElement);
        waitForProgressBar();
    }

    public void searchFor(String searchText, WebElement searchTextBoxElement, WebElement searchButtonElement) {
        waitAndSendKeys(searchTextBoxElement, searchText);
        waitAndClick(searchButtonElement);
        waitForProgressBar();

    }

    public Integer getNumberOfElements(By locator) {
        return driver.findElements(locator).size();
    }

    public void pressTabKey() {
        Actions build = new Actions(driver);
        build.sendKeys(Keys.TAB).build().perform();
    }

    public void pressEnterKey() {
        Actions build = new Actions(driver);
        build.sendKeys(Keys.ENTER).build().perform();
    }

    public void deleteAllElementsFromTable() {
        List<WebElement> elements = rowElement;
        int numberOfElements = elements.size();
        while (numberOfElements > 0) {
            deleteFirstElementFromTable();
            wait.until(ExpectedConditions.numberOfElementsToBeLessThan(rowLocator, numberOfElements));
            numberOfElements = driver.findElements(rowLocator).size();
        }
    }

    public void deleteFirstElementFromTable() {
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(rowLocator, 0));
        List<WebElement> elements = rowElement;
        elements.get(0).findElement(deleteButtonLocator).click();
        waitAndClick(dialogSubmitButtonElement);
        try {
            waitAndClick(alertDialogLocator);
        } catch (Exception e) {
        }

    }

    public void pressDayOnCalendar(String day) {
        driver.findElement(By.xpath("//div[contains(text(),\"" + day + "\")]")).click();
    }

    public boolean hasNameOnTheTable(String text) {
        searchFor(text);
        List<WebElement> elements = driver.findElements(rowLocator);
        if(elements.size()!=0)
            for(WebElement element:elements){
                if(element.getText().contains(text))
                    return true;
            }
        return false;
    }

}
