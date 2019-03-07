package br.usjt.web.alunos.model;

public class Aluno {

	private String nome;
	private int ra;
	private boolean situacao;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getRa() {
		return ra;
	}
	
	public void setRa(int ra) {
		this.ra = ra;
	}
	
	public boolean isSituacao() {
		return situacao;
	}
	
	public void setSituacao(boolean situacao) {
		this.situacao = situacao;
	}
	
	@Override
	public boolean equals(Object obj) {
		Aluno aluno = (Aluno) obj; //Coersão explícita no Java
		
		if (!aluno.getNome().equals(this.getNome())) {
			return false;
		}
		if (aluno.getRa() != this.getRa()) {
			return false;
		}
		if (aluno.isSituacao() != this.isSituacao()) {
			return false;
		}
		return true;
	}
	
}
