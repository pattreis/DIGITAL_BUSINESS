package br.com.fiap.ws.view;

import java.util.Scanner;

import br.com.fiap.to.Selecao;
import br.com.fiap.ws.service.SelecaoService;

public class CadastrarView {

	public static void main(String[] args) throws Exception {
		// Ler os dados

		Scanner sc = new Scanner(System.in);

		Selecao selecao = new Selecao();

		System.out.println("País");
		selecao.setPais(sc.nextLine());

		System.out.println("Mundiais");
		selecao.setNumeroMundiais(sc.nextInt());

		System.out.println("Classificado");
		selecao.setClassificado(sc.nextBoolean());

		SelecaoService service = new SelecaoService();

		try {

			service.cadastrar(selecao);
			System.out.println("Cadastrado!");
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		sc.close();

	}

}
