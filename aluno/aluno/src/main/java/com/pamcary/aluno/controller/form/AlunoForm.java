package com.pamcary.aluno.controller.form;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.springframework.lang.NonNull;

import com.pamcary.aluno.model.Usuario;
import com.pamcary.aluno.repository.AlunoRepository;

public class AlunoForm {

	private String nome;
	private int idade;
	private String email;
	private String senha;

	@NonNull @NotEmpty
	public String getNome() {
		return nome;
	}
	@NonNull @NotEmpty
	public int getIdade() {
		return idade;
	}
	public String getEmail() {
		return email;
	}
	public String getSenha() {
		return senha;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	

	public Usuario converter(AlunoRepository alunoRepository) {
		Usuario usuario = alunoRepository.findByNome(nome);
		return new Usuario(nome,idade,email,senha);
	}
	
}
