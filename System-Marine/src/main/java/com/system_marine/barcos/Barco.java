package com.system_marine.barcos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name= "Barco")
@Entity(name= "Barcos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")

public class Barco {
	
	@Id @GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	private boolean ativo;
	private String nome;
	private String proprietario;
	private String marinheiro;
	private String modelo;
	private String tamanho;
	private String registro;
	private String observacoes;
	private int vaga;

	
	public Barco() {
		
	}
	
	public Barco(DadosCadastroBarco dados) {
		this.ativo = true;
		this.setNome(dados.nome());
		this.setProprietario(dados.proprietario());
		this.setMarinheiro(dados.marinheiro());
		this.setModelo(dados.modelo());
		this.setTamanho(dados.tamanho());
		this.setRegistro(dados.registro());
		this.setObservacoes(dados.observacoes());
		this.setVaga(dados.vaga());
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getProprietario() {
		return proprietario;
	}
	public void setProprietario(String proprietario) {
		this.proprietario = proprietario;
	}
	public String getMarinheiro() {
		return marinheiro;
	}
	public void setMarinheiro(String marinheiro) {
		this.marinheiro = marinheiro;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getTamanho() {
		return tamanho;
	}
	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}
	public String getRegistro() {
		return registro;
	}
	public void setRegistro(String registro) {
		this.registro = registro;
	}
	public String getObservacoes() {
		return observacoes;
	}
	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
	public int getVaga() {
		return vaga;
	}
	public void setVaga(int vaga) {
		this.vaga = vaga;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}


	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	public void atualizarInformações(@Valid DadosAtualizarBarco dados) {
		if (dados.nome() != null) {
			this.nome = dados.nome();
		}
		if (dados.marinheiro() != null) {
			this.marinheiro = dados.marinheiro();
		}
		if (dados.observacoes() != null) {
			this.observacoes = dados.observacoes();
		}
		if (dados.vaga() != vaga) {
			this.vaga = dados.vaga();
		}
		
		
	}
	
	public void inativar() {
		this.ativo = false;
	}

	public void ativar() {
		this.ativo = true;
		
	}

	


}
	