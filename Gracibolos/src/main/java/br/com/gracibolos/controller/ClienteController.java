package br.com.gracibolos.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.gracibolos.jdbc.dao.ClienteDao;
import br.com.gracibolos.jdbc.dao.EstadoDao;
import br.com.gracibolos.jdbc.model.Cliente;
import br.com.gracibolos.jdbc.model.Estado;

@Controller
public class ClienteController {
	
	/*
	 * 
	 * ###################### CLIENTES ######################
	 * 
	 * */
	
	//CLIENTES
	@RequestMapping("/administrativo-clientes")
	public ModelAndView clientes(){
		System.out.println("Entrou na servlet de listagem de clientes");
		

		//cria uma nova instância DAO do estado
	    EstadoDao estadoDao = new EstadoDao();
	    //Guarda a lista de estados num List
	    List<Estado> estados = estadoDao.listar_estados();
		
	    //instância uma nova modelView
		ModelAndView mv = new ModelAndView();
		//seta o caminho e o nome da jsp
	    mv.setViewName("administrativo/clientes");
	    //retorna o mv	
		//passa a lista de estados para a Expression Language chamada estados	
		mv.addObject("estados", estados);
		
		return mv;
	}
	
	//INCLUIR NOVO CLIENTE
	@RequestMapping("/administrativo-incluir-cliente")
	public ModelAndView incluir_cliente(Cliente cliente){
		System.out.println("Entrou na servlet de inclusão de um novo cliente");
		
		//reclara um status como falso, pra depois verificar se a condição foi atendida ou não.
		boolean status = false;
		//cria uma nova instância DAO do estado
	    EstadoDao estadoDao = new EstadoDao();
	    //Guarda a lista de estados num List
	    List<Estado> estados = estadoDao.listar_estados();
	    
	    //cria uma nova instância DAO do cliente
		ClienteDao dao = new ClienteDao();
		
		try {
			//se o método inserir passando um cliente, for executado corretamente, status recebe verdadeiro
			if(dao.inserir(cliente)){
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
		mv.setViewName("administrativo/clientes");
		//passa o retorno do status para a Expression Language chamada incluir
		mv.addObject("incluir", status);
		//passa a lista de estados para a Expression Language chamada estados	
		mv.addObject("estados", estados);
	    //retorna o mv
		return mv;
	}
	
	//AlTERAR CLIENTE
	@RequestMapping("/administrativo-alterar-cliente")
	public ModelAndView alterar_cliente(Cliente cliente){
		System.out.println("Entrou na pagina de alteração de cliente");
		
		//reclara um status como falso, pra depois verificar se a condição foi atendida ou não.
		boolean status = false;
		//cria uma nova instância DAO do estado
	    EstadoDao estadoDao = new EstadoDao();
	    //Guarda a lista de estados num List
	    List<Estado> estados = estadoDao.listar_estados();
	    
	  //cria uma nova instância DAO do cliente
		ClienteDao clienteDao = new ClienteDao();
		
		try {
			//se o método alterar passando um cliente, for executado corretamente, status recebe verdadeiro
			if(clienteDao.alterar(cliente)){
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
		mv.setViewName("administrativo/clientes");
		//passa o retorno do status para a Expression Language chamada alterar
		mv.addObject("alterar", status);
		//passa a lista de estados para a Expression Language chamada estados	
		mv.addObject("estados", estados);
	    //retorna o mv		
		return mv;
	}
	
	//EXCLUIR CLIENTE
	@RequestMapping("/administrativo-remover-cliente")
	public ModelAndView excluir_cliente(Cliente cliente){
		System.out.println("Entrou na pagina de exclusão de cliente");
		
		//reclara um status como falso, pra depois verificar se a condição foi atendida ou não.
		boolean status = false;
		//cria uma nova instância DAO do estado
	    EstadoDao estadoDao = new EstadoDao();
	    //Guarda a lista de estados num List
	    List<Estado> estados = estadoDao.listar_estados();
	    
	    //cria uma nova instância DAO do cliente
		ClienteDao clienteDao = new ClienteDao();
		
		try {
			//se o método excluir passando um cliente, for executado corretamente, status recebe verdadeiro
			if(clienteDao.excluir(cliente)){
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
		mv.setViewName("administrativo/clientes");
		//passa o retorno do status para a Expression Language chamada excluir
		mv.addObject("excluir", status);
		//passa a lista de estados para a Expression Language chamada estados	
		mv.addObject("estados", estados);
		//retorna o mv		
		return mv;
	}
	
	//PESQUISAR CLIENTE
	@RequestMapping("/administrativo-pesquisar-cliente")
	public ModelAndView pesquisar_cliente(String pesquisa){
		System.out.println("Realizou a pesquisa de cliente");
		
		//cria uma nova instância DAO do cliente
		ClienteDao clienteDao = new ClienteDao();
		List<Cliente> clientes = null;
		try {
			clientes = clienteDao.pesquisar(pesquisa);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//cria uma nova instância DAO do estado
	    EstadoDao estadoDao = new EstadoDao();
	    //Guarda a lista de clientes num List
	    List<Estado> estados = estadoDao.listar_estados();
	    
	    //instância uma nova modelView
	    ModelAndView mv = new ModelAndView();
	    //seta o caminho e o nome da jsp
	    mv.setViewName("administrativo/clientes");
	    //passa a lista de clientes para a Expression Language chamada clientes	
	    mv.addObject("clientes", clientes);
	    //passa a lista de estados para a Expression Language chamada estados	
	    mv.addObject("estados", estados);
	    //retorna mv
	    return mv;
	}

	//LISTAR CLIENTES
	@RequestMapping("/administrativo-listar-clientes")
	public ModelAndView listar_cliente(){
		System.out.println("Realizou a listagem de clientes");
		
		//cria uma nova instância DAO do cliente
		ClienteDao clienteDao = new ClienteDao();
		List<Cliente> clientes = null;
		try {
			//Guarda a lista de clientes num List
			clientes = clienteDao.listar();
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
	    mv.setViewName("administrativo/clientes");
	    //passa a lista de clientes para a Expression Language chamada clientes	
	    mv.addObject("clientes", clientes);
	    //passa a lista de estados para a Expression Language chamada estados	
	    mv.addObject("estados", estados);
	    //retorna mv
	    return mv;
	}
	
}
