package br.com.fiap.jpa.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.ProdutoDAO;
import br.com.fiap.to.ProdutoTO;

public class ProdutoDAOImpl extends GenericDAOImpl<ProdutoTO, Integer> implements ProdutoDAO {

	public ProdutoDAOImpl(EntityManager em) {
		super(em);
		
	}

}
