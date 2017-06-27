package br.com.gacibolos.test;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import br.com.gracibolos.jpa.dao.CaixaJpaDao;
import br.com.gracibolos.jpa.model.Caixa;
import br.com.gracibolos.jpa.model.Dashboard;
import br.com.gracibolos.jpa.model.MesesJpa;
import br.com.gracibolos.jpa.util.DateUtil;

public class CaixaJpaTest extends GenericTest {
	
	@Autowired
	CaixaJpaDao dao;
	List<Caixa> list;
	Caixa caixa;
	
	@Test
	@Transactional
	@Override
	public void entreDatas(){
		try {
			list = new ArrayList<Caixa>();
			list = dao.pesquisarEntre(DateUtil.asDate("2017-06-01"), DateUtil.asDate("2017-06-30"));
			System.out.println("Números de entradas de Junho : "+list.size());
			assertEquals("Entre datas ok",19, list.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	@Transactional
	@Override
	public void pesqPorId(){
		try {
			caixa = new Caixa();
			caixa = dao.pesquisar("87");
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
		MesesJpa receb = new MesesJpa();
		MesesJpa gasto = new MesesJpa();		
		
		try {
			
			//list = dao.pesquisarEntre(DataUtil.ano+"-01-01", DataUtil.ano+"-12-31");
			list = dao.pesquisarEntre(DateUtil.asDate("2017-01-01"), DateUtil.asDate("2017-12-31"));
			
			for(Caixa c : list){
				
				switch(DateUtil.mes(c.getDataTransacao())){
					case 1 :// Janeiro
						if(c.getGastoRecebimento()==1)// receb
							receb.setJaneiro(c.getValor());
						else							  // gasto
							gasto.setJaneiro(c.getValor());
						continue;
					case 2 :// Fevereiro
						if(c.getGastoRecebimento()==1)
							receb.setFevereiro(c.getValor());
						else
							gasto.setFevereiro(c.getValor());
						continue;
					case 3 :// Março
						if(c.getGastoRecebimento()==1)
							receb.setMarco(c.getValor());
						else
							gasto.setMarco(c.getValor());
						continue;
					case 4 :// Abril
						if(c.getGastoRecebimento()==1)
							receb.setAbril(c.getValor());
						else
							gasto.setAbril(c.getValor());
						continue;
					case 5 :// Maio
						if(c.getGastoRecebimento()==1)
							receb.setMaio(c.getValor());
						else
							gasto.setMaio(c.getValor());
						continue;
					case 6 :// Junho
						if(c.getGastoRecebimento()==1)
							receb.setJunho(c.getValor());
						else
							gasto.setJunho(c.getValor());
						continue;
					case 7 :// Julho
						if(c.getGastoRecebimento()==1)
							receb.setJulho(c.getValor());
						else
							gasto.setJulho(c.getValor());
						continue;
					case 8 :// Agosto
						if(c.getGastoRecebimento()==1)
							receb.setAgosto(c.getValor());
						else
							gasto.setAgosto(c.getValor());
						continue;
					case 9 :// Setembro
						if(c.getGastoRecebimento()==1)
							receb.setSetembro(c.getValor());
						else
							gasto.setSetembro(c.getValor());
						continue;
					case 10 :// Outubro
						if(c.getGastoRecebimento()==1)
							receb.setOutubro(c.getValor());
						else
							gasto.setOutubro(c.getValor());
						continue;
					case 11 :// Novembro
						if(c.getGastoRecebimento()==1)
							receb.setNovembro(c.getValor());
						else
							gasto.setNovembro(c.getValor());
						continue;
					case 12 :// Dezembro
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
