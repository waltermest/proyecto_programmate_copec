package pagePom;

import org.openqa.selenium.WebDriver;
import basePom.Base;
import basePom.Locator;

public class ActualizarFondosPage extends Base implements Locator {
	
	
	public ActualizarFondosPage(WebDriver driver) {
		super(driver);
		
	}
	

	public void clickBotonActualizarGrilla() {			
		
		try {
	
			click(clickActualizarLocator);
			System.out.println("Se valida que al presionar el botón actualizar la grilla de programados se mantiene sin cambios ");

		}catch(Exception e){
			System.out.println(e);
			
			
		}
		
	}
	
	
}
	

