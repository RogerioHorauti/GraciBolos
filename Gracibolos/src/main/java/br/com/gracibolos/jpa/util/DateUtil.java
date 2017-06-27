package br.com.gracibolos.jpa.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class DateUtil {
	
	public static LocalDate hoje = LocalDate.now();
	
	public static LocalDate primeiroDiaMes(){
		return hoje.with(TemporalAdjusters.firstDayOfMonth());
	}
	
	//with : lembra um setter, mas retorna um novo objeto com o valor alterado
	public static LocalDate ultimoDiaMes(){
		return hoje.with(TemporalAdjusters.lastDayOfMonth());
	}
	public static int ano(){
		return hoje.getYear();
	}
	
	public static int mes(Date date){
		return asLocalDate(date).getMonthValue(); // LocalDate
	}
	
	public static int mes(Calendar calendar){
		//get : obtém o valor de algo
		return calendar.get(Calendar.MONTH);
	}
	
	public static int mes(LocalDate localDate){
		return localDate.getMonthValue();
	}

	public static Date asDate(LocalDate localDate){
		//return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
		//Um ZoneId é usado para identificar as regras usadas para converter entre um Instant e um LocalDateTime.
		return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
	}
	
	public static Date asDate(LocalDateTime localDateTime) {
		return Date.from(localDateTime.atZone(ZoneOffset.UTC).toInstant());
	    //return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
	}
	
	public static Date asDate(String string) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.parse(string);
	}
	
	public static LocalDate asLocalDate(Date date) {
	    //return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
		return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}
	
	public static LocalDateTime asLocalDateTime(Date date) {
	    //return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDateTime();
		return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
	}
	
	// Gerador de datas---------------------------------------------------------------------
	public LocalDate generateDate(int anoInicial, int mesInicial, int diaInicial,
			int anoFinal, int mesFinal, int diaFinal){
		LocalDate start = LocalDate.of(anoInicial, mesInicial, diaInicial);
		LocalDate end = LocalDate.of(anoFinal, mesFinal, diaFinal);	
	    long days = ChronoUnit.DAYS.between(start, end);// Retorna o n° de dias
        return start.plusDays(new Random().nextInt((int) days + 1));//soma o n° de dias
	}
}
