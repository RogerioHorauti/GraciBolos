package br.com.gracibolos.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import br.com.gracibolos.jdbc.dao.CidadeDao;
import br.com.gracibolos.jdbc.dao.ProdutoDao;
import br.com.gracibolos.jdbc.model.Cidade;
import br.com.gracibolos.jdbc.model.Produto;

@Controller
public class AdministrativoController {		
	
	/*
	 * 
	 * ###################### CIDADES ######################
	 * 
	 * */
	
	@RequestMapping(value="/administrativo-pesquisar-cidade", method=RequestMethod.POST)
	public @ResponseBody List<Cidade> pesquisar_cidade(int id){
				
		List<Cidade> cidades = new ArrayList<Cidade>();

		//cria uma nova instância DAO do estado
		CidadeDao dao = new CidadeDao();
		try {
			cidades = dao.pesquisar_cidades(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	    return cidades;
		
	}
	
	/*
	 * 
	 * ###################### PESQUISA VALORES ######################
	 * 
	 * */
	
	@RequestMapping(value="/administrativo-pesquisar-valor", method=RequestMethod.POST)
	public @ResponseBody Produto pesquisar_valor(int id){
				
		Produto produto = new Produto();

		//cria uma nova instância DAO
		ProdutoDao dao = new ProdutoDao();
		try {
			produto = dao.pesquisarPorId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
				
	    return produto;
		
	}
	
	
	
	
	
	
}