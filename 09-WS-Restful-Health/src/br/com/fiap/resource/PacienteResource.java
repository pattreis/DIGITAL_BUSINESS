package br.com.fiap.resource;

import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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
}
