package com.tutorialsNinja.Step_Definition_Files;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login {
	public WebDriver driver;
	
	@Before
	public void loginSetup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo");
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Login")).click();
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}

	
	@Given("user navigates to LoginPage")
	public void user_navigates_to_LoginPage() {
		Assert.assertTrue(driver.findElement(By.xpath("//h2[contains(text(), 'Returning Customer')]")).isDisplayed());
	}
	
	
	@When("^user enters valid email (.*) into email textbox field$")
	public void user_enters_valid_email_into_email_textbox_field(String emailText){
		driver.findElement(By.id("input-email")).sendKeys(emailText);
	}
	
	
	@And("^user enters valid password (.*) into password textbox field$")
	public void user_enters_valid_password_into_password_textbox_field(String passwordText) {
		driver.findElement(By.id("input-password")).sendKeys(passwordText);
	}
	
	
	@And("user clicks on Login button")
	public void user_clicks_on_Login_button() {
		driver.findElement(By.cssSelector("input.btn.btn-primary")).click();	
	}
	
	@Then("user is navigated to AccountPage")
	public void user_is_navigated_to_AccountPage() {
		Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());
	}
	
	@When("user enters invalid email {string} into email textbox field")
	public void user_enters_invalid_email_into_email_textbox_field(String string) {
	    	driver.findElement(By.id("input-email")).sendKeys(string);
	}
	
	@When("user enters invalid password {string} into password textbox field")
	public void user_enters_invalid_password_into_password_textbox_field(String string) {
		driver.findElement(By.id("input-password")).sendKeys(string);
	}
	
	@Then("user gets warning message about credentials mismatch")
	public void user_gets_warning_message_about_credentials_mismatch() {
		String expectedWarningMessage = "Warning: No match for E-Mail Address and/or Password.";
		String actualWarningMessage = driver.findElement(By.xpath("//div[contains(@class, 'alert-dismissible')]")).getText();
		Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage));
	  
	}
}
