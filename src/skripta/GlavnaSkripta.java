package skripta;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import objekti.FillForm2O;
import objekti.FillFormO;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.security.UserAndPassword;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


public class GlavnaSkripta {
	
	//private static RemoteWebDriver driver;
	private static RemoteWebDriver driver;
	/* 
	 * 
	 */
	
	public static void Test (
			int Predsolski, int Osnovnosolski, int Srednjesolski, int Studentnje, 
			String Paket
			) throws InterruptedException, MalformedURLException{
		
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("version", "38");
        capabilities.setCapability("platform", Platform.WIN8_1);
        // Create the connection to Sauce Labs to run the tests
        driver = new RemoteWebDriver(
                new URL("http://k3ks91:bc64233e-bf6d-4462-a039-57c4ab669713@ondemand.saucelabs.com:80/wd/hub"),
                capabilities);
		
		//WebDriver driver = new FirefoxDriver();
		
		System.out.println("");
		System.out.println("Zagon spletne strani");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//WebDriverWait wait = new WebDriverWait(driver, 10);
		//Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		driver.get("https://dlabs:pustimenamiru@sola.beta.zav-tilia.si");
		//http://username:password@url
		//alert.authenticateUsing(new UserAndPassword("dlabs", "pustimenamiru"));
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		FillFormO fillFormO = new FillFormO(driver);
		System.out.println("Je opozorilo za cookije prisotno?");
		if (!driver.findElements(By.xpath("html/body/aside/button[1]")).isEmpty()){
			System.out.println("Vidi ga");
			fillFormO.CookieOk().click();
		}
		else{
			System.out.println("Vidi ga NE!");
		}
		
		System.out.println("");
		System.out.println("Pricel izpolnjevati obrazec 1");
		
		System.out.println("Preverjam potrditev nepravilno izpolnjenega obrazca");
		fillFormO.Submit1().click();
		Thread.sleep(1000);
		if(fillFormO.Error1().isDisplayed()){
			System.out.println("Pravilno izpise napako");
		}
		else {
			System.out.println("Napake ni izpisalo");
		}
		
		System.out.println("Pravilno izpolnjujem obrazec");
		
		if (Predsolski!=0){
			fillFormO.PredSola().sendKeys(Integer.toString(Predsolski));
			Thread.sleep(3000);
		}
		if (Osnovnosolski!=0){
			fillFormO.OsnovSola().sendKeys(Integer.toString(Osnovnosolski));
			Thread.sleep(3000);
		}
		if (Srednjesolski!=0){
			fillFormO.SredSola().sendKeys(Integer.toString(Srednjesolski));
			Thread.sleep(3000);
		}
		if (Studentnje!=0){
			fillFormO.StudSola().sendKeys(Integer.toString(Studentnje));
			Thread.sleep(3000);
		}
		fillFormO.Terms().click();
		Thread.sleep(3000);
		fillFormO.Submit1().click();
		System.out.println("obrazec oddan");
		System.out.println("");
		
		System.out.println("Preverjam izpis iz prvega obrazca");
		FillForm2O fillForm2O = new FillForm2O(driver);
		WebElement box = fillForm2O.KolikoOtrokBox();
		if (Predsolski!=0){
			if(box.getText().contains(Predsolski + " predšolskega otroka")){
				System.out.println("Predsolskih otrok je prav");
			}
			else {
				System.out.println("Predsolskih otrok ne izpise prav");
				System.out.println(box.getText());
			}
		}
		if (Osnovnosolski!=0){
			if(box.getText().contains(Predsolski + " osnovnošolskega otroka")){
			System.out.println("Osnovnosolskih otrok je prav");
			}
			else {
				System.out.println("Osnovnosolskih otrok ne izpise prav");
			}
		}
		if (Srednjesolski!=0){
			if(box.getText().contains(Predsolski + " srednješolskega otroka")){
			System.out.println("Srednjesolskih otrok je prav");
			}
			else {
				System.out.println("Srednjesolskih otrok ne izpise prav");
			}
		}
		if (Studentnje!=0){
			if(box.getText().contains(Predsolski + " študenta")){
			System.out.println("Studentov je prav");
			}
			else {
				System.out.println("Studentov ne izpise prav");
			}
		}
		
		System.out.println("");
		System.out.println("Izpolnjevanje drugega obrazca");
		
		WebElement Formbox = fillForm2O.AllFormBox();
		int kolikoOtrok = Predsolski+Osnovnosolski+Srednjesolski+Studentnje;
		
		// Izponjevanje obrazcev za vse otroke\
		
		Actions act = new Actions(driver);
		act.keyDown(Keys.CONTROL).keyDown(Keys.ALT).keyDown(Keys.SHIFT).sendKeys("f").build().perform();
		
		for (int i=0;i<kolikoOtrok;i++){
			/*if (i!=0 && kolikoOtrok > 1){
				Thread.sleep(3000);
				Formbox.findElements(By.cssSelector(".btn.btn-sqpec-edit.edit")).get(i).click();
				Thread.sleep(2000);
			}*/
			
			//Datum Rojstva
			Formbox.findElement(By.name("insureeDay_"+(i))).sendKeys("1");
			Formbox.findElement(By.name("insureeMonth_"+(i))).sendKeys("1");
			if(i>Predsolski+Osnovnosolski-1&&i<Predsolski+Osnovnosolski+Srednjesolski-1){
				Formbox.findElement(By.name("insureeYear_"+(i))).sendKeys("2000");
			}
			if(i>Predsolski+Osnovnosolski+Srednjesolski-1){
				Formbox.findElement(By.name("insureeYear_"+(i))).sendKeys("1991");
			}
			else {
				Formbox.findElement(By.name("insureeYear_"+(i))).sendKeys("2009");
			}
			Thread.sleep(2000);
			//Osebni podatki  CTRL SHIFT ALT F
			/*
			Formbox.findElement(By.name("insureeFirstName_"+(i))).sendKeys("Janez");
			Formbox.findElement(By.name("insureeLastName_"+(i))).sendKeys("Novak");
			Formbox.findElement(By.name("insureeAddress_"+(i))).sendKeys("Kranjska");
			Formbox.findElement(By.name("insureeAddressNumber_"+(i))).sendKeys("8");
			Formbox.findElement(By.name("insureeZip_"+(i))).sendKeys("1000 LJUBLJANA");
			Formbox.findElement(By.name("insureeTaxNumber_"+(i))).sendKeys("11112222");
			//Kateri Paket
			Formbox.findElements(By.tagName("button"));
			*/
			for (int i2=0;i2<Formbox.findElements(By.tagName("button")).size();i2++){
				if (Formbox.findElements(By.tagName("button")).get(i2).getText().contains("IZBERI "+Paket)){
					Formbox.findElements(By.tagName("button")).get(i2).click();
					break;
				}
			}
		}
		System.out.println("Koncal Izpolnjevanje obrazca za otroke");
		
		System.out.println("Izpolnjujem obrazec za sklenitelja");
		
		driver.findElement(By.name("day")).sendKeys("1");
		driver.findElement(By.name("month")).sendKeys("1");
		driver.findElement(By.name("year")).sendKeys("1991");
		act.keyDown(Keys.CONTROL).keyDown(Keys.ALT).keyDown(Keys.SHIFT).sendKeys("f").build().perform();
		act.keyDown(Keys.CONTROL).keyDown(Keys.ALT).keyDown(Keys.SHIFT).sendKeys("f").build().perform();
		Thread.sleep(2000);
		
		for (int i2=0;i2<driver.findElements(By.tagName("button")).size();i2++){
			if (driver.findElements(By.tagName("button")).get(i2).getText().contains("NADALJUJMO")){
				driver.findElements(By.tagName("button")).get(i2).click();
				break;
			}
		}
		
		System.out.println("Potrjujem pogoje");
		Thread.sleep(3000);
		fillForm2O.Terms().click();
		Thread.sleep(1000);
		for (int i2=0;i2<driver.findElements(By.tagName("button")).size();i2++){
			if (driver.findElements(By.tagName("button")).get(i2).getText().contains("NADALJUJ NA PLAČILO")){
				driver.findElements(By.tagName("button")).get(i2).click();
				break;
			}
		}
		
		System.out.println("Sprejel Pogoje, nadaljujem na placilo");
		fillForm2O.CardNumber().sendKeys("5450429876543211");
		Thread.sleep(1000);
		fillForm2O.CVC2().sendKeys("1231");
		Thread.sleep(1000);
		fillForm2O.CardMonth().sendKeys("2");
		Thread.sleep(1000);
		fillForm2O.CardYear().sendKeys("2017");
		Thread.sleep(1000);
		fillForm2O.CardSubmit().click();
		
		System.out.println("Cakam na Prenos Police in preverjam uspesnost sklenitve zavarovanja");
		fillForm2O.AliJeSklenjeno().isDisplayed();
		if (fillForm2O.AliJeSklenjeno().getText().contains("Zavarovanje je sklenjeno")){
			System.out.println("Zavarovanje je sklenjeno");
			System.out.println("Cakam na prenos pogodbe");
		}
		else {
			System.out.println("Zavarovanje ni sklenjeno?");
			System.out.println(fillForm2O.AliJeSklenjeno().getText());
		}
		fillForm2O.Pogodba().isDisplayed();
		fillForm2O.Pogodba().click();
		
		//Spremeni window ki se naredi ob downloadu *NO WORK*
		/*Thread.sleep(5000);
		Set<String>ids=driver.getWindowHandles();
		Iterator<String> it = ids.iterator();
		String parentid=it.next();
		System.out.println(driver.getTitle());
		String childid=it.next();
		driver.switchTo().window(childid);
		System.out.println(driver.getTitle());
		*/
		if(driver.getCurrentUrl().contains("https://sola.beta.zav-tilia.si/uploadZip/")){
			System.out.println("Pogodbo je mozno pridobiti");
		}
		else {
			System.out.println("Pogodbe NI mozno pridobiti");
			System.out.println(driver.getCurrentUrl());
		}
		System.out.println("**********Test Koncan**********");
		driver.quit();
	}
	
}
