package com.interview.pageObjects;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleSearchPage {
	
	WebDriver driver;
	
	@FindBy(xpath="//input[@title='Search']")
	WebElement searchTextBox;
	
	@FindBy(xpath="//*[@id='rso']/div[1]/div/div/div/div/div/div/div/div[1]/a/h3")
	WebElement expectedLink;
	
	@FindBy(xpath="//*[@class='MjjYud']")
	List<WebElement> results;

	public GoogleSearchPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void searchWithText(String text) {
		searchTextBox.sendKeys(text+Keys.ENTER);
	}
	
	public void clickOnAmazonLink(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(expectedLink)).click();
	}
	
	
	public void printResultsIntheLogs() {
		for(int i=0;i<results.size();i++) {
			System.out.println(results.get(i).getText());
		}
		
	}
	
}
