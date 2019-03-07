package teste;

import java.sql.SQLException;

import br.usjt.web.alunos.dao.AlunosDAO;
import br.usjt.web.alunos.model.Aluno;

public class Teste {

	public static void main(String[] args) {
		Aluno aluno = new Aluno();
		aluno.setNome("Maria Joaquina");
		aluno.setRa(987654);
		aluno.setSituacao(true);
				
				
		AlunosDAO alunosDAO = new AlunosDAO();
		try {
			alunosDAO.consultarAluno("Maria");
		} catch (SQLException ex ) {
			ex.printStackTrace();
		}

	}
}
