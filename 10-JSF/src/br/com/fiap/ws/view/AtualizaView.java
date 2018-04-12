package br.com.fiap.ws.view;

import java.util.Scanner;

import br.com.fiap.ws.service.SelecaoService;
import br.com.fiap.ws.to.Selecao;

public class AtualizaView {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//Ler os dados
		Selecao selecao = new Selecao();
		
		System.out.println("Codigo");
		selecao.setCodigo(sc.nextInt());
		
		System.out.println("Pa�s");
		selecao.setPais(sc.next() + sc.nextLine());
		
		System.out.println("N�mero Mundiais");
		selecao.setNumeroMundiais(sc.nextInt());
		
		System.out.println("Classificado?");
		selecao.setClassificado(sc.nextBoolean());
		
		//Atualializar atrav�s do webservice
		SelecaoService service = new SelecaoService();
		try {
			service.atualizar(selecao);
			System.out.println("Atualizado!");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		sc.close();
	}
	
}
