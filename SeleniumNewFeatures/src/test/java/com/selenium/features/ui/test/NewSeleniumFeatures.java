package com.selenium.features.ui.test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.security.Security;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class NewSeleniumFeatures {

	private ChromeDriver driver;
	private DevTools chromeDevTools;

	@BeforeClass
	public void before() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@Test
	public void testScreenShotOfWebElement() throws IOException {

		driver.navigate().to("https://7-3test-fzvfwlq-gq5t6ltuu2f22.us-4.magentosite.cloud/");
		WebElement shopNewYogaButton = driver.findElement(By.cssSelector(".action.more.button"));
		File file = shopNewYogaButton.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("shopnewbutton.png"));

	}

	@Test
	public void testOpenWindowInNewTab() {

		driver.navigate().to("https://7-3test-fzvfwlq-gq5t6ltuu2f22.us-4.magentosite.cloud/");
		driver.switchTo().newWindow(WindowType.TAB);
		driver.navigate().to("https://7-3test-fzvfwlq-gq5t6ltuu2f22.us-4.magentosite.cloud/admin");

	}

	@Test
	public void testGetElementLocation() {

		driver.navigate().to("https://7-3test-fzvfwlq-gq5t6ltuu2f22.us-4.magentosite.cloud/");
		WebElement shopNewYogaButton = driver.findElement(By.cssSelector(".action.more.button"));
		System.out.println("Height is " + shopNewYogaButton.getRect().getDimension().getHeight());
		System.out.println("Width is " + shopNewYogaButton.getRect().getDimension().getWidth());
		System.out.println("Location X is " + shopNewYogaButton.getRect().getX());
		System.out.println("Location Y is " + shopNewYogaButton.getRect().getY());

	}

	@Test
	public void testLoadInsecureWebsite() {

		chromeDevTools = driver.getDevTools();
		chromeDevTools.createSession();
		chromeDevTools.send(Security.enable());
		chromeDevTools.send(Security.setIgnoreCertificateErrors(true));
		driver.get("https://expired.badssl.com/");

	}

	@Test
	public void testUsageOfRelativeLocators() {

		driver.navigate().to("https://7-3test-fzvfwlq-gq5t6ltuu2f22.us-4.magentosite.cloud/");
		driver.findElement(RelativeLocator.withTagName("input").toLeftOf(By.cssSelector(".action.showcart")))
				.sendKeys("Duffle Bags");

	}

	@AfterClass
	public void after() {
		driver.quit();
	}

}
