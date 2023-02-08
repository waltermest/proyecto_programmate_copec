package pagePom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import basePom.Base;


public class LoginPage extends Base {

	By usuarioLocator = By.id("username");   
	By passwordLocator = By.id("pwd");
	By clicBtnIngresarLocator = By.xpath("/html/body/app-root/app-login/div/div[2]/div/button");
	
	By homePageLocator = By.xpath("/html/body/app-root/app-login/div/div[1]/div");
	
	
	public LoginPage(WebDriver driver) {
		super(driver);
		
	}
	
	public void login() {
     
		 if (isDisplayed(usuarioLocator)) {
			 type("ZUSR_PROGQAS", usuarioLocator);
			 type("Rfc.01012023", passwordLocator);
			 click(clicBtnIngresarLocator);
			 
		 } else {
			 
			 System.out.println("No se visualiza el home de copec");
		 }
				
     }

	public boolean HomePageDisplayed() {
	return isDisplayed(homePageLocator);
	
   }

}