package br.com.StepDefinition;

import br.com.Business.PesquisaDolarBusiness;
import br.com.Utils.AcoesUteis;
import br.com.Utils.Driver;
import br.com.Utils.MontaEvidencia;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class Steps {

	private PesquisaDolarBusiness business;

	public Steps() {
		business = new PesquisaDolarBusiness();
	}

	
	@Given("^Entrar no site do 'Google' \"([^\"]*)\" \"([^\"]*)\"$")
	public void entrar_no_site_do_Google(String url, String cenarioTest) throws Throwable {
		MontaEvidencia.criarDirEvidencia(cenarioTest);
		AcoesUteis.AbrirNavegador(url);
	}

	
	@Given("^no campo de pesquisa pesquisar por \"([^\"]*)\"$")
	public void no_campo_de_pesquisa_pesquisar_por(String arg1) throws Throwable {
		business.escreverCampoPesquisa(arg1);
	}

	@Given("^clico no 'botão de Pesquisa'$")
	public void clico_no_botão_de_Pesquisa() throws Throwable {
		business.clicarBotaoPesquisar();
	}

	@Given("^clico no link do site pesquisado para direcionamento$")
	public void clico_no_link_do_site_pesquisado_para_direcionamento() throws Throwable {
		business.clicarnoLink();
	}

	@Given("^clico na aba de 'Economia'$")
	public void clico_na_aba_de_Economia() throws Throwable {
		business.clicarAbaEconomia();
	}

	@Then("^verifico a cotação do Dólar$")
	public void verifico_a_cotação_do_Dólar() throws Throwable {

		System.out.println("Cotação do Dólar: " + business.getValorDolar());
		Driver.fecharBrowser();
		
	}

}
