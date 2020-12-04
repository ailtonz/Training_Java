package br.ce.wcaquinho.test;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.ce.wcaquinho.core.DSL;
import br.ce.wcaquinho.core.DriverFactory;

public class TesteAjax {
	
	private WebDriver driver;
	private DSL dsl;

	@Before
	public void inicializa() {
		driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("https://www.primefaces.org/showcase/ui/ajax/basic.xhtml");
		dsl = new DSL();
	}

	@After
	public void finaliza() {
		driver.quit();
	}

	@Test
	public void testAjax() {
		dsl.escrever("j_idt720:name", "Teste");
		dsl.clicarBotao("j_idt720:j_idt723");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.textToBe(By.id("j_idt720:display"), "Teste"));
		Assert.assertEquals("Teste", dsl.obterTexto("j_idt720:display"));
	}

}
