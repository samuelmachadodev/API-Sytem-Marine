package com.system_marine.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import com.system_marine.barcos.Barco;
import com.system_marine.barcos.BarcoRepository;
import com.system_marine.barcos.DadosAtualizarBarco;
import com.system_marine.barcos.DadosCadastroBarco;
import com.system_marine.barcos.DadosDetalhamentoBarco;
import com.system_marine.barcos.DadosListagemBarco;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@CrossOrigin("*")
@RequestMapping("/barcos")
public class BarcosController {
	
	@Autowired
	private BarcoRepository repository;
	
	@PostMapping
	@Transactional
	public ResponseEntity<DadosDetalhamentoBarco> cadastrar(@RequestBody @Valid DadosCadastroBarco dados, UriComponentsBuilder uriBuilder) {
		var barco = new Barco(dados);
		repository.save(barco);
		
		var uri = uriBuilder.path("/barcos/{id}").buildAndExpand(barco.getId()).toUri();
		
		return ResponseEntity.created(uri).body(new DadosDetalhamentoBarco(barco));
	}
	
	@GetMapping
	public ResponseEntity<List<DadosListagemBarco>> listar () {
		var lista = repository.findAllByAtivoTrue().stream().map(DadosListagemBarco::new).toList();
		
		return ResponseEntity.ok(lista);
		
	}
	
	@PutMapping 
	@Transactional
	public ResponseEntity<DadosDetalhamentoBarco> atualizar(@RequestBody @Valid DadosAtualizarBarco dados) {
		var barco = repository.getReferenceById(dados.id());
		
		barco.atualizarInformações(dados);
		
		return ResponseEntity.ok(new DadosDetalhamentoBarco(barco));
		
	}
	
	@DeleteMapping("/{id}") 
	@Transactional
	public ResponseEntity<Void> excluir (@PathVariable Long id) {
		repository.deleteById(id);
		
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping ("inativar/{id}")
	@Transactional
	public ResponseEntity<Void> inativar (@PathVariable Long id) {
		var barco = repository.getReferenceById(id);
		barco.inativar();
		
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping ("ativar/{id}")
	@Transactional
	public ResponseEntity<Void> ativar (@PathVariable Long id) {
		var barco = repository.getReferenceById(id);
	    barco.ativar();
	    
	    return ResponseEntity.noContent().build();

	}
	
	@GetMapping  ("/{id}") 
	public ResponseEntity<DadosDetalhamentoBarco> detalhar(@PathVariable Long id) {
		var barco = repository.getReferenceById(id);
		return ResponseEntity.ok(new DadosDetalhamentoBarco(barco));
	}
	
	
	
	
	
	
	

}
