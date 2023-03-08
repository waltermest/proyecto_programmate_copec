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
import pagePom.PlantaFechaPage;

public class NuevaPropuesta_Test {
    
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
    public void FondoTramado() throws InterruptedException, IOException {
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
        
    }
        

}

