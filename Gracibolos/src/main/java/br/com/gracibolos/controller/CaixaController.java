package br.com.gracibolos.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.gracibolos.jdbc.dao.CaixaDao;
import br.com.gracibolos.jdbc.model.Caixa;
import br.com.gracibolos.jpa.util.DateUtil;
import br.com.gracibolos.jpa.util.FinanceiroUtil;

@Controller
public class CaixaController{
	
	private CaixaDao daoCaixa;
			
	//CAIXA
	@RequestMapping("/administrativo-caixa")
	public ModelAndView caixa(){

		System.out.println("Entrou na servlet de listagem do caixa");
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("administrativo/caixa");
		mv.addObject("listCaixa",FinanceiroUtil.listaCaixaMes());
		mv.addObject("saldo",FinanceiroUtil.saldo());
		mv.addObject("datainicial", DateUtil.primeiroDiaMes());
		mv.addObject("datafinal", DateUtil.ultimoDiaMes());
		return mv;
	}
	
	//INCLUIR NOVO CAIXA
	@RequestMapping("/administrativo-incluir-caixa")
	public ModelAndView incluir_caixa(Caixa caixa){
		System.out.println("Entrou na servlet de inclus�o de inclus�o de um novo caixa");
		
		//declara um status como falso, pra depois verificar se a condi��o foi atendida ou n�o.
		boolean status = false;
		
		//cria uma nova inst�ncia dao do caixa
		daoCaixa = new CaixaDao();					
		
		try {
			//se o m�todo inserir passando um caixa, for executado corretamente, status recebe verdadeiro
			if(daoCaixa.inserir(caixa)) {
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
		mv.setViewName("administrativo/caixa");
		//passa o retorno do status para a Expression Language chamada incluir
		mv.addObject("incluir", status);
		mv.addObject("listCaixa",FinanceiroUtil.listaCaixaMes());
		mv.addObject("saldo",FinanceiroUtil.saldo());
		mv.addObject("datainicial", DateUtil.primeiroDiaMes());
		mv.addObject("datafinal", DateUtil.ultimoDiaMes());
		//retorna o mv
		return mv;
	}

	//AlTERAR CAIXA
	@RequestMapping("/administrativo-alterar-caixa")
	public ModelAndView alterar_caixa (Caixa caixa){
		System.out.println("Entrou na pagina de altera��o do caixa");
		
		//reclara um status como falso, pra depois verificar se a condi��o foi atendida ou n�o.
		boolean status = false;
		//cria uma nova inst�ncia DAO do caixa
		daoCaixa = new CaixaDao();			
			
		try
		{
			//se o m�todo alterar passando um caixa, for executado corretamente, status recebe verdadeiro
			if(daoCaixa.alterar(caixa)) {
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
		mv.setViewName("administrativo/caixa");
		//passa o retorno do status para a Expression Language chamada alterar
		mv.addObject("alterar", status);
		mv.addObject("listCaixa",FinanceiroUtil.listaCaixaMes());
		mv.addObject("saldo",FinanceiroUtil.saldo());
		mv.addObject("datainicial", DateUtil.primeiroDiaMes());
		mv.addObject("datafinal", DateUtil.ultimoDiaMes());
	    //retorna mv
		return mv;
	}
			
	//EXCLUIR CAIXA
	@RequestMapping("/administrativo-excluir-caixa")
	public ModelAndView excluir_caixa (Caixa caixa){
		System.out.println("Entrou na pagina de exclus�o do caixa");
		
		//reclara um status como falso, pra depois verificar se a condi��o foi atendida ou n�o.
		boolean status = false;	
		//cria uma nova inst�ncia DAO do caixa		
		daoCaixa = new CaixaDao();			
				
		try {
			//se o m�todo excluir passando um caixa, for executado corretamente, status recebe verdadeiro
			if(daoCaixa.excluir(caixa)) {
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
		mv.setViewName("administrativo/caixa");
		mv.addObject("listCaixa",FinanceiroUtil.listaCaixaMes());
		mv.addObject("saldo",FinanceiroUtil.saldo());
		//passa o retorno do status para a Expression Language chamada excluir
		mv.addObject("excluir", status);
		mv.addObject("datainicial", DateUtil.primeiroDiaMes());
		mv.addObject("datafinal", DateUtil.ultimoDiaMes());
	    //retorna mv
		return mv;
	}
			
	//PESQUISAR ENTRE CAIXA
	@RequestMapping("/administrativo-pesquisar-entre")
	// NO SUBMIT, O FORM OS DOIS PARAMETROS id="datainicial" E id="datafinal"	
	public ModelAndView pesquisar_entre (String datainicial, String datafinal){
		System.out.println("Realizou a pesquisa entre datas do caixa");
		
		//cria uma nova inst�ncia DAO do caixa
		daoCaixa = new CaixaDao();	
		
		List<Caixa> caixas = null;
		try {
			caixas = daoCaixa.pesquisarEntre(datainicial, datafinal);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		//inst�ncia uma nova modelView
		ModelAndView mv = new ModelAndView();
	    //seta o caminho e o nome da jsp
		mv.setViewName("administrativo/caixa");
	    //passa a lista do caixa para a Expression Language chamada caixas
		mv.addObject("listCaixa", caixas);
		mv.addObject("saldo",FinanceiroUtil.saldo());
	    //retorna mv
	    return mv;
	}
	
	//LISTAR CAIXA
	@RequestMapping("/administrativo-listar-caixa")
	public ModelAndView listar_caixa(){	    
	    return new ModelAndView("administrativo/caixa");
	}

}
