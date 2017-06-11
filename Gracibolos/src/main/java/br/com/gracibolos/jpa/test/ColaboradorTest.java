package br.com.gracibolos.jpa.test;

import br.com.gracibolos.jpa.dao.ColaboradorJpaDao;
import br.com.gracibolos.jpa.model.Colaborador;


public class ColaboradorTest {

	public static void main(String[] args) {

		ColaboradorJpaDao dao = new ColaboradorJpaDao();
		Colaborador c = new Colaborador();
		
		try {
			c = dao.pesquisar("rogerio");
			System.out.println(c.getNome());
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	}

}
