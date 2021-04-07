package com.julia.evoluum.service;

import java.io.ByteArrayInputStream;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import com.julia.evoluum.model.CidadeResponse;
@Service
public class FileCsvService {
	
	@Autowired
	private CidadeService cidadeService;
	private List<List<String>> csvBody = new ArrayList<>();
	private String csvFileName = "estados.csv";
	private static final Logger LOG = LoggerFactory.getLogger(FileCsvService.class);
	private final String CONCAT_CHAR = "/";
	private String nomeFormato = null;
	private StringBuilder atributoFormatado = new StringBuilder();
	public InputStreamResource criarCsv() {
		List<CidadeResponse> listCidade = cidadeService.getListCidade();
		LOG.info("Criar csv");
		ByteArrayInputStream byteArrayOutputStream;


	
		for (CidadeResponse cidadeResponse : listCidade) {
		
			csvBody.add(Arrays.asList(
					cidadeResponse.getMicrorRegiao().getMesorRegiao().getEstado().getIdEstado().toString(),
					cidadeResponse.getMicrorRegiao().getMesorRegiao().getEstado().getSiglaEstado(),
					cidadeResponse.getMicrorRegiao().getMesorRegiao().getEstado().getRegiao().getRegiaoNome(),
					cidadeResponse.getNomeCidade(),
					cidadeResponse.getMicrorRegiao().getMesorRegiao().getNomeMesorregiao(),
				    formatar(cidadeResponse.getNomeCidade(), cidadeResponse.getMicrorRegiao().getMesorRegiao().getEstado().getSiglaEstado())
					));
			       }

		try (ByteArrayOutputStream out = new ByteArrayOutputStream();
				CSVPrinter csvPrinter = new CSVPrinter(new PrintWriter(out),
						CSVFormat.DEFAULT.withHeader(getHeader()));) {
		
			for (List<String> record : csvBody)
				csvPrinter.printRecord(record);

			
			csvPrinter.flush();

			byteArrayOutputStream = new ByteArrayInputStream(out.toByteArray());
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage());
		}

		InputStreamResource fileInputStream = new InputStreamResource(byteArrayOutputStream);
		return fileInputStream;
	}

	public HttpHeaders criarHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + getCsvFileName());
		headers.set(HttpHeaders.CONTENT_TYPE, "text/csv");
		return headers;
	}

	public String formatar(String nomeCidade, String siglaEstado) {
	    String atributo = nomeCidade.concat(CONCAT_CHAR);
	    String atributo2 = atributo.concat(siglaEstado);
		return atributo2;
	}


	public String[] getHeader() {
		String[] csvHeader = { "idEstado", "siglaEstado", "regiaoNome", "nomeCidade", "nomeMesorregiao",
				"nomeFormatado" };
		return csvHeader;
	}
	
	public String getCsvFileName() {
		return csvFileName;
	}

	public void setCsvFileName(String csvFileName) {
		this.csvFileName = csvFileName;
	}

}
