package com.pamcary.aluno.controller.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.pamcary.aluno.model.Topico;

public class TopicoDto {
	
	private Long id;
	private String titulo;
	private String messagem;
	private LocalDateTime dataCriacao;
	
	//Esse será o retorno das informações do topico
	public TopicoDto(Topico topico) {
		this.id = topico.getId();
		this.titulo = topico.getTitulo();
		this.messagem = topico.getMensagem();
		this.dataCriacao = topico.getDataCriacao();
	}


	public Long getId() {
		return id;
	}
	public String getTitulo() {
		return titulo;
	}
	public String getMessagem() {
		return messagem;
	}
	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}
	//Cria a lista de topicos
	public static List<TopicoDto> converter(List<Topico> topicos) {
		return topicos.stream().map(TopicoDto::new).collect(Collectors.toList());
	}

}
