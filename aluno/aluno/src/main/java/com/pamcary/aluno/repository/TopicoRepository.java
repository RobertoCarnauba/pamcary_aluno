package com.pamcary.aluno.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pamcary.aluno.model.Topico;

public interface TopicoRepository extends JpaRepository<Topico, Long> {

	List<Topico> findByCursoNome(String nomeCurso);

}
