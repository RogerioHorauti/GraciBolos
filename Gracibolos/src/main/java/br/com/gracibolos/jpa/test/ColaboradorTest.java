package br.com.gracibolos.jpa.test;

import br.com.gracibolos.jpa.dao.ColaboradorDao;
import br.com.gracibolos.jpa.model.Colaborador;


public class ColaboradorTest {

	public static void main(String[] args) {

		ColaboradorDao dao = new ColaboradorDao();
		Colaborador c = new Colaborador();
		
		try {
			c = dao.pesquisar("rogerio");
			System.out.println(c.getNome());
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	}

}
