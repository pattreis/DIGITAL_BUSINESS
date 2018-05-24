package br.com.fiap.ws.service;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import br.com.fiap.ws.to.Imovel;

public class ImovelService {

	private static final String URL = "http://localhost:8080/NACServer/rest/imovel";

	private Client client = Client.create();

	public void cadastrar(Imovel imovel) throws Exception {

		WebResource resource = client.resource(URL);
		ClientResponse resp = resource.type(MediaType.APPLICATION_JSON).post(ClientResponse.class, imovel);

		if (resp.getStatus() != 201) {
			throw new Exception("Erro!");
		}
	}

	public List<Imovel> listar() throws Exception {
		WebResource resource = client.resource(URL);
		ClientResponse response = resource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);

		if (response.getStatus() != 200) {
			throw new Exception("Erro: " + response.getStatus());
		}

		return Arrays.asList(response.getEntity(Imovel[].class));

	}

	public void atualizar(Imovel imovel) throws Exception {
		WebResource resource = client.resource(URL).path(String.valueOf(imovel.getCodigo()));
		ClientResponse resp = resource.type(MediaType.APPLICATION_JSON).post(ClientResponse.class, imovel);

		if (resp.getStatus() != 200) {
			throw new Exception("Erro! "+ resp.getStatus());
		}

	}
}
