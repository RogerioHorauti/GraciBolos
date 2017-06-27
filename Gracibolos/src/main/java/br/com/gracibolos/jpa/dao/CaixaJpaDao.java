package br.com.gracibolos.jpa.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.gracibolos.jpa.model.Caixa;
import br.com.gracibolos.jpa.model.Encomenda;

@Repository
public class CaixaJpaDao extends GenericJpaDao<Caixa>{
	
	private Encomenda e;
	
	@Override
	public int inserir(Caixa caixa) {
		super.em.persist(caixa);
		return 0;
	}

	@Override
	public void alterar(Caixa caixa) {
		super.em.merge(caixa);
	}
	
	@Override
	public Caixa pesquisar(String id) {
		e = new Encomenda();
		e.setId(Integer.parseInt(id));
		TypedQuery<Caixa> query = super.em.createNamedQuery("Caixa.findByEncomenda", Caixa.class);
		query.setParameter("encomenda", e);
		return query.getSingleResult();
	}
	
	@Override
	public List<Caixa> pesquisarEntre(Date start, Date end) {
		TypedQuery<Caixa> query = super.em.createNamedQuery("Caixa.betweenDate", Caixa.class);
		query.setParameter("dateStart", start);
		query.setParameter("dateEnd", end);
		return query.getResultList();
	}
}
