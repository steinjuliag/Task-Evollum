package com.julia.evoluum.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.julia.evoluum.service.CidadeService;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class DocumentoModelo {
	
	@Autowired
	private CidadeService cidadeService;
	String estado = "sc";
	List<CidadeResponse> listCidade = cidadeService.getListCidadeByEstado(estado);
	XStream xStream = new XStream(new DomDriver());
	private String xml = xStream.toXML(listCidade);

}
