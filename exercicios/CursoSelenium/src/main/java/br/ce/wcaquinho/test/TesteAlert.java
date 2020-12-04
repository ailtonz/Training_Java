package br.ce.wcaquinho.test;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteAlert {
	private WebDriver driver;
	
	@Before
	public void inicializa() {
		driver = new FirefoxDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
	}
	
	@After
	public void finaliza() {
		driver.quit();
	}
	
	@Test
	public void deveInteragirComAlertSimples() {
		driver.findElement(By.id("alert")).click();
		Alert alert = driver.switchTo().alert(); //mudar o foco
		String texto = alert.getText();
		Assert.assertEquals("Alert Simples", texto);
		alert.accept(); //clicar no ok do alert
		driver.findElement(By.id("elementosForm:nome")).sendKeys(texto);
	}
	
	@Test
	public void deveInteragirComAlertConfirm() {
		driver.findElement(By.id("confirm")).click();
		Alert alert = driver.switchTo().alert();
		
		Assert.assertEquals("Confirm Simples", alert.getText());
		alert.accept(); //confimar
		Assert.assertEquals("Confirmado", alert.getText());
		alert.accept(); //confimar
		
		driver.findElement(By.id("confirm")).click();
		alert.dismiss(); //cancelar
		Assert.assertEquals("Negado", alert.getText());
		alert.dismiss(); //confimar
	}
	
	@Test
	public void deveInteragirComAlertPrompt() {
		driver.findElement(By.id("prompt")).click();
		Alert alert = driver.switchTo().alert(); //mudar o foco
		Assert.assertEquals("Digite um numero", alert.getText());
		alert.sendKeys("12");
		alert.accept(); //clicar no ok do alert
		Assert.assertEquals("Era 12?", alert.getText());
		alert.accept();
		Assert.assertEquals(":D", alert.getText());
		alert.accept();
	}
}
