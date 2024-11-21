package com.tcc.tcc.model;

import com.tcc.tcc.dto.VendasDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Vendas")
public class VendasModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idVendas;
	private String textoVendas;
	private String imageVendas;
	private double preco;
	private String localização;
	
	public Long getIdVendas() {
		return idVendas;
	}
	public void setIdVendas(Long idVendas) {
		this.idVendas = idVendas;
	}
	public String getTextoVendas() {
		return textoVendas;
	}
	public void setTextoVendas(String textoVendas) {
		this.textoVendas = textoVendas;
	}
	public String getImageVendas() {
		return imageVendas;
	}
	public void setImageVendas(String imageVendas) {
		this.imageVendas = imageVendas;
	}
	public double getPreço() {
		return preco;
	}
	public void setPreço(double preco) {
		this.preco = preco;
	}
	public String getLocalização() {
		return localização;
	}
	public void setLocalização(String localização) {
		this.localização = localização;
	}
	
	public VendasModel(VendasDTO DTO) {
		this.textoVendas = DTO.textoVendas();
		this.imageVendas = DTO.imagemVendas();
		this.preco = DTO.preco();
		this.localização = DTO.localização();
	}
	
	
	
	
}
