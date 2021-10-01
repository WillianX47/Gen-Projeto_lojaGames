package com.gen.lojagames.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gen.lojagames.model.ProdutoModel;

public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {
	
	public Optional<ProdutoModel> findAllById(Long id);
	
	public List<ProdutoModel> findAllByDescricaoTituloContainingIgnoreCase(String descricaoTitulo);
}
