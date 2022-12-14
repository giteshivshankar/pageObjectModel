package com.interview.pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class AmazonHomepage {
	
	WebDriver driver;
	
	@FindBy(id="searchDropdownBox")
	WebElement allSelectButton;
	
	@FindBy(id="nav-search-dropdown-card")
	WebElement allButton;
	
	@FindBy(id="twotabsearchtextbox")
	WebElement searchBox;
	
	@FindBy(id="low-price")
	WebElement lowerPrice;
	
	@FindBy(id="high-price")
	WebElement higherPrice;
	
	@FindBy(xpath="//input[@type='submit' and not(@id)]")
	WebElement goButton;
	
	@FindBy(xpath="//span[@class = 'a-price-whole']")
	List<WebElement> prices;
	
	
	@FindBy(xpath="//*[contains(@id, \"announce\")]")
	WebElement filter;
	

	public AmazonHomepage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void selectCategory(String selection) {
		Select select = new Select(allSelectButton);
		select.selectByValue(selection);
	}
	
	public void searchQuery(String query) {
		searchBox.sendKeys(query+Keys.ENTER);
	}
	
	public void setLowerPrice(String price) {
		lowerPrice.sendKeys(price);
	}
	
	public void setHigherPrice(String price) {
		higherPrice.sendKeys(price);
	}
	
	public void clickOnGoButton() {
		goButton.click();
	}
	
	public ArrayList<Integer> getPrices() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<prices.size();i++) {
			list.add(Integer.valueOf(prices.get(i).getText()));
		}
		return list;
	}
	
	public void checkPricesWithRange(int lower, int higher) {
		ArrayList<Integer> list = this.getPrices();
		SoftAssert sassert = new SoftAssert();
		int temp=0;
		for(int i=0;i<list.size();i++) {
			temp=list.get(i);
			if(temp<30000 && temp>20000) {
				sassert.assertTrue(true);
			}else {
				sassert.assertTrue(false);
			}
		}
		sassert.assertAll();
	
	}
	
	public void clickOnFilter() {
		filter.click();
	}
	
	public void setPriceRange(String lower, String higher) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(lowerPrice));
		setLowerPrice(lower);
		setHigherPrice(higher);
		clickOnGoButton();
	}
	
	public void waitForAmazonHome(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(allButton));
	}
	
}
