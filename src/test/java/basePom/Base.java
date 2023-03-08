package basePom;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
//import java.io.File;
//import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Base {
	

	 
	protected WebDriver driver;

	  public Base(WebDriver driver) {
	    this.driver = driver;
	    
	  }
	  
	  public WebDriver chromeDriverConnection() {
		  System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		  
	      driver = new ChromeDriver();
		  return driver;
		  
	  }
	  
	  public WebElement findElement(By locator) {
		  return driver.findElement(locator);
		  
	  }
	  
//	  public List<WebElemnt> findElement(By locator){
//		  
//		  return driver.findElement(locator);
		  
		 
//}
	  
	  public void borrar(By locator) {
			driver.findElement(locator).clear();
	  }

	  
	  	  
		public String getText(String attribute) {
	
		return null;
	}
	  
	  
	    
	  
	  public String getText(WebElement element) {
	  return element.getText();
	  }

	  
	 public String getText(By locator) {			 
	 return driver.findElement(locator).getText();
			 
		 }
		 
		public void type(String inputText, By locator) {
			
			driver.findElement(locator).sendKeys(inputText);
		}
		
		public void click(By locator) {
			
			driver.findElement(locator).click();
			
		}
		
		public void select(By locator) {
			driver.findElement(locator).click();
			
		}
		
		
		
		public Boolean isDisplayed(By locator) {
			try {
				return driver.findElement(locator).isDisplayed();
			} catch (org.openqa.selenium.NoSuchElementException e) {
				
			return false;
			
			}
		}
			
		
			public void visit(String url) {
				driver.get(url);
			}
			
			
			private static final String EXTENSION_IMAGEN = ".png";
			public void capturarPantalla(WebDriver driver, String nombreImagen) throws IOException {

				File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(scrFile, new File("./screenshots/" + nombreImagen + EXTENSION_IMAGEN));
				scrFile.delete();
			
			}
			

		}
