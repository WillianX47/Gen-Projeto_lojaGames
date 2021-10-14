package com.gen.lojagames.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_produto")
public class ProdutoModel {

	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;

	private @NotBlank String descricaoTitulo;

	@ManyToOne
	@JoinColumn(name = "categoria_id")
	@JsonIgnoreProperties({ "categoriaProduto" })
	private CategoriaModel categoriaRelacionada;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricaoTitulo() {
		return descricaoTitulo;
	}

	public void setDescricaoTitulo(String descricaoTitulo) {
		this.descricaoTitulo = descricaoTitulo;

	}

	public CategoriaModel getCategoriaRelacionada() {
		return categoriaRelacionada;
	}

	public void setCategoriaRelacionada(CategoriaModel categoriaRelacionada) {
		this.categoriaRelacionada = categoriaRelacionada;
	}

}
