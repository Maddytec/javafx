package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import tabela.PessoaTabela;

@Entity
public class Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;

	public Pessoa(PessoaTabela pessoaTabela) {
		setId(pessoaTabela.getId());
		setNome(pessoaTabela.getNome());
		setIdade(pessoaTabela.getIdade()) ;
	}
	

	public Pessoa() {
		
	}


	@Id
	private int id;

	@Column(name = "nome", nullable = false)
	private String nome;

	@Column(name = "idade", nullable = false)
	private int idade;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + idade;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (id != other.id)
			return false;
		if (idade != other.idade)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
}
