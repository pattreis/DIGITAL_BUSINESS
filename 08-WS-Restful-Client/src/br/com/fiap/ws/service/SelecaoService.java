package br.com.fiap.ws.service;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import br.com.fiap.to.Selecao;

// REALIZA ACESSO AO WEB SERVICE
public class SelecaoService {

	// Acessar o web service
	private Client client = Client.create();

	private static final String URL = "http://localhost:8080/07-WS-Restful-Server/rest/selecao";

	public void atualizar(Selecao selecao) throws Exception {

		WebResource resource = client.resource(URL)
				// Adiciona o código na URL
				.path(String.valueOf(selecao.getCodigo()));
		// Chamar o webservice
		ClientResponse response = resource
				// Configura o formato de resposta - JSON
				.type(MediaType.APPLICATION_JSON)
				// Faz a requisição do tipo GET
				.put(ClientResponse.class, selecao);

		if (response.getStatus() != 200) {
			throw new Exception("ERRO:" + response.getStatus());
		}
	}

	public void remover(int codigo) throws Exception {
		WebResource resource = client.resource(URL)
				// Adiciona o código na URL
				.path(String.valueOf(codigo));
		// Chamar o webservice
		ClientResponse response = resource
				// Configura o formato de resposta - JSON
				.type(MediaType.APPLICATION_JSON).delete(ClientResponse.class);

		if (response.getStatus() != 204) {
			throw new Exception("ERRO:" + response.getStatus());
		}
	}

	public Selecao buscar(int codigo) throws Exception {
		WebResource resource = client.resource(URL)
				// Adiciona o código na URL
				.path(String.valueOf(codigo));

		// Chamar o webservice
		ClientResponse response = resource
				// Configura o formato de resposta - JSON
				.accept(MediaType.APPLICATION_JSON)
				// Faz a requisição do tipo GET
				.get(ClientResponse.class);

		if (response.getStatus() != 200) {
			throw new Exception("ERRO:" + response.getStatus());
		}

		return response.getEntity(Selecao.class);
	}

	public void cadastrar(Selecao selecao) throws Exception {
		WebResource resource = client.resource(URL);

		ClientResponse response = resource.type(MediaType.APPLICATION_JSON).post(ClientResponse.class, selecao);

		// Valida se cadastrou HTTP Status 201 Created

		if (response.getStatus() != 201) {
			throw new Exception("ERRO:" + response.getStatus());
		}

	}

	public List<Selecao> listar() throws Exception {
		// Cria o acesso ao web service com a URL
		WebResource resource = client.resource(URL);

		// Chamar o webservice
		ClientResponse response = resource
				// Configura o formato de resposta - JSON
				.accept(MediaType.APPLICATION_JSON)
				// Faz a requisição do tipo GET
				.get(ClientResponse.class);

		// Valida a resposta do servidor
		if (response.getStatus() != 200) {
			throw new Exception("ERRO:" + response.getStatus());

		}
		// Recupera as seleções e retorna um tipo Array
		return Arrays.asList(response.getEntity(Selecao[].class));

	}

}
