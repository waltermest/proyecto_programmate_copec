package pagePom;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import basePom.Base;

public class ClickNuevaPropuestaPage extends Base {
	

    
	//Locator Login
	By usuarioLocator = By.id("username");   
	By passwordLocator = By.id("pwd");
	By clicBtnIngresarLocator = By.xpath("/html/body/app-root/app-login/div/div[2]/div/button");
	
	//Locator Bienvenido Usuario
	By homeBienvenidoLocator = By.xpath("//h3[contains(text(),\" Bienvenido ZUSR_PROGQAS\")]");
	By seleccionarPlantaLocator = By.xpath("/html/body/app-root/app-selector-planta/div/div[2]/div/div[1]/select");
	By fechaLocator = By.name("dp");
	By clickIngresarPlantaLocator = By.id("ingresarPlanta");
	
	//Locator Home Planta Programado
	By homePlantaProgramadoLocator = By.id("truckSearchBox");
	
	//Locator botón nueva propuesta
	By recuadroVacioProgramado = By.id("//*[@id=\"28-01-2022;0000008823;8;30\"]");
	By btnNuevaPropuestaLocator = By.xpath("//*[@class='btn btn-primary btn-sm button-control'][2]"); 
	By visualizarMenuProgrammateLocator = By.id("//*[@id=\"programador-main\"]/div[1]/div[3]/div[1]");
	
	
	
	
	public ClickNuevaPropuestaPage(WebDriver driver) {
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
			 type("2022-01-28", fechaLocator);
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
	
	public void clickBotonNuevaPropuesta() {
		
//		System.out.println("boton" + btnNuevaPropuestaLocator);
		
		System.out.println("Switch");
		driver.switchTo().frame(5);
		click(btnNuevaPropuestaLocator);
//		driver.switchTo().defaultContent();
//		if (isDisplayed(btnNuevaPropuestaLocator)) {
//   		 
//			 
//		 } else {
//			 
//			 System.out.println("No se visualiza el botón Nueva Propuesta");
//		 }
	}
	

	
	
		public boolean HomePlantaProgramadoDisplayed() {
			return isDisplayed(homePlantaProgramadoLocator);
	}
	
}
	

