package br.com.gacibolos.test;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import br.com.gracibolos.jpa.dao.CaixaJpaDao;
import br.com.gracibolos.jpa.model.Caixa;
import br.com.gracibolos.jpa.util.DataUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/gracibolos-servlet.xml")
public class CaixaJpaTest extends DataUtil {
	
	@Autowired
	CaixaJpaDao dao;
	List<Caixa> list = new ArrayList<Caixa>();
	Caixa caixa;
	
	@Test
	@Transactional
	public void entreDatas(){
		try {
			list = dao.pesquisarEntre("2017-06-01", "2017-06-30");
			System.out.println(list.size());
			assertEquals("Entre datas ok",19, list.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	@Transactional
	public void pesqEncomendaId(){
		try {
			caixa = new Caixa();
			caixa = dao.pesquisaUnica("87");
			System.out.println(caixa.getValor());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
