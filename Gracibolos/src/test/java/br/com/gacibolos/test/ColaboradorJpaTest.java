package br.com.gacibolos.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import br.com.gracibolos.jpa.dao.ColaboradorJpaDao;
import br.com.gracibolos.jpa.model.Colaborador;

public class ColaboradorJpaTest extends GenericTest {
	
	@Autowired
	ColaboradorJpaDao dao;
	Colaborador c;
	List<Colaborador> list;
	
	@Override
	public void inserir() {
		
	}
	
	@Test
	@Transactional
	@Override
	public void listar() {
		list = new ArrayList<Colaborador>();
		try {
			list = dao.listar();
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (Colaborador c : list) {
			System.out.println(c.toString());
		}
	}
	
	@Test
	@Transactional
	public void save(){
		c = new Colaborador();
		c.setId(3);
		c.setNome("Paula");
		c.setUsuario("user");
		c.setSenha("user");
		c.setNivel(2);
		try {
			System.out.println();
			dao.alterar(c);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	@Transactional
	public void remove(){
		c = new Colaborador();
		c.setId(3);
		try {
			//dao.excluir(c);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
