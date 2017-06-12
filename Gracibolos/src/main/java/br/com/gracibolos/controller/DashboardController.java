package br.com.gracibolos.controller;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.gracibolos.jdbc.dao.CaixaDao;
import br.com.gracibolos.jdbc.dao.ClienteDao;
import br.com.gracibolos.jdbc.dao.DashboardDao;
import br.com.gracibolos.jdbc.dao.EncomendaDao;
import br.com.gracibolos.jdbc.dao.ProdutoDao;
import br.com.gracibolos.jdbc.model.Meses;

@Controller
public class DashboardController {
	
	private static CaixaDao daoCaixa;
	private static BigDecimal saldo;
	
	@RequestMapping("/administrativo-dashboard")
	public ModelAndView dashboard(){
		System.out.println("Entrou na pagina dashboard");
		
		LocalDate ld = LocalDate.now();
		String ano = String.valueOf(ld.getYear());
		
		Meses gasto = new Meses();
		Meses rec = new Meses();
		
		DashboardDao dao = new DashboardDao();
		ClienteDao daoCli = new ClienteDao();
		EncomendaDao daoEnc = new EncomendaDao();
		ProdutoDao daoPro = new ProdutoDao();
		
		gasto = dao.buscarGastoRecebimento("0", ano);//Aqui eu busquei os gastos "0" deste ano
		rec = dao.buscarGastoRecebimento("1", ano);//Aqui eu busquei os recebimentos "0" deste ano
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("administrativo/dashboard");
		mv.addObject("clientes", daoCli.contagem());
		mv.addObject("encomendas", daoEnc.contagemEmAberto());
		mv.addObject("saldoMes",saldo());
		mv.addObject("produtos", daoPro.contagem());
		mv.addObject("gasto", gasto);
		mv.addObject("recebimento", rec);
		
		return mv;
	}
	
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
}
