package br.com._PageObject;

import org.openqa.selenium.By;

public class Page {

 private By campoPesquisar = By.xpath("//input[@title='Pesquisar']");

 private By BtnPesquisar = By.xpath("(//input[@value= 'Pesquisa Google'])[2]");
 
 private By link = By.xpath("//a[@href='https://www.uol.com.br/']");
 
 private By abaEconomia = By.xpath("//span[contains(text(), 'Economia')]");

 private By getvalorDolar = By.xpath("((//div[@name=\"grafico\"])[1]//a[contains(text(),\"R$\")])[2]");
 
 
 /////// geters ///////
 public By getCampoPesquisar() {
		return campoPesquisar;
	}

	public By getBtnPesquisar() {
		return BtnPesquisar;
	}

	public By getLink() {
		return link;
	}
	
	public By getAbaEconomia() {
		return abaEconomia;
	}

	public By getGetvalorDolar() {
		return getvalorDolar;
	}
}
