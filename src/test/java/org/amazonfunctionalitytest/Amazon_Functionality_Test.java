package org.amazonfunctionalitytest;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Amazon_Functionality_Test {

	WebDriver driver = null;

	// Locators

	By Login = By.xpath("//a[@data-csa-c-content-id='nav_ya_signin']");
	By Username = By.id("ap_email");
	By Continue = By.xpath("//input[@aria-labelledby='continue-announce']");
	By Usecode = By.xpath("//input[@aria-labelledby='auth-login-via-otp-btn-announce']");
	By EnterOtp = By.xpath("//input[@autocomplete='off']");
	By SignIn = By.xpath("//input[@aria-labelledby='cvf-submit-otp-button-announce']");
	By Search = By.xpath("//input[@aria-label='Search Amazon.in']");
	By SelectProduct = By.xpath("//span[text()='OnePlus 11R 5G (Sonic Black, 16GB RAM, 256GB Storage)']");
	By AddToCart = By.id("add-to-cart-button");

	@Test
	private void test_1_LoginPage() {

		driver = new ChromeDriver();

		try {

			driver.get("https://www.amazon.in/");
			driver.manage().window().maximize();
			Thread.sleep(30000);
			driver.findElement(Login).click();
			driver.findElement(Username).sendKeys("9994482188");
			driver.findElement(Continue).click();
			driver.findElement(Usecode).click();
			Thread.sleep(10000);
			driver.findElement(EnterOtp).click();
			driver.findElement(SignIn).click();

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

	@Test
	private void test_2_SearchBox() {
		try {
			Thread.sleep(50000);
			driver.findElement(Search).click();
			driver.findElement(Search).sendKeys("oneplus 11r");
			Thread.sleep(1000);
			driver.findElement(Search).sendKeys(Keys.ENTER);

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	@Test

	private void test_3_SelectProduct() {

		String firstwindow = driver.getWindowHandle();
		driver.findElement(SelectProduct).click();

	}

	@Test

	private void test_4_AddToCart() {

		try {

			Set<String> allwindows = driver.getWindowHandles();
			List<String> list = new ArrayList<String>(allwindows);
			driver.switchTo().window(list.get(1));
			Thread.sleep(1000);
			driver.findElement(AddToCart).click();

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

}
