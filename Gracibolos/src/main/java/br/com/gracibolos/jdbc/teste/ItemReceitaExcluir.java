package br.com.gracibolos.jdbc.teste;

//funcionando
import br.com.gracibolos.jdbc.dao.ItemReceitaDao;
import br.com.gracibolos.jdbc.model.ItemReceita;

public class ItemReceitaExcluir {

	public static void main(String[] args) {
		
		ItemReceita receita = new ItemReceita();		
		receita.setId(2L);
		
		ItemReceitaDao dao = new ItemReceitaDao();
		
		try {
			if(dao.excluir(receita) == true){
				System.out.println("Excluido com sucesso!");
			}else{
				System.out.println("Erro ao Excluir item da receita");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
