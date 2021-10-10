package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ContactUsPage {
	
	private WebDriver driver;

	private By email = By.id("email");
	private By reference = By.xpath("//input[@id='id_order']");
	private By messageText = By.xpath("//textarea[@id='message']");
	private By sendButton = By.id("submitMessage");
	private By successMessg = By.cssSelector("div#center_column p");

	public ContactUsPage(WebDriver driver) {
		this.driver = driver;
	}

	public String getContactUsPageTitle() {
		return driver.getTitle();
	}
	
	public void fillContactUsForm(String emailId, String ref, String  number) throws InterruptedException {

		driver.findElement(email).sendKeys(emailId);
		Thread.sleep(3000);
		driver.findElement(reference).sendKeys(ref);
		Thread.sleep(3000);
		driver.findElement(messageText).sendKeys(number);
		Thread.sleep(3000);
		
	}

	public void clickSend() {
		driver.findElement(sendButton).click();
	}
	
	public String getSuccessMessg() {
		return driver.findElement(successMessg).getText();
	}
	
	
	
	

}
