package com.julia.evoluum.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EstadoResponse {

	@JsonProperty("id")
	private Long idEstado;
	@JsonProperty("sigla")
	private String siglaEstado;
	@JsonProperty("nome")
	private String regiaoNome;
	@JsonProperty("regiao")
	private RegiaoResponse regiao;

	public Long getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(Long idEstado) {
		this.idEstado = idEstado;
	}

	public String getSiglaEstado() {
		return siglaEstado;
	}

	public void setSiglaEstado(String siglaEstado) {
		this.siglaEstado = siglaEstado;
	}

	public String getRegiaoNome() {
		return regiaoNome;
	}

	public void setRegiaoNome(String regiaoNome) {
		this.regiaoNome = regiaoNome;
	}

	public RegiaoResponse getRegiao() {
		return regiao;
	}

	public void setRegiao(RegiaoResponse regiao) {
		this.regiao = regiao;
	}

}
