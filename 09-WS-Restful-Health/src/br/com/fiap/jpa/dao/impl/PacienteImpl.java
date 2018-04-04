package br.com.fiap.jpa.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.entity.Paciente;
import br.com.fiap.jpa.dao.PacienteDAO;

public class PacienteImpl extends GenericDAOImpl<Paciente, Integer> implements PacienteDAO{

	public PacienteImpl(EntityManager em) {
		super(em);
		
	}

}
