package com.julia.evoluum.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CidadeResponse {
	@JsonProperty("id")
	private Long id;
	@JsonProperty("nome")
	private String nomeCidade;
	@JsonProperty("microrregiao")
	private MicrorregiaoResponse microrRegiao;

	public String getNomeCidade() {
		return nomeCidade;
	}

	public MicrorregiaoResponse getMicrorRegiao() {
		return microrRegiao;
	}

	public void setMicrorRegiao(MicrorregiaoResponse microrRegiao) {
		this.microrRegiao = microrRegiao;
	}


	public void setNomeCidade(String nomeCidade) {
		this.nomeCidade = nomeCidade;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	

}
