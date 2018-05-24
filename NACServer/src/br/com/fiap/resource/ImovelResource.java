package br.com.fiap.resource;

import java.util.List;

import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
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

import br.com.fiap.ws.dao.ImovelDAO;
import br.com.fiap.ws.dao.impl.ImovelDAOImpl;
import br.com.fiap.ws.entity.Imovel;
import br.com.fiap.ws.singleton.EntityManagerFactorySingleton;

@Path("/imovel")
public class ImovelResource {
	
	private ImovelDAO dao;
	
	//Inicializar os objetos - DAO
	public ImovelResource() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		dao = new ImovelDAOImpl(em);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(Imovel imovel, @Context UriInfo uri) {
		try {
			dao.cadastrar(imovel);
			dao.commit();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
		
		UriBuilder b = uri.getAbsolutePathBuilder().path(String.valueOf(imovel.getCodigo()));		
		return Response.created(b.build()).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Imovel> listar() {
		return dao.listar();
	}
	
	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualiza(Imovel imovel, @PathParam("id") int codigo) {
		imovel.setCodigo(codigo);		
		try {
			dao.atualizar(imovel);
			dao.commit();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.serverError().build();
			
		}		
		return Response.ok().build();
	}

}
