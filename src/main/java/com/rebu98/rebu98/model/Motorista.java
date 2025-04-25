package com.rebu98.rebu98.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_motorista")
public class Motorista {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Informações sobre o CNH é obrigatório!")
	@Size(min = 3, max = 100, message = "Atributo tem que ter no mínimo 3 caracteres")
	private String cnh;
	
	@NotBlank(message = "Informações sobre o Modelo de Carro é obrigatório!")
	@Size(min = 3, max = 100, message = "Atributo tem que ter no mínimo 3 caracteres")
    private String modeloCarro;
	
	@NotBlank(message = "Informações sobre a Placa é obrigatório!")
	@Size(min = 3, max = 100, message = "Atributo tem que ter no mínimo 3 caracteres")
    private String placa;
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "motorista", cascade = CascadeType.REMOVE)
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCnh() {
		return cnh;
	}

	public void setCnh(String cnh) {
		this.cnh = cnh;
	}

	public String getModeloCarro() {
		return modeloCarro;
	}

	public void setModeloCarro(String modeloCarro) {
		this.modeloCarro = modeloCarro;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}