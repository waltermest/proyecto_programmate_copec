package testProgrammate;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import pagePom.LoginPage;

public class Login_Test {
	
	private static final String EXTENSION_IMAGEN = ".png";
	private WebDriver driver;
	LoginPage loginPage;
	

	//Validación de capturas de evidencias	
		public void capturarPantalla(WebDriver driver, String nombreImagen) throws IOException {

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("./screenshots/" + nombreImagen + EXTENSION_IMAGEN));
		scrFile.delete();
		
		}

	@Before
	public void setUp() throws Exception {
		loginPage = new LoginPage(driver); 
		driver = loginPage.chromeDriverConnection();
		driver.manage().window().maximize();
		loginPage.visit("https://stg.programmate.copec.cl/");
//		https://stg.programmate.copec.cl/
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		 
	}

	@After
	public void tearDown() throws Exception {
//		driver.quit();
	}

	@Test
	public void LoginTest() throws InterruptedException, IOException {
		loginPage.login();
//		Thread.sleep(3000);
		assertTrue(loginPage.HomePageDisplayed());
		capturarPantalla(driver, "Pag_Login" + "-- Se visualiza correctamente el Login");
		
	}
}

