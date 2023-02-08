package testFuncional1;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import pagePom.ClickNuevaPropuestaPage;
import pagePom.SeleccionarPlantaFechaPage;

public class ClickNuevaPropuesta_Test {
    
    private static final String SCREENSHOT_FOLDER = "./screenshots/";
    private static final String SCREENSHOT_FORMAT = ".png";
    private WebDriver driver;
    SeleccionarPlantaFechaPage seleccionarPlanta;
    ClickNuevaPropuestaPage nuevaPropuesta;
    
    @Rule
    public TestName testName = new TestName();
    
    @Before
    public void setUp() throws Exception {
        seleccionarPlanta = new SeleccionarPlantaFechaPage(driver);
        nuevaPropuesta = new ClickNuevaPropuestaPage(driver);
        driver = seleccionarPlanta.chromeDriverConnection();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        seleccionarPlanta.login();
    }
    
    public void takeScreenshot(String fileName) throws IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, Paths.get(SCREENSHOT_FOLDER, fileName + SCREENSHOT_FORMAT).toFile());
    }
    
    @Test
    public void seleccionarPlanta() throws InterruptedException, IOException {
        seleccionarPlanta.DropdownSelecionaPlanta();
        assertEquals(seleccionarPlanta.DropdownSelecionaPlanta(), "PLANTA CALDERA");
        takeScreenshot(testName.getMethodName() + "-dropdown");
        seleccionarPlanta.seleccionarFecha();
        assertTrue(seleccionarPlanta.HomeBienvenidoDisplayed());
        takeScreenshot(testName.getMethodName() + "-fecha");
        seleccionarPlanta.PantallaPlantaProgramada();
        takeScreenshot(testName.getMethodName() + "-pantalla");
        
        nuevaPropuesta.clickBotonNuevaPropuesta();
//        assertTrue(nuevaPropuesta.HomePlantaProgramadoDisplayed());
//        takeScreenshot(testName.getMethodName() + "-boton");
    }
}







//package testFuncional1;
//
//import static org.junit.Assert.*;
//import java.io.IOException;
//import java.util.concurrent.TimeUnit;
//import org.apache.commons.io.FileUtils;
//import org.junit.Before;
//import org.junit.Test;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.WebDriver;
//
//import pagePom.ClickNuevaPropuestaPage;
//import pagePom.SeleccionarPlantaFechaPage;
//
//import org.openqa.selenium.TakesScreenshot;
//import java.io.File;
//
//
//
//public class ClickNuevaPropuesta_Test {
//	
//	private static final String EXTENSION_IMAGEN = ".png";
//	private WebDriver driver;
//    private SeleccionarPlantaFechaPage seleccionarPlanta;
//    private ClickNuevaPropuestaPage btnNuevaPropuesta;
//	
//	@Before
//	public void setUp() throws Exception, IOException {
//		
//		//se utilizarán para iniciar una sesión en el servidor remoto de Selenium
////		DesiredCapabilities caps = new DesiredCapabilities();
//		
//		//Coneccion al navegador para validar el test Planta Fecha
//		seleccionarPlanta = new SeleccionarPlantaFechaPage(driver);
//		driver = seleccionarPlanta.chromeDriverConnection();
//		driver.manage().window().maximize();
//		
//		//Se aplica a todas las acciones realizadas durante la sesión. 
//		//si no encuentra algún elemento inmediatamente, esperara hasta que termine y arroje una excepción
//		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
//		
//		//Validar ingresar datos de seleccionar planta y fecha programada
//		seleccionarPlanta.login();
////		btnNuevaPropuesta.PantallaPlantaProgramada();
//	
//	}
//	
//		//Validación de capturas de evidencias	
//	public void capturarPantalla(WebDriver driver, String nombreImagen) throws IOException {
//         TakesScreenshot screenshot = (TakesScreenshot) driver;
//         File screenshotFile = screenshot.getScreenshotAs(OutputType.FILE);
//         File targetFile = new File("./screenshots/" + nombreImagen + EXTENSION_IMAGEN);
// 		 FileUtils.copyFile(screenshotFile, targetFile);
//         
////		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
////		FileUtils.copyFile(scrFile, new File("./screenshots/" + nombreImagen + EXTENSION_IMAGEN));
////		scrFile.delete();
//	
//	}
//	
//	@Test
//	public void seleccionarPlanta() throws InterruptedException, IOException {
//		
//		//valida si dos valores son iguales y lanza una excepción si es incorrecto
//		seleccionarPlanta.DropdownSelecionaPlanta();
//		assertEquals(seleccionarPlanta.DropdownSelecionaPlanta(),"PLANTA CALDERA");
//		capturarPantalla(driver, "DrpPlanta" + "- Se despliega correctamente el dropdown de planta");
//		
//		// valida si una condición es verdadera y lanza una excepción si es incorrecto
//		seleccionarPlanta.seleccionarFecha();
//		assertTrue(seleccionarPlanta.HomeBienvenidoDisplayed());
//		capturarPantalla(driver, "CampoFecha" + "- Se selecciona correctamente la fecha");
//		
//		// valida si una condición es verdadera y lanza una excepción si es incorrecto
//		seleccionarPlanta.PantallaPlantaProgramada();
//		capturarPantalla(driver, "Pantalla Programmate" + "- Se visualiza correctamente la pantalla");
//	
//			
//		Thread.sleep(10000);
//		
//		
//		//Click botón Nueva Propuesta
//		btnNuevaPropuesta.clickBotonNuevaPropuesta();
//		assertTrue(btnNuevaPropuesta.HomePlantaProgramadoDisplayed());
//		capturarPantalla(driver, "Click botón Nueva Propuesta" + "- Se ejecuta correctamente");
//		
////		Thread.sleep(3000);
//		
//	}
//	
//
//}
 


