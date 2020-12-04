package br.ce.wcaquinho.test;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import br.ce.wcaquinho.core.BaseTest;
import br.ce.wcaquinho.core.DSL;
import br.ce.wcaquinho.page.CampoTreinamentoPage;

@RunWith(Parameterized.class)
public class TesteValidarRegras extends BaseTest {
	
	private WebDriver driver;
	private DSL dsl;
	private CampoTreinamentoPage page;
	
	@Parameter
	public String nome;
	@Parameter(value=1)
	public String sobrenome;
	@Parameter(value=2)
	public String sexo;
	@Parameter(value=3)
	public List<String> comidas;
	@Parameter(value=4)
	public String[] esportes;
	@Parameter(value=5)
	public String msg;
	
	
////	xpath
//	tag nome - //*[@id="elementosForm:nome"]
//	sexo feminino -- //input[@value='F']
//	label pizza -- //label[@for='elementosForm:comidaFavorita:2']
//	Usuário B --//*[@id="tabelaSemJSF"]/tbody/tr[3]/td[1] --não é muito bom usar a forma ingessada melhor usar uma mais dinâmica //*[@id="tabelaSemJSF"]//td[.='Usuario B']
//	botão elemento cujo nome é maria --//input[@onclick="alert('Maria')"] -- //*[@id="elementosForm:tableUsuarios"]//td[.='Maria']/..//input[@type='button']
//	radio do elemento doutorado-- //*[@id="elementosForm:tableUsuarios"]//td[1][.='Doutorado']/..//td[2][.='Doutorado']/..//input[@type='radio']
//	escolaridade superior -- (//*[@id="elementosForm:tableUsuarios"]//td[2][.='Superior'])[2]/..//input[@type='text']
//	
	
	@Before
	public void inicializa(){
		driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		dsl = new DSL();
		page = new CampoTreinamentoPage();
	}
	
	@Parameters
	public static Collection<Object[]> getCollection(){
		return Arrays.asList(new Object[][] {
			{"Raissa", "", "", Arrays.asList(), new String[]{}, "Nome eh obrigatorio"},
			{"Wagner", "", "", Arrays.asList(), new String[]{}, "Sobrenome eh obrigatorio"},
			{"Wagner", "Costa", "", Arrays.asList(), new String[]{}, "Sexo eh obrigatorio"},
			{"Wagner", "Costa", "Masculino", Arrays.asList("Carne", "Vegetariano"), new String[]{}, "Tem certeza que voce eh vegetariano?"},
			{"Wagner", "Costa", "Masculino", Arrays.asList("Carne"), new String[]{"Karate", "O que eh esporte?"}, "Voce faz esporte ou nao?"}		
		});
	}
	
	@Test
	public void deveValidarRegras(){
		page.setNome(nome);
		page.setSobrenome(sobrenome);
		if(sexo.equals("Feminino"))
			page.setSexofeminino();
		if(sexo.equals("Masculino"))
			page.setSexomasculino();
		
		if(comidas.contains("Carne")) page.setComidaCarne();
		if(comidas.contains("Pizza")) page.setComidaPizza();
		if(comidas.contains("Vegetariano")) page.setComidaVegetariano();
		page.setEsporte(esportes);
		page.cadastrar();
		System.out.println(msg);
		Assert.assertEquals(msg, dsl.alertaObterTextoEAceita());
	}
}
