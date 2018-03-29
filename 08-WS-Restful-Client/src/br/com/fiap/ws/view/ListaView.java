package br.com.fiap.ws.view;


import br.com.fiap.to.Selecao;
import br.com.fiap.ws.service.SelecaoService;

public class ListaView {

	public static void main(String[] args) throws Exception {
		
		SelecaoService ss = new SelecaoService();
		
		
			//Exibe as seleções
			for (Selecao selecao : ss.listar()) {
				System.out.println(selecao.getCodigo());
				System.out.println(selecao.getPais());
				System.out.println(selecao.getNumeroMundiais());
				System.out.println("*********************");
			}
		
		
	}
	
}



