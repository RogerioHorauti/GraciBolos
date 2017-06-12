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
	 * ###################### MAT�RIA PRIMA ######################
	 * 
	 * */
	
	//MAT�RIA PRIMA
	//mapeamento da jsp admin materias-primas
	@RequestMapping("/administrativo-materiasprimas")
	public ModelAndView materiaPrima(){
		System.out.println("Entrou na servlet de listagem de mat�ria prima");
		
		//retorna a p�gina materias-primas
		return new ModelAndView("administrativo/materiasprimas");
	}
		
	//INCLUIR NOVA MAT�RIA PRIMA
	@RequestMapping("/administrativo-incluir-materiaprima")
	public ModelAndView incluir_materiaPrima(MateriaPrima materiaprima){
		System.out.println("Entrou na servlet de inclus�o de uma nova materiaPrima");
		
		//reclara um status como falso, pra depois verificar se a condi��o foi atendida ou n�o.
		boolean status = false;
		
		//cria uma nova inst�ncia dao da materia-prima
		MateriaPrimaDao dao = new MateriaPrimaDao();			
		
		try {
			//se o m�todo inserir passando uma materiaprima, for executado corretamente, status recebe verdadeiro
			if(dao.inserir(materiaprima)) {
				status = true;			
			}
			//caso contr�rio, status recebe falso
			else {
				status = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//inst�ncia uma nova modelView
		ModelAndView mv = new ModelAndView();
		//seta o caminho e o nome da jsp
		mv.setViewName("administrativo/materiasprimas");
		//passa o retorno do status para a Expression Language chamada incluir
		mv.addObject("incluir", status);
		//retorna o mv
		return mv;
	}
		
	//AlTERAR MAT�RIA PRIMA
	@RequestMapping("/administrativo-alterar-materiaprima")
	public ModelAndView alterar_materiaPrima(MateriaPrima materiaprima){
		System.out.println("Entrou na pagina de altera��o de materiaPrima");
		
		//reclara um status como falso, pra depois verificar se a condi��o foi atendida ou n�o.
		boolean status = false;
		
		//cria uma nova inst�ncia DAO da materia-prima
		MateriaPrimaDao materiaPrimaDao = new MateriaPrimaDao();			
			
		try
		{
			//se o m�todo alterar passando uma materiaprima, for executado corretamente, status recebe verdadeiro
			if(materiaPrimaDao.alterar(materiaprima)) {
				status = true;
			} else {
			//caso contr�rio, status recebe falso
				status = false;
			}
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
		//inst�ncia uma nova modelView
		ModelAndView mv = new ModelAndView();
	    //seta o caminho e o nome da jsp
		mv.setViewName("administrativo/materiasprimas");
		//passa o retorno do status para a Expression Language chamada alterar
		mv.addObject("alterar", status);
	    //retorna mv
		return mv;
			
	}
		
	//EXCLUIR MAT�RIA PRIMA
	@RequestMapping("/administrativo-remover-materiaprima")
	public ModelAndView excluir_materiaPrima(MateriaPrima materiaprima){
		System.out.println("Entrou na pagina de exclus�o de materiaprima");
		
		//reclara um status como falso, pra depois verificar se a condi��o foi atendida ou n�o.
		boolean status = false;	
		
		//cria uma nova inst�ncia dao da materia-prima
	    MateriaPrimaDao materiaPrimaDao = new MateriaPrimaDao();
			
		try {
			//se o m�todo excluir passando uma materiaprima, for executado corretamente, status recebe verdadeiro
			if(materiaPrimaDao.excluir(materiaprima)) {
				status = true;
			} 
			//caso contr�rio, status recebe falso
			else {
				status = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//inst�ncia uma nova modelView
		ModelAndView mv = new ModelAndView();
	    //seta o caminho e o nome da jsp
		mv.setViewName("administrativo/materiasprimas");
		//passa o retorno do status para a Expression Language chamada excluir
		mv.addObject("excluir", status);			
	    //retorna mv
		return mv;
	}
		
	//PESQUISAR MAT�RIA PRIMA
	@RequestMapping("/administrativo-procurar-materiaprima")
	public ModelAndView pesquisar_materiaPrima(String pesquisa){
		System.out.println("Realizou a pesquisa de mat�ria prima");
		
		//cria uma nova inst�ncia dao da materia-prima
		MateriaPrimaDao dao = new MateriaPrimaDao();
		List<MateriaPrima> materiasprimas = null;
		try {
			materiasprimas = dao.pesquisar(pesquisa);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//inst�ncia uma nova modelView
		ModelAndView mv = new ModelAndView();
	    //seta o caminho e o nome da jsp
		mv.setViewName("administrativo/materiasprimas");
		//passa a lita de materia-prima para a Expression Language chamada materiasprimas
		mv.addObject("materiasprimas", materiasprimas);
	    //retorna mv		    
	    return mv;
	}
	
	//LISTAR MAT�RIA PRIMA
	@RequestMapping("/administrativo-listar-materiasprimas")
	public ModelAndView listar_materiasprimas(){
		System.out.println("Realizou a listagem de mat�rias primas");
		
		//cria uma nova inst�ncia dao da materia-prima
		MateriaPrimaDao dao = new MateriaPrimaDao();
		List<MateriaPrima> materiasprimas = null;
		
		try {
			//Guarda a lista de materia-prima num List
			materiasprimas = dao.listar();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//inst�ncia uma nova modelView
		ModelAndView mv = new ModelAndView();
	    //seta o caminho e o nome da jsp
		mv.setViewName("administrativo/materiasprimas");
		//passa a lita de materia-prima para a Expression Language chamada materiasprimas
		mv.addObject("materiasprimas", materiasprimas);
	    //retorna mv		    
	    return mv;
	}
}
