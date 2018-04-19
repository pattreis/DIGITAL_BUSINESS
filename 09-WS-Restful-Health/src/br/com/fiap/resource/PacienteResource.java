package br.com.fiap.resource;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import br.com.fiap.entity.Paciente;
import br.com.fiap.jpa.dao.PacienteDAO;
import br.com.fiap.jpa.dao.impl.PacienteImpl;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.KeyNotFoundException;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

@Path("/paciente")
public class PacienteResource {

	public PacienteDAO dao;

	public PacienteResource() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		dao = new PacienteImpl(em);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(Paciente paciente, @Context UriInfo uri) {

		try {
			dao.inserir(paciente);
			dao.commit();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.serverError().build();
		}

		UriBuilder b = uri.getAbsolutePathBuilder();
		b.path(Integer.toString(paciente.getCodigo()));

		return Response.created(b.build()).build();

	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Paciente pesquisar(@PathParam("id") int codigo) {

		return dao.pesquisar(codigo);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Paciente> listar() {
		return dao.listar();
	}

	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar(Paciente paciente, @PathParam("id") int codigo) {
		try {
			paciente.setCodigo(codigo);
			dao.atualizar(paciente);
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
			e.printStackTrace();
		}
	}

}
