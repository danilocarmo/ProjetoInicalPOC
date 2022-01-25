package br.com.Utils;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import cucumber.api.Scenario;

public class Driver {
	
	
	public Driver() {
		
	}
	
	public static Properties systemProperties = System.getProperties();
	public static LeitorProperties leitorProperties = new LeitorProperties();// cria instancia do LeitorProperties //
	private static WebDriver driver = null; /// Criar Driver statico
	public static Scenario scenario;
	public static File destinationPath;
	
	

	
	public static WebDriver getWebDriver() { // retornar driver
		return driver;
	}
	
	public static String getLeitorProperties(String chave) {
		return leitorProperties.getValor(chave);
	}

	public static void newChromeWebDriver() {
		System.setProperty("webdriver.chrome.driver", "browsers\\chromedriver.exe"); // setar o caminho do Driver
		driver = newChromeDriver(); /// criar Driver do chrome
		//lowerTimeouts();
		raiseTimeouts();
	}

	// Método para criação do Driver para o Navegador "Google Chrome"
	private static ChromeDriver newChromeDriver() {
		ChromeOptions options = new ChromeOptions();

		options.setCapability("applicationCacheEnabled", false);
		options.setExperimentalOption("useAutomationExtension", false);
		options.addArguments("--test-name", "--test-type", "--no-check-default-driver", "--reduce-security-for-testing",
				"--allow-running-insecure-content", // Aceita certificados SSL self-signed
				"--disable-web-security", // Permite chamadas Ajax CORS
				"--no-sandbox", // Permite executar chrome dentro de um container docker
				"--no-first-run", // Evita que o chrome abra popups na inicialização
				"--disable-popup-blocking", "--disable-infobars", "--testing-fixed-https-port", "--start-maximized",
				"--disable-extensions");

		return new ChromeDriver(options);
	}

	public static void lowerTimeouts() {
		Driver.getWebDriver().manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		Driver.getWebDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	public static void raiseTimeouts() {
		Driver.getWebDriver().manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		Driver.getWebDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public static void iniciarNavegador() {
		Driver.newChromeWebDriver();
	}

	public static void fecharBrowser() {

		if (driver != null) {
			getWebDriver().quit();
			driver = null;
		}
	}
	
	
	public static void fecharTudoDepoisDaSuite() {
		if (driver != null) {
			getWebDriver().quit();
			driver = null;
			System.out.println("-------------- fecharTudoDepoisDaSuite getWebDriver().quit()");
		}
			try {
				Runtime.getRuntime().exec(".\\kill_chromedriver_iedriver.bat");
				Thread.sleep(5000);
				System.out.println("-------------- fecharTudoDepoisDaSuite kill_chromedriver_iedriver.bat");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
	}
}
