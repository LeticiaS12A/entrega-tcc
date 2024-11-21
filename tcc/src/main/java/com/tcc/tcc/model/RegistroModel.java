package com.tcc.tcc.model;

import com.tcc.tcc.dto.RegistroDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Registro")
public class RegistroModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idRegistro;
	private String email;
	private String nome;
	private String senha;
	
	public Long getIdRegistro() {
		return idRegistro;
	}
	public void setIdRegistro(Long idRegistro) {
		this.idRegistro = idRegistro;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public RegistroModel(RegistroDTO DTO) {
		this.email = DTO.email();
		this.nome = DTO.nome();
		this.senha = DTO.senha();
	}
	public void setId(Long idRegistro2) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
