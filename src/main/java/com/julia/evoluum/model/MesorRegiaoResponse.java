package com.julia.evoluum.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MesorRegiaoResponse {
	@JsonProperty("nome")
	private String nomeMesorregiao;
	
	@JsonProperty("UF")
	private EstadoResponse estado;

	public EstadoResponse getEstado() {
		return estado;
	}

	public void setEstado(EstadoResponse estado) {
		this.estado = estado;
	}

	public String getNomeMesorregiao() {
		return nomeMesorregiao;
	}

	public void setNomeMesorregiao(String nomeMesorregiao) {
		this.nomeMesorregiao = nomeMesorregiao;
	}

}
