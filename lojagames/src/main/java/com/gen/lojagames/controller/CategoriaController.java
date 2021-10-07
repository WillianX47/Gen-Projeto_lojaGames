package com.gen.lojagames.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gen.lojagames.model.CategoriaModel;
import com.gen.lojagames.repository.CategoriaRepository;

@RestController
@RequestMapping("/api/v1/categoria")
@CrossOrigin("*")
public class CategoriaController {

	private @Autowired CategoriaRepository repositorio;

	@GetMapping
	public ResponseEntity<List<CategoriaModel>> findAllCategoria() {
		List<CategoriaModel> objetoLista = repositorio.findAll();
		if (objetoLista.isEmpty()) {
			return ResponseEntity.status(204).build();

		} else {
			return ResponseEntity.ok(objetoLista);
		}

	}

	@GetMapping("/{id}")
	public ResponseEntity<CategoriaModel> findAllById(@PathVariable Long id) {
		return repositorio.findAllById(id).map(resp -> ResponseEntity.status(201).body(resp))
				.orElse(ResponseEntity.status(400).build());
	}

	@GetMapping("/procura/{nomeCategoria}")
	public ResponseEntity<List<CategoriaModel>> findAllByNomeCategoria(@PathVariable String nomeCategoria) {
		return ResponseEntity.ok(repositorio.findByNomeCategoriaContainingIgnoreCase(nomeCategoria));
	}

	@PostMapping("/nova")
	public ResponseEntity<CategoriaModel> novaCategoria(@Valid @RequestBody CategoriaModel novaCategoria) {
		return ResponseEntity.status(200).body(repositorio.save(novaCategoria));
	}

	@PutMapping("/atualizar")
	public ResponseEntity<CategoriaModel> atualizarCategoria(@Valid @RequestBody CategoriaModel atualizarCategoria) {
		return ResponseEntity.status(200).body(repositorio.save(atualizarCategoria));
	}

	/*
	 * CategoriaController Com 5 endpoints: 1 - findAllCategoria = endPoint com a
	 * capacidade de trazer todas as categorias (testar o MÉTODO findAll através do
	 * POSTMAN); 2 - findByIDCategoria = endPoint com a função de trazer uma única
	 * categoria por id (testar o MÉTODO findByID via postman); 3 -
	 * findByDescricaoCategoria = endPoint com a função de trazer uma categoria
	 * turma por Descricao; 4 - postCategoria = endPoint com a função de gravar uma
	 * nova categoria no banco de dados (testar o MÉTODO post via postman); 5 -
	 * putCategoria = endPoint com a função de atualizar dados de uma categoria
	 * (testar o MÉTODO put no postman); 6 - deleteCategoria = endPoint com a função
	 * de apagar uma categoria do banco de dados (testar o MÉTODO delete no
	 * postman).
	 */

}