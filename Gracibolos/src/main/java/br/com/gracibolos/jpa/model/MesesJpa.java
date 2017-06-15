package br.com.gracibolos.jpa.model;

import java.math.BigDecimal;

public class MesesJpa {
	
	private BigDecimal janeiro = new BigDecimal(0);
	private BigDecimal fevereiro = new BigDecimal(0);
	private BigDecimal marco = new BigDecimal(0);
	private BigDecimal abril= new BigDecimal(0);
	private BigDecimal maio= new BigDecimal(0);
	private BigDecimal junho= new BigDecimal(0);
	private BigDecimal julho= new BigDecimal(0);
	private BigDecimal agosto= new BigDecimal(0);
	private BigDecimal setembro= new BigDecimal(0);
	private BigDecimal outubro= new BigDecimal(0);
	private BigDecimal novembro= new BigDecimal(0);
	private BigDecimal dezembro= new BigDecimal(0);
	
	public BigDecimal getJaneiro() {
		return janeiro;
	}
	public void setJaneiro(BigDecimal janeiro) {
		this.janeiro = this.janeiro.add(janeiro);
	}
	public BigDecimal getFevereiro() {
		return fevereiro;
	}
	public void setFevereiro(BigDecimal fevereiro) {
		this.fevereiro = this.fevereiro.add(fevereiro);
	}
	public BigDecimal getMarco() {
		return marco;
	}
	public void setMarco(BigDecimal marco) {
		this.marco = this.marco.add(marco);
	}
	public BigDecimal getAbril() {
		return abril;
	}
	public void setAbril(BigDecimal abril) {
		this.abril = this.abril.add(abril);
	}
	public BigDecimal getMaio() {
		return maio;
	}
	public void setMaio(BigDecimal maio) {
		this.maio = this.maio.add(maio);
	}
	public BigDecimal getJunho() {
		return junho;
	}
	public void setJunho(BigDecimal junho) {
		this.junho = this.junho.add(junho);
	}
	public BigDecimal getJulho() {
		return julho;
	}
	public void setJulho(BigDecimal julho) {
		this.julho = this.julho.add(julho);
	}
	public BigDecimal getAgosto() {
		return agosto;
	}
	public void setAgosto(BigDecimal agosto) {
		this.agosto = this.agosto.add(agosto);
	}
	public BigDecimal getSetembro() {
		return setembro;
	}
	public void setSetembro(BigDecimal setembro) {
		this.setembro = this.setembro.add(setembro);
	}
	public BigDecimal getOutubro() {
		return outubro;
	}
	public void setOutubro(BigDecimal outubro) {
		this.outubro = this.outubro.add(outubro);
	}
	public BigDecimal getNovembro() {
		return novembro;
	}
	public void setNovembro(BigDecimal novembro) {
		this.novembro = this.novembro.add(novembro);
	}
	public BigDecimal getDezembro() {
		return dezembro;
	}
	public void setDezembro(BigDecimal dezembro) {
		this.dezembro = this.dezembro.add(dezembro);
	}

}
