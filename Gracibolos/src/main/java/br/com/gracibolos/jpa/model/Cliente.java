package br.com.gracibolos.jpa.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the cliente database table.
 * 
 */
@Entity
@NamedQuery(name="Cliente.findAll", query="SELECT c FROM Cliente c")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String bairro;

	private String cel;

	private String cep;

	private int cidade;

	@Temporal(TemporalType.DATE)
	private Date clientedesde;

	private String complemento;

	private String cpfcnpj;

	@Temporal(TemporalType.DATE)
	private Date datanascimento;

	private String email;

	private String endereco;

	private int estado;

	private String nomerazao;

	private String numero;

	@Lob
	private String obs;

	private String rgie;

	private int sexo;

	private String site;

	private int status;

	private String tel;

	private int tipopessoa;

	//bi-directional many-to-one association to Encomenda
	@OneToMany(mappedBy="clienteBean")
	private List<Encomenda> encomendas;

	public Cliente() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBairro() {
		return this.bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCel() {
		return this.cel;
	}

	public void setCel(String cel) {
		this.cel = cel;
	}

	public String getCep() {
		return this.cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public int getCidade() {
		return this.cidade;
	}

	public void setCidade(int cidade) {
		this.cidade = cidade;
	}

	public Date getClientedesde() {
		return this.clientedesde;
	}

	public void setClientedesde(Date clientedesde) {
		this.clientedesde = clientedesde;
	}

	public String getComplemento() {
		return this.complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCpfcnpj() {
		return this.cpfcnpj;
	}

	public void setCpfcnpj(String cpfcnpj) {
		this.cpfcnpj = cpfcnpj;
	}

	public Date getDatanascimento() {
		return this.datanascimento;
	}

	public void setDatanascimento(Date datanascimento) {
		this.datanascimento = datanascimento;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return this.endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getEstado() {
		return this.estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public String getNomerazao() {
		return this.nomerazao;
	}

	public void setNomerazao(String nomerazao) {
		this.nomerazao = nomerazao;
	}

	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getObs() {
		return this.obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public String getRgie() {
		return this.rgie;
	}

	public void setRgie(String rgie) {
		this.rgie = rgie;
	}

	public int getSexo() {
		return this.sexo;
	}

	public void setSexo(int sexo) {
		this.sexo = sexo;
	}

	public String getSite() {
		return this.site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public int getTipopessoa() {
		return this.tipopessoa;
	}

	public void setTipopessoa(int tipopessoa) {
		this.tipopessoa = tipopessoa;
	}

	public List<Encomenda> getEncomendas() {
		return this.encomendas;
	}

	public void setEncomendas(List<Encomenda> encomendas) {
		this.encomendas = encomendas;
	}

	public Encomenda addEncomenda(Encomenda encomenda) {
		getEncomendas().add(encomenda);
		encomenda.setClienteBean(this);

		return encomenda;
	}

	public Encomenda removeEncomenda(Encomenda encomenda) {
		getEncomendas().remove(encomenda);
		encomenda.setClienteBean(null);

		return encomenda;
	}

}