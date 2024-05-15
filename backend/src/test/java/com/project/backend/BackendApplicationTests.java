package com.project.backend;


import com.project.backend.domain.usecase.UseCaseUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class BackendApplicationTests {


	@ParameterizedTest
	@ValueSource(strings = { "HOLA", "MuNDo", "pRueBA" })
	void testNormalizarTextNotNull(String input) {
		String textoNormalizado = UseCaseUtils.normalizarTexto(input);
		Assert.notNull(textoNormalizado,"Texto not null");
		Assert.isTrue(
				textoNormalizado.equals("Hola") ||
						textoNormalizado.equals("Mundo") ||
						textoNormalizado.equals("Prueba")
				,"Texto normalizado");
	}

}
