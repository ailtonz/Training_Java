package br.ce.wcaquinho.test;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Cadastro {
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
	public void desafioCadastroComSucesso() {
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Raissa");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Cardoso");
		driver.findElement(By.id("elementosForm:sexo:1")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:2")).click();
		
		new Select(driver.findElement(By.id("elementosForm:escolaridade"))).selectByValue("especializacao"); // isso é igual as três linhas de baixo
//		WebElement elementEscolaridade = driver.findElement(By.id("elementosForm:escolaridade"));
//		Select selectEscolaridade = new Select(elementEscolaridade);
//		selectEscolaridade.selectByValue("especializacao");
//		
		WebElement elementEsporte = driver.findElement(By.id("elementosForm:esportes"));
		Select selectEsporte = new Select(elementEsporte);
		selectEsporte.selectByValue("natacao");
		
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		
		Assert.assertTrue(driver.findElement(By.id("resultado")).getText().startsWith("Cadastrado!"));
		Assert.assertTrue(driver.findElement(By.id("descNome")).getText().endsWith("Raissa"));
		Assert.assertEquals("Sobrenome: Cardoso", driver.findElement(By.id("descSobrenome")).getText());
		Assert.assertEquals("Sexo: Feminino",driver.findElement(By.id("descSexo")).getText());
		Assert.assertEquals("Comida: Pizza", driver.findElement(By.id("descComida")).getText());
		Assert.assertEquals("Escolaridade: especializacao",driver.findElement(By.id("descEscolaridade")).getText());
		Assert.assertEquals("Esportes: Natacao", driver.findElement(By.id("descEsportes")).getText());
	}
	
}
