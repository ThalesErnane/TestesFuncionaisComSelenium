package br.ce.wcaquino.tests;

import org.junit.Assert;
import org.junit.Test;

import br.ce.wcaquino.core.BaseTest;
import br.ce.wcaquino.pages.ContasPage;
import br.ce.wcaquino.pages.MenuPage;

public class RemoverContaTest extends BaseTest {

	private MenuPage menuPage = new MenuPage();
	private ContasPage contasPage = new ContasPage();
	
	@Test
	public void test1_RemoverConta() {
		menuPage.acessarTelaListarConta();
		contasPage.clicarExcluirConta("Conta alterada");
		Assert.assertEquals("Conta removida com sucesso!", contasPage.obterMensagemSucesso());
	}
}
