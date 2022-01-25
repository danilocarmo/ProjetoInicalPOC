package br.com.santander.reporter;

import java.io.File;
import com.cucumber.listener.Reporter;

import br.com.Utils.CalendarUtils;
import br.com.Utils.Driver;

public class CriaRelatorio {
	
	private static String nome;

	// Método criado para montar o relatório
	public static void montaRelatorio() {

		Reporter.loadXMLConfig(new File(FileReaderManager.getInstance().getConfigReader().getReportConfigPath()));
		Reporter.setSystemInfo("Browser: ", "Chrome");
		Reporter.setSystemInfo("Usuário Maquina: ", System.getProperty("user.name"));
		Reporter.setSystemInfo("Ambiente: ", "Testes");
		
	}
	
	
	public static void autor(String txt) {
		Reporter.assignAuthor(txt);
	}

	// Método para mover o relatório para a pasta de relatórios
	public static void renomeiaRelatorio() {
		File dirRelatorio = new File(Driver.leitorProperties.getValor("relatorioDirRaiz"));
		dirRelatorio.mkdirs();
		File arquivo = new File(System.getProperty("user.dir") + "/cucumber-reports/" + "report.html");

		File dirMove = new File(dirRelatorio.toString());

		nome = "report_" + CalendarUtils.getDataHoraAtual() + ".html";
		arquivo.renameTo(new File(dirMove + "", nome));
	}

}
