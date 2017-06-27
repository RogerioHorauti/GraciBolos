package br.com.gacibolos.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import br.com.gracibolos.jpa.dao.ClienteJpaDao;
import br.com.gracibolos.jpa.model.Cliente;

public class ClienteJpaTest extends GenericTest{
	
	@Autowired
	ClienteJpaDao dao;
	Cliente c;
	
	@Test
	@Transactional
	@Override
	public void inserir() {
		c = new Cliente();
		c.setNomerazao("Maria");
		try {
			System.out.println(dao.inserir(c));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
