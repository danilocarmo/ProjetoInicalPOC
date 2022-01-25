package br.com.Business;

import br.com.Utils.AcoesUteis;
import br.com.Utils.MontaEvidencia;
import br.com._PageObject.Page;

public class PesquisaDolarBusiness {
	
	private Page page;
	public PesquisaDolarBusiness() {
		page = new Page();
	}
	
	public void escreverCampoPesquisa(String arg1) {
		AcoesUteis.escrever(page.getCampoPesquisar(),arg1);
		AcoesUteis.darTab(page.getCampoPesquisar());
	}
	
	
	public void clicarBotaoPesquisar() {
		MontaEvidencia.tiraPrintTela();
		AcoesUteis.clicar(page.getBtnPesquisar());
	}
	
	public void clicarnoLink() {
		AcoesUteis.clicar(page.getLink());
	}
	
	public void clicarAbaEconomia() {
		AcoesUteis.clicar(page.getAbaEconomia());
	}
	
	public String getValorDolar() {	
		AcoesUteis.ScrollPagAteElemento(page.getGetvalorDolar());
		MontaEvidencia.tiraPrintTela();
		return AcoesUteis.lerTexto(page.getGetvalorDolar());
	}
	
	
	
}
