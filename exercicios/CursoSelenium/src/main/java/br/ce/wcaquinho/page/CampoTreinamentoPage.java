package br.ce.wcaquinho.page;
import org.openqa.selenium.By;

import br.ce.wcaquinho.core.BasePage;
import br.ce.wcaquinho.core.DSL;

public class CampoTreinamentoPage extends BasePage {
	private DSL dsl;
	
	public void setNome(String nome) {
		dsl.escrever("elementosForm:nome", nome);
	}
	
	public void setSobrenome(String sobrenome) {
		dsl.escrever("elementosForm:sobrenome", sobrenome);
	}
	
	public void setSexofeminino() {
		dsl.clicarRadio("elementosForm:sexo:1");
	}
	
	public void setSexomasculino() {
		dsl.clicarRadio("elementosForm:sexo:0");
	}
	
	public void setComidaCarne() {
		dsl.clicarRadio("elementosForm:comidaFavorita:0");
	}
	
	public void setComidaPizza() {
		dsl.clicarRadio("elementosForm:comidaFavorita:2");
	}
	
	public void setComidaVegetariano() {
		dsl.clicarRadio("elementosForm:comidaFavorita:3");
	}
	
	public void setEscolaridade(String escolaridade) {
		dsl.selecionarCombo("elementosForm:escolaridade", escolaridade);
	}
	
	public void setEsporte(String... valores) {
		for(String valor: valores)
			dsl.selecionarCombo("elementosForm:esportes", valor);
	}
	
	public void cadastrar() {
		dsl.clicarBotao("elementosForm:cadastrar");
	}
	
	public String obterResultadoCadastro() {
		return dsl.obterTexto(By.xpath("//*[@id='resultado']/span"));
	}
	
	public String obterNomeCadastro() {
		return dsl.obterTexto(By.xpath("//*[@id='descNome']/span"));
	}
	
	public String obterSobrenomeCadastro() {
		return dsl.obterTexto(By.xpath("//*[@id='descSobrenome']/span"));
	}
	
	public String obterSexoCadastro() {
		return dsl.obterTexto(By.xpath("//*[@id='descSexo']/span"));
	}
	
	public String obterComidaCadastro() {
		return dsl.obterTexto(By.xpath("//*[@id='descComida']/span"));
	}
	
	public String obterEscolaridadeCadastro() {
		return dsl.obterTexto(By.xpath("//*[@id='descEscolaridade']/span"));
	}
	
	public String obterEsporteCadastro() {
		return dsl.obterTexto(By.xpath("//*[@id='descEsportes']/span"));
	}
	
	
}
