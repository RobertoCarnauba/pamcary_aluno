package com.pamcary.aluno.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pamcary.aluno.controller.dto.AlunoDto;
import com.pamcary.aluno.controller.dto.AtualizarAlunoForm;
import com.pamcary.aluno.controller.dto.AtualizarTopicoForm;
import com.pamcary.aluno.controller.dto.TopicoDto;
import com.pamcary.aluno.controller.form.AlunoForm;
import com.pamcary.aluno.model.Topico;
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
	//Cria
	@PostMapping
	public void cadastrar(@RequestBody AlunoForm form){
		Usuario usuario = form.converter(alunoRepository);
		alunoRepository.save(usuario);
	}
	
	//UpDate
	@PutMapping("/{id}")
	public  ResponseEntity<AlunoDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizarAlunoForm form){
		Optional<Usuario> optional = alunoRepository.findById(id);
		if(optional.isPresent()){
			Usuario usuario = form.atualizar(id, alunoRepository); 
			return ResponseEntity.ok(new AlunoDto(usuario));
		}
		return ResponseEntity.notFound().build();
		
	}
	
	// Removendo
	@DeleteMapping("/{id}")
	public ResponseEntity<?> remover(@PathVariable Long id) {
		Optional<Usuario> optional = alunoRepository.findById(id);
		if(optional.isPresent()){
			alunoRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}

}
