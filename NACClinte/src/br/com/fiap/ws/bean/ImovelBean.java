package br.com.fiap.ws.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.fiap.ws.service.ImovelService;
import br.com.fiap.ws.to.Imovel;

@ManagedBean
public class ImovelBean {

	private Imovel imovel;

	private ImovelService service;

	@PostConstruct
	public void Init() {
		service = new ImovelService();
		imovel = new Imovel();
	}

	public String cadastrar() {

		FacesMessage msg;
		try {

			service.cadastrar(imovel);
			msg = new FacesMessage("Cadastrado com Sucesso !");

		} catch (Exception e) {
			e.printStackTrace();
			msg = new FacesMessage("Erro");
		}

		FacesContext.getCurrentInstance().addMessage(null, msg);

		// Manter a mensagem após o redirect
		FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);

		// retorna a página de resposta realizando um redirect.
		return "imovel?faces-redirect=true";
	}

	public List<Imovel> getLista() {
		try {
			return service.listar();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void atualizar() {
		try {
			
		} catch (Exception e) {
			
		}
	}
	

	public Imovel getImovel() {
		return imovel;
	}

	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}

}
