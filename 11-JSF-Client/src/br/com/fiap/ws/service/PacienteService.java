package br.com.fiap.ws.service;


import java.util.Arrays;
import java.util.List;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import br.com.fiap.ws.to.Paciente;

public class PacienteService {

	private Client client = Client.create();

	private static final String URL = "http://localhost:8080/09-WS-Restful-Health/rest/paciente";

	public void cadastrar(Paciente paciente) throws Exception {
		WebResource resource = client.resource(URL);

		ClientResponse response = resource.type(MediaType.APPLICATION_JSON).post(ClientResponse.class, paciente);
		if (response.getStatus() != 201) {
			throw new Exception("Erro ao inserir: " + response.getStatus());
		}
	}

	public Paciente buscar(int codigo) throws Exception {
		WebResource resource = client.resource(URL).path(String.valueOf(codigo));

		ClientResponse response = resource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);

		if (response.getStatus() != 200) {
			throw new Exception("Error código: " + response.getStatus());
		}
		return response.getEntity(Paciente.class);
	}

	public List<Paciente> listar() throws Exception {
		WebResource resource = client.resource(URL);

		ClientResponse response = resource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);

		if (response.getStatus() != 200) {
			throw new Exception("Error código: " + response.getStatus());
		}
		return Arrays.asList(response.getEntity(Paciente[].class));
	}

	public void atualizar(Paciente paciente) throws Exception {
		WebResource resource = client.resource(URL);

		ClientResponse response = resource.type(MediaType.APPLICATION_JSON).put(ClientResponse.class, paciente);

		if (response.getStatus() != 200) {
			throw new Exception("Error: " + response.getStatus());
		}
	}

	public void remover(int codigo) throws Exception {
		WebResource resource = client.resource(URL).path(String.valueOf(codigo));

		ClientResponse response = resource.delete(ClientResponse.class);

		if (response.getStatus() != 204) {
			throw new Exception("Error: " + response.getStatus());
		}

	}

}
