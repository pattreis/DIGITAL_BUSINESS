package br.com.fiap.jpa.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.entity.Jogador;
import br.com.fiap.jpa.dao.JogadorDAO;


public class JogadorDAOImpl extends GenericDAOImpl<Jogador, Integer> implements JogadorDAO {

	public JogadorDAOImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
