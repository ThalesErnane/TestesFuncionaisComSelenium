package br.ce.wcaquino.core;

public class Propriedades {

	public static boolean FECHAR_BROWSER = true; // se for true fecha o browser a cada teste 
	
	public static Browsers BROWSER = Browsers.CHROME; // padrão será 
	
	public static TipoExecucao TIPO_EXECUCAO = TipoExecucao.LOCAL; //obs alterar quando for rodar os testes na NUVEM OU GRID
	// https://app.saucelabs.com/dashboard/tests
	
	// pegar as configurações para efetuar os testes em diferentes plataformas etc
	// https://saucelabs.com/products/platform-configurator#/ 
	
	
	public enum Browsers {
		CHROME, 
		FIREFOX, 
		EDGE
	}
	
	public enum TipoExecucao {
		LOCAL, GRID, NUVEM
	}
	
}
