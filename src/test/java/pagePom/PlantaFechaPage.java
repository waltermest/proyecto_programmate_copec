package pagePom;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import basePom.Base;
import basePom.Locator;

public class PlantaFechaPage extends Base implements Locator  {
	
	public PlantaFechaPage(WebDriver driver) {
		super(driver);
		
	}
	
	public void login()throws InterruptedException, IOException {
		     visit("https://stg.programmate.copec.cl/");
		 if (isDisplayed(usuarioLocator)) {
			 type("ZUSR_PROGQAS", usuarioLocator);
			 type("Rfc.01012023", passwordLocator);
			 click(clicBtnIngresarLocator);	
			 
		 } else {
			 
			 System.out.println("No se visualiza el campo de ingreso");
		 }
				
    }
		
	public String DropdownSelecionaPlanta() {
		
		Select selecccionarPlanta = new Select(findElement(seleccionarPlantaLocator));
		selecccionarPlanta.selectByVisibleText("PLANTA CALDERA");
		return getText(selecccionarPlanta.getFirstSelectedOption());
			
		}
	
	
	public void seleccionarFecha() {
		
	
		if (isDisplayed(fechaLocator)) {
			 type("2023-02-14", fechaLocator);
			 click(clickIngresarPlantaLocator);
			 
		 } else {
			 
			 System.out.println("No se visualiza el campo de fecha");
		 }
	}
	
	
	public void PantallaPlantaProgramada() {
		
		
		if (isDisplayed(homePlantaProgramadoLocator)) {
			  type("carga", homePlantaProgramadoLocator);

			 
		 } else {
			 
			 System.out.println("No se visualiza la pantalla de programmate");
		 }
	}
	
		public boolean HomeBienvenidoDisplayed() {
			return isDisplayed(homeBienvenidoLocator);
	}
	
}
	

