package br.com.gracibolos.jpa.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the encomenda database table.
 * 
 */
@Entity
@NamedQuery(name="Encomenda.findAll", query="SELECT e FROM Encomenda e")
public class Encomenda implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Temporal(TemporalType.DATE)
	private Date datacancelado;

	@Temporal(TemporalType.DATE)
	private Date dataencomenda;

	@Temporal(TemporalType.DATE)
	private Date dataentrega;

	@Temporal(TemporalType.DATE)
	private Date datafaturamento;

	@Temporal(TemporalType.DATE)
	private Date datafinalizado;

	@Temporal(TemporalType.DATE)
	private Date dataproducao;

	@Lob
	private String obs;

	private String responsavel;

	private BigDecimal total;

	//bi-directional many-to-one association to Caixa
	@OneToMany(mappedBy="encomenda")
	private List<Caixa> caixas;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="cliente")
	private Cliente clienteBean;

	//bi-directional many-to-one association to Status
	@ManyToOne
	@JoinColumn(name="status")
	private Status statusBean;

	//bi-directional many-to-one association to Itemencomenda
	@OneToMany(mappedBy="encomenda")
	private List<Itemencomenda> itemencomendas;

	//bi-directional many-to-one association to Produtopronto
	@OneToMany(mappedBy="encomenda")
	private List<Produtopronto> produtoprontos;

	//bi-directional many-to-one association to Suporte
	@OneToMany(mappedBy="encomenda")
	private List<Suporte> suportes;

	public Encomenda() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDatacancelado() {
		return this.datacancelado;
	}

	public void setDatacancelado(Date datacancelado) {
		this.datacancelado = datacancelado;
	}

	public Date getDataencomenda() {
		return this.dataencomenda;
	}

	public void setDataencomenda(Date dataencomenda) {
		this.dataencomenda = dataencomenda;
	}

	public Date getDataentrega() {
		return this.dataentrega;
	}

	public void setDataentrega(Date dataentrega) {
		this.dataentrega = dataentrega;
	}

	public Date getDatafaturamento() {
		return this.datafaturamento;
	}

	public void setDatafaturamento(Date datafaturamento) {
		this.datafaturamento = datafaturamento;
	}

	public Date getDatafinalizado() {
		return this.datafinalizado;
	}

	public void setDatafinalizado(Date datafinalizado) {
		this.datafinalizado = datafinalizado;
	}

	public Date getDataproducao() {
		return this.dataproducao;
	}

	public void setDataproducao(Date dataproducao) {
		this.dataproducao = dataproducao;
	}

	public String getObs() {
		return this.obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public String getResponsavel() {
		return this.responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	public BigDecimal getTotal() {
		return this.total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public List<Caixa> getCaixas() {
		return this.caixas;
	}

	public void setCaixas(List<Caixa> caixas) {
		this.caixas = caixas;
	}

	public Caixa addCaixa(Caixa caixa) {
		getCaixas().add(caixa);
		caixa.setEncomenda(this);

		return caixa;
	}

	public Caixa removeCaixa(Caixa caixa) {
		getCaixas().remove(caixa);
		caixa.setEncomenda(null);

		return caixa;
	}

	public Cliente getClienteBean() {
		return this.clienteBean;
	}

	public void setClienteBean(Cliente clienteBean) {
		this.clienteBean = clienteBean;
	}

	public Status getStatusBean() {
		return this.statusBean;
	}

	public void setStatusBean(Status statusBean) {
		this.statusBean = statusBean;
	}

	public List<Itemencomenda> getItemencomendas() {
		return this.itemencomendas;
	}

	public void setItemencomendas(List<Itemencomenda> itemencomendas) {
		this.itemencomendas = itemencomendas;
	}

	public Itemencomenda addItemencomenda(Itemencomenda itemencomenda) {
		getItemencomendas().add(itemencomenda);
		itemencomenda.setEncomenda(this);

		return itemencomenda;
	}

	public Itemencomenda removeItemencomenda(Itemencomenda itemencomenda) {
		getItemencomendas().remove(itemencomenda);
		itemencomenda.setEncomenda(null);

		return itemencomenda;
	}

	public List<Produtopronto> getProdutoprontos() {
		return this.produtoprontos;
	}

	public void setProdutoprontos(List<Produtopronto> produtoprontos) {
		this.produtoprontos = produtoprontos;
	}

	public Produtopronto addProdutopronto(Produtopronto produtopronto) {
		getProdutoprontos().add(produtopronto);
		produtopronto.setEncomenda(this);

		return produtopronto;
	}

	public Produtopronto removeProdutopronto(Produtopronto produtopronto) {
		getProdutoprontos().remove(produtopronto);
		produtopronto.setEncomenda(null);

		return produtopronto;
	}

	public List<Suporte> getSuportes() {
		return this.suportes;
	}

	public void setSuportes(List<Suporte> suportes) {
		this.suportes = suportes;
	}

	public Suporte addSuporte(Suporte suporte) {
		getSuportes().add(suporte);
		suporte.setEncomenda(this);

		return suporte;
	}

	public Suporte removeSuporte(Suporte suporte) {
		getSuportes().remove(suporte);
		suporte.setEncomenda(null);

		return suporte;
	}

}