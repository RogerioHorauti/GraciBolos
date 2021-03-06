package br.com.gracibolos.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.gracibolos.jdbc.connection.ConnectionProvider;
import br.com.gracibolos.jdbc.model.Colaborador;

@Repository
public class ColaboradorDao implements GenericoDao<Colaborador> {

	/*
	 * INCLUIR COLABORADOR
	 * 
	 * Este m�todo tem como principal objetivo receber os dados de um novo colaborador e persistir no banco de dados.
	 * 
	 * */
	
	@Override
	public boolean inserir(Colaborador colaborador) {
		
		boolean status = false;
		PreparedStatement ps = null;
		
		//string query do banco
		String sql = "INSERT INTO colaborador (status, nivel, usuario, senha, nome, cpf, rg, endereco, numero, complemento, bairro, cep, estado, cidade, tel, cel, email, obs) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		//chama uma inst�ncia da Connection e tenta realizar uma conex�o com o banco atrav�s do AutoCloseable
		try (Connection conn = ConnectionProvider.getInstance().getConnection()){
			
			//seta os atributos do objeto colaborador
			ps = conn.prepareStatement(sql);
			ps.setInt(1, colaborador.getStatus());
			ps.setInt(2, colaborador.getNivel());
			ps.setString(3, colaborador.getUsuario());
			ps.setString(4, colaborador.getSenha());
			ps.setString(5, colaborador.getNome());
			ps.setString(6, colaborador.getCpf());
			ps.setString(7, colaborador.getRg());
			ps.setString(8, colaborador.getEndereco());
			ps.setString(9, colaborador.getNumero());
			ps.setString(10, colaborador.getComplemento());
			ps.setString(11, colaborador.getBairro());
			ps.setString(12, colaborador.getCep());
			ps.setInt(13, colaborador.getEstado());
			ps.setInt(14, colaborador.getCidade());
			ps.setString(15, colaborador.getTel());
			ps.setString(16, colaborador.getCel());
			ps.setString(17, colaborador.getEmail());
			ps.setString(18, colaborador.getObs());
			
			if(ps.executeUpdate() != 0) {
				status = true;
				
			}
			
			//fecha as conex�es
			ps.close();
			conn.close();
			
		} 
		//trata, caso de uma exce��o
		catch (Exception e) {
			System.out.println("Houve um erro ao inserir o colaborador");
		}
		//retorna true ou false, dizendo se o metodo foi executado com sucesso.
		return status;
	}
	
	/*
	 * ALTERAR COLABORADOR
	 * 
	 * Este m�todo tem como principal objetivo receber os dados de um determinado colaborador e alterar os dados do banco de dados.
	 * 
	 * */

	@Override
	public boolean alterar(Colaborador colaborador) {
		
		boolean status = false;
		PreparedStatement ps = null;
		
		//string query do banco
		String sql = "UPDATE colaborador SET status = ?, nivel = ?, usuario = ?, senha = ?, nome = ?, cpf = ?, rg = ?, endereco = ?, numero = ?, complemento = ?, bairro = ?, cep = ?, estado = ?, cidade = ?, tel = ?, cel = ?, email = ?, obs = ? WHERE id = ?";
		
		//chama uma inst�ncia da Connection e tenta realizar uma conex�o com o banco atrav�s do AutoCloseable
		try (Connection conn = ConnectionProvider.getInstance().getConnection()){
			
			//seta os atributos do objeto colaborador, fazendo a altera��o.
			ps = conn.prepareStatement(sql);			
			ps.setInt(1, colaborador.getStatus());
			ps.setInt(2, colaborador.getNivel());
			ps.setString(3, colaborador.getUsuario());
			ps.setString(4, colaborador.getSenha());
			ps.setString(5, colaborador.getNome());
			ps.setString(6, colaborador.getCpf());
			ps.setString(7, colaborador.getRg());
			ps.setString(8, colaborador.getEndereco());
			ps.setString(9, colaborador.getNumero());
			ps.setString(10, colaborador.getComplemento());
			ps.setString(11, colaborador.getBairro());
			ps.setString(12, colaborador.getCep());
			ps.setInt(13, colaborador.getEstado());
			ps.setInt(14, colaborador.getCidade());
			ps.setString(15, colaborador.getTel());
			ps.setString(16, colaborador.getCel());
			ps.setString(17, colaborador.getEmail());
			ps.setString(18, colaborador.getObs());
			ps.setLong(19, colaborador.getId());
			
			if(ps.executeUpdate() != 0) {
				status = true;
			}
			
			//fecha as conex�es
			ps.close();
			conn.close();
			
		} 
		//trata, caso de uma exce��o
		catch (Exception e) {
			System.out.println("Houve um erro ao alterar o colaborador");
		}
		//retorna true ou false, dizendo se o metodo foi executado com sucesso.
		return status;
	}
	
	/*
	 * EXCLUIR COLABORADOR
	 * 
	 * Este m�todo tem como principal objetivo receber os dados de um determinado colaborador e excluir do banco de dados.
	 * 
	 * */

	@Override
	public boolean excluir(Colaborador colaborador) {
		
		boolean status = false;
		PreparedStatement ps = null;

		//string query do banco
		String sql = "DELETE FROM colaborador WHERE id = ?";
	
		//chama uma inst�ncia da Connection e tenta realizar uma conex�o com o banco atrav�s do AutoCloseable
		try (Connection conn = ConnectionProvider.getInstance().getConnection()){
			
			//seta o id do caixa, e excluir o objeto
			ps = conn.prepareStatement(sql);
			ps.setLong(1, colaborador.getId());
			
			if(ps.executeUpdate() != 0) {
				status = true;
			}
			
			//fecha as conex�es
			ps.close();
			conn.close();
	
		} 
		//trata, caso de uma exce��o
		catch (Exception e) {
			System.out.println("Houve um erro ao tentar deletar o colaborador");
		}
		//retorna true ou false, dizendo se o metodo foi executado com sucesso.
		return status;
	}
	
	/*
	 * LISTAR COLABORADORES
	 * 
	 * Este m�todo tem como principal objetivo realizar uma consulta ao banco e retornar todos os dados dos colaboradores.
	 * 
	 * */

	@Override
	public List<Colaborador> listar() {
		
		List<Colaborador> colaboradores = new ArrayList<Colaborador>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		//string query do banco
		String sql = "SELECT id, status, nivel, usuario, senha, nome, cpf, rg, endereco, numero, complemento, bairro, cep, estado, cidade, tel, cel, email, obs FROM colaborador";
		
		//chama uma inst�ncia da Connection e tenta realizar uma conex�o com o banco atrav�s do AutoCloseable
		try(Connection conn = ConnectionProvider.getInstance().getConnection()) {
						
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()){
				
				//da um get nos atributos do objeto colaborador
				Colaborador colaborador = new Colaborador();
				colaborador.setId(rs.getLong("id"));
				colaborador.setStatus(rs.getInt("status"));
				colaborador.setNivel(rs.getInt("nivel"));
				colaborador.setUsuario(rs.getString("usuario"));
				colaborador.setSenha(rs.getString("senha"));
				colaborador.setNome(rs.getString("nome"));
				colaborador.setCpf(rs.getString("cpf"));
				colaborador.setRg(rs.getString("rg"));
				colaborador.setEndereco(rs.getString("endereco"));
				colaborador.setNumero(rs.getString("numero"));
				colaborador.setComplemento(rs.getString("complemento"));
				colaborador.setBairro(rs.getString("bairro"));
				colaborador.setCep(rs.getString("cep"));
				colaborador.setEstado(rs.getInt("estado"));
				colaborador.setCidade(rs.getInt("cidade"));
				colaborador.setTel(rs.getString("tel"));
				colaborador.setCel(rs.getString("cel"));
				colaborador.setEmail(rs.getString("email"));
				colaborador.setObs(rs.getString("obs"));
				
				//adiciona o objeto colaborador no arrayList
				colaboradores.add(colaborador);
			}
			
			//fecha as conex�es
			ps.close();
			rs.close();
			conn.close();
					
		} 
		//trata, caso de uma exce��o
		catch (Exception e) {
			System.out.println("Houve um erro ao listar os colaboradores");
		}
		//retorna o array
		return colaboradores;
	}

	/*
	 * PESQUISAR COLABORADORES
	 * 
	 * Este m�todo tem como principal objetivo realizar uma consulta ao banco e retornar os dados dos colaboradores pesquisados.
	 * 
	 * */
	
	@Override
	public List<Colaborador> pesquisar(String pesquisa) {
		
		List<Colaborador> colaboradores = new ArrayList<Colaborador>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		//string query do banco
		String sql = "SELECT id, status, nivel, usuario, senha, nome, cpf, rg, endereco, numero, complemento, bairro, cep, estado, cidade, tel, cel, email, obs FROM colaborador WHERE cpf = ? OR nome LIKE ? OR rg = ?";
		
		//chama uma inst�ncia da Connection e tenta realizar uma conex�o com o banco atrav�s do AutoCloseable
		try(Connection conn = ConnectionProvider.getInstance().getConnection()) {
			
			//seta a string para fazer a busca
			ps = conn.prepareStatement(sql);
			ps.setString(1, pesquisa);
			ps.setString(2, "%"+pesquisa+"%");
			ps.setString(3, pesquisa);
			
			rs = ps.executeQuery();
			
			while(rs.next()){
				
				//da um get nos atributos do objeto colaborador		
				Colaborador colaborador = new Colaborador();
				colaborador.setId(rs.getLong("id"));
				colaborador.setStatus(rs.getInt("status"));
				colaborador.setNivel(rs.getInt("nivel"));
				colaborador.setUsuario(rs.getString("usuario"));
				colaborador.setSenha(rs.getString("senha"));
				colaborador.setNome(rs.getString("nome"));
				colaborador.setCpf(rs.getString("cpf"));
				colaborador.setRg(rs.getString("rg"));
				colaborador.setEndereco(rs.getString("endereco"));
				colaborador.setNumero(rs.getString("numero"));
				colaborador.setComplemento(rs.getString("complemento"));
				colaborador.setBairro(rs.getString("bairro"));
				colaborador.setCep(rs.getString("cep"));
				colaborador.setEstado(rs.getInt("estado"));
				colaborador.setCidade(rs.getInt("cidade"));
				colaborador.setTel(rs.getString("tel"));
				colaborador.setCel(rs.getString("cel"));
				colaborador.setEmail(rs.getString("email"));
				colaborador.setObs(rs.getString("obs"));
				
				//adiciona o objeto colaborador no arrayList
				colaboradores.add(colaborador);
			}
			
			//fecha as conex�es
			ps.close();
			rs.close();
			conn.close();
					
		} 
		//trata, caso de uma exce��o
		catch (Exception e) {
			System.out.println("Houve um erro ao pesquisar o colaborador");
		}
		//retorna o array
		return colaboradores;
	}
	
}