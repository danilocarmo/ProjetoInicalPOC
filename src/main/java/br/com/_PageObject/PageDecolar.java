package br.com._PageObject;

import org.openqa.selenium.By;

public class PageDecolar {

	
	private By imgPassagens = By.xpath("//a[@title='Passagens']");
	private By buttonIdaVolta = By.xpath("//span[text()='Ida e Volta']");
	private String labelPesquisa = "(//label[text()= \"Origem\"]/../../../../..//h1[text()=\"Passagens aéreas\"]/../../../..//input[@placeholder])";
	private By poupPesquisa = By.xpath("//li[@class='item -active']");
	private By btnProcurar = By.xpath("(//em[text()=\"Procurar\"]/..)[1]");
	private By elementPreçoCompAerea = By.xpath("//*[contains (text(), 'Preços por companhia aérea')]");
	
	
	
	public By getElementPreçoCompAerea() {
		return elementPreçoCompAerea;
	}


	public By getBtnProcurar() {
		return btnProcurar;
	}


	public By getPoupPesquisa() {
		return poupPesquisa;
	}


	public String getLabelPesquisa() {
		return labelPesquisa;
	}


	public By getButtonIdaVolta() {
		return buttonIdaVolta;
	}


	public By getImgPassagens() {
		return imgPassagens;
	}


	


	
	
	
	
}
