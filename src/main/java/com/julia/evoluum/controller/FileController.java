package com.julia.evoluum.controller;

import java.io.OutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.julia.evoluum.service.FileCsvService;

@Controller
@RequestMapping("/download")
public class FileController {

	@Autowired
	private FileCsvService fileCsv;
	private static final Logger LOG = LoggerFactory.getLogger(FileController.class);

	@GetMapping(value = "/csv", produces = "text/csv")
	public ResponseEntity<OutputStream> dowloadCsv() {
		LOG.info("Inicio do download arquivo csv...");
		InputStreamResource csv = fileCsv.criarCsv();
		HttpHeaders headers = fileCsv.criarHeaders();
		ResponseEntity<?> responseEntity = new ResponseEntity<>(csv, headers, HttpStatus.OK);
		LOG.info("Concluído download csv...");
		return (ResponseEntity<OutputStream>) responseEntity;

	}

}
