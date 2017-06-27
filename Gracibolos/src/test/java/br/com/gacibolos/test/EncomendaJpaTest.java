package br.com.gacibolos.test;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import br.com.gracibolos.jpa.dao.EncomendaJpaDao;
import br.com.gracibolos.jpa.model.Cliente;
import br.com.gracibolos.jpa.model.Encomenda;
import br.com.gracibolos.jpa.model.Itemencomenda;
import br.com.gracibolos.jpa.model.Produto;
import br.com.gracibolos.jpa.model.Status;
import br.com.gracibolos.jpa.util.DateUtil;

public class EncomendaJpaTest extends GenericTest {
	
	@Autowired
	EncomendaJpaDao dao;
	Encomenda e;
	Cliente c;
	Status status;
	List<Itemencomenda> ieList;
	Itemencomenda ie,ie2;
	Produto p, p2;
	
	@Test
	@Transactional
	@Override
	public void inserir() {
		/*--Encomenda----------------------------------------------------------------------------------*/
		e = new Encomenda();
		c = new Cliente();
		c.setId(356);// Brian Juarez
		e.setClienteBean(c);
		
		status = new Status();
		status.setId(3);//Faturada
		//status.setStatus("Faturada");
		e.setStatusBean(status);
		
		try {
			e.setDataencomenda(DateUtil.asDate("2017-06-12"));
			e.setDataentrega(DateUtil.asDate("2017-06-17"));
			e.setDatafaturamento(DateUtil.asDate("2017-06-12"));
			
		} catch (ParseException e) 
		{
			e.printStackTrace();
		}
		
		e.setResponsavel("João");
		
		/*--Itens-------------------------------------------------------------------------------------*/
//			ieList = new ArrayList<Itemencomenda>();
//			p = new Produto();
//			ie = new Itemencomenda();
//			ie.setEncomenda(e);
//			p.setId(13);//Bolo de cenoura
//			ie.setProduto(p);
//			ie.setQtd(1);
//			ie.setValor(new BigDecimal(12.00));
//			ieList.add(ie);
//			
//			p2 = new Produto();
//			ie2 = new Itemencomenda();
//			ie2.setEncomenda(e);
//			p2.setId(1);//Torta de morango
//			ie2.setProduto(p2);
//			ie2.setQtd(1);
//			ie2.setValor(new BigDecimal(35.00));
//			ieList.add(ie2);
//			
//			e.setItemencomendas(ieList);
//			
//		/*--Total encomenda---------------------------------------------------------------------------*/
//			e.setTotal(ie.getValor());
//			e.setTotal(ie2.getValor());
		/*--------------------------------------------------------------------------------------------*/
		try {
			System.out.println(dao.inserir(e));
		} catch (Exception e) {	
			e.printStackTrace();
		}
	}
	
//	@Test
//	@Transactional
//	@Override
//	public void pesqPorId() {
//		e = new Encomenda();
//		try {
//			e = dao.pesquisar(47);
//			System.out.println(
//					"Cliente : "+e.getClienteBean().getNomerazao()
//					+"\nNumero : "+e.getId()
//					+"\nData encomenda : "+e.getDataencomenda()
//					+"\nData entrega : "+e.getDataentrega()
//					+"\nData faturamento : "+e.getDatafaturamento()
//					+"\nData produção : "+e.getDataproducao()
//					+"\nData finalizado : "+e.getDatafinalizado()
//				);
//		} catch (Exception e1) {
//			e1.printStackTrace();
//		}
//	}
}
