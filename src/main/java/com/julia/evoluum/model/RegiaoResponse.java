package com.julia.evoluum.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RegiaoResponse {

	private Long idRegiao;
	private String siglaRegiao;
	@JsonProperty("nome")
	private String regiaoNome;

	public Long getIdRegiao() {
		return idRegiao;
	}

	public void setIdRegiao(Long idRegiao) {
		this.idRegiao = idRegiao;
	}

	public String getSiglaRegiao() {
		return siglaRegiao;
	}

	public void setSiglaRegiao(String siglaRegiao) {
		this.siglaRegiao = siglaRegiao;
	}

	public String getRegiaoNome() {
		return regiaoNome;
	}

	public void setRegiaoNome(String regiaoNome) {
		this.regiaoNome = regiaoNome;
	}

}
