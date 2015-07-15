package objekti;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FillFormO {

	WebDriver driver;
	
	public FillFormO(WebDriver driver) {
		this.driver=driver;
	}
	
	By CookieOk=By.xpath("html/body/aside/button[1]");
	public WebElement CookieOk(){
		return driver.findElement(CookieOk);
	}
	
	By PredSola = By.id("preSchoolNum");
	public WebElement PredSola(){
		return driver.findElement(PredSola);
	}
	
	By OsnovSola = By.id("primarySchoolNum");
	public WebElement OsnovSola(){
		return driver.findElement(OsnovSola);
	}
	
	By SredSola = By.id("highSchoolNum");
	public WebElement SredSola(){
		return driver.findElement(SredSola);
	}
	
	By StudSola = By.id("studentNum");
	public WebElement StudSola(){
		return driver.findElement(StudSola);
	}
	
	By Submit1 = By.xpath("html/body/div[2]/article/div/div/section/div/section[1]/div/div/div[3]/button");
	public WebElement Submit1(){
		return driver.findElement(Submit1);
	}
	
	By Error1 = By.className("errorMsg");
	public WebElement Error1(){
		return driver.findElement(Error1);
	}
	
	By Terms = By.id("t_terms");
	public WebElement Terms(){
		return driver.findElement(Terms);
	}
	
}
