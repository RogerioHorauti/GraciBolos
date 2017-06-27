package br.com.gracibolos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.gracibolos.jdbc.dao.ColaboradorDao;
import br.com.gracibolos.jdbc.dao.EstadoDao;

import br.com.gracibolos.jdbc.model.Estado;
import br.com.gracibolos.jpa.dao.ColaboradorJpaDao;
import br.com.gracibolos.jpa.model.Colaborador;

@Controller
public class ColaboradorController {
	
	@Autowired
	ColaboradorJpaDao jpaDao;
	
	@RequestMapping("/administrativo-colaboradores")
	public ModelAndView colaboradores(){
		System.out.println("Entrou na servlet de listagem de colaboradores");
		
		//cria uma nova instância DAO do estado
		EstadoDao estadoDao = new EstadoDao();
		//Guarda a lista de estados num List
	    List<Estado> estados = estadoDao.listar_estados();
		
	    //instância uma nova modelView
		ModelAndView mv = new ModelAndView();
		//seta o caminho e o nome da jsp
	    mv.setViewName("administrativo/colaboradores");
	    //passa a lista de estados para a Expression Language chamada estados
	    mv.addObject("estados", estados);
	    //retorna mv		
		return mv;
	}
	
	//INCLUIR NOVO COLABORADOR
	@RequestMapping("/administrativo-incluir-colaborador")
	public ModelAndView incluir_colaborador(Colaborador colaborador){
		System.out.println("Entrou na servlet de inclusão de um novo colaborador");
		
		//reclara um status como falso, pra depois verificar se a condição foi atendida ou não.
		//boolean status = false;
		//cria uma nova instância DAO do estado
	    EstadoDao estadoDao = new EstadoDao();
	    //Guarda a lista de estados num List
	    List<Estado> estados = estadoDao.listar_estados();
	    
	    //cria uma nova instância DAO do colaborador
		//ColaboradorDao dao = new ColaboradorDao();
		
		//se o método inserir passando um colaborador, for executado corretamente, status recebe verdadeiro
//		if(dao.inserir(colaborador)){
//			status = true;
//		}
//		//caso contrário, status recebe falso
//		else{
//			status = false;
//		}
		System.out.println(colaborador.toString());
		//instância uma nova modelView
		ModelAndView mv = new ModelAndView();
	    //seta o caminho e o nome da jsp
		mv.setViewName("administrativo/colaboradores");
		//passa o retorno do status para a Expression Language chamada incluir
		//mv.addObject("incluir", status);
		//passa a lista de estados para a Expression Language chamada estados
		mv.addObject("estados", estados);
		//retorna mv
		return mv;
	}	
	
	//AlTERAR COLABORADOR
	@RequestMapping("/administrativo-alterar-colaborador")
	public ModelAndView alterar_colaborador(Colaborador colaborador){
		System.out.println("Entrou na pagina de alteração de colaborador");
		
		//reclara um status como falso, pra depois verificar se a condição foi atendida ou não.
		//boolean status = false;
		//cria uma nova instância DAO do estado
	    EstadoDao estadoDao = new EstadoDao();
	    //Guarda a lista de estados num List
	    List<Estado> estados = estadoDao.listar_estados();
	    
	    //cria uma nova instância DAO do colaborador
		ColaboradorDao colaboradorDao = new ColaboradorDao();
		
		//se o método alterar passando um colaborador, for executado corretamente, status recebe verdadeiro
//		if(colaboradorDao.alterar(colaborador)){
//			status = true;
//		}
//		//caso contrário, status recebe falso
//		else{
//			status = false;
//		}
		System.out.println(colaborador.toString());
		//jpaDao.alterar(colaborador);
		//instância uma nova modelView
		ModelAndView mv = new ModelAndView();
		//seta o caminho e o nome da jsp
		mv.setViewName("administrativo/colaboradores");
		//passa o retorno do status para a Expression Language chamada alterar
		//mv.addObject("alterar", status);
		//passa a lista de clientes para a Expression Language chamada clientes
	    mv.addObject("estados", estados);
	    //retorna mv		
		return mv;
	}
	
	//EXCLUIR COLABORADOR
	@RequestMapping("/administrativo-remover-colaborador")
	public ModelAndView excluir_colaborador(Colaborador colaborador){
		System.out.println("Entrou na pagina de exclusão de colaborador");
		
		//reclara um status como falso, pra depois verificar se a condição foi atendida ou não.
		boolean status = false;
		//cria uma nova instância DAO do estado
	    EstadoDao estadoDao = new EstadoDao();
	    //Guarda a lista de estados num List
	    List<Estado> estados = estadoDao.listar_estados();
	    
	  //cria uma nova instância DAO do colaborador
		ColaboradorDao colaboradorDao = new ColaboradorDao();
		
		//se o método excluir passando um colaborador, for executado corretamente, status recebe verdadeiro
//		if(colaboradorDao.excluir(colaborador)){
//			status = true;
//		}
//		//caso contrário, status recebe falso
//		else{
//			status = false;
//		}
		//instância uma nova modelView
		ModelAndView mv = new ModelAndView();
	    //seta o caminho e o nome da jsp
		mv.setViewName("administrativo/colaboradores");
		//passa o retorno do status para a Expression Language chamada excluir
		mv.addObject("excluir", status);
	    //passa a lista de clientes para a Expression Language chamada clientes
		mv.addObject("estados", estados);
	    //retorna mv		
		return mv;
	}
	
	//PESQUISAR COLABORADOR
	@RequestMapping("/administrativo-procurar-colaborador")
	//id="pesquisa" do input
	public ModelAndView pesquisar_colaborador(String pesquisa){
		System.out.println("Realizou a pesquisa de colaboradores");
		
		//cria uma nova instância DAO do colaborador
		ColaboradorDao dao = new ColaboradorDao();
		//List<Colaborador> colaboradores = dao.pesquisar(pesquisa);
		
		//cria uma nova instância DAO do estado
	    EstadoDao estadoDao = new EstadoDao();
	    //Guarda a lista de estados num List
	    List<Estado> estados = estadoDao.listar_estados();
	    
	    //instância uma nova modelView
	    ModelAndView mv = new ModelAndView();
	    //seta o caminho e o nome da jsp
	    mv.setViewName("administrativo/colaboradores");
		//passa a lista de colaborador para a Expression Language chamada colaboradores
	    //mv.addObject("colaboradores", colaboradores);
	    //passa a lista de clientes para a Expression Language chamada clientes
	    mv.addObject("estados", estados);
	    //retorna mv    
	    return mv;
	}
	
	//LISTAR COLABORADOR
		@RequestMapping("/administrativo-listar-colaboradores")
	public ModelAndView listar_colaborador(){
			System.out.println("Realizou a listagem de colaboradores");
			
			//cria uma nova instância DAO do colaborador
			ColaboradorDao colaboradorDao = new ColaboradorDao();
			//Guarda a lista de colaborador num List
			List<br.com.gracibolos.jpa.model.Colaborador> colaboradores = jpaDao.listar();
			
			//cria uma nova instância DAO do estado
		    EstadoDao estadoDao = new EstadoDao();
		    //Guarda a lista de estados num List
		    List<Estado> estados = estadoDao.listar_estados();
		    
		    //instância uma nova modelView
		    ModelAndView mv = new ModelAndView();
		    //seta o caminho e o nome da jsp
		    mv.setViewName("administrativo/colaboradores");
			//passa a lista de colaborador para a Expression Language chamada colaboradores
		    mv.addObject("colaboradores", colaboradores);
		    //passa a lista de clientes para a Expression Language chamada clientes
		    mv.addObject("estados", estados);
		    //retorna mv    
		    return mv;
		}
		
}
