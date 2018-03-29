package br.com.fiap.ws.view;

import java.util.Scanner;

import br.com.fiap.to.Selecao;
import br.com.fiap.ws.service.SelecaoService;

public class AtualizarView {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Selecao selecao = new Selecao();

		System.out.println("Código: ");
		selecao.setCodigo(sc.nextInt());

		System.out.println("País");
		selecao.setPais(sc.nextLine() + sc.nextLine());

		System.out.println("Número Mundiais");
		selecao.setNumeroMundiais(sc.nextInt());

		System.out.println("Classificado?");
		selecao.setClassificado(sc.nextBoolean());

		SelecaoService service = new SelecaoService();
		try {
			service.atualizar(selecao);
			System.out.println("Atualizado!");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

}
