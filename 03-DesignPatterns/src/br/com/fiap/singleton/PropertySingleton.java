package br.com.fiap.singleton;

import java.io.IOException;
import java.util.Properties;

public class PropertySingleton {

	//1 - Atributo estático que mantem a única instancia
	private static Properties prop;
	
	//3 - Construtor private
	private PropertySingleton() { }
	
	//2 - Método estático getInstance que retorna a única instancia
	public static Properties getInstance() {
		if (prop == null) {
			prop = new Properties();
			//carregar o arquivo com as propriedades
			try {
				prop.load(PropertySingleton.class
						.getResourceAsStream("/config.properties"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return prop;
	}
	
}