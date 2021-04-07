package com.julia.evoluum.feignService;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.julia.evoluum.model.CidadeResponse;
import com.julia.evoluum.model.EstadoResponse;

@FeignClient(name = "serviceFeign", url = "https://servicodados.ibge.gov.br")
public interface ServiceFeign {
	
	@GetMapping("/api/v1/localidades/estados/{estado}/municipios")
	List<CidadeResponse> getListCidade(@PathVariable("estado") String estado);
	
	@GetMapping("/api/v1/localidades/estados")
	List<EstadoResponse> getListEstado();
	
	@GetMapping("/api/v1/localidades/municipios/{nomeCidade}")
	CidadeResponse getIdCidade(@PathVariable("nomeCidade") String nomeCidade);
	
	@GetMapping("/api/v1/localidades/municipios")
	List<CidadeResponse> getListCidade();
	

}
