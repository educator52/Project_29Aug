package poms;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CountryPOM extends BasePOM{

    public By setupMenuLocator = By.xpath("//span[text()='Setup']");
    public By parametersMenuLocator = By.xpath("//span[text()='Parameters']");
    public By countriesMenuLocator = By.xpath("//span[text()='Countries']");
    public By citiesMenuLocator = By.xpath("//span[text()='Cities']");
    public By citizenshipMenuLocator = By.xpath("//span[text()='Citizenships']");
    public By feeMenuLocator = By.xpath("//span[text()='Fees']");
    public By discountMenuLocator = By.xpath("//span[text()='Discounts']");
    public By nationalityMenuLocator = By.xpath("//span[text()='Nationalities']");
    public By documentMenuLocator = By.xpath("//span[text()='Document Types']");



    @FindBy(css = "[formgroupname=\"country\"]")
    public WebElement countryDropDawnElement;

}
