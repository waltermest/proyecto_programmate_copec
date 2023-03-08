package pagePom;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.Select;

import basePom.Base;
import basePom.Locator;

public class BajarFondoTramadoPage extends Base implements Locator {
//    public static void main(String[] args) {
//
//    }

	
	public BajarFondoTramadoPage(WebDriver driver) {
		super(driver);
		
	}
	  
	   public void clickFondoTramado() {	        
	        
		    
	        Actions actions = new Actions(driver);
	        WebElement elementLocator = driver.findElement(visualizarFondoProgramadoteLocator);
	        actions.doubleClick(elementLocator).perform();			 
	   }
		     
	   public void clickBajarDespacho() {
			
		   try {
				click(clickBajarPropuestaLocator);	
			}catch(Exception e){
				System.out.println(e);
				
			}
						
	   }
	   
	   public void fondoBajaNoProgramado() {
		   
		    WebElement fondoVerdeTramadoBaja = driver.findElement(fondoBajaNoProgramadoLocator);
	        String fondoVerdeBajaText = getText(fondoVerdeTramadoBaja);
	        System.out.println("Texto del fondo verde: " + fondoVerdeBajaText);
		   
		   
//		    String element = driver.findElement(fondoBajaNoProgramadoLocator).getText();
//			System.out.println("se visualiza el fondo verde en la grilla no programado ");
//		    return element.equals("40193: ORELLANA CONCHA RAFAEL");
	        
			 }
	   
	   
		public boolean HomePlantaProgramadoDisplayed() {
			return isDisplayed(homePlantaProgramadoLocator);
	}
	
}
	

