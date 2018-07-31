package smp.cucumber;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.hamcrest.CoreMatchers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertThat;

public class Stepdefs {
    WebDriver driver;

    @Given("^Google troubleshoot$")
    public void hsiTroubleshoot() {
        System.setProperty("webdriver.chrome.driver", "target/tmp_webdrivers/chromedriver-mac-64bit");
        driver = new ChromeDriver();
        driver.get("http://www.google.com");
    }

    @When("^Input appears$")
    public void input() {
        WebElement element = driver.findElement(By.name("q"));

        element.sendKeys("Real");
        element.submit();
    }

    @Then("^Title contains \"([^\"]*)\"$")
    public void i_should_be_told(String expectedAnswer) {
        System.out.println("Google title: " + driver.getTitle());
        assertThat(driver.getTitle(), CoreMatchers.containsString(expectedAnswer));
    }

    @Then("Close")
    public void close() {
        driver.close();

    }
}