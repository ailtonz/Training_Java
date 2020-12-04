package br.ce.wcaquinho.test;
import static br.ce.wcaquinho.core.DriverFactory.getDriver;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.ce.wcaquinho.core.BaseTest;
import br.ce.wcaquinho.core.DSL;
import br.ce.wcaquinho.core.DriverFactory;
import br.ce.wcaquinho.page.CampoTreinamentoPage;

public class Cadastro_DSL extends BaseTest{
	private DSL dsl;
	private CampoTreinamentoPage page;

	@Before
	public void inicializa() {
		getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		page = new CampoTreinamentoPage();
	}

	@After
	public void finaliza() {
		DriverFactory.killDriver();
	}

	@Test
	public void deveRealizarCadastroComSucesso() {
		page.setNome("Raissa");
		page.setSobrenome("Rissari");
		page.setSexofeminino();
		page.setComidaPizza();
		page.setEscolaridade("Mestrado");
		page.setEsporte("Natacao");
		page.cadastrar();

		Assert.assertEquals("Cadastrado!", page.obterResultadoCadastro());
		Assert.assertEquals("Raissa", page.obterNomeCadastro());
		Assert.assertEquals("Rissari", page.obterSobrenomeCadastro());
		Assert.assertEquals("Feminino", page.obterSexoCadastro());
		Assert.assertEquals("Pizza", page.obterComidaCadastro());
		Assert.assertEquals("Mestrado", page.obterEscolaridadeCadastro());
		Assert.assertEquals("Natacao", page.obterEsporteCadastro());
	}

	@Test
	public void deveValidarNomeObrigatorio() {
		page.cadastrar();
		Assert.assertEquals("Nome eh obrigatorio", dsl.alertaObterTextoEAceita());
	}

	@Test
	public void deveValidarSobrenomeObrigatorio() {
		page.setNome("Raissa");
		page.cadastrar();

		Assert.assertEquals("Sobrenome eh obrigatorio", dsl.alertaObterTextoEAceita());
	}

	@Test
	public void deveValidarSexoObrigatorio() {
		page.setNome("Raissa");
		page.setSobrenome("Rissari");
		page.cadastrar();

		Assert.assertEquals("Sexo eh obrigatorio", dsl.alertaObterTextoEAceita());
	}

	@Test
	public void deveValidarComidaVegetariana() {
		page.setNome("Raissa");
		page.setSobrenome("Rissari");
		page.setSexofeminino();
		page.setComidaCarne();
		page.setComidaVegetariano();
		page.cadastrar();

		Assert.assertEquals("Tem certeza que voce eh vegetariano?", dsl.alertaObterTextoEAceita());
	}

	@Test
	public void deveValidarEsportistaIndeciso() {
		page.setNome("Raissa");
		page.setSobrenome("Rissari");
		page.setSexofeminino();
		page.setComidaCarne();
		page.setEsporte("Karate", "O que eh esporte?");
		page.cadastrar();

		Assert.assertEquals("Voce faz esporte ou nao?", dsl.alertaObterTextoEAceita());
	}
}
