package poms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EducationPOM extends BasePOM{

    public By educationMenuLocator = By.xpath("//*[contains(text(),\"Education\")]");
    public By setupEduMenuLocator = By.cssSelector("[class=\"ng-fa-icon nav-link-icon ng-tns-c101-33 ng-star-inserted\"]+span");
    public By subjectCategoriesMenuLocator = By.xpath("//*[text()='Subject Categories']");
    public By subjectsMenuLocator = By.xpath("//*[text()='Subjects']");

    @FindBy(xpath = "//span[text()='Education']//following::span[1]")
    public WebElement setupEduMenuElement;

    @FindBy(css = "[formgroupname=\"subjectCategory\"]")
    public WebElement subjectCategoryDropDawnElement;


}
