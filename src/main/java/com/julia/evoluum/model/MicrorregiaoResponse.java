package com.julia.evoluum.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MicrorregiaoResponse {
	private MesorRegiaoResponse mesorRegiao;

	@JsonProperty("mesorregiao")
	public MesorRegiaoResponse getMesorRegiao() {
		return mesorRegiao;
	}

	public void setMesorRegiao(MesorRegiaoResponse mesorRegiao) {
		this.mesorRegiao = mesorRegiao;
	}
}
