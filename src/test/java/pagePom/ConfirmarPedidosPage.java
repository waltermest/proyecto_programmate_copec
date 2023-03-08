package pagePom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.log4testng.Logger;

import basePom.Base;
import basePom.Locator;



  public class ConfirmarPedidosPage extends Base implements Locator {
	
	
	public ConfirmarPedidosPage(WebDriver driver) {
		super(driver);
		
	}
	
    //Presionar  botón confirmar
	public void clickBotonConfirmar() {		
		
		final Logger log = Logger.getLogger(ConfirmarPedidosPage.class);
		
		try {
	
			click(clickConfirmarLocator);
			System.out.println("Se valida que al presionar el botón Confirmar");

		}catch(Exception e){
			log.error("Error al hacer clic en el botódfdfdn Nueva Propuesta: "+ e.getMessage());
			
		}
		
	}
		  
					
	  //Validar fondo homogéneo en la grilla programada
	   public void visualizarFondoVerde_40502 () {
		   
	    WebElement fondoVerde = driver.findElement(clickFondoVerde40502Locator);
		String fondoVerdeText = getText(fondoVerde);
	    System.out.println("Se visualizan los despachos programados en la grilla los recuadros en color homogéneo: " + fondoVerdeText);
		
	}

	 
}





	

