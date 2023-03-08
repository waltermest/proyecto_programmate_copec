package testProgrammate;

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

import pagePom.ConfirmarPedidosPage;
import pagePom.NuevaPropuestaPage;
import pagePom.PlantaFechaPage;



public class ConfirmarPedidos_Test {
    
    private static final String SCREENSHOT_FOLDER = "./screenshots/";
    private static final String SCREENSHOT_FORMAT = ".png";
    
    private WebDriver driver;
    PlantaFechaPage seleccionarPlanta;

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
    
    @Test
    public void clickBotonConfirmar() throws InterruptedException, IOException {
        
    	seleccionarPlanta.DropdownSelecionaPlanta();
        assertEquals(seleccionarPlanta.DropdownSelecionaPlanta(), "PLANTA CALDERA");
        seleccionarPlanta.seleccionarFecha();
        assertTrue(seleccionarPlanta.HomeBienvenidoDisplayed()); 
        seleccionarPlanta.PantallaPlantaProgramada();
            
              
        //Click en nueva propuesta para que se visualice la programación de despachos
        Thread.sleep(10000);
        
        var nuevapropuesta = new NuevaPropuestaPage(driver);
        nuevapropuesta.clickBotonNuevaPropuesta();
     
        
        //Click en botón Confirmar
        Thread.sleep(60000);
        
        var botonConfirmar = new ConfirmarPedidosPage(driver);
        botonConfirmar.clickBotonConfirmar();
        takeScreenshot(testName.getMethodName() + "- Botón Confirmar");
        
                
        //Visualizar el fondo verde homogéneo en programado
        Thread.sleep(20000);
        var visibleGrillaFondoVerde = new ConfirmarPedidosPage(driver);
        visibleGrillaFondoVerde.visualizarFondoVerde_40502();       
        takeScreenshot(testName.getMethodName() + "- Fondo verde homogéneo programado");

    
    }

		
}
        



 


