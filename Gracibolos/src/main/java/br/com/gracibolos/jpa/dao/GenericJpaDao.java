package br.com.gracibolos.jpa.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.gracibolos.jpa.model.Caixa;

abstract class GenericJpaDao<E> {
	
	@PersistenceContext(name="gacibolosjpa")
	protected EntityManager em;
	
	public int inserir(E e) {return 0;}
	public void alterar(E e) {}
	public void excluir(E e) {}
	public List<E> listar() {return null;}
	public List<E> pesquisarLista(String pesquisa){return null;}
	public E pesquisar(String pesquisa) {return null;}	
	public E pesquisar(int pesquisa) {return null;}	
	public List<Caixa> pesquisarEntre(Date start, Date end) {return null;}
    
}
