package br.com.gacibolos.test;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/gracibolos-servlet.xml")
abstract class GenericTest {
	public void entreDatas(){}
	public void pesqPorId(){}
	public void dashboard(){}
	public void inserir() {}
	public void listar() {}
}
