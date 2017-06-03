package br.com.gracibolos.jpa.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the medida database table.
 * 
 */
@Entity
@NamedQuery(name="Medida.findAll", query="SELECT m FROM Medida m")
public class Medida implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private BigDecimal gramas;

	private String ingrediente;

	private BigDecimal litros;

	private String medida;

	//bi-directional many-to-one association to Estoque
	@OneToMany(mappedBy="medida")
	private List<Estoque> estoques;

	//bi-directional many-to-one association to Itemreceita
	@OneToMany(mappedBy="medida")
	private List<Itemreceita> itemreceitas;

	public Medida() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigDecimal getGramas() {
		return this.gramas;
	}

	public void setGramas(BigDecimal gramas) {
		this.gramas = gramas;
	}

	public String getIngrediente() {
		return this.ingrediente;
	}

	public void setIngrediente(String ingrediente) {
		this.ingrediente = ingrediente;
	}

	public BigDecimal getLitros() {
		return this.litros;
	}

	public void setLitros(BigDecimal litros) {
		this.litros = litros;
	}

	public String getMedida() {
		return this.medida;
	}

	public void setMedida(String medida) {
		this.medida = medida;
	}

	public List<Estoque> getEstoques() {
		return this.estoques;
	}

	public void setEstoques(List<Estoque> estoques) {
		this.estoques = estoques;
	}

	public Estoque addEstoque(Estoque estoque) {
		getEstoques().add(estoque);
		estoque.setMedida(this);

		return estoque;
	}

	public Estoque removeEstoque(Estoque estoque) {
		getEstoques().remove(estoque);
		estoque.setMedida(null);

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
		itemreceita.setMedida(this);

		return itemreceita;
	}

	public Itemreceita removeItemreceita(Itemreceita itemreceita) {
		getItemreceitas().remove(itemreceita);
		itemreceita.setMedida(null);

		return itemreceita;
	}

}