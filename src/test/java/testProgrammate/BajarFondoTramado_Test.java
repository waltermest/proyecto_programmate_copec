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
import pagePom.NuevaPropuestaPage;
import pagePom.BajarFondoTramadoPage;
import pagePom.PlantaFechaPage;

public class BajarFondoTramado_Test {
    
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
    public void clickFondoTramado() throws InterruptedException, IOException {
        seleccionarPlanta.DropdownSelecionaPlanta();
        assertEquals(seleccionarPlanta.DropdownSelecionaPlanta(), "PLANTA CALDERA");
        takeScreenshot(testName.getMethodName() + "-dropdown");
        seleccionarPlanta.seleccionarFecha();
        assertTrue(seleccionarPlanta.HomeBienvenidoDisplayed());
        takeScreenshot(testName.getMethodName() + "-fecha");
        seleccionarPlanta.PantallaPlantaProgramada();
        takeScreenshot(testName.getMethodName() + "-pantalla");
        
        
        Thread.sleep(12000);
        
        //Click en nueva propuesta para que se visualice la programación de despachos
        var nuevapropuesta = new NuevaPropuestaPage(driver);
        nuevapropuesta.clickBotonNuevaPropuesta();
        
        Thread.sleep(12000);
        
        //Mostrar los fondos tramados programado
        var fondoverde = new NuevaPropuestaPage(driver);
        fondoverde.FondoVerde();
        takeScreenshot(testName.getMethodName() + "- fondo verde");
        
        Thread.sleep(40000);
      //Doble click en el fondo verde para abrir popup de detalles de pedido 40193
        var clickFondoTramado = new BajarFondoTramadoPage(driver);
        clickFondoTramado.clickFondoTramado();
        takeScreenshot(testName.getMethodName() + "- doble click fondo verde");
                
        //Click dar de baja al fonde verde        
        Thread.sleep(3000);
        var bajarPropuesta = new BajarFondoTramadoPage(driver);
        bajarPropuesta.clickBajarDespacho();
        
        
//      Visualizar el fondo verde en no programado
        Thread.sleep(5000);
        var visibleGrillaFondoVerde = new BajarFondoTramadoPage(driver);
        visibleGrillaFondoVerde.fondoBajaNoProgramado();       
        takeScreenshot(testName.getMethodName() + "- Baja fondo verde no programado");
        

       
    
    }

		
}
        



 


