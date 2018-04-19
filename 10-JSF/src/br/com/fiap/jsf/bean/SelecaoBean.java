package br.com.fiap.jsf.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.fiap.ws.service.SelecaoService;
import br.com.fiap.ws.to.Selecao;

@ManagedBean
public class SelecaoBean {

	private Selecao selecao;
	private String mundiaisSelecionado;
	private SelecaoService service;
	

	@PostConstruct
	private void init() {
		selecao = new Selecao();
		service = new SelecaoService();
	}

	public List<Integer> getMundiais() {
		List<Integer> listMundiais = new ArrayList<Integer>();
		listMundiais.add(0);
		listMundiais.add(1);
		listMundiais.add(2);
		listMundiais.add(3);
		listMundiais.add(4);
		listMundiais.add(5);
		return listMundiais;
	}

	public void cadastrar() {
		FacesMessage msg;
		try {

			if (selecao.getCodigo() == 0) {
				service.cadastrar(selecao);
				msg = new FacesMessage("Sucesso !");
			} else {
				service.atualizar(selecao);
				msg = new FacesMessage("Atualizado!");
			}

		} catch (Exception e) {
			e.printStackTrace();
			msg = new FacesMessage("Error ao atualizar!");
		}

	}

	public void deletar(int codigo) {
		FacesMessage msg;
		try {			
			
			service.remover(codigo);
			msg = new FacesMessage("Removido!");
		} catch (Exception e) {
			msg = new FacesMessage("Erro ao remover!");
		}

		FacesContext.getCurrentInstance().addMessage(null, msg);

	}

	public String getMundiaisSelecionado() {
		return mundiaisSelecionado;
	}

	public void setMundiaisSelecionado(String mundiaisSelecionado) {
		this.mundiaisSelecionado = mundiaisSelecionado;
	}

	public Selecao getSelecao() {
		return selecao;
	}

	public void setSelecao(Selecao selecao) {
		this.selecao = selecao;
	}

	public List<Selecao> getSelecoes() {
		try {

			return service.listar();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
