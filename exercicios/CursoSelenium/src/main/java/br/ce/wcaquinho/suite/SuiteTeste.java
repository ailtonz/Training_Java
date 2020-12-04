package br.ce.wcaquinho.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.ce.wcaquinho.test.Cadastro;
import br.ce.wcaquinho.test.TesteValidarRegras;

@RunWith(Suite.class)
@SuiteClasses({
	Cadastro.class,
	TesteValidarRegras.class
})
public class SuiteTeste {

}
