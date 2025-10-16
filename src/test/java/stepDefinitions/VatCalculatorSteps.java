package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pages.VatCalculatorPage;

import java.time.Duration;

public class VatCalculatorSteps {
    WebDriver driver;
    VatCalculatorPage vatPage;

    @Given("user is on the VAT Calculator webpage")
    public void openVatCalculatorPage() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.calkoo.com/?lang=3&page=8");
        vatPage = new VatCalculatorPage(driver);
    }

    @When("user selects country {string}")
    public void user_select_country(String country) {
        vatPage.selectCountry(country);
    }

    @When("user selects VAT rate {string}")
    public void user_select_vat_rate(String vatRate) {
        String xpath = String.format("//input[@value='%s']", vatRate);
        vatPage.selectVATRate(xpath);
    }

    @When("user enters net amount {string}")
    public void user_enter_net_amount(String amount) {
        vatPage.enterAmount(amount);
    }

    @Then("VAT amount should be {string}")
    public void vat_amount_should_be(String expectedVat) {
        vatPage.verifyVATAmount(expectedVat);
    }

    @Then("Gross amount should be {string}")
    public void verifyGrossAmount(String expectedGross) {
        vatPage.verifyGrossAmount(expectedGross);
        driver.quit();
    }

    @Then("error message should contain {string}")
    public void verifyErrorMessage(String expectedText) {
        vatPage.verifyErrorMessage(expectedText);
        driver.quit();
    }
}
