package com.pamcary.aluno.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pamcary.aluno.controller.dto.AlunoDto;
import com.pamcary.aluno.controller.form.AlunoForm;
import com.pamcary.aluno.model.Usuario;
import com.pamcary.aluno.repository.AlunoRepository;

@RestController
@RequestMapping("/alunos")
public class UsuarioController {
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	@GetMapping
	public List<AlunoDto> lista(Long id){
		if(id == null){
			//Recuperar todos os alunos
			List<Usuario> usuarios = alunoRepository.findAll();
			return AlunoDto.converter(usuarios);
		} else {
			//Recuperar um aluno por id 
			List<Usuario> usuarios = alunoRepository.findAllById(id);
			return AlunoDto.converter(usuarios);
		}
	}
	
	@PostMapping
	public void cadastrar(@RequestBody AlunoForm form){
		Usuario usuario = form.converter(alunoRepository);
		alunoRepository.save(usuario);
	}

}
