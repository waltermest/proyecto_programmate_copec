package pagePom;

import org.openqa.selenium.WebDriver;
import basePom.Base;
import basePom.Locator;

public class LimpiarGrillaProgramadaPage extends Base implements Locator {
	
	
	public LimpiarGrillaProgramadaPage(WebDriver driver) {
		super(driver);
		
	}
	
	public void PantallaPlantaProgramada() {
		
		if (isDisplayed(homePlantaProgramadoLocator)) {
	    type("carga", homePlantaProgramadoLocator);

		 } else {
			 
			 System.out.println("No se visualiza la pantalla de programmate");
		 }
	}
	
	
	public void clickBotonNuevaPropuesta() {			
		   
		
		try {
			click(btnNuevaPropuestaLocator);	
		}catch(Exception e){
			System.out.println(e);
		}
	}


	
   public void FondoVerde() {
		
	   try {
			isDisplayed(visualizarFondoProgramadoteLocator);	
			System.out.println("se visualiza el fondo verde programado "+visualizarFondoProgramadoteLocator);
		}catch(Exception e){
			System.out.println(e);
		}
	   
    }
   
   
      public void clickBotonLimpiar() {			
	   
		
		try {
			click(clickLimpiarLocator);	
		}catch(Exception e){
			System.out.println(e);
		}
	}
      
      
      public void clickOkLimpiar() {			
   	   
  		
  		try {
  			click(clickOkLimpiarLocator);
  			System.out.println("se limpia la grilla programado ");
  		}catch(Exception e){
  			System.out.println(e);
  		}
  	}
      
      
      public void clickBotonGuardar() {			
   	   
  		
  		try {
  			click(clickGuardarLocator);	
  			System.out.println("se guarda la configuración con la grilla vacía ");
  		}catch(Exception e){
  			System.out.println(e);
  		}
  	}
   
   
   
	
		public boolean HomePlantaProgramadoDisplayed() {
			return isDisplayed(homePlantaProgramadoLocator);
	}


		}

	
			

	

	

