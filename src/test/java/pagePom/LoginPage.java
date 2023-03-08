package pagePom;

import org.openqa.selenium.WebDriver;
import basePom.Base;
import basePom.Locator;


public class LoginPage extends Base implements Locator {

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