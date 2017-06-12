package br.com.gracibolos.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.gracibolos.jdbc.dao.GenericoDao;
import br.com.gracibolos.jpa.model.Caixa;
import br.com.gracibolos.jpa.util.DataUtil;

@Repository
public class CaixaJpaDao extends DataUtil implements GenericoDao<Caixa>{
	
	@PersistenceContext(name="gacibolosjpa")
	private EntityManager em;
	
	@Override
	public boolean inserir(Caixa caixa) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean alterar(Caixa caixa) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean excluir(Caixa caixa) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Caixa> listar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Caixa> pesquisar(String pesquisa) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
