package br.com.fiap.ws.view;

import java.util.GregorianCalendar;
import java.util.Scanner;

import br.com.fiap.ws.service.PacienteService;
import br.com.fiap.ws.to.Paciente;

public class CadastrarView {
	
	public static void main (String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Paciente paciente = new Paciente();
		
		System.out.println("Informe o nome do paciente:");
		paciente.setNome(sc.nextLine());
		
		paciente.setDataNascimento(new GregorianCalendar(1990, 01, 10));
		
		System.out.println("Doador?\n");
		paciente.setDoador(sc.nextBoolean());
		
		
		PacienteService pacienteService = new PacienteService();
		try {
			pacienteService.cadastrar(paciente);
			System.out.println("Paciente Cadastrado!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
