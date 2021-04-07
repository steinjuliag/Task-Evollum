package com.julia.evoluum;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.julia.evoluum.feignService.ServiceFeign;
import com.julia.evoluum.model.CidadeResponse;
import com.julia.evoluum.service.CidadeService;

@SpringBootTest
public class CidadeServiceTest {
	@Mock
	private ServiceFeign estadoServiceFeign;

	@InjectMocks
	private CidadeService cidadeService;
	
	@Test
	void getListCidade() {

		List<CidadeResponse> cidadeResponsesEsperado = new ArrayList<>();
		CidadeResponse cidadeResponse = new CidadeResponse();
		cidadeResponsesEsperado.add(cidadeResponse);
		Mockito.when(estadoServiceFeign.getListCidade()).thenReturn(cidadeResponsesEsperado);

		List<CidadeResponse> estadoResponses = cidadeService.getListCidade();
		assertEquals(cidadeResponsesEsperado, estadoResponses);
	}

}
