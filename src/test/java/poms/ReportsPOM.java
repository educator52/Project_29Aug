package poms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ReportsPOM extends BasePOM {

    public By reportsMenuLocator = By.cssSelector("[class=\"nav-link-title ng-tns-c101-31 ng-star-inserted\"]");
    public By exelTemplateMenuLocator = By.xpath("//*[text()='Excel Template']");

    @FindBy(css = ".ng-tns-c101-32  span.ng-tns-c101-32")
    public WebElement setupReportsElement;

    @FindBy(css="[class=\"ng-fa-icon\"] [data-icon=\"times-square\"]")
    public WebElement closeButton;




}
