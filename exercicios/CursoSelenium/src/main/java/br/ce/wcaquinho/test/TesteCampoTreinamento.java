package br.ce.wcaquinho.test;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteCampoTreinamento {
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
	public void testeTextField() {
		driver.findElement(By.id("elementosForm:nome")).sendKeys("teste de escrita");
//		driver.findElement(By.id("elementosForm:nome")).getText(); //não da o valor que está dentro do textfield
		Assert.assertEquals("teste de escrita", driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));
	}

	@Test
	public void deveInteragirRadioButton() {
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		Assert.assertTrue(driver.findElement(By.id("elementosForm:sexo:0")).isSelected()); // porque ele é boleano da
																							// para fazer direto aqui
	}

	@Test
	public void deveInteragirCheckBox() {
		driver.findElement(By.id("elementosForm:comidaFavorita:2")).click();
		Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:2")).isSelected()); // porque ele é
																										// boleano da
																										// para fazer
																										// direto aqui
	}

	@Test
	public void deveInteragirTextArea() {
		driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("teste\nteste\n"); // como escrever várias linhas
		Assert.assertEquals("teste\nteste\n",
				driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));
	}

	@Test
	public void deveVerificarCombo() {
		WebElement element = driver.findElement(By.id("elementosForm:escolaridade")); // como escrever várias linhas
		Select combo = new Select(element);

//		combo.selectByIndex(2); esse é por index.
//		combo.selectByValue("superior"); //esse é o valor que está no código
		combo.selectByVisibleText("2o grau completo"); // esse é o valor visivel

		Assert.assertEquals("2o grau completo", combo.getFirstSelectedOption().getText());
	}

	@Test
	public void deveVerificarValoresCombo() {
		WebElement element = driver.findElement(By.id("elementosForm:escolaridade")); // como escrever várias linhas
		Select combo = new Select(element);
		List<WebElement> options = combo.getOptions(); // para aparecer a lista sem precisar digitar tudo use o atalho
														// CTRL+1
		Assert.assertEquals(8, options.size());// verificar o tamanho de itens do combo

		boolean encontrou = false;
		for (WebElement option : options) {
			if (option.getText().equals("Mestrado")) {
				encontrou = true;
				break;
			}
		}

		Assert.assertTrue(encontrou);
	}

	@Test
	public void deveVerificarComboMultiplo() {
		WebElement element = driver.findElement(By.id("elementosForm:esportes")); // como escrever várias linhas
		Select combo = new Select(element);
		combo.selectByVisibleText("Natacao");
		combo.selectByVisibleText("Corrida");
		combo.selectByVisibleText("O que eh esporte?");

		List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
		Assert.assertEquals(3, allSelectedOptions.size()); // verifica quantos itens foram selecionados

		combo.deselectByVisibleText("Corrida"); // tirar a seleção de um item
		allSelectedOptions = combo.getAllSelectedOptions();
		Assert.assertEquals(2, allSelectedOptions.size()); // verifica quantos itens foram selecionados
	}

	@Test
	public void deveInteragirComBotões() {
		WebElement botao = driver.findElement(By.id("buttonSimple"));
		botao.click();
		

		Assert.assertEquals("Obrigado!", botao.getAttribute("value"));
	}
	
	@Test
//	@Ignore //isso diz para o junit não rodar esse teste
	public void deveInteragirComLinks() {
		driver.findElement(By.linkText("Voltar")).click();
//		Assert.fail();//usar em testes que vc não terminou para não dar um falso positivo e faz com que não me esqueça do texto mas não é o jeito mas elegante
		Assert.assertEquals("Voltou!", driver.findElement(By.id("resultado")).getText());
	}
	
	@Test
	public void deveBuscarTextosNaPagina() {
//		Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("Campo de Treinamento")); //busca por todo o arquivo
		Assert.assertEquals("Campo de Treinamento", driver.findElement(By.tagName("h3")).getText());
		Assert.assertEquals("Cuidado onde clica, muitas armadilhas...", driver.findElement(By.className("facilAchar")).getText());
	}
}
