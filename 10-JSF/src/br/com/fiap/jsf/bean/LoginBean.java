package br.com.fiap.jsf.bean;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class LoginBean {
	
	private String login;
	private String password;
	
	public void validarLogin() {
		
		if (login.equals("patrick") && password.equals("123456")) {
			System.out.println("Logado com sucesso!");
		}
		
	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
