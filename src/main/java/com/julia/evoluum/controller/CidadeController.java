package com.julia.evoluum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.julia.evoluum.model.CidadeResponse;
import com.julia.evoluum.service.CidadeService;

@RestController
public class CidadeController {
	@Autowired
	private CidadeService cidadeService;

	@GetMapping(value = "/cidades")
	public List<CidadeResponse> getListCidades() {
		return cidadeService.getListCidade();
	}

	@GetMapping(value = "/buscarIdcidade/{nomeCidade}")
	public Long getIdCidade(@PathVariable String nomeCidade) {
		return cidadeService.getIdCidade(nomeCidade);
	}
	
	@GetMapping(value = "/buscarCidadesInEstado/{estado}")
	public List<CidadeResponse> getListCidadesByEstado(@PathVariable String estado) {
		return cidadeService.getListCidadeByEstado(estado);
	}
	
}
