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

import pagePom.DesconfirmarPedidosPage;
import pagePom.NuevaPropuestaPage;
import pagePom.PlantaFechaPage;


public class DesconfirmarPedidos_Test {
    
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
    
	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}
    
    @Test
    public void clickBotonConfirmar() throws InterruptedException, IOException {
        seleccionarPlanta.DropdownSelecionaPlanta();
        assertEquals(seleccionarPlanta.DropdownSelecionaPlanta(), "PLANTA CALDERA");
        seleccionarPlanta.seleccionarFecha();
        assertTrue(seleccionarPlanta.HomeBienvenidoDisplayed()); 
        seleccionarPlanta.PantallaPlantaProgramada();
            
        
        
//        Click en nueva propuesta para que se visualice la programación de despachos
        Thread.sleep(10000);
        
        var nuevapropuesta = new NuevaPropuestaPage(driver);
        nuevapropuesta.clickBotonNuevaPropuesta();
     
        
        //Click en botón Confirmar
        Thread.sleep(60000);
        
        var botonConfirmar = new DesconfirmarPedidosPage(driver);
        botonConfirmar.clickBotonConfirmar();
        takeScreenshot(testName.getMethodName() + "- Botón Confirmar");
        
        
//      visualizar y click el fondo verdes para desconfirmar
        Thread.sleep(20000);
        var visualizarVerdeDesconfirmar_1 = new DesconfirmarPedidosPage(driver);
        visualizarVerdeDesconfirmar_1.dobleClickFondoVerde_1();
        
//      click el popup para desconfirmar el fondo verde
        Thread.sleep(15000);
        var fondoVerdeDesconfirmar_1 = new DesconfirmarPedidosPage(driver);
        fondoVerdeDesconfirmar_1.clickBotonDesconfirmar();
        
        
//      visualizar y click el fondo verdes para desconfirmar
        Thread.sleep(20000);
        var visualizarVerdeDesconfirmar_2 = new DesconfirmarPedidosPage(driver);
        visualizarVerdeDesconfirmar_2.dobleClickFondoTramado_2();    
        
        
//      click el popup para desconfirmar el fondo verde
        Thread.sleep(15000);
        var fondoVerdeDesconfirmar_2 = new DesconfirmarPedidosPage(driver);
        fondoVerdeDesconfirmar_2.clickBotonDesconfirmar();     
               
             
//      Visualizar el fondo 1 verde en no programado 40502
        Thread.sleep(20000);
        var visibleGrillaFondoVerde1 = new DesconfirmarPedidosPage(driver);
        visibleGrillaFondoVerde1.visualizarFondoVerde_40502();       
        takeScreenshot(testName.getMethodName() + "- Baja fondo verde no programado");

        
//      Visualizar el fondo verde 2 en no programado 40508
        Thread.sleep(20000);
        var visibleGrillaFondoVerde2 = new DesconfirmarPedidosPage(driver);
        visibleGrillaFondoVerde2.visualizarFondoVerde_40508();       
        takeScreenshot(testName.getMethodName() + "- Baja fondo verde no programado");
        
        /*-------------------------------------------------------------------*/        
        
        
        
        

  
    
    }

		
}
        



 


