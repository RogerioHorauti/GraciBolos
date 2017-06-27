package br.com.gracibolos.jpa.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the caixa database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name="Caixa.findAll", query="SELECT c FROM Caixa c"),
	@NamedQuery(name="Caixa.findByEncomenda", query="SELECT c FROM Caixa c where c.encomenda = :encomenda"),
	@NamedQuery(name="Caixa.betweenDate", query="SELECT c FROM Caixa c where c.dataTransacao between :dateStart and :dateEnd")
})

public class Caixa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.DATE)
	private Date dataOperacao;

	@Temporal(TemporalType.DATE)
	private Date dataTransacao;

	@Lob
	private String descricao;

	private String forma;

	private int gastoRecebimento;

	private int parcela;

	private BigDecimal saldo;

	private BigDecimal valor;

	//bi-directional many-to-one association to Encomenda
	@ManyToOne
	@JoinColumn(name="encomendaId")
	private Encomenda encomenda;

	//bi-directional many-to-one association to Fornecedor
	@ManyToOne
	@JoinColumn(name="fornecedorId")
	private Fornecedor fornecedor;

	public Caixa() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDataOperacao() {
		return this.dataOperacao;
	}

	public void setDataOperacao(Date dataOperacao) {
		this.dataOperacao = dataOperacao;
	}

	public Date getDataTransacao() {
		return this.dataTransacao;
	}

	public void setDataTransacao(Date dataTransacao) {
		this.dataTransacao = dataTransacao;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getForma() {
		return this.forma;
	}

	public void setForma(String forma) {
		this.forma = forma;
	}

	public int getGastoRecebimento() {
		return this.gastoRecebimento;
	}

	public void setGastoRecebimento(int gastoRecebimento) {
		this.gastoRecebimento = gastoRecebimento;
	}

	public int getParcela() {
		return this.parcela;
	}

	public void setParcela(int parcela) {
		this.parcela = parcela;
	}

	public BigDecimal getSaldo() {
		return this.saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
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

	public Fornecedor getFornecedor() {
		return this.fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Caixa other = (Caixa) obj;
		if (id != other.id)
			return false;
		return true;
	}

}