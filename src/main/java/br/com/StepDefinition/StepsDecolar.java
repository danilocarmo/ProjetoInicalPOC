package br.com.StepDefinition;

import java.util.Calendar;

import br.com.Business.BusinessDecolar;
import br.com.Utils.AcoesUteis;
import br.com.Utils.CalendarUtils;
import br.com.Utils.MontaEvidencia;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class StepsDecolar {

	private BusinessDecolar step;

	public StepsDecolar() {
		step = new BusinessDecolar();
	}

	@Given("^Entrar no site \"([^\"]*)\" \"([^\"]*)\"$")
	public void entrar_no_site(String url, String cenarioTest) throws Throwable {
		MontaEvidencia.criarDirEvidencia(cenarioTest+CalendarUtils.getDataHoraAtual());
		AcoesUteis.AbrirNavegador(url);
	}

	@Given("^selecionar modalidade 'Passagens'$")
	public void selecionar_modalidade_Passagens() throws Throwable {
		step.clicaImgPassagens();
	}

	@Given("^clico no botão 'Ida e Volta'$")
	public void clico_no_botão_Ida_e_Volta() throws Throwable {
		step.clicaBotaoIda_Volta();
	}

	@Given("^digito 'Origem' \"([^\"]*)\"$")
	public void digito_Origem(String texto) throws Throwable {
		step.digitarOrigem(texto);
	}

	@Given("^digito 'Destino' \"([^\"]*)\"$")
	public void digito_Destino(String texto) throws Throwable {
		step.digitarDestino(texto);
	}

	@Given("^digito 'Data Ida' \"([^\"]*)\"$")
	public void digito_Data_Ida(String texto) throws Throwable {
		step.digitarDataIda(texto);
	}

	@Given("^digito 'Data Volta' \"([^\"]*)\"$")
	public void digito_Data_Volta(String texto) throws Throwable {
		step.digitarDataVolta(texto);
	}

	@Given("^clico em 'Procurar'$")
	public void clico_em_Procurar() throws Throwable {
		step.clicarProcurar();
	}
	
	@Then("^verifico valido 'Preço por companhia aérea'$")
	public void verifico_valido_Preço_por_companhia_aérea() throws Throwable {
	     step.elementoPreçoPorCompanhiaAerea();
	}

}
