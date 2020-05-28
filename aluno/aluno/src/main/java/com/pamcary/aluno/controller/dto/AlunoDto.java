package com.pamcary.aluno.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.pamcary.aluno.model.Usuario;

public class AlunoDto {
	

	private Long id;
	private String nome;
	private int idade;
	
	public AlunoDto(Usuario usuario){
		this.id = usuario.getId();
		this.nome = usuario.getNome();
		this.idade = usuario.getIdade();
	}
	
	public Long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}

	public static List<AlunoDto> converter(List<Usuario> usuarios) {
		
		return usuarios.stream().map(AlunoDto::new).collect(Collectors.toList());
	}

}
