package br.com.fiap.jsf.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

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
		try {
			
			service.cadastrar(selecao);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
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

}
