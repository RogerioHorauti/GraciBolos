package br.com.gracibolos.jpa.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the estoque database table.
 * 
 */
@Entity
@NamedQuery(name="Estoque.findAll", query="SELECT e FROM Estoque e")
public class Estoque implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private BigDecimal precoUnit;

	private int qtd;

	private BigDecimal total;

	@Temporal(TemporalType.TIMESTAMP)
	private Date venc;

	//bi-directional many-to-one association to Compra
	@ManyToOne
	@JoinColumn(name="compraId")
	private Compra compra;

	//bi-directional many-to-one association to Materiaprima
	@ManyToOne
	@JoinColumn(name="materiaPrimaId")
	private Materiaprima materiaprima;

	//bi-directional many-to-one association to Medida
	@ManyToOne
	@JoinColumn(name="medidaId")
	private Medida medida;

	public Estoque() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigDecimal getPrecoUnit() {
		return this.precoUnit;
	}

	public void setPrecoUnit(BigDecimal precoUnit) {
		this.precoUnit = precoUnit;
	}

	public int getQtd() {
		return this.qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}

	public BigDecimal getTotal() {
		return this.total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public Date getVenc() {
		return this.venc;
	}

	public void setVenc(Date venc) {
		this.venc = venc;
	}

	public Compra getCompra() {
		return this.compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}

	public Materiaprima getMateriaprima() {
		return this.materiaprima;
	}

	public void setMateriaprima(Materiaprima materiaprima) {
		this.materiaprima = materiaprima;
	}

	public Medida getMedida() {
		return this.medida;
	}

	public void setMedida(Medida medida) {
		this.medida = medida;
	}

}