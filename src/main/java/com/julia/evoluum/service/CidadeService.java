package com.julia.evoluum.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.julia.evoluum.feignService.ServiceFeign;
import com.julia.evoluum.model.CidadeResponse;

@Service
public class CidadeService {

	@Autowired
	private ServiceFeign serviceFeign;
	private static final Logger LOG = LoggerFactory.getLogger(CidadeService.class);
	private List<CidadeResponse> listCidade;
	private CidadeResponse cidadeResponse;

	public List<CidadeResponse> getListCidadeByEstado(String estado) {
		// redis para o cache
		try {
			LOG.info("Buscar cidades por estado..");
			listCidade = serviceFeign.getListCidade(estado);
			return listCidade;
		} catch (Exception e) {
			System.err.println(e);
			return new ArrayList<CidadeResponse>();
		}
	}

	public List<CidadeResponse> getListCidade() {
		// redis para o cache
		try {
			LOG.info("Buscar cidades...");
			listCidade = serviceFeign.getListCidade();
			return listCidade;
		} catch (Exception e) {
			System.err.println(e);
			return new ArrayList<CidadeResponse>();
		}
	}

	public Long getIdCidade(String nomeCidade) {
		// redis para o cache
		try {
			LOG.info("Buscar id da cidade...");
			cidadeResponse = serviceFeign.getIdCidade(nomeCidade);
			return cidadeResponse.getId();
		} catch (Exception e) {
			System.err.println(e);
			return new Long(1L);
		}
	}
}
