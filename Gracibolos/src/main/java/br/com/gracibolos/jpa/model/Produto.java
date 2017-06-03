package br.com.gracibolos.jpa.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the produto database table.
 * 
 */
@Entity
@NamedQuery(name="Produto.findAll", query="SELECT p FROM Produto p")
public class Produto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String codigo;

	private BigDecimal custo;

	private int estoque;

	private String foto;

	private String nome;

	@Lob
	private String obs;

	private BigDecimal peso;

	@Lob
	private String receita;

	private byte status;

	private int unidade;

	private BigDecimal valor;

	//bi-directional many-to-one association to Itemencomenda
	@OneToMany(mappedBy="produto")
	private List<Itemencomenda> itemencomendas;

	//bi-directional many-to-one association to Itemreceita
	@OneToMany(mappedBy="produto")
	private List<Itemreceita> itemreceitas;

	//bi-directional many-to-one association to Tipoproduto
	@ManyToOne
	@JoinColumn(name="tipo")
	private Tipoproduto tipoproduto;

	//bi-directional many-to-one association to Produtopronto
	@OneToMany(mappedBy="produto")
	private List<Produtopronto> produtoprontos;

	public Produto() {
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

	public BigDecimal getCusto() {
		return this.custo;
	}

	public void setCusto(BigDecimal custo) {
		this.custo = custo;
	}

	public int getEstoque() {
		return this.estoque;
	}

	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}

	public String getFoto() {
		return this.foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getObs() {
		return this.obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public BigDecimal getPeso() {
		return this.peso;
	}

	public void setPeso(BigDecimal peso) {
		this.peso = peso;
	}

	public String getReceita() {
		return this.receita;
	}

	public void setReceita(String receita) {
		this.receita = receita;
	}

	public byte getStatus() {
		return this.status;
	}

	public void setStatus(byte status) {
		this.status = status;
	}

	public int getUnidade() {
		return this.unidade;
	}

	public void setUnidade(int unidade) {
		this.unidade = unidade;
	}

	public BigDecimal getValor() {
		return this.valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public List<Itemencomenda> getItemencomendas() {
		return this.itemencomendas;
	}

	public void setItemencomendas(List<Itemencomenda> itemencomendas) {
		this.itemencomendas = itemencomendas;
	}

	public Itemencomenda addItemencomenda(Itemencomenda itemencomenda) {
		getItemencomendas().add(itemencomenda);
		itemencomenda.setProduto(this);

		return itemencomenda;
	}

	public Itemencomenda removeItemencomenda(Itemencomenda itemencomenda) {
		getItemencomendas().remove(itemencomenda);
		itemencomenda.setProduto(null);

		return itemencomenda;
	}

	public List<Itemreceita> getItemreceitas() {
		return this.itemreceitas;
	}

	public void setItemreceitas(List<Itemreceita> itemreceitas) {
		this.itemreceitas = itemreceitas;
	}

	public Itemreceita addItemreceita(Itemreceita itemreceita) {
		getItemreceitas().add(itemreceita);
		itemreceita.setProduto(this);

		return itemreceita;
	}

	public Itemreceita removeItemreceita(Itemreceita itemreceita) {
		getItemreceitas().remove(itemreceita);
		itemreceita.setProduto(null);

		return itemreceita;
	}

	public Tipoproduto getTipoproduto() {
		return this.tipoproduto;
	}

	public void setTipoproduto(Tipoproduto tipoproduto) {
		this.tipoproduto = tipoproduto;
	}

	public List<Produtopronto> getProdutoprontos() {
		return this.produtoprontos;
	}

	public void setProdutoprontos(List<Produtopronto> produtoprontos) {
		this.produtoprontos = produtoprontos;
	}

	public Produtopronto addProdutopronto(Produtopronto produtopronto) {
		getProdutoprontos().add(produtopronto);
		produtopronto.setProduto(this);

		return produtopronto;
	}

	public Produtopronto removeProdutopronto(Produtopronto produtopronto) {
		getProdutoprontos().remove(produtopronto);
		produtopronto.setProduto(null);

		return produtopronto;
	}

}