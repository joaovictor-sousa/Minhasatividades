package br.usjt.web.alunos.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.usjt.web.alunos.model.Aluno;


public class AlunosDAO {

	Connection conexao;

	public AlunosDAO() {
		try {
			this.conexao = ConnectionFactory.getConnection();
		} catch (ClassNotFoundException c) {
			System.out.println("Driver não encontrado");
		} catch (SQLException e) {
			System.out.println("Não foi possível conectar-se ao banco de dados");
			e.printStackTrace();
		}
		
	}

	public void inserirAluno(Aluno aluno) throws SQLException {

		String sql = "INSERT INTO alunos (nome, ra, situacao) VALUES (?,?,?)";
		PreparedStatement ps = this.conexao.prepareStatement(sql);
		ps.setString(1, aluno.getNome());
		ps.setInt(2, aluno.getRa());
		ps.setBoolean(3, aluno.isSituacao());
		ps.execute();
		ps.close();
	}

	public void excluirAluno(int ra) throws SQLException {

		String sql = "DELETE FROM alunos where ra = ?";
		PreparedStatement ps = this.conexao.prepareStatement(sql);
		ps.setInt(1, ra);
		ps.execute();
		ps.close();
	}
	
	public void atualizarAluno(Aluno aluno) throws SQLException {
		String sql = "UPDATE alunos SET nome = ?, situacao = ? where ra = ?";
		PreparedStatement ps = this.conexao.prepareStatement(sql);
		ps.setString(1, aluno.getNome());
		ps.setBoolean(2, aluno.isSituacao());
		ps.setInt(3, aluno.getRa());
		ps.execute();
		ps.close();
	}
	
	public Aluno consultarAluno(int ra) throws SQLException {
		String sql = "SELECT * from alunos WHERE ra = ?";
		PreparedStatement ps = this.conexao.prepareStatement(sql);
		ps.setInt(1, ra);
		ResultSet resultado = ps.executeQuery(); //Retorna os valores
		
		if (resultado.next()) { //Caso exista resultado da query
			Aluno aluno = new Aluno();
			aluno.setNome(resultado.getString("nome"));
			aluno.setRa(resultado.getInt("ra"));
			aluno.setSituacao(resultado.getBoolean("situacao"));
			ps.close();
			return aluno;
		} else {
			ps.close();
			return null;
		}
		
		
	}
	
	public ArrayList<Aluno> consultarAluno(String nome) throws SQLException{
		String sql = "SELECT * FROM alunos WHERE nome LIKE ?";
		PreparedStatement ps = this.conexao.prepareStatement(sql);
		ps.setString(1, "%" + nome + "%");
		ResultSet resultado = ps.executeQuery();
		
		ArrayList<Aluno> listaDeAlunos = new ArrayList<>();
		while (resultado.next()) {
			Aluno aluno = new Aluno();
			aluno.setNome(resultado.getString("nome"));
			aluno.setRa(resultado.getInt("ra"));
			aluno.setSituacao(resultado.getBoolean("situacao"));
			listaDeAlunos.add(aluno);
			System.out.println(aluno.getNome());
		}
		ps.close();
		return listaDeAlunos;
		
	}
	
	public ArrayList<Aluno> consultarAlunos() throws SQLException{
		String sql = "SELECT * FROM alunos";
		PreparedStatement ps = this.conexao.prepareStatement(sql);
		ResultSet resultado = ps.executeQuery();
		
		ArrayList<Aluno> listaDeAlunos = new ArrayList<>();
		while (resultado.next()) {
			Aluno aluno = new Aluno();
			aluno.setNome(resultado.getString("nome"));
			aluno.setRa(resultado.getInt("ra"));
			aluno.setSituacao(resultado.getBoolean("situacao"));
			listaDeAlunos.add(aluno);
		}
		ps.close();
		return listaDeAlunos;
		
	}

}
