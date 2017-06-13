package br.com.gracibolos.jpa.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.gracibolos.jdbc.dao.GenericoDao;
import br.com.gracibolos.jpa.model.Caixa;
import br.com.gracibolos.jpa.model.Encomenda;
import br.com.gracibolos.jpa.util.DataUtil;

@Repository
public class CaixaJpaDao extends DataUtil implements GenericoDao<Caixa>{
	
	@PersistenceContext(name="gacibolosjpa")
	private EntityManager em;
	private Encomenda e;
	
	@Override
	public boolean inserir(Caixa caixa) throws Exception {
		em.persist(caixa);
		return false;
	}

	@Override
	public boolean alterar(Caixa caixa) throws Exception {
		em.merge(caixa);
		return false;
	}

	@Override
	public boolean excluir(Caixa caixa) throws Exception {
		em.remove(caixa);
		return false;
	}

	@Override
	public List<Caixa> listar() throws Exception {
		TypedQuery<Caixa> query = em.createNamedQuery("Caixa.findAll", Caixa.class);
		return query.getResultList(); 
	}

	@Override
	public List<Caixa> pesquisar(String pesquisa) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Caixa pesquisaUnica(String id) throws Exception {
		e = new Encomenda();
		e.setId(Integer.parseInt(id));
		TypedQuery<Caixa> query = em.createNamedQuery("Caixa.findByEncomenda", Caixa.class);
		query.setParameter("encomenda", e);
		return query.getSingleResult();
	}
	
	public List<Caixa> pesquisarEntre(String start, String end) throws Exception {
		TypedQuery<Caixa> query = em.createNamedQuery("Caixa.betweenDate", Caixa.class);
		SimpleDateFormat fmt = new SimpleDateFormat("yyy-MM-dd");	
		Date inicio = fmt.parse(start);
		Date fim = fmt.parse(end);
		query.setParameter("dateStart", inicio);
		query.setParameter("dateEnd", fim);
		return query.getResultList();
	}
}
