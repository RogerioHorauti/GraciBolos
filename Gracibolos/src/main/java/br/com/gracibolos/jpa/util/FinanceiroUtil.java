package br.com.gracibolos.jpa.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.com.gracibolos.jdbc.dao.CaixaDao;
import br.com.gracibolos.jdbc.model.Caixa;

public class FinanceiroUtil {
	
	private static CaixaDao daoCaixa;
	private static BigDecimal saldo;
	private static List<Caixa> listCaixa;
	
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
	
	public static List<Caixa> listaCaixaMes()
	{
		daoCaixa = new CaixaDao();
		listCaixa = new ArrayList<Caixa>();

		//System.out.println(dataFinal);
		try {
			listCaixa = daoCaixa.pesquisarEntre(
					DateUtil.primeiroDiaMes().toString(), 
					DateUtil.ultimoDiaMes().toString()
					);
		} catch (Exception e) {
			// Auto-generated catch block
			e.printStackTrace();
		}
		return listCaixa;
	}
}
