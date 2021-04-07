package com.julia.evoluum.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.julia.evoluum.feignService.ServiceFeign;
import com.julia.evoluum.model.EstadoResponse;


@Service
public class EstadoService {

	@Autowired
	private ServiceFeign serviceFeign;
	
	public List<EstadoResponse> getListEstado() {

		// redis para o cache
		try {
			List<EstadoResponse> listEstados = serviceFeign.getListEstado();
			return listEstados;
		} catch (Exception e) {
			System.err.println(e);
			return new ArrayList<EstadoResponse>();
		}

	}
}
