package br.com.fiap.resource;

import java.util.List;

import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.Status;

import br.com.fiap.entity.Jogador;
import br.com.fiap.jpa.dao.JogadorDAO;
import br.com.fiap.jpa.dao.impl.JogadorDAOImpl;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.KeyNotFoundException;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

@Path("/jogador")
public class JogadorResource {

	JogadorDAO dao;

	public JogadorResource() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		dao = new JogadorDAOImpl(em);
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Jogador pesquisar(@PathParam("id") int codigo) {

		return dao.pesquisar(codigo);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Jogador> listar() {
		return dao.listar();
	}

	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar(Jogador jogador, @PathParam("id") int codigo) {
		try {

			jogador.setCodigo(codigo);
			dao.atualizar(jogador);
			dao.commit();

		} catch (CommitException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}

		return Response.ok().build();
	}
	
	@DELETE
	@Path("{id}")
	public void apagar(@PathParam("id") int codigo) throws KeyNotFoundException {
		
		try {

			dao.remover(codigo);
			dao.commit();
		} catch (CommitException e) {
			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(Jogador jogador, @Context UriInfo uri) {

		try {
			dao.inserir(jogador);
			dao.commit();
		} catch (CommitException e) {
			e.printStackTrace();
			// Retorna o Status code 500 do HTTP
			return Response.serverError().build();
		}

		UriBuilder b = uri.getAbsolutePathBuilder();
		b.path(Integer.toString(jogador.getCodigo()));

		// Retorna status 201 com a URL para acessar a seleção
		return Response.created(b.build()).build();
	}
}
