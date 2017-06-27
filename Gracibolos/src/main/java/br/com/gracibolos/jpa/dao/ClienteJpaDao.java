package br.com.gracibolos.jpa.dao;

import org.springframework.stereotype.Repository;

import br.com.gracibolos.jpa.model.Cliente;

@Repository
public class ClienteJpaDao extends GenericJpaDao<Cliente>{
	
	@Override
	public int inserir(Cliente c) {
		super.em.persist(c);
		super.em.flush();
		return c.getId();
	}

}
