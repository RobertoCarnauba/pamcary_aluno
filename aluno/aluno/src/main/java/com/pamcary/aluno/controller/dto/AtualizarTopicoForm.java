package com.pamcary.aluno.controller.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.pamcary.aluno.model.Topico;
import com.pamcary.aluno.repository.TopicoRepository;

public class AtualizarTopicoForm {

	@NotNull @NotEmpty 
	private String titulo;
	@NotNull @NotEmpty 
	private String mensagem;
	
	
	public String getTitulo() {
		return titulo;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	public Topico atualizar(Long id, TopicoRepository topicoRepository) {
		System.out.println("Chegamosa qui");
		Topico topico = topicoRepository.getOne(id);
		topico.setTitulo(titulo);
		topico.setMensagem(mensagem);
		return topico;
	}
	
	
	

	

}
