package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class VatCalculatorPage {

    WebDriver driver;

    By countryDropdown = By.name("Country");
    By netAmount = By.id("NetPrice");
    By vatAmount = By.id("VATsum");
    By grossAmount = By.id("Price");
    By errorMessage = By.xpath("//div[@id='google-visualization-errors-2']/span");


    public VatCalculatorPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectCountry(String country) {
        driver.findElement(countryDropdown).sendKeys(country);
    }

    public void selectVATRate(String xpath) {
        WebElement vatRateElement = driver.findElement(By.xpath(xpath));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", vatRateElement);
    }

    public void enterAmount(String amount) {
        driver.findElement(netAmount).clear();
        driver.findElement(netAmount).sendKeys(amount);
    }

    public void verifyVATAmount(String expectedVat) {
        String vatValue = driver.findElement(vatAmount).getAttribute("value");
        Assert.assertEquals(vatValue, expectedVat, "Incorrect VAT amount");
    }

    public void verifyGrossAmount(String expectedGross) {
        String grossValue = driver.findElement(grossAmount).getAttribute("value");
        Assert.assertEquals(grossValue, expectedGross, "Incorrect Gross amount");
    }

    public void verifyErrorMessage(String expectedText) {
        String errorMsg = driver.findElement(errorMessage).getText().toLowerCase();
        Assert.assertTrue(errorMsg.contains(expectedText.toLowerCase()));
    }
}
