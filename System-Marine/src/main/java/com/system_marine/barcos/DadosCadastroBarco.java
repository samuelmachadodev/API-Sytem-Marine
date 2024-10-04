package com.system_marine.barcos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroBarco (
		
		@NotBlank
		String nome,
		@NotBlank
		String proprietario,
		@NotBlank
		String marinheiro,
		@NotBlank
		String modelo,
		@NotBlank
		String tamanho,
		@NotBlank
		String registro,
		String observacoes,
		@NotNull
		int vaga,
		String imagemBase64) {
	   
	
}
