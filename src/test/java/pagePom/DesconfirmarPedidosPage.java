package pagePom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.log4testng.Logger;

import basePom.Base;
import basePom.Locator;



  public class DesconfirmarPedidosPage extends Base implements Locator {
	
	
	public DesconfirmarPedidosPage(WebDriver driver) {
		super(driver);
		
	}
	
    //Presionar  botón confirmar
	public void clickBotonConfirmar() {		
		
		final Logger log = Logger.getLogger(DesconfirmarPedidosPage.class);
		
		try {
	
			click(clickConfirmarLocator);
			System.out.println("Se valida que al presionar el botón Confirmar");

		}catch(Exception e){
			log.error("Error al hacer clic en el botódfdfdn Nueva Propuesta: "+ e.getMessage());
			
		}
		
	}
	
	      //Doble click al fondo verde para desconfirmar
		  public void dobleClickFondoVerde_1() {	        
		        
			    
		   Actions actions = new Actions(driver);
		   WebElement elementLocator = driver.findElement(clickFondoVerde40502Locator);
		   actions.doubleClick(elementLocator).perform();			 
		   }
		 
		  
		  //Presionar botón desconfirmar el fondo verde
		  public void clickBotonDesconfirmar() {	
		
			  final Logger log = Logger.getLogger(DesconfirmarPedidosPage.class);
				
				try {
			
					click(clickDesconfirmarLocator);
					System.out.println("Se valida al presionar botón Confirmar");

				}catch(Exception e) {
				log.error("Error al hacer clic en el botón Nueva Propuesta: "+ e.getMessage());
				
				}
			
		}
								
	  //Validar fondo verde en la grilla no programada
	   public void visualizarFondoVerde_40502 () {
		   
	    WebElement fondoVerdeBaja = driver.findElement(visualizarVerdeDesconfirmado405502Locator);
		String fondoVerdeBajaText_1 = getText(fondoVerdeBaja);
	    System.out.println("Se baja el fondo homogéneo a la grilla no programada: " + fondoVerdeBajaText_1);
		
	}
	
  
	/*--------------------------------------------------------------------------------------*/
	
	   //Doble click al fondo verde para desconfirmar
		  public void dobleClickFondoTramado_2() {	        
		        
			    
		   Actions actions = new Actions(driver);
		   WebElement elementLocator = driver.findElement(clickFondoVerde40508Locator);
		   actions.doubleClick(elementLocator).perform();			 
		   }
		 
		  					
	 //Validar fondo verde en la grilla no programada
	 public void visualizarFondoVerde_40508 () {
		   
	 WebElement fondoVerdeBaja = driver.findElement(visualizarVerdeDesconfirmado40508Locator);
	 String fondoVerdeBajaText_2 = getText(fondoVerdeBaja);
     System.out.println("Se baja el fondo homogéneo a la grilla no programada: " + fondoVerdeBajaText_2);
	 
	 
	   }

}



	

