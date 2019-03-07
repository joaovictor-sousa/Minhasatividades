/*package br.usjt.web.alunos.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.SQLException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.usjt.web.alunos.model.Aluno;

public class AlunosDAOTest {
	
	  AlunosDAO alunosDAO;
		@BeforeAll
		static void setUpBeforeClass() throws Exception {
		}

		@AfterAll
		static void tearDownAfterClass() throws Exception {
		}

		@BeforeEach
		void setUp() throws Exception {
			alunosDAO = new AlunosDAO(); //Inicializa para não ter problema de lixo.
		}

		@Test
		void testarInsercao() {
			Aluno a = new Aluno();
			a.setNome("Jose");
			a.setRa(123456);
			a.setSituacao(false);
			
			try {
			alunosDAO.inserirAluno(a);
			Aluno b = alunosDAO.consultarAluno(123456);
			
			assertEquals(a,b);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

} */
