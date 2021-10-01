package com.gen.lojagames.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gen.lojagames.model.ProdutoModel;

public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {
	
	public Optional<ProdutoModel> findAllById(Long id);
	
	public Optional<ProdutoModel> findAllByDescricaoTituloContainingIgnoreCase(String descricaoTitulo);
}
