package com.julia.evoluum;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.julia.evoluum.feignService.ServiceFeign;
import com.julia.evoluum.model.EstadoResponse;
import com.julia.evoluum.service.EstadoService;

@SpringBootTest
public class EstadoServiceTest {

	@Mock
	private ServiceFeign estadoServiceFeign;

	@InjectMocks
	private EstadoService estadoService;

	@Test
	void getListEstado() {

		List<EstadoResponse> estadoResponsesEsperado = new ArrayList<>();
		EstadoResponse estadoResponse = new EstadoResponse();
		estadoResponse.setIdEstado(1L);
		estadoResponsesEsperado.add(estadoResponse);
		Mockito.when(estadoServiceFeign.getListEstado()).thenReturn(estadoResponsesEsperado);

		List<EstadoResponse> estadoResponses = estadoService.getListEstado();
		assertEquals(estadoResponsesEsperado, estadoResponses);
	}

	@Test
	void getListaVaziaQuandoHouverExeption() {

		Mockito.when(estadoServiceFeign.getListEstado()).thenThrow(new RuntimeException());

		List<EstadoResponse> estadoResponses = estadoService.getListEstado();
		assertTrue(estadoResponses.isEmpty());

	}

}
