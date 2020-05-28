package com.pamcary.aluno.controller.dto;

import com.pamcary.aluno.model.Usuario;
import com.pamcary.aluno.repository.AlunoRepository;

public class AtualizarAlunoForm {
	
	private String nome;
	private String idade;
	

	public String getIdade() {
		return idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}




	public Usuario atualizar(Long id, AlunoRepository alunoRepository) {
		Usuario usuario = alunoRepository.getOne(id);
		usuario.setNome(nome);
		usuario.setEmail(idade);
		return usuario;
	}

}
