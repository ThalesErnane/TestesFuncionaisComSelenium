package br.ce.wcaquino.core;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import br.ce.wcaquino.core.Propriedades.TipoExecucao;

public class DriverFactory {

	private static WebDriver driver;

	private DriverFactory() {
	}

	public static WebDriver getDriver() {
		
		if(Propriedades.TIPO_EXECUCAO == TipoExecucao.LOCAL) {
			if (driver == null) {
				switch (Propriedades.BROWSER) {
				case FIREFOX:
					driver = new FirefoxDriver();
					break;
				case CHROME:
					driver = new ChromeDriver();
					break;
				case EDGE:
					driver = new EdgeDriver();
					break;
				}
			}
		}
			if(Propriedades.TIPO_EXECUCAO == TipoExecucao.GRID) {
				DesiredCapabilities cap = null;
				
				switch (Propriedades.BROWSER) {
				case FIREFOX:
					cap = DesiredCapabilities.firefox();
					break;
				case CHROME:
					cap = DesiredCapabilities.chrome();
					break;
				case EDGE:
					cap = DesiredCapabilities.edge();
					break;
				}
				
				try {
					// url da maq no GRID
					driver = new RemoteWebDriver(new URL("http://192.168.0.184:4444/wd/hub"), cap);
				} catch (MalformedURLException e) {
					System.out.println("Falha na conexão com o GRID");
					e.printStackTrace();
				}
			}
			
			if(Propriedades.TIPO_EXECUCAO == TipoExecucao.NUVEM) {
				DesiredCapabilities cap = null;
				
				switch (Propriedades.BROWSER) {
				case FIREFOX:
					cap = DesiredCapabilities.firefox();
					break;
				case CHROME:
					cap = DesiredCapabilities.chrome();
					break;
				case EDGE:
					cap = DesiredCapabilities.edge();
					break;
				}
				
				try {
					
					driver = new RemoteWebDriver(new 
							URL("https://oauth-talesernani-f71eb:05fee576-a343-4307-8125-ef331fc9d5e6@ondemand.us-west-1.saucelabs.com:443/wd/hub"), cap);
				} catch (MalformedURLException e) {
					System.out.println("Falha na conexão com a NUVEM");
					e.printStackTrace();
				}
			}

		driver.manage().window().setSize(new Dimension(1200, 765));
		return driver;
	}

	public static void killDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}

	}

}
