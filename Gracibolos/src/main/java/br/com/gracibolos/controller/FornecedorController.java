package br.com.gracibolos.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.gracibolos.jdbc.dao.EstadoDao;
import br.com.gracibolos.jdbc.dao.FornecedorDao;
import br.com.gracibolos.jdbc.model.Estado;
import br.com.gracibolos.jdbc.model.Fornecedor;

@Controller
public class FornecedorController {
	
	/*
	 * 
	 * ###################### FORNECEDORES ######################
	 * 
	 * */
	
	//FORNECEDORES
	@RequestMapping("/administrativo-fornecedores")
	public ModelAndView fornecedores(){
		System.out.println("Entrou na servlet de listagem de fornecedores");
		
		//cria uma nova instância DAO do estado
		EstadoDao estadoDao = new EstadoDao();
		//Guarda a lista de estados num List
	    List<Estado> estados = estadoDao.listar_estados();
		
	    //instância uma nova modelView
		ModelAndView mv = new ModelAndView();
		//seta o caminho e o nome da jsp
	    mv.setViewName("administrativo/fornecedores");
	    //passa a lista de estados para a Expression Language chamada estados
	    mv.addObject("estados", estados);
	    //retorna o mv
		return mv;
	}
	
	//INCLUIR NOVO FORNECEDOR
	@RequestMapping("/administrativo-incluir-fornecedor")
	public ModelAndView incluir_fornecedor(Fornecedor fornecedor){
		System.out.println("Entrou na servlet de inclusão de um novo fornecedor");
		
		//reclara um status como falso, pra depois verificar se a condição foi atendida ou não.
		boolean status = false;
		
		//cria uma nova instância DAO do estado
	    EstadoDao estadoDao = new EstadoDao();
	    //Guarda a lista de estados num List
	    List<Estado> estados = estadoDao.listar_estados();
	    
	    //cria uma nova instância DAO do fornecedor
		FornecedorDao fornecedorDao = new FornecedorDao();
		
		try {
			//se o método inserir passando um fornecedor, for executado corretamente, status recebe verdadeiro
			if(fornecedorDao.inserir(fornecedor)){
				status = true;
			}
			//caso contrário, status recebe falso
			else{
				status = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//instância uma nova modelView
		ModelAndView mv = new ModelAndView();
     	//seta o caminho e o nome da jsp
		mv.setViewName("administrativo/fornecedores");
		//passa o retorno do status para a Expression Language chamada incluir
		mv.addObject("incluir", status);
		//passa a lista de estados para a Expression Language chamada estados
		mv.addObject("estados", estados);
		//retorna o mv
		return mv;
	}
	
	//AlTERAR FORNECEDOR
	@RequestMapping("/administrativo-alterar-fornecedor")
	public ModelAndView alterar_fornecedor(Fornecedor fornecedor){
		System.out.println("Entrou na pagina de alteração de fornecedor");
		
		//reclara um status como falso, pra depois verificar se a condição foi atendida ou não.
		boolean status = false;
		
		//cria uma nova instância DAO do estado
	    EstadoDao estadoDao = new EstadoDao();
	    //Guarda a lista de estados num List
	    List<Estado> estados = estadoDao.listar_estados();
	    
	    //cria uma nova instância DAO do fornecedor
		FornecedorDao fornecedorDao = new FornecedorDao();
		
		try {
			//se o método alterar passando um fornecedor, for executado corretamente, status recebe verdadeiro
			if(fornecedorDao.alterar(fornecedor)){
				status = true;
			}
			//caso contrário, status recebe falso
			else{
				status = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//instância uma nova modelView
		ModelAndView mv = new ModelAndView();
		//seta o caminho e o nome da jsp
		mv.setViewName("administrativo/fornecedores");
		//passa o retorno do status para a Expression Language chamada alterar
		mv.addObject("alterar", status);
		//passa a lista de estados para a Expression Language chamada estados
	    mv.addObject("estados", estados);		
	    //retorna o mv
		return mv;
	}
	
	//EXCLUIR FORNECEDOR
	@RequestMapping("/administrativo-remover-fornecedor")
	public ModelAndView excluir_fornecedor(Fornecedor fornecedor){
		System.out.println("Entrou na pagina de exclusão de fornecedor");
		
		//reclara um status como falso, pra depois verificar se a condição foi atendida ou não.
		boolean status = false;
		
		//cria uma nova instância DAO do estado
	    EstadoDao estadoDao = new EstadoDao();
	    //Guarda a lista de estados num List
	    List<Estado> estados = estadoDao.listar_estados();
	    
	    //cria uma nova instância DAO do fornecedor
		FornecedorDao fornecedorDao = new FornecedorDao();
		
		try {
			//se o método excluir passando um fornecedor, for executado corretamente, status recebe verdadeiro
			if(fornecedorDao.excluir(fornecedor)){
				status = true;
			}
			//caso contrário, status recebe falso
			else{
				status = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//instância uma nova modelView
		ModelAndView mv = new ModelAndView();
		//seta o caminho e o nome da jsp
		mv.setViewName("administrativo/fornecedores");
		//passa o retorno do status para a Expression Language chamada excluir
		mv.addObject("excluir", status);
		//passa a lista de estados para a Expression Language chamada estados
	    mv.addObject("estados", estados);		
	    //retorna o mv
		return mv;
	}
	
	//PESQUISAR FORNECEDORES
	@RequestMapping("/administrativo-pesquisar-fornecedor")
	public ModelAndView pesquisar_fornecedor(String pesquisa){
		System.out.println("Realizou a pesquisa de fornecedor");
		
		//cria uma nova instância DAO do fornecedor
		FornecedorDao fornecedorDao = new FornecedorDao();
		List<Fornecedor> fornecedores = null;
		
		try {
			fornecedores = fornecedorDao.pesquisar(pesquisa);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//cria uma nova instância DAO do estado
	    EstadoDao estadoDao = new EstadoDao();
	    //Guarda a lista de estados num List
	    List<Estado> estados = estadoDao.listar_estados();
	    
	    //instância uma nova modelView
	    ModelAndView mv = new ModelAndView();
	    //seta o caminho e o nome da jsp
	    mv.setViewName("administrativo/fornecedores");
	    //passa a lista de fornecedores para a Expression Language chamada fornecedores
	    mv.addObject("fornecedores", fornecedores);
		//passa a lista de estados para a Expression Language chamada estados
	    mv.addObject("estados", estados);	    
	    //retorna o mv
	    return mv;
	}
	
	//LISTAR FORNECEDORES
		@RequestMapping("/administrativo-listar-fornecedores")
	public ModelAndView listar_fornecedores(){
		System.out.println("Realizou a listagem de fornecedores");
		
		//cria uma nova instância DAO do fornecedor
		FornecedorDao fornecedorDao = new FornecedorDao();
		List<Fornecedor> fornecedores = null;
		
		try {
			//Guarda a lista de fornecedores num List
			fornecedores = fornecedorDao.listar();
		} catch (Exception e) {
			e.printStackTrace();
		}			
		//cria uma nova instância DAO do estado
	    EstadoDao estadoDao = new EstadoDao();
	    //Guarda a lista de estados num List
	    List<Estado> estados = estadoDao.listar_estados();
	    
	    //instância uma nova modelView
	    ModelAndView mv = new ModelAndView();
		//seta o caminho e o nome da jsp
	    mv.setViewName("administrativo/fornecedores");
		//passa a lista de fornecedores para a Expression Language chamada fornecedores
	    mv.addObject("fornecedores", fornecedores);
		//passa a lista de estados para a Expression Language chamada estados	
	    mv.addObject("estados", estados);
		//retorna o mv		    
	    return mv;
	}
		
}
