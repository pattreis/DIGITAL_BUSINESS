package br.com.fiap.ws.view;

import java.util.Scanner;

import br.com.fiap.ws.service.SelecaoService;
import br.com.fiap.ws.to.Selecao;

public class BuscaView {

	public static void main(String[] args) {
		//Ler o c�digo
		Scanner sc = new Scanner(System.in);
		System.out.println("C�digo");
		int codigo = sc.nextInt();
		
		try {
			//Buscar a Sele��o no web service
			SelecaoService service = new SelecaoService();
			Selecao selecao = service.buscar(codigo);
			//Exibir os dados
			System.out.println(selecao.getPais());
			System.out.println(selecao.getNumeroMundiais());
			System.out.println(selecao.isClassificado());
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		sc.close();
	}
	
}
