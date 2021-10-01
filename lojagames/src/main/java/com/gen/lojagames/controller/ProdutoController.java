package com.gen.lojagames.controller;
/*CategoriaController Com 5 endpoints:
1 - findAllCategoria = endPoint com a capacidade de trazer todas as categorias (testar o MÉTODO findAll através do POSTMAN);
2 - findByIDCategoria = endPoint com a função de trazer uma única categoria por id (testar o MÉTODO findByID via postman);
3 - findByDescricaoCategoria = endPoint com a função de trazer uma categoria turma por Descricao;
4 - postCategoria = endPoint com a função de gravar uma nova categoria no banco de dados (testar o MÉTODO post via postman);
5 - putCategoria = endPoint com a função de atualizar dados de uma categoria (testar o MÉTODO put no postman);
6 - deleteCategoria = endPoint com a função de apagar uma categoria do banco de dados (testar o MÉTODO delete no postman).*/



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

import com.gen.lojagames.model.ProdutoModel;
import com.gen.lojagames.repository.ProdutoRepository;

@RestController
@RequestMapping("/api/v1/produto")
@CrossOrigin("*")
public class ProdutoController {
	
	private @Autowired ProdutoRepository repositorio;

	@GetMapping
	public ResponseEntity<List<ProdutoModel>> findAllCategoria() {
		List<ProdutoModel> objetoLista = repositorio.findAll();
		if (objetoLista.isEmpty()) {
			return ResponseEntity.status(204).build();

		} else {
			return ResponseEntity.ok(objetoLista);
		}
		
	}
	
	@GetMapping("/{id}")
    public ResponseEntity<ProdutoModel> findAllById(@PathVariable Long id){
        return repositorio.findAllById(id).map(resp -> ResponseEntity.status(201).body(resp))
                .orElse(ResponseEntity.status(400).build());
    }
	
	@GetMapping("/procura/{nomeProduto}")
    public ResponseEntity<List<ProdutoModel>> findAllByNomeProduto(@PathVariable String descricaoTitulo){
		return ResponseEntity.ok(repositorio.findAllByDescricaoTituloContainingIgnoreCase(descricaoTitulo));
	}
	
	@PostMapping("/novo")
	public ResponseEntity<ProdutoModel> novoProduto(@Valid @RequestBody ProdutoModel novaProduto){
		return ResponseEntity.status(200).body(repositorio.save(novaProduto));
	}
	
	@PutMapping("/atualizar")
	public ResponseEntity<ProdutoModel> atualizarProduto(@Valid @RequestBody ProdutoModel atualizarProduto){
		return ResponseEntity.status(200).body(repositorio.save(atualizarProduto));
	}	
	
	

}
