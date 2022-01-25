package br.com.Utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LeitorProperties {

	 private Properties props;
	 
	    public LeitorProperties() {
	    	
	        props = new Properties();
	        InputStream in = this.getClass().getClassLoader().getResourceAsStream("Configuration.properties");
	        try {
	            props.load(in);
	            in.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	 
	    public String getValor(String chave) {
	        return props.getProperty(chave);
	    }
	    
}
