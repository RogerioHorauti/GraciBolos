package br.com.gracibolos.jpa.util;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

import br.com.gracibolos.jdbc.dao.CaixaDao;
import br.com.gracibolos.jdbc.model.Caixa;

public class DataUtil {
	
	public static LocalDate hoje = LocalDate.now();
	public static String dataInicial = hoje.with(TemporalAdjusters.firstDayOfMonth()).toString();
	public static String dataFinal = hoje.with(TemporalAdjusters.lastDayOfMonth()).toString();
	public static String ano = String.valueOf(hoje.getYear());
	
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
			listCaixa = daoCaixa.pesquisarEntre(dataInicial, dataFinal);
		} catch (Exception e) {
			// Auto-generated catch block
			e.printStackTrace();
		}
		return listCaixa;
	}
}
