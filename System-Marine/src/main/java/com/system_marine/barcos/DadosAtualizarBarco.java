package com.system_marine.barcos;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarBarco(
		@NotNull
		Long id,
		String nome,
		String marinheiro,
		String observacoes,
		int vaga) {

}
