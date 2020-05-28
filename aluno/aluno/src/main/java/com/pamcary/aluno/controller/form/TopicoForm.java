package com.pamcary.aluno.controller.form;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.springframework.lang.NonNull;

import com.pamcary.aluno.model.Curso;
import com.pamcary.aluno.model.Topico;
import com.pamcary.aluno.repository.CursoRepository;

public class TopicoForm {

	
	private String titulo;
	private String mensagem;
	private String nomeCurso;
	
	@NonNull @NotEmpty @Length(min = 5)
	public String getTitulo() {
		return titulo;
	}
	@NonNull @NotEmpty @Length(min = 10)
	public String getMensagem() {
		return mensagem;
	}
	@NonNull @NotEmpty
	public String getNomeCurso() {
		return nomeCurso;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}
	public Topico converter(CursoRepository cursoRepository ) {
		Curso curso = cursoRepository.findByNome(nomeCurso);
		return new Topico(titulo,mensagem,curso);
	}
	
}
