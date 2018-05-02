package br.com.fiap.ws.bean;

import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.fiap.ws.service.PacienteService;
import br.com.fiap.ws.to.Paciente;

@ManagedBean
public class PacienteBean {

	private Paciente paciente;
	private PacienteService service;

	@PostConstruct
	private void init() {
		paciente = new Paciente();
		paciente.setDataNascimento(Calendar.getInstance());
		service = new PacienteService();
	}

	public String excluir(int codigo) {
		FacesMessage msg;
		try {
			service.remover(codigo);
			msg = new FacesMessage("Removido com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
			msg = new FacesMessage("Error...");
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);
		return "lista-paciente?faces-redirect=true";
	}

	public String cadastrar() {
		FacesMessage msg;
		try {

			if (paciente.getCodigo() == 0) {

				service.cadastrar(paciente);
				msg = new FacesMessage("Cadastro realizado com sucesso !!!");
				FacesContext.getCurrentInstance().addMessage(null, msg);
			} else {

				service.atualizar(paciente);
				msg = new FacesMessage("Atualizado sucesso!");
			}

		} catch (Exception e) {
			e.printStackTrace();
			msg = new FacesMessage("Error: " + e.getMessage());
		}

		FacesContext.getCurrentInstance().addMessage(null, msg);
		return "lista-paciente?faces-redirect=true"; // direciona para a pagina de lista-pacientes já com um redirect

	}

	public List<Paciente> getPacientes() {
		try {
			return service.listar();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public PacienteService getService() {
		return service;
	}

	public void setService(PacienteService service) {
		this.service = service;
	}

}
