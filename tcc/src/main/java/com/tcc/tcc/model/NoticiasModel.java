package com.tcc.tcc.model;

import com.tcc.tcc.dto.NoticiasDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Noticias")
public class NoticiasModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idNoticias;
	private String textoNoticias;
	private String imageNoticias;
	private String localização;
	
	
	public Long getIdNoticias() {
		return idNoticias;
	}
	public void setIdNoticias(Long idNoticias) {
		this.idNoticias = idNoticias;
	}
	public String getTextoNoticias() {
		return textoNoticias;
	}
	public void setTextoNoticias(String textoNoticias) {
		this.textoNoticias = textoNoticias;
	}
	public String getImageNoticias() {
		return imageNoticias;
	}
	public void setImageNoticias(String imageNoticias) {
		this.imageNoticias = imageNoticias;
	}
	public String getLocalização() {
		return localização;
	}
	public void setLocalização(String localização) {
		this.localização = localização;
	}
	
	public NoticiasModel(NoticiasDTO DTO) {
		this.textoNoticias = DTO.textoNoticias();
		this.imageNoticias = DTO.imagemNoticias();
		this.localização = DTO.localização();
	}
	
	
	
	
	
	
}
