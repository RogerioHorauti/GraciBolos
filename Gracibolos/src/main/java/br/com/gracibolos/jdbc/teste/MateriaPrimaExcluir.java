package br.com.gracibolos.jdbc.teste;

//funcionando
import br.com.gracibolos.jdbc.dao.MateriaPrimaDao;
import br.com.gracibolos.jdbc.model.MateriaPrima;

public class MateriaPrimaExcluir {

	public static void main(String[] args) {

		MateriaPrima mp = new MateriaPrima();
		
		mp.setId(2L);
		
		MateriaPrimaDao dao = new MateriaPrimaDao();
		
		try {
			if(dao.excluir(mp) == true){
				System.out.println("Excluido com sucesso!");
			}else{
				System.out.println("Erro ao excluir materia prima");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
