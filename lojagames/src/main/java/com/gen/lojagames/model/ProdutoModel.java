package com.gen.lojagames.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "tb_produto")
public class ProdutoModel {
	
	@Id
	public @GeneratedValue(strategy = GenerationType.IDENTITY) Long id; 
	
	@NotBlank
	public String descricaoTitulo;
	
}
