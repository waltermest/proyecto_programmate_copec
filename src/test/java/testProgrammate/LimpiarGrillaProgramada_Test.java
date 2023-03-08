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

import pagePom.LimpiarGrillaProgramadaPage;
import pagePom.NuevaPropuestaPage;
import pagePom.PlantaFechaPage;

public class LimpiarGrillaProgramada_Test {
    
    private static final String SCREENSHOT_FOLDER = "./screenshots/";
    private static final String SCREENSHOT_FORMAT = ".png";
    
    private WebDriver driver;
    PlantaFechaPage seleccionarPlanta;
    NuevaPropuestaPage nuevaPropuesta;
    
    @Rule
    public TestName testName = new TestName();
    
    @Before
    public void setUp() throws Exception {
        seleccionarPlanta = new PlantaFechaPage(driver);
        driver = seleccionarPlanta.chromeDriverConnection();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        seleccionarPlanta.login();
    }
    
    public void takeScreenshot(String fileName) throws IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, Paths.get(SCREENSHOT_FOLDER, fileName + SCREENSHOT_FORMAT).toFile());
    }
    
    @Test
    public void LimpiarGrillaProgramada() throws InterruptedException, IOException {
        seleccionarPlanta.DropdownSelecionaPlanta();
        assertEquals(seleccionarPlanta.DropdownSelecionaPlanta(), "PLANTA CALDERA");
        seleccionarPlanta.seleccionarFecha();
        assertTrue(seleccionarPlanta.HomeBienvenidoDisplayed());
        seleccionarPlanta.PantallaPlantaProgramada();
     
        
        
        Thread.sleep(12000);
        
        //Click en nueva propuesta para que se visualice la programación de despachos
        var nuevapropuesta = new NuevaPropuestaPage(driver);
        nuevapropuesta.clickBotonNuevaPropuesta();
        
        Thread.sleep(12000);
        
        //Mostrar los fondos tramados programado
        var fondoverde = new NuevaPropuestaPage(driver);
        fondoverde.FondoVerde();
        takeScreenshot(testName.getMethodName() + "- fondo verde");
        
        
        Thread.sleep(20000);
        //Limpiar grilla programada      
        var btnlimpiar = new LimpiarGrillaProgramadaPage(driver);
        btnlimpiar.clickBotonLimpiar();
        takeScreenshot(testName.getMethodName() + "- Popup de dar OK para limpiar grilla");  
        
        Thread.sleep(8000);
        var btnOKlimpiar = new LimpiarGrillaProgramadaPage(driver);
        btnOKlimpiar.clickOkLimpiar();
               
        Thread.sleep(12000);
        //Presionar guardar para realizar los cambios
        var btnguardar = new LimpiarGrillaProgramadaPage(driver);
        btnguardar.clickBotonGuardar();
        takeScreenshot(testName.getMethodName() + "- Grilla vacía programada"); 
        
   
        
    }
        

}

