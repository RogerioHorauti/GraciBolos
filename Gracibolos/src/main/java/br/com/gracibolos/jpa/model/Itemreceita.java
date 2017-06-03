package br.com.gracibolos.jpa.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the itemreceita database table.
 * 
 */
@Entity
@NamedQuery(name="Itemreceita.findAll", query="SELECT i FROM Itemreceita i")
public class Itemreceita implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private int qtd;

	private BigDecimal total;

	//bi-directional many-to-one association to Materiaprima
	@ManyToOne
	@JoinColumn(name="materiaPrimaId")
	private Materiaprima materiaprima;

	//bi-directional many-to-one association to Medida
	@ManyToOne
	@JoinColumn(name="medidaId")
	private Medida medida;

	//bi-directional many-to-one association to Produto
	@ManyToOne
	@JoinColumn(name="produtoId")
	private Produto produto;

	public Itemreceita() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Produto getProduto() {
		return this.produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

}