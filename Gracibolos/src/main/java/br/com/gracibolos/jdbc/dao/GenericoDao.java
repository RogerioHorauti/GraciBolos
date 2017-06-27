package br.com.gracibolos.jdbc.dao;

import java.util.List;

interface GenericoDao <E>{
	
    boolean inserir(E e) throws Exception;
    boolean alterar(E e) throws Exception;
    boolean excluir(E e) throws Exception;
    //Interface para listar objetos, retorna uma lista
    List<E> listar() throws Exception;
    //Interface de pesquisa, é passado um parametro e é retornado uma lista
    List<E> pesquisar(String pesquisa) throws Exception;

}
