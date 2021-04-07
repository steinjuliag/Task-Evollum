package com.julia.evoluum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.julia.evoluum.model.CidadeResponse;
import com.julia.evoluum.model.EstadoResponse;
import com.julia.evoluum.service.CidadeService;
import com.julia.evoluum.service.EstadoService;

@RestController
public class EstadoController {

	@Autowired
	private EstadoService estadoService;

	@GetMapping("/buscarEstados")
	public List<EstadoResponse> getEstados() {
		return estadoService.getListEstado();
	}

}
