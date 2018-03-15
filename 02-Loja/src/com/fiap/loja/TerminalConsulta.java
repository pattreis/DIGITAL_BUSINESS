package com.fiap.loja;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

import com.fiap.loja.to.ProdutoTO;

import br.com.fiap.config.PropertySingleton;

public class TerminalConsulta {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//Recuperar a data do sistema
		SimpleDateFormat sdf = 
				new SimpleDateFormat("dd/MM/yyyy HH:mm"); 
		DecimalFormat df = new DecimalFormat("R$ #,###.00");
		int opcao;
		EstoqueBO bo = new EstoqueBO();
		String nome = PropertySingleton
				.getInstance().getProperty("organizacao");
		do{
			Calendar calendar = Calendar.getInstance();
			System.out.println(nome+ "         "
					+ sdf.format(calendar.getTime()));
			System.out.println("***************************");
			System.out.println("1 - Pesquisar");
			System.out.println("0 - Sair");
			System.out.print("Opção: ");
			opcao = sc.nextInt();
			if (opcao == 1) {
				System.out.print("Código do produto: ");
				int codigo = sc.nextInt();
				ProdutoTO prod = bo.consultarProduto(codigo);
				if (prod == null) {
					System.out.println("Produto não cadastrado");
				} else {
					System.out.println(prod.getNome());
					System.out.println(prod.getDescricao());
					System.out.println(df.format(prod.getPreco()));
				}
			}
		}while(opcao != 0);
		sc.close();
	}
	
}





