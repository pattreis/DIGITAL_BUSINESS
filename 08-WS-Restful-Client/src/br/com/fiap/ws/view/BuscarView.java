package br.com.fiap.ws.view;

import java.util.Scanner;

import br.com.fiap.to.Selecao;
import br.com.fiap.ws.service.SelecaoService;

public class BuscarView {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Digite o código da busca");
		int codigo = sc.nextInt();

		try {
			SelecaoService service = new SelecaoService();
			Selecao selecao = service.buscar(codigo);

			// Exibir os dados

			System.out.println("Pais: "+selecao.getPais());
			System.out.println("Mundiais: " + selecao.getNumeroMundiais());
			System.out.println("Classificado Copa: " + (selecao.isClassificado() == true ? "SIM" : "NÃO"));

		} catch (Exception e) {
			System.out.println(e.getMessage());

		}

	}
}
