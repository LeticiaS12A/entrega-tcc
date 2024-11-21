package com.tcc.tcc.model;

import com.tcc.tcc.dto.ComercioDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Comercio")
public class ComercioModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idComercio;
	private String textoComercio;
	private String imageComercio;
	private String localização;
	
	public Long getIdComercio() {
		return idComercio;
	}
	public void setIdComercio(Long idComercio) {
		this.idComercio = idComercio;
	}
	public String getTextoComercio() {
		return textoComercio;
	}
	public void setTextoComercio(String textoComercio) {
		this.textoComercio = textoComercio;
	}
	public String getImageComercio() {
		return imageComercio;
	}
	public void setImageComercio(String imageComercio) {
		this.imageComercio = imageComercio;
	}
	public String getLocalização() {
		return localização;
	}
	public void setLocalização(String localização) {
		this.localização = localização;
	}
	
	public ComercioModel(ComercioDTO DTO) {
		this.textoComercio = DTO.textoComercio();
		this.imageComercio = DTO.imagemComercio();
		this.localização = DTO.localização();
	}
	
	
	
	
	
	
}
