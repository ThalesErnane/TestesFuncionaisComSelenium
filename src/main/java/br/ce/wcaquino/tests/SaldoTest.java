package br.ce.wcaquino.tests;

import org.junit.Assert;
import org.junit.Test;

import br.ce.wcaquino.core.BaseTest;
import br.ce.wcaquino.pages.HomePage;

public class SaldoTest extends BaseTest {
	
	private HomePage homePage = new HomePage();
	
	@Test
	public void testSaldoConta() {
		Assert.assertEquals("534.00", homePage.obterSaldoConta("Conta para saldo"));
	}

}
