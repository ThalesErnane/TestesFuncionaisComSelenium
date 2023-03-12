package br.ce.wcaquino.suites;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.ce.wcaquino.pages.LoginPage;
import br.ce.wcaquino.tests.ContaTest;
import br.ce.wcaquino.tests.MovimentacaoTest;
import br.ce.wcaquino.tests.RemoverContaTest;
import br.ce.wcaquino.tests.RemoverMovimentacaoContaTest;
import br.ce.wcaquino.tests.ResumoTest;
import br.ce.wcaquino.tests.SaldoTest;

@RunWith(Suite.class)
@SuiteClasses({
	ContaTest.class,
	MovimentacaoTest.class,
	RemoverMovimentacaoContaTest.class,
	SaldoTest.class,
	ResumoTest.class,
	RemoverContaTest.class
})
public class SuiteGeral {
	// ace
	private static LoginPage page = new LoginPage();
	
	@BeforeClass
	public static void inicializa() {
		page.acessarTelaInicial();
		page.logar("talesernani@gmail.com", "th@les123");
		// page.entrar();
	}
}
