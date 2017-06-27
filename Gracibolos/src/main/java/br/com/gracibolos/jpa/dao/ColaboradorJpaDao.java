package br.com.gracibolos.jpa.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.gracibolos.jpa.model.Colaborador;

@Repository
public class ColaboradorJpaDao extends GenericJpaDao<Colaborador>{

	Colaborador c;
	
	@Override
	public Colaborador pesquisar(String pesquisa) {
		//em = JpaUtil.getEntityManager();
		//em.getTransaction().begin();
		c = new Colaborador();
		TypedQuery<Colaborador> query = super.em.createQuery("select c from Colaborador c where c.usuario=:usuario",
						Colaborador.class).setParameter("usuario", pesquisa);
		c = query.getSingleResult();
		//em.getTransaction().commit();
		//em.close();
		return c;
	}
	
	@Override
	public int inserir(Colaborador c) {
		super.em.persist(c);
		super.em.flush();
		return c.getId();
	}
	
	@Override
	public void alterar(Colaborador c) {
		super.em.merge(c);
	}
	
	@Override
	public List<Colaborador> listar() {
		TypedQuery<Colaborador> query = super.em.createNamedQuery("Colaborador.findAll", Colaborador.class);
		return query.getResultList();
	}
	
	@Override
	public void excluir(Colaborador c) {
		//super.em.remove(super.em.getReference(Colaborador.class, c.getId()));
		Query query = super.em.createQuery("DELETE FROM Colaborador c WHERE c.id = :id");
		int result = query.setParameter("id", c.getId()).executeUpdate();
		
	}
}
