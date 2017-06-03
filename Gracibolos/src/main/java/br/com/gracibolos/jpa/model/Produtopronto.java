package br.com.gracibolos.jpa.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the produtopronto database table.
 * 
 */
@Entity
@NamedQuery(name="Produtopronto.findAll", query="SELECT p FROM Produtopronto p")
public class Produtopronto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String codigo;

	@Temporal(TemporalType.DATE)
	private Date dataValidade;

	@Temporal(TemporalType.TIMESTAMP)
	private Date finalizado;

	//bi-directional many-to-one association to Encomenda
	@ManyToOne
	@JoinColumn(name="encomendaId")
	private Encomenda encomenda;

	//bi-directional many-to-one association to Produto
	@ManyToOne
	@JoinColumn(name="produtoId")
	private Produto produto;

	public Produtopronto() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Date getDataValidade() {
		return this.dataValidade;
	}

	public void setDataValidade(Date dataValidade) {
		this.dataValidade = dataValidade;
	}

	public Date getFinalizado() {
		return this.finalizado;
	}

	public void setFinalizado(Date finalizado) {
		this.finalizado = finalizado;
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