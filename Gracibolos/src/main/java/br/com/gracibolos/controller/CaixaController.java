package br.com.gracibolos.controller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.gracibolos.jdbc.dao.CaixaDao;
import br.com.gracibolos.jdbc.model.Caixa;

@Controller
public class CaixaController {
	
	/*
	 * 
	 * ###################### CAIXA ######################
	 * 
	 * */
	private static CaixaDao daoCaixa;
	private static List<Caixa> listCaixa;
	//private static Saldo saldo;
	private static LocalDate data = LocalDate.now();
	private static String dataInicial = data.with(TemporalAdjusters.firstDayOfMonth()).toString();
	private static String dataFinal = data.with(TemporalAdjusters.lastDayOfMonth()).toString();
	private static BigDecimal saldo;
	//VERIFICA A DATA ATUAL, E PEGA O PRIMEIRO E ULTIMO DIA DO MÊS
			
	//CAIXA
	@RequestMapping("/administrativo-caixa")
	public ModelAndView caixa(){

		System.out.println("Entrou na servlet de listagem do caixa");
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("administrativo/caixa");
		mv.addObject("listCaixa",listaCaixaMes());
		mv.addObject("saldo",saldo());
		mv.addObject("datainicial", dataInicial);
		mv.addObject("datafinal", dataFinal);
		return mv;
	}
	
	public static List<Caixa> listaCaixaMes()
	{
		daoCaixa = new CaixaDao();
		listCaixa = new ArrayList<Caixa>();

		//System.out.println(dataFinal);
		try {
			listCaixa = daoCaixa.pesquisarEntre(dataInicial, dataFinal);
		} catch (Exception e) {
			// Auto-generated catch block
			e.printStackTrace();
		}
		return listCaixa;
	}
	
	public static BigDecimal saldo(){
		daoCaixa = new CaixaDao();
		try {
			saldo = daoCaixa.getSaldo();
		} catch (Exception e) {
			// Auto-generated catch block
			e.printStackTrace();
		}
		return saldo;
	}

	//INCLUIR NOVO CAIXA
	@RequestMapping("/administrativo-incluir-caixa")
	public ModelAndView incluir_caixa(Caixa caixa){
		System.out.println("Entrou na servlet de inclusão de inclusão de um novo caixa");
		
		//declara um status como falso, pra depois verificar se a condição foi atendida ou não.
		boolean status = false;
		
		//cria uma nova instância dao do caixa
		daoCaixa = new CaixaDao();					
		
		try {
			//se o método inserir passando um caixa, for executado corretamente, status recebe verdadeiro
			if(daoCaixa.inserir(caixa)) {
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
		mv.setViewName("administrativo/caixa");
		//passa o retorno do status para a Expression Language chamada incluir
		mv.addObject("incluir", status);
		mv.addObject("listCaixa",listaCaixaMes());
		mv.addObject("saldo",saldo());
		mv.addObject("datainicial", dataInicial);
		mv.addObject("datafinal", dataFinal);
		//retorna o mv
		return mv;
	}

	//AlTERAR CAIXA
	@RequestMapping("/administrativo-alterar-caixa")
	public ModelAndView alterar_caixa (Caixa caixa){
		System.out.println("Entrou na pagina de alteração do caixa");
		
		//reclara um status como falso, pra depois verificar se a condição foi atendida ou não.
		boolean status = false;
		//cria uma nova instância DAO do caixa
		daoCaixa = new CaixaDao();			
			
		try
		{
			//se o método alterar passando um caixa, for executado corretamente, status recebe verdadeiro
			if(daoCaixa.alterar(caixa)) {
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
		mv.setViewName("administrativo/caixa");
		//passa o retorno do status para a Expression Language chamada alterar
		mv.addObject("alterar", status);
		mv.addObject("listCaixa",listaCaixaMes());
		mv.addObject("saldo",saldo());
		mv.addObject("datainicial", dataInicial);
		mv.addObject("datafinal", dataFinal);
	    //retorna mv
		return mv;
	}
			
	//EXCLUIR CAIXA
	@RequestMapping("/administrativo-excluir-caixa")
	public ModelAndView excluir_caixa (Caixa caixa){
		System.out.println("Entrou na pagina de exclusão do caixa");
		
		//reclara um status como falso, pra depois verificar se a condição foi atendida ou não.
		boolean status = false;	
		//cria uma nova instância DAO do caixa		
		daoCaixa = new CaixaDao();			
				
		try {
			//se o método excluir passando um caixa, for executado corretamente, status recebe verdadeiro
			if(daoCaixa.excluir(caixa)) {
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
		mv.setViewName("administrativo/caixa");
		mv.addObject("listCaixa",listaCaixaMes());
		mv.addObject("saldo",saldo());
		//passa o retorno do status para a Expression Language chamada excluir
		mv.addObject("excluir", status);
		mv.addObject("datainicial", dataInicial);
		mv.addObject("datafinal", dataFinal);
	    //retorna mv
		return mv;
	}
			
	//PESQUISAR ENTRE CAIXA
	@RequestMapping("/administrativo-pesquisar-entre")
	// NO SUBMIT, O FORM OS DOIS PARAMETROS id="datainicial" E id="datafinal"	
	public ModelAndView pesquisar_entre (String datainicial, String datafinal){
		System.out.println("Realizou a pesquisa entre datas do caixa");
		
		//cria uma nova instância DAO do caixa
		daoCaixa = new CaixaDao();	
		
		List<Caixa> caixas = null;
		try {
			caixas = daoCaixa.pesquisarEntre(datainicial, datafinal);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		//instância uma nova modelView
		ModelAndView mv = new ModelAndView();
	    //seta o caminho e o nome da jsp
		mv.setViewName("administrativo/caixa");
	    //passa a lista do caixa para a Expression Language chamada caixas
		mv.addObject("listCaixa", caixas);
		mv.addObject("saldo",saldo());
	    //retorna mv
	    return mv;
	}
	
	//LISTAR CAIXA
	@RequestMapping("/administrativo-listar-caixa")
	public ModelAndView listar_caixa(){	    
	    return new ModelAndView("administrativo/caixa");
	}

}
