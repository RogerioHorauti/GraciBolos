package br.com.gracibolos.jpa.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the itemencomenda database table.
 * 
 */
@Entity
@NamedQuery(name="Itemencomenda.findAll", query="SELECT i FROM Itemencomenda i")
public class Itemencomenda implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private int qtd;

	private BigDecimal total;

	private BigDecimal valor;

	//bi-directional many-to-one association to Encomenda
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="encomendaId")
	private Encomenda encomenda;

	//bi-directional many-to-one association to Produto
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="produtoId")
	private Produto produto;

	public Itemencomenda() {
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

	public BigDecimal getValor() {
		return this.valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Encomenda getEncomenda() {
		return this.encomenda;
	}

	public void setEncomenda(Encomenda encomenda) {
		this.encomenda = encomenda;
	}

	public Produto getProduto() {
		return this.produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

}