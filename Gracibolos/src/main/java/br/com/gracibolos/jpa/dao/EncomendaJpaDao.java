package br.com.gracibolos.jpa.dao;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.gracibolos.jpa.model.Encomenda;

@Repository
public class EncomendaJpaDao extends GenericJpaDao<Encomenda> {
	
	@Override
	public int inserir(Encomenda e) {
		super.em.persist(e);
		super.em.flush();// Descarga
		return e.getId();
	}
	
	@Override
	public void alterar(Encomenda e) {
		super.em.merge(e);
	}
	
	@Override
	public Encomenda pesquisar(int id) {
		TypedQuery<Encomenda> query = super.em.createNamedQuery("Encomenda.findById", Encomenda.class);
		query.setParameter("id", id);
		return query.getSingleResult();
	}
}
