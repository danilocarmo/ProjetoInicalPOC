package br.com.Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AcoesUteis {

	public AcoesUteis() {
	}
	
	public static void AbrirNavegador(String url) {
		Driver.iniciarNavegador();
		Driver.getWebDriver().get(url);
	}
	
	public static String obterConteudoPagina() {
		return Driver.getWebDriver().getPageSource();
	}
	
	public static void redirecionarPagina(String url) {
		Driver.getWebDriver().navigate().to(url);
	}

	// Verifica se o elemento esta visivel
	public static boolean isDisplayed(By by) {
		boolean isDisplayed = false;

		try {
			Driver.getWebDriver().findElement(by).isDisplayed();
			isDisplayed = true;
		} catch (org.openqa.selenium.StaleElementReferenceException ex) {

		} catch (org.openqa.selenium.ElementNotVisibleException ex) {

		} catch (NoSuchElementException ex) {

		} catch (Exception ex) {

		} finally {
		}

		return isDisplayed;
	}

	// Verifica se o elemento esta disponivel para iteração
	public static boolean isEnabled(By by) {
		boolean isEnabled = true;

		if (Driver.getWebDriver().findElement(by).isEnabled()) {
			isEnabled = true;
		} else {
			isEnabled = false;
		}

		return isEnabled;
	}

	public static void darTab(By by) {
		Driver.getWebDriver().findElement(by).sendKeys(Keys.TAB);
	}

	public static void darEnd(By by) {
		Driver.getWebDriver().findElement(by).sendKeys(Keys.END);
	}

	public static void limparCampo(By by) {
		Driver.getWebDriver().findElement(by).clear();
		AcoesUteis.wait(500);
	}

	public static void refresh() {
		Driver.getWebDriver().navigate().refresh();
	}

	public static void escrever(By by, String texto) {
		try {
			Driver.getWebDriver().findElement(by).sendKeys(texto);
		} catch (Exception e) {
			Driver.getWebDriver().findElement(by).clear();
			Driver.getWebDriver().findElement(by).sendKeys(texto);
		}
	}
	
	public static void escreverCaracterPorCaracter(By by, String texto) {
		int contador = 0;

		do {
			try {

				AcoesUteis.wait(500);
				WebElement element = Driver.getWebDriver().findElement(by);
				for (int i = 0; i < texto.length(); i++) {
					String escreve = String.valueOf(texto.charAt(i));
					element.sendKeys(escreve);
				}
				return;
			} catch (Exception ex) {
				AcoesUteis.wait(500);
				contador++;
			}
		} while (contador <= 20);
	}
	
	public static void clicar(By by) {

		try {
			Driver.getWebDriver().findElement(by).click();
		} catch (org.openqa.selenium.StaleElementReferenceException ex) {
			AcoesUteis.ScrollPagAteElemento(by);
			Driver.getWebDriver().findElement(by).click();
		} catch (org.openqa.selenium.ElementNotVisibleException ex) {
			Driver.getWebDriver().findElement(by).click();
		} catch (org.openqa.selenium.JavascriptException ex) {
			AcoesUteis.ScrollPagAteElemento(by);
			Driver.getWebDriver().findElement(by).click();
		} finally {
		}

	}

	// ***********************Select para ComboBox*****************************

	public static void selecionarComboPorTextoVisivel(By by, String visibleText) {
		Select combobox = new Select(Driver.getWebDriver().findElement(by));
		combobox.selectByVisibleText(visibleText);
	}

	public static void selecionarComboPorIndex(By by, int index) {
		Select combo = new Select(Driver.getWebDriver().findElement(by));
		combo.selectByIndex(index);
	}

	public static void selecionarComboPorValue(By by, String value) {
		Select combo = new Select(Driver.getWebDriver().findElement(by));
		combo.selectByValue(value);
	}

	public static void passeCimaElemento(By by) throws InterruptedException {
		Actions action = new Actions(Driver.getWebDriver());
		action.moveToElement(Driver.getWebDriver().findElement(by)).click().build().perform();
	}

	public static void clicarElemento(By by) throws InterruptedException {
		Actions action = new Actions(Driver.getWebDriver());
		action.click(Driver.getWebDriver().findElement(by)).build().perform();
	}
	
	public static void escreverComJavaScript(By by, String texto) {
		Driver.getWebDriver().findElement(by).clear();
		AcoesUteis.wait(500);
		
		JavascriptExecutor js = (JavascriptExecutor) Driver.getWebDriver();

		try {
			js.executeScript("arguments[0].setAttribute('value','" + texto + "');", Driver.getWebDriver().findElement(by));

		} catch (org.openqa.selenium.StaleElementReferenceException ex) {
			ScrollPagAteElemento(by);
			js.executeScript("arguments[0].value='" + texto + "');", Driver.getWebDriver().findElement(by));
		}
	}
	
	public static void clicaComJavaScript(By by) {

		JavascriptExecutor js = (JavascriptExecutor) Driver.getWebDriver();

		try {

			js.executeScript("arguments[0].click();", Driver.getWebDriver().findElement(by));

		} catch (org.openqa.selenium.NoSuchElementException ex) {
			AcoesUteis.wait(1000);
		} catch (org.openqa.selenium.StaleElementReferenceException ex) {
			ScrollPagAteElemento(by);
			js.executeScript("arguments[0].click();", Driver.getWebDriver().findElement(by));
		} finally {
		}

	}

	public static void ScrollPagAteElemento(By by) {
		JavascriptExecutor js = (JavascriptExecutor) Driver.getWebDriver();
		js.executeScript("arguments[0].scrollIntoView(true);", Driver.getWebDriver().findElement(by));
		AcoesUteis.wait(500);
	}

	public static WebElement waitVisibilityOf(By by, int segundosAteTimeout) {
		WebDriverWait wait = new WebDriverWait(Driver.getWebDriver(), segundosAteTimeout);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(by));

	}
	
	
	public static  String lerTexto(By by) {
		return Driver.getWebDriver().findElement(by).getText();
	}
	
	
	public static void wait(final int iTimeInMillis) {
		try {
			Thread.sleep(iTimeInMillis);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
	}
}
