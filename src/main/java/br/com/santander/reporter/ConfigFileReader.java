package br.com.santander.reporter;

import br.com.Utils.Driver;

public class ConfigFileReader {

	public String getReportConfigPath() {
			
		String reportConfigPath = Driver.leitorProperties.getValor("reportConfigPath");
		if(reportConfigPath!= null) return reportConfigPath;
		else throw new RuntimeException("Caminho de configuração do relatório não especificado no arquivo Configuration.properties "
				+ "Caminho deve estar especificado na chave: reportConfigPath");		
	}
}
