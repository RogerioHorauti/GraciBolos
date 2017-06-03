package br.com.gracibolos.jpa.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the materiaprima database table.
 * 
 */
@Entity
@NamedQuery(name="Materiaprima.findAll", query="SELECT m FROM Materiaprima m")
public class Materiaprima implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String codigo;

	@Lob
	private String descricao;

	private BigDecimal estoque;

	@Temporal(TemporalType.DATE)
	private Date fabricacao;

	private String nome;

	private int unidade;

	@Temporal(TemporalType.DATE)
	private Date vencimento;

	//bi-directional many-to-one association to Estoque
	@OneToMany(mappedBy="materiaprima")
	private List<Estoque> estoques;

	//bi-directional many-to-one association to Itemreceita
	@OneToMany(mappedBy="materiaprima")
	private List<Itemreceita> itemreceitas;

	public Materiaprima() {
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

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getEstoque() {
		return this.estoque;
	}

	public void setEstoque(BigDecimal estoque) {
		this.estoque = estoque;
	}

	public Date getFabricacao() {
		return this.fabricacao;
	}

	public void setFabricacao(Date fabricacao) {
		this.fabricacao = fabricacao;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getUnidade() {
		return this.unidade;
	}

	public void setUnidade(int unidade) {
		this.unidade = unidade;
	}

	public Date getVencimento() {
		return this.vencimento;
	}

	public void setVencimento(Date vencimento) {
		this.vencimento = vencimento;
	}

	public List<Estoque> getEstoques() {
		return this.estoques;
	}

	public void setEstoques(List<Estoque> estoques) {
		this.estoques = estoques;
	}

	public Estoque addEstoque(Estoque estoque) {
		getEstoques().add(estoque);
		estoque.setMateriaprima(this);

		return estoque;
	}

	public Estoque removeEstoque(Estoque estoque) {
		getEstoques().remove(estoque);
		estoque.setMateriaprima(null);

		return estoque;
	}

	public List<Itemreceita> getItemreceitas() {
		return this.itemreceitas;
	}

	public void setItemreceitas(List<Itemreceita> itemreceitas) {
		this.itemreceitas = itemreceitas;
	}

	public Itemreceita addItemreceita(Itemreceita itemreceita) {
		getItemreceitas().add(itemreceita);
		itemreceita.setMateriaprima(this);

		return itemreceita;
	}

	public Itemreceita removeItemreceita(Itemreceita itemreceita) {
		getItemreceitas().remove(itemreceita);
		itemreceita.setMateriaprima(null);

		return itemreceita;
	}

}