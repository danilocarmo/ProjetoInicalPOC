package br.com.Utils;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

import com.google.common.io.Files;

public class MontaEvidencia {
	
	
	private static String diretorioEv;
	private static String cenario;
	private static int numEvidencia = 1;
	private static File screenshot = null;
	

	 private static void getDiretorioEv() {
		diretorioEv = Driver.getLeitorProperties("evidenciaDirRaiz");
	 }


	private static String getcenarioTest(String cenarioTest) {
		return cenario = cenarioTest;
	}

	private static int getnumEvidencia() {
		return numEvidencia++;
	}

	public static File getScreenshot() throws WebDriverException {
		return ((TakesScreenshot) Driver.getWebDriver()).getScreenshotAs(OutputType.FILE);
	}

	private static void saveScreenshot(String fileName) {

		if (screenshot == null) {
			screenshot = MontaEvidencia.getScreenshot();
			try {
				Files.copy(screenshot, new File(fileName + ".png"));
			} catch (IOException e) {
				throw new RuntimeException("Falha ao Gerar Screenshot.");
			}
		}
		screenshot = null;
	}

	public static void tiraPrintTela() {
		int numEvidencia = MontaEvidencia.getnumEvidencia();
		MontaEvidencia.saveScreenshot(diretorioEv + "\\" + cenario + "\\EV_" + numEvidencia);
	}

	public static void criarDirEvidencia(String cenarioTest) {
		MontaEvidencia.deletePastaTemp();
		MontaEvidencia.getDiretorioEv();
		MontaEvidencia.getcenarioTest(cenarioTest);
		File dirEvidencia = new File(diretorioEv + "\\" + cenario);
		dirEvidencia.mkdirs();
	}

	private static void deletePastaTemp() {

		File temp = new File(System.getProperty("java.io.tmpdir"));

		if (temp.isDirectory()) {
			File[] files = temp.listFiles();

			for (int i = 0; i < files.length; ++i) {
				//System.out.println("---- :" + files[i]);
				files[i].delete();
			}
		}

	}
}
