package br.com.gracibolos.jpa.model;

public class Dashboard {
	
	private MesesJpa gasto;
	private MesesJpa receb;
	
	public MesesJpa getGasto() {
		return gasto;
	}
	public void setGasto(MesesJpa gasto) {
		this.gasto = gasto;
	}
	public MesesJpa getReceb() {
		return receb;
	}
	public void setReceb(MesesJpa receb) {
		this.receb = receb;
	}
}
