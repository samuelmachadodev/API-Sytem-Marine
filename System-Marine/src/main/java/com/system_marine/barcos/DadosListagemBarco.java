package com.system_marine.barcos;

public record DadosListagemBarco(
		Long id,
		String nome,		
		String proprietario,		
		String marinheiro,
		String modelo,
		String tamanho,
		String registro,
		String observacoes,
		int vaga) {
	
	public DadosListagemBarco(Barco barco) {
		this(   barco.getId(),
				barco.getNome(),
				barco.getProprietario(),
				barco.getMarinheiro(),
				barco.getModelo(),
				barco.getTamanho(),
				barco.getRegistro(),
				barco.getObservacoes(),
				barco.getVaga()
				);
	}

}
	