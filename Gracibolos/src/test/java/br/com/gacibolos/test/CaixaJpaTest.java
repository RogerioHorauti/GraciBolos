package br.com.gacibolos.test;
import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.ZoneId;
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
import br.com.gracibolos.jpa.model.Dashboard;
import br.com.gracibolos.jpa.model.MesesJpa;
import br.com.gracibolos.jpa.util.DataUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/gracibolos-servlet.xml")
public class CaixaJpaTest extends DataUtil {
	
	@Autowired
	CaixaJpaDao dao;
	List<Caixa> list;
	Caixa caixa;
	
	@Test
	@Transactional
	public void entreDatas(){
		try {
			list = new ArrayList<Caixa>();
			list = dao.pesquisarEntre("2017-06-01", "2017-06-30");
			System.out.println("Números de entradas de Junho : "+list.size());
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
			System.out.println("encomendaId 87 : "+caixa.getValor());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	@Transactional
	public void dashboard(){
	//public Dashboard dashboard(String ano){
		
		list = new ArrayList<Caixa>();
		LocalDate ld;
		MesesJpa receb = new MesesJpa();
		MesesJpa gasto = new MesesJpa();
		
		try {
			
			//list = dao.pesquisarEntre(DataUtil.ano+"-01-01", DataUtil.ano+"-12-31");
			list = dao.pesquisarEntre("2017-01-01", "2017-12-31");
			
			for(Caixa c : list){
				
				//Conversão da dataTransacao para LocalDate
				ld = c.getDataTransacao().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				//System.out.println(ld.getMonthValue()+" "+c.getValor());
				
				switch(ld.getMonthValue()){
					case 1 :
						if(c.getGastoRecebimento()==1)// receb
							receb.setJaneiro(c.getValor());
					else							  // gasto
							gasto.setJaneiro(c.getValor());
						continue;
					case 2 :
						if(c.getGastoRecebimento()==1)
							receb.setFevereiro(c.getValor());
						else
							gasto.setFevereiro(c.getValor());
						continue;
					case 3 :
						if(c.getGastoRecebimento()==1)
							receb.setMarco(c.getValor());
						else
							gasto.setMarco(c.getValor());
						continue;
					case 4 :
						if(c.getGastoRecebimento()==1)
							receb.setAbril(c.getValor());
						else
							gasto.setAbril(c.getValor());
						continue;
					case 5 :
						if(c.getGastoRecebimento()==1)
							receb.setMaio(c.getValor());
						else
							gasto.setMaio(c.getValor());
						continue;
					case 6 :
						if(c.getGastoRecebimento()==1)
							receb.setJunho(c.getValor());
						else
							gasto.setJunho(c.getValor());
						continue;
					case 7 :
						if(c.getGastoRecebimento()==1)
							receb.setJulho(c.getValor());
						else
							gasto.setJulho(c.getValor());
						continue;
					case 8 :
						if(c.getGastoRecebimento()==1)
							receb.setAgosto(c.getValor());
						else
							gasto.setAgosto(c.getValor());
						continue;
					case 9 :
						if(c.getGastoRecebimento()==1)
							receb.setSetembro(c.getValor());
						else
							gasto.setSetembro(c.getValor());
						continue;
					case 10 :
						if(c.getGastoRecebimento()==1)
							receb.setOutubro(c.getValor());
						else
							gasto.setOutubro(c.getValor());
						continue;
					case 11 :
						if(c.getGastoRecebimento()==1)
							receb.setNovembro(c.getValor());
						else
							gasto.setNovembro(c.getValor());
						continue;
					case 12 :
						if(c.getGastoRecebimento()==1)
							receb.setDezembro(c.getValor());
						else
							gasto.setDezembro(c.getValor());
						continue;
					default:
						continue;
				}
				
			}// end for
			
			System.out.println(
					"Janeiro + "+receb.getJaneiro()+" - "+gasto.getJaneiro()//	Janeiro + 1216.00 - 1065.00
					+"\nFevereiro "+receb.getFevereiro()+" - "+gasto.getFevereiro()//	Fevereiro 1980.00 - 1725.00
					+"\nMarço "+receb.getMarco()+" - "+gasto.getMarco()//	Março 1680.00 - 1507.00
					+"\nAbril "+receb.getAbril()+" - "+gasto.getAbril()//	Abril 2127.00 - 1955.00
					+"\nMaio "+receb.getMaio()+" - "+gasto.getMaio()//	Maio 1554.00 - 1171.00
					+"\nJunho "+receb.getJunho()+" - "+gasto.getJunho()//	Junho 1527.00 - 663.00
					+"\nJulho "+receb.getJulho()+" - "+gasto.getJulho()//	Julho 2397.00 - 828.00
					+"\nAgosto "+receb.getAgosto()+" - "+gasto.getAgosto()//	Agosto 1607.00 - 467.00
					+"\nSetembro "+receb.getSetembro()+" - "+gasto.getSetembro()//	Setembro 2102.00 - 634.00
					+"\nOutubro "+receb.getOutubro()+" - "+gasto.getOutubro()//	Outubro 1835.00 - 737.00
					+"\nNovembro "+receb.getNovembro()+" - "+gasto.getNovembro()//	Novembro 2076.00 - 1885.00
					+"\nDezembro "+receb.getDezembro()+" - "+gasto.getDezembro()//	Dezembro 1642.00 - 1025.00
				);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Dashboard db = new Dashboard();
		db.setReceb(receb);
		db.setGasto(gasto);
		
		//return db;
		
	}
}
