package objekti;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FillForm2O {

	WebDriver driver;
	
	public FillForm2O(WebDriver driver) {
		this.driver=driver;
	}
	
	By KolikoOtrokBox = By.xpath("html/body/div[2]/article/div/div/section/div/section[1]/div/div");
	public WebElement KolikoOtrokBox() {
		return driver.findElement(KolikoOtrokBox);
	}
	
	By AllFormBox = By.xpath("html/body/div[2]/article/div/div/section/div/section[2]/div/div/div");
	public WebElement AllFormBox() {
		return driver.findElement(AllFormBox);
	}
	
	By Terms = By.id("t_terms");
	public WebElement Terms() {
		return driver.findElement(Terms);
	}
	
	By CardNumber = By.name("Ecom_Payment_Card_Number");
	public WebElement CardNumber() {
		return driver.findElement(CardNumber);
	}
	
	By CVC2 = By.name("Ecom_Payment_Card_Verification");
	public WebElement CVC2() {
		return driver.findElement(CVC2);
	}
	
	By CardMonth = By.name("Ecom_Payment_Card_ExpDate_Month");
	public WebElement CardMonth() {
		return driver.findElement(CardMonth);
	}
	
	By CardYear = By.name("Ecom_Payment_Card_ExpDate_Year");
	public WebElement CardYear() {
		return driver.findElement(CardYear);
	}
	
	By CardSubmit = By.name("Button_Continue");
	public WebElement CardSubmit() {
		return driver.findElement(CardSubmit);
	}
	
	By AliJeSklenjeno = By.cssSelector(".alpha");
	public WebElement AliJeSklenjeno() {
		return driver.findElement(AliJeSklenjeno);
	}
	
	By Pogodba = By.cssSelector("#download_zip");
	public WebElement Pogodba() {
		return driver.findElement(Pogodba);
	}
}
