package br.ce.wcaquinho.core;

import org.junit.After;

public class BaseTest {

	@After
	public void finaliza() {
		if (Propriedades.FECHAR_BROWSER)
			DriverFactory.killDriver();
	}
}
