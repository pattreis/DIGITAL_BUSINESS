package br.com.fiap.ws.bean;

import java.util.Calendar;

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

	public void cadastrar() {
		FacesMessage msg;
		try {

			if (paciente.getCodigo() == 0) {

				service.cadastrar(paciente);
				msg = new FacesMessage("Cadastro realizado com sucesso !!!");
				FacesContext.getCurrentInstance().addMessage(null, msg);
			}

		} catch (Exception e) {
			msg = new FacesMessage("Error: " + e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, msg);
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
