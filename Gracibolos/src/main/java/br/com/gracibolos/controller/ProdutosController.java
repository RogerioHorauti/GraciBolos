package br.com.gracibolos.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import br.com.gracibolos.jdbc.dao.ProdutoDao;
import br.com.gracibolos.jdbc.model.Produto;

@Controller
public class ProdutosController {
	
	/*
	 * 
	 * ###################### PRODUTOS ######################
	 * 
	 * */
	
	//PRODUTOS
	//mapeamento da jsp admin produtos
	@RequestMapping("/administrativo-produtos")
	public ModelAndView produtos(){
		System.out.println("Entrou na pagina de listagem de produtos");
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("administrativo/produtos");
		
		return mv;
	}
	
	//INCLUIR NOVO PRODUTO
	@RequestMapping("/administrativo-incluir-produto")
	public ModelAndView incluir_produto(Produto produto, @RequestParam("file") MultipartFile file, HttpServletRequest request){
		System.out.println("Entrou na servlet de inclusão de um novo produto");
		
		//reclara um status como falso, pra depois verificar se a condição foi atendida ou não.
		boolean status = false;
		
		//cria uma nova instância DAO do produto
	    ProdutoDao produtoDao = new ProdutoDao();

	    if(!file.isEmpty()) {
		    produto.setFoto(file.getOriginalFilename().toString());
		    
		    try {
		    	
		    	//Pasta de destino
		        String Path = request.getServletContext().getRealPath("\\resources\\img\\produtos");
		        System.out.println("uploadRootPath=" + Path);
		 
		        File diretorio = new File(Path);
		        
		        //Verifica se o diretório já existe, senão cria o diretorio
		        if (!diretorio.exists()) {
		        	diretorio.mkdirs();
		        }
		        
		        File serverFile = new File(diretorio.getAbsolutePath() + File.separator + file.getOriginalFilename());
		    	
		    	BufferedOutputStream stream = null;
		    	stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				FileCopyUtils.copy(file.getInputStream(), stream);
				
				stream.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		    
	    } else {
	    	
	    	if(produto.getFoto() == null || produto.getFoto().equals("")){
		    	produto.setFoto("model.png");
	    	}
	    	
	    }
	    
		try {
			//se o método inserir passando um produto, for executado corretamente, status recebe verdadeiro
			if(produtoDao.inserir(produto)){
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
		mv.setViewName("administrativo/produtos");
		//passa o retorno do status para a Expression Language chamada incluir
		mv.addObject("incluir", status);
		//retorna o mv
		return mv;
	}
	
	//AlTERAR PRODUTO
	@RequestMapping("/administrativo-alterar-produto")
	public ModelAndView alterar_produto(Produto produto, @RequestParam("file") MultipartFile file, HttpServletRequest request){
				
		System.out.println("Entrou na pagina de alteração de produto");
		
		//reclara um status como falso, pra depois verificar se a condição foi atendida ou não.
		boolean status = false;
		//cria uma nova instância DAO do produto
		ProdutoDao produtoDao = new ProdutoDao();
	    
		if(!file.isEmpty()) {
		    produto.setFoto(file.getOriginalFilename().toString());
		    
		    try {
		    	
		    	//Pasta de destino
		        String Path = request.getServletContext().getRealPath("\\resources\\img\\produtos");
		        System.out.println("uploadRootPath=" + Path);
		 
		        File diretorio = new File(Path);
		        
		        //Verifica se o diretório já existe, senão cria o diretorio
		        if (!diretorio.exists()) {
		        	diretorio.mkdirs();
		        }
		        
		        File serverFile = new File(diretorio.getAbsolutePath() + File.separator + file.getOriginalFilename());
		    	
		    	BufferedOutputStream stream = null;
		    	stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				FileCopyUtils.copy(file.getInputStream(), stream);

				stream.close();
			} catch (IOException e) {
				System.out.println("Não foi possível fazer o upload da imagem.");
				e.printStackTrace();
			}
		    
	    } else {
	    	
	    	if(produto.getFoto() == null){
		    	produto.setFoto("model.png");
	    	}
	    	
	    }
				
		try {
			//se o método alterar passando um produto, for executado corretamente, status recebe verdadeiro
			if(produtoDao.alterar(produto)){
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
		mv.setViewName("administrativo/produtos");
		//passa o retorno do status para a Expression Language chamada alterar
		mv.addObject("alterar", status);
		//retorna o mv
		return mv;
	}
	
	//EXCLUIR PRODUTO
	@RequestMapping("/administrativo-remover-produto")
	public ModelAndView excluir_produto(Produto produto){
		System.out.println("Entrou na pagina de exclusão de produto");
		
		//reclara um status como falso, pra depois verificar se a condição foi atendida ou não.
		boolean status = false;
		//cria uma nova instância DAO do produto
		ProdutoDao produtoDao = new ProdutoDao();
		
		try {
			//se o método excluir passando um produto, for executado corretamente, status recebe verdadeiro
			if(produtoDao.excluir(produto)){
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
		mv.setViewName("administrativo/produtos");
		//passa o retorno do status para a Expression Language chamada excluir
		mv.addObject("excluir", status);
		//retorna o mv
		return mv;
	}	
	
	//PESQUISAR PRODUTOS
	@RequestMapping("/administrativo-pesquisar-produto")
	public ModelAndView pesquisar_produto(String pesquisa){
		System.out.println("Realizou a pesquisa de produto");
		
		//cria uma nova instância DAO do produto
		ProdutoDao produtoDao = new ProdutoDao();
				
		List<Produto> produtos = null;
		
		try {
			produtos = produtoDao.pesquisar(pesquisa);
		} catch (Exception e) {
			e.printStackTrace();
		}
	    
		//instância uma nova modelView
		ModelAndView mv = new ModelAndView();
		//seta o caminho e o nome da jsp
		mv.setViewName("administrativo/produtos");
		//passa a lista de produtos para a Expression Language chamada produtos
		mv.addObject("produtos", produtos);
		//retorna o mv	    
	    return mv;
	}
	
	//LISTAR PRODUTOS
		@RequestMapping("/administrativo-listar-produtos")
		public ModelAndView listar_produtos(){
			System.out.println("Realizou a listagem de produtos");
			
			//cria uma nova instância DAO do produto
			ProdutoDao produtoDao = new ProdutoDao();
			
			List<Produto> produtos = null;
			
			try {
				//Guarda a lista de produtos num List
				produtos = produtoDao.listar();
			} catch (Exception e) {
				e.printStackTrace();
			}
		    
			//instância uma nova modelView
			ModelAndView mv = new ModelAndView();
			//seta o caminho e o nome da jsp
			mv.setViewName("administrativo/produtos");
			//passa a lista de produtos para a Expression Language chamada produtos
			mv.addObject("produtos", produtos);
			//retorna o mv	    
		    return mv;
		}
		
		
}
