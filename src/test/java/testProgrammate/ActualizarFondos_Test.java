package testProgrammate;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import pagePom.ActualizarFondosPage;
import pagePom.NuevaPropuestaPage;
import pagePom.PlantaFechaPage;


public class ActualizarFondos_Test {
    
    private static final String SCREENSHOT_FOLDER = "./screenshots/";
    private static final String SCREENSHOT_FORMAT = ".png";
    
    private WebDriver driver;
    PlantaFechaPage seleccionarPlanta;
    NuevaPropuestaPage btnNuevaPropuesta;
    ActualizarFondosPage btnActualizar;
    
    @Rule
    public TestName testName = new TestName();
    
    @Before
    public void setUp() throws Exception {
        seleccionarPlanta = new PlantaFechaPage(driver);
        driver = seleccionarPlanta.chromeDriverConnection();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        seleccionarPlanta.login();
    }
    
    public void takeScreenshot(String fileName) throws IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, Paths.get(SCREENSHOT_FOLDER, fileName + SCREENSHOT_FORMAT).toFile());
    }
    
    
	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}
    
    @Test
    public void clickBotonActualizar() throws InterruptedException, IOException {
        seleccionarPlanta.DropdownSelecionaPlanta();
        assertEquals(seleccionarPlanta.DropdownSelecionaPlanta(), "PLANTA CALDERA");
        seleccionarPlanta.seleccionarFecha();
        assertTrue(seleccionarPlanta.HomeBienvenidoDisplayed()); 
        seleccionarPlanta.PantallaPlantaProgramada();
            
        
        
//        Click en nueva propuesta para que se visualice la programación de despachos
        Thread.sleep(10000);
        
        var nuevapropuesta = new NuevaPropuestaPage(driver);
        nuevapropuesta.clickBotonNuevaPropuesta();
     
        
        //Click en botón actualizar
        Thread.sleep(70000);
        
        var botonActualizar = new ActualizarFondosPage(driver);
        botonActualizar.clickBotonActualizarGrilla();
        takeScreenshot(testName.getMethodName() + "- Botón Actualizar");
        
        
        
//      Visualizar los fondos verdes sin realizar cambios
        
       Thread.sleep(5000);
       var visualizarFondoVerde = new NuevaPropuestaPage(driver);
       visualizarFondoVerde.FondoVerde();
       takeScreenshot(testName.getMethodName() + "- fondo verde");
  
    
    }

		
}
        



 


