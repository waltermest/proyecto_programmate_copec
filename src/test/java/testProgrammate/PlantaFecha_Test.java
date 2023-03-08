package testProgrammate;

import static org.junit.Assert.*;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import pagePom.PlantaFechaPage;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;



public class PlantaFecha_Test {
	
	private static final String EXTENSION_IMAGEN = ".png";
	private WebDriver driver;
    PlantaFechaPage seleccionarPlanta;


	
	@Before
	public void setUp() throws Exception, IOException {
		
		
		//Coneccion al navegador para validar el test Planta Fecha
		seleccionarPlanta = new PlantaFechaPage(driver);
		driver = seleccionarPlanta.chromeDriverConnection();
		driver.manage().window().maximize();
		
		//Se aplica a todas las acciones realizadas durante la sesión. 
		//si no encuentra algún elemento inmediatamente, esperara hasta que termine y arroje una excepción
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//Intancia Login + Seleccionar planta
		seleccionarPlanta.login();
	
	}
	
		//Validación de capturas de evidencias	
	    public void capturarPantalla(WebDriver driver, String nombreImagen) throws IOException {

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("./screenshots/" + nombreImagen + EXTENSION_IMAGEN));
		scrFile.delete();
	
	}
	
	@Test
	public void seleccionarPlanta() throws InterruptedException, IOException {
		
		//valida si dos valores son iguales y lanza una excepción si es incorrecto
		seleccionarPlanta.DropdownSelecionaPlanta();
		assertEquals(seleccionarPlanta.DropdownSelecionaPlanta(),"PLANTA CALDERA");
		capturarPantalla(driver, "DrpPlanta" + "- Se despliega correctamente el dropdown de planta");
		
		// valida si una condición es verdadera y lanza una excepción si es incorrecto
		seleccionarPlanta.seleccionarFecha();
		assertTrue(seleccionarPlanta.HomeBienvenidoDisplayed());
		capturarPantalla(driver, "CampoFecha" + "- Se selecciona correctamente la fecha");
		
		// valida si una condición es verdadera y lanza una excepción si es incorrecto
		seleccionarPlanta.PantallaPlantaProgramada();
		capturarPantalla(driver, "Pantalla Programmate" + "- Se visualiza correctamente la pantalla");
			
		
		
	}
	

}
 


