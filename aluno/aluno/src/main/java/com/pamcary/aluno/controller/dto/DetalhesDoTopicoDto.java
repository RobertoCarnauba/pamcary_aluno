package com.pamcary.aluno.controller.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.pamcary.aluno.model.StatusTopico;
import com.pamcary.aluno.model.Topico;

public class DetalhesDoTopicoDto {

	private Long id;
	private String titulo;
	private String messagem;
	private LocalDateTime dataCriacao;
	private String nomeAutor;
	private StatusTopico status;
	private List<RespostaDto> resposta;
	
	public DetalhesDoTopicoDto(Topico topico){
		this.id = topico.getId();
		this.titulo  = topico.getTitulo();
		this.messagem = topico.getMensagem();
		this.dataCriacao = topico.getDataCriacao();
		this.nomeAutor = topico.getAutor().getNome();
		this.status = topico.getStatus();
		this.resposta = new ArrayList<>();
		this.resposta.addAll(topico.getRespostas().stream().map(RespostaDto::new).collect(Collectors.toList()));
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

	public String getNomeAutor() {
		return nomeAutor;
	}

	public StatusTopico getStatus() {
		return status;
	}

	public List<RespostaDto> getResposta() {
		return resposta;
	}
	
	
	
}
