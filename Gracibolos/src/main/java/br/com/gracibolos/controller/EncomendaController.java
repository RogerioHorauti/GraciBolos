package br.com.gracibolos.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.gracibolos.jdbc.dao.EncomendaDao;
import br.com.gracibolos.jdbc.model.Encomenda;
import br.com.gracibolos.jdbc.model.Status;

@Controller
public class EncomendaController {
	
	
	/*
	 * 
	 * ###################### ENCOMENDA #####################
	 * 
	 * */
	
	
	@RequestMapping("/administrativo-listar-encomendas-finalizadas")
	public ModelAndView listarEncomendasFinalizadas(){
		
		EncomendaDao daoEnc = new EncomendaDao();
		ModelAndView mv = new ModelAndView();
		try {
			mv.addObject("encomendas", daoEnc.finalizadas());
		} catch (Exception e) {
			// Auto-generated catch block
			e.printStackTrace();
		}
		mv.setViewName("administrativo/encomendas");
		return mv;
	}
	
	//ENCOMENDA
	@RequestMapping("/administrativo-encomendas")
	public ModelAndView encomenda(
			//HttpSession session
			){
		System.out.println("Entrou na servlet de listagem das encomendas");
		
		//session.setAttribute("respostaStatus", "ok");
		
		EncomendaDao dao = new EncomendaDao();
				
		//instância uma nova modelView
		ModelAndView mv = new ModelAndView();
		//seta o caminho e o nome da jsp
		mv.setViewName("administrativo/encomendas");
		//passa os dados da encomenda para a Expression Language chamada encomenda
		try {//Passando as encomendas em aberto - status >= 3
			mv.addObject("encomendas", dao.emAberto());
		} catch (Exception e) {
			// Auto-generated catch block
			e.printStackTrace();
		}
		//passa a lista de item para a Expression Language chamada itens
		//mv.addObject("itens", itens);
		//retorna mv
		return mv;
	}
	
	
	
	//INCLUIR NOVA ENCOMENDA
	@RequestMapping("/administrativo-incluir-encomenda")
	public ModelAndView incluir_encomenda(Encomenda encomenda){
		System.out.println("Entrou na servlet de inclusão de uma nova encomenda");
		
		
		/*
		 
		 
		 
		 Código para ler os produtos de um input array html
		 
		 
		 
		 System.out.println(encomendas.getProdutos().size());
		
		for(int i=0; i<encomendas.getProdutos().size();i++){
			if(encomendas.getProdutos().get(i).getNome() != ""){
				
				Produto produto = new Produto();
				produto.setId(encomendas.getProdutos().get(i).getId());
				produto.setNome(encomendas.getProdutos().get(i).getNome());

				System.out.println(produto.getId());
				System.out.println(produto.getNome());
			}
		}
		 
		 
		 */
		
		
		//reclara um status como falso, pra depois verificar se a condição foi atendida ou não.
		//boolean status = false;
		//cria uma nova instância DAO da encomenda
		//EncomendaDao dao = new EncomendaDao();			
		Status status = new Status();	
		try {
			//se o método inserir passando uma encomenda, for executado corretamente, status recebe verdadeiro
			//status = dao.inserir(encomenda);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//instância uma nova modelView
		ModelAndView mv = new ModelAndView();
	    //seta o caminho e o nome da jsp
		mv.setViewName("administrativo/encomendas");
		//passa o retorno do status para a Expression Language chamada incluir
		mv.addObject("incluir", true);
		mv.addObject("incluirItens", status.getStatus2());
		mv.addObject("numeroEncomenda", status.getNumeroEncomenda());
	    //retorna mv
		return mv;
	}
		
	//AlTERAR ENCOMENDA
	@RequestMapping("/administrativo-alterar-encomenda")
	public ModelAndView alterar_encomenda(Encomenda encomenda){
		System.out.println("Entrou na pagina de alteração de encomenda");
		
		//reclara um status como falso, pra depois verificar se a condição foi atendida ou não.
		boolean status = false;
		//cria uma nova instância DAO da encomenda
		EncomendaDao dao = new EncomendaDao();			
			
		try
		{
			//se o método alterar passando uma encomenda, for executado corretamente, status recebe verdadeiro
			if(dao.alterar(encomenda)) {
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
		mv.setViewName("administrativo/encomendas");
		//passa o retorno do status para a Expression Language chamada alterar
		mv.addObject("alterar", status);
	    //retorna mv			
		return mv;
	}
		
	//EXCLUIR ENCOMENDA
	@RequestMapping("/administrativo-excluir-encomenda")
	public ModelAndView excluir_encomenda(Encomenda encomenda){
		System.out.println("Entrou na pagina de exclusão de encomenda");
		
		//reclara um status como falso, pra depois verificar se a condição foi atendida ou não.
		boolean status = false;	
		//cria uma nova instância DAO da encomenda	
		EncomendaDao dao = new EncomendaDao();
			
		try {
			//se o método excluir passando uma encomenda, for executado corretamente, status recebe verdadeiro
			if(dao.excluir(encomenda)) {
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
		mv.setViewName("administrativo/encomendas");
		//passa o retorno do status para a Expression Language chamada excluir
		mv.addObject("excluir", status);			
	    //retorna mv			
		return mv;
	}
		
	//PESQUISAR ENCOMENDA
	@RequestMapping("/administrativo-pesquisar-encomenda")
	public ModelAndView pesquisar_encomenda(String pesquisa){
		System.out.println("Realizou a pesquisa do número da encomenda");
		
		//cria uma nova instância DAO da encomenda
		EncomendaDao dao = new EncomendaDao();
		Encomenda e = new Encomenda();
		List<Encomenda> encomendas = new ArrayList<Encomenda>();
		try {
			e = dao.pesquisarId(pesquisa);
			encomendas.add(e);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		//instância uma nova modelView
		ModelAndView mv = new ModelAndView();
	    //seta o caminho e o nome da jsp
		mv.setViewName("administrativo/encomendas");
	    //passa a lista de encomenda para a Expression Language chamada encomendas
		mv.addObject("encomendas", encomendas);
	    //retorna mv		    
	    return mv;
	}
	
}
