package br.com.gracibolos.jpa.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the status database table.
 * 
 */
@Entity
@NamedQuery(name="Status.findAll", query="SELECT s FROM Status s")
public class Status implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String status;

	//bi-directional many-to-one association to Compra
	@OneToMany(mappedBy="status")
	private List<Compra> compras;

	//bi-directional many-to-one association to Encomenda
	@OneToMany(mappedBy="statusBean")
	private List<Encomenda> encomendas;

	public Status() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Compra> getCompras() {
		return this.compras;
	}

	public void setCompras(List<Compra> compras) {
		this.compras = compras;
	}

	public Compra addCompra(Compra compra) {
		getCompras().add(compra);
		compra.setStatus(this);

		return compra;
	}

	public Compra removeCompra(Compra compra) {
		getCompras().remove(compra);
		compra.setStatus(null);

		return compra;
	}

	public List<Encomenda> getEncomendas() {
		return this.encomendas;
	}

	public void setEncomendas(List<Encomenda> encomendas) {
		this.encomendas = encomendas;
	}

	public Encomenda addEncomenda(Encomenda encomenda) {
		getEncomendas().add(encomenda);
		encomenda.setStatusBean(this);

		return encomenda;
	}

	public Encomenda removeEncomenda(Encomenda encomenda) {
		getEncomendas().remove(encomenda);
		encomenda.setStatusBean(null);

		return encomenda;
	}

}