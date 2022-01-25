package br.com.Business;

import org.openqa.selenium.By;

import br.com.Utils.AcoesUteis;
import br.com.Utils.MontaEvidencia;
import br.com._PageObject.PageDecolar;

public class BusinessDecolar {

	
	private PageDecolar page;

	public BusinessDecolar() {
		
		page = new PageDecolar();
	}
	
	public void clicaImgPassagens () {
		AcoesUteis.clicar(page.getImgPassagens());
	}
	
	public void clicaBotaoIda_Volta() {
		AcoesUteis.waitVisibilityOf(page.getButtonIdaVolta(), 3);
		AcoesUteis.clicar(page.getButtonIdaVolta());
	}
	
	public void digitarOrigem(String texto) {
		
		By origem = By.xpath(page.getLabelPesquisa()+"[1]");
		
		AcoesUteis.limparCampo(origem);
		AcoesUteis.escrever(origem, texto);
		this.popUpPesquisa();
	}
	
	public void popUpPesquisa() {
		AcoesUteis.waitVisibilityOf(page.getPoupPesquisa(), 3);
		AcoesUteis.clicar(page.getPoupPesquisa());
		AcoesUteis.wait(500);
	}
	
	public void digitarDestino(String texto) {
		
		By origem = By.xpath(page.getLabelPesquisa()+"[2]");
		
		AcoesUteis.escrever(origem, texto);
		this.popUpPesquisa();
	}
	
	public void digitarDataIda(String texto) {
		
		By origem = By.xpath(page.getLabelPesquisa()+"[3]");
		AcoesUteis.clicaComJavaScript(origem);
		AcoesUteis.clicar(By.xpath("//span[text()='Dezembro']/../..//span[text()='"+texto+"']/.."));
		AcoesUteis.wait(500);
	
	}

	public void digitarDataVolta(String texto) {
	
	By origem = By.xpath(page.getLabelPesquisa()+"[4]");
	AcoesUteis.clicaComJavaScript(origem);
	AcoesUteis.clicar(By.xpath("//span[text()='Dezembro']/../..//span[text()='"+texto+"']/.."));
	AcoesUteis.wait(500);
	
   }
	
	
	public void clicarProcurar() {
		AcoesUteis.clicar(page.getBtnProcurar());
	}
	
	public void elementoPreçoPorCompanhiaAerea() {
		AcoesUteis.waitVisibilityOf(page.getElementPreçoCompAerea(), 120);
		AcoesUteis.clicaComJavaScript(page.getElementPreçoCompAerea());
		AcoesUteis.wait(3000);
		MontaEvidencia.tiraPrintTela();
	}
	
}
