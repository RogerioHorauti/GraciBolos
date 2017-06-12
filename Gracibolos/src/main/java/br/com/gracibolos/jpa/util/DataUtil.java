package br.com.gracibolos.jpa.util;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

import br.com.gracibolos.jdbc.dao.CaixaDao;
import br.com.gracibolos.jdbc.model.Caixa;

public class DataUtil {
	
	public LocalDate hoje = LocalDate.now();
	public String dataInicial = hoje.with(TemporalAdjusters.firstDayOfMonth()).toString();
	public String dataFinal = hoje.with(TemporalAdjusters.lastDayOfMonth()).toString();
	public String ano = String.valueOf(hoje.getYear());
	
	private CaixaDao daoCaixa;
	private BigDecimal saldo;
	private List<Caixa> listCaixa;
	
	public BigDecimal saldo(){
		daoCaixa = new CaixaDao();
		try {
			saldo = daoCaixa.getSaldo();
		} catch (Exception e) {
			// Auto-generated catch block
			e.printStackTrace();
		}
		return saldo;
	}
	
	public List<Caixa> listaCaixaMes()
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
}
