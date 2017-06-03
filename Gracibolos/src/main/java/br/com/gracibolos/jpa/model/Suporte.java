package br.com.gracibolos.jpa.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the suporte database table.
 * 
 */
@Entity
@NamedQuery(name="Suporte.findAll", query="SELECT s FROM Suporte s")
public class Suporte implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private String codigo;

	private int fornecedorId;

	private String status;

	private BigDecimal valor;

	//bi-directional many-to-one association to Encomenda
	@ManyToOne
	@JoinColumn(name="encomendaId")
	private Encomenda encomenda;

	public Suporte() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public int getFornecedorId() {
		return this.fornecedorId;
	}

	public void setFornecedorId(int fornecedorId) {
		this.fornecedorId = fornecedorId;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
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

}