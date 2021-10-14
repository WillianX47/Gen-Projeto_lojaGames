package com.gen.lojagames.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gen.lojagames.model.CategoriaModel;

public interface CategoriaRepository extends JpaRepository<CategoriaModel, Long> {

	public Optional<CategoriaModel> findAllById(Long id);
	
	public List<CategoriaModel> findByNomeCategoriaContainingIgnoreCase(String nomeCategoria);
	
}