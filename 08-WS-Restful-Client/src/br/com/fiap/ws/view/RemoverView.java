package br.com.fiap.ws.view;

import java.util.Scanner;

import br.com.fiap.ws.service.SelecaoService;

public class RemoverView {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Informe o código para remover: ");
		int codigo = sc.nextInt();

		try {

			SelecaoService service = new SelecaoService();
			service.remover(codigo);
			System.out.println("Removido");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}
