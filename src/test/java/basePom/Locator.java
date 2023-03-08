package basePom;

import org.openqa.selenium.By;

public interface Locator {
	
	                                 /*       LOCALIZADORES         */ 
	
	/* ************************************************************************************************************ */ 

	
	                                 /*       LOGIN         */ 
	
	By homePageLocator = By.xpath("/html/body/app-root/app-login/div/div[1]/div");
	
	By usuarioLocator = By.id("username");   
	By passwordLocator = By.id("pwd");
	By clicBtnIngresarLocator = By.xpath("/html/body/app-root/app-login/div/div[2]/div/button");
	
	
	                                 /*       PLANTA Y FECHA         */ 
	
	By homeBienvenidoLocator = By.xpath("//h3[contains(text(),\" Bienvenido ZUSR_PROGQAS\")]");
	
	By seleccionarPlantaLocator = By.xpath("/html/body/app-root/app-selector-planta/div/div[2]/div/div[1]/select");
	By fechaLocator = By.name("dp");
	By clickIngresarPlantaLocator = By.id("ingresarPlanta");
		
		
	                                 /*       GRILLA PROGRAMMATE         */ 

	By homePlantaProgramadoLocator = By.id("truckSearchBox");
	
	By recuadroVacioProgramado = By.id("14-02-2023;0000000893;10;30");
	By btnNuevaPropuestaLocator = By.xpath("//*[@class='btn btn-primary btn-sm button-control'][2]");
	By visualizarFondoProgramadoteLocator = By.xpath("(//*[@class='label-programmed-order'])[1]");
	
	By clickBajarPropuestaLocator = By.xpath("//button[text()='Bajar']");
	
	By fondoBajaNoProgramadoLocator = By.xpath("//div[text()=' 40193: ORELLANA CONCHA RAFAEL ']");
	
	By clickActualizarLocator = By.xpath("//button[text()='Actualizar']");
		
	
	//-------------------------------------------------------------------------
	By clickConfirmarLocator = By.xpath("//button[text()='Confirmar']");
		
	By clickDesconfirmarLocator = By.xpath("//button[text()='Desconfirmar']");
		
	By visualizarVerdeDesconfirmado405502Locator = By.xpath("//div[text()=' 40502: ESTACION DE SERVICIO EL VALLE ']");
	By visualizarVerdeDesconfirmado40508Locator = By.xpath("//div[text()=' 40508: COMERCIAL CAMINITO LIMITADA ']");

	
	By clickFondoVerde40502Locator = By.xpath("(//*[@class='label-programmed-order'])[4]");
	
	By clickFondoVerde40508Locator = By.xpath("(//*[@class='label-programmed-order'])[4]");
	
	
	 							/*       LIMPIAR GRILLA PROGRAMMATE         */ 
      
	
	By clickLimpiarLocator = By.xpath("//button[text()='Limpiar']");
	By clickGuardarLocator = By.xpath("//button[text()='Guardar']");
	By clickOkLimpiarLocator = By.xpath("//button[text()='Ok']");

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}
