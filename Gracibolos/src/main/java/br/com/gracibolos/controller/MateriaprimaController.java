package br.com.gracibolos.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.gracibolos.jdbc.dao.MateriaPrimaDao;
import br.com.gracibolos.jdbc.model.MateriaPrima;

@Controller
public class MateriaprimaController {
	
	/*
	 * 
	 * ###################### MATÉRIA PRIMA ######################
	 * 
	 * */
	
	//MATÉRIA PRIMA
	//mapeamento da jsp admin materias-primas
	@RequestMapping("/administrativo-materiasprimas")
	public ModelAndView materiaPrima(){
		System.out.println("Entrou na servlet de listagem de matéria prima");
		
		//retorna a página materias-primas
		return new ModelAndView("administrativo/materiasprimas");
	}
		
	//INCLUIR NOVA MATÉRIA PRIMA
	@RequestMapping("/administrativo-incluir-materiaprima")
	public ModelAndView incluir_materiaPrima(MateriaPrima materiaprima){
		System.out.println("Entrou na servlet de inclusão de uma nova materiaPrima");
		
		//reclara um status como falso, pra depois verificar se a condição foi atendida ou não.
		boolean status = false;
		
		//cria uma nova instância dao da materia-prima
		MateriaPrimaDao dao = new MateriaPrimaDao();			
		
		try {
			//se o método inserir passando uma materiaprima, for executado corretamente, status recebe verdadeiro
			if(dao.inserir(materiaprima)) {
				status = true;			
			}
			//caso contrário, status recebe falso
			else {
				status = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//instância uma nova modelView
		ModelAndView mv = new ModelAndView();
		//seta o caminho e o nome da jsp
		mv.setViewName("administrativo/materiasprimas");
		//passa o retorno do status para a Expression Language chamada incluir
		mv.addObject("incluir", status);
		//retorna o mv
		return mv;
	}
		
	//AlTERAR MATÉRIA PRIMA
	@RequestMapping("/administrativo-alterar-materiaprima")
	public ModelAndView alterar_materiaPrima(MateriaPrima materiaprima){
		System.out.println("Entrou na pagina de alteração de materiaPrima");
		
		//reclara um status como falso, pra depois verificar se a condição foi atendida ou não.
		boolean status = false;
		
		//cria uma nova instância DAO da materia-prima
		MateriaPrimaDao materiaPrimaDao = new MateriaPrimaDao();			
			
		try
		{
			//se o método alterar passando uma materiaprima, for executado corretamente, status recebe verdadeiro
			if(materiaPrimaDao.alterar(materiaprima)) {
				status = true;
			} else {
			//caso contrário, status recebe falso
				status = false;
			}
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
		//instância uma nova modelView
		ModelAndView mv = new ModelAndView();
	    //seta o caminho e o nome da jsp
		mv.setViewName("administrativo/materiasprimas");
		//passa o retorno do status para a Expression Language chamada alterar
		mv.addObject("alterar", status);
	    //retorna mv
		return mv;
			
	}
		
	//EXCLUIR MATÉRIA PRIMA
	@RequestMapping("/administrativo-remover-materiaprima")
	public ModelAndView excluir_materiaPrima(MateriaPrima materiaprima){
		System.out.println("Entrou na pagina de exclusão de materiaprima");
		
		//reclara um status como falso, pra depois verificar se a condição foi atendida ou não.
		boolean status = false;	
		
		//cria uma nova instância dao da materia-prima
	    MateriaPrimaDao materiaPrimaDao = new MateriaPrimaDao();
			
		try {
			//se o método excluir passando uma materiaprima, for executado corretamente, status recebe verdadeiro
			if(materiaPrimaDao.excluir(materiaprima)) {
				status = true;
			} 
			//caso contrário, status recebe falso
			else {
				status = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//instância uma nova modelView
		ModelAndView mv = new ModelAndView();
	    //seta o caminho e o nome da jsp
		mv.setViewName("administrativo/materiasprimas");
		//passa o retorno do status para a Expression Language chamada excluir
		mv.addObject("excluir", status);			
	    //retorna mv
		return mv;
	}
		
	//PESQUISAR MATÉRIA PRIMA
	@RequestMapping("/administrativo-procurar-materiaprima")
	public ModelAndView pesquisar_materiaPrima(String pesquisa){
		System.out.println("Realizou a pesquisa de matéria prima");
		
		//cria uma nova instância dao da materia-prima
		MateriaPrimaDao dao = new MateriaPrimaDao();
		List<MateriaPrima> materiasprimas = null;
		try {
			materiasprimas = dao.pesquisar(pesquisa);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//instância uma nova modelView
		ModelAndView mv = new ModelAndView();
	    //seta o caminho e o nome da jsp
		mv.setViewName("administrativo/materiasprimas");
		//passa a lita de materia-prima para a Expression Language chamada materiasprimas
		mv.addObject("materiasprimas", materiasprimas);
	    //retorna mv		    
	    return mv;
	}
	
	//LISTAR MATÉRIA PRIMA
	@RequestMapping("/administrativo-listar-materiasprimas")
	public ModelAndView listar_materiasprimas(){
		System.out.println("Realizou a listagem de matérias primas");
		
		//cria uma nova instância dao da materia-prima
		MateriaPrimaDao dao = new MateriaPrimaDao();
		List<MateriaPrima> materiasprimas = null;
		
		try {
			//Guarda a lista de materia-prima num List
			materiasprimas = dao.listar();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//instância uma nova modelView
		ModelAndView mv = new ModelAndView();
	    //seta o caminho e o nome da jsp
		mv.setViewName("administrativo/materiasprimas");
		//passa a lita de materia-prima para a Expression Language chamada materiasprimas
		mv.addObject("materiasprimas", materiasprimas);
	    //retorna mv		    
	    return mv;
	}
}
