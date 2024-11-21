 package com.tcc.tcc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcc.tcc.model.RegistroModel;
import com.tcc.tcc.repository.RegistroRepository;

@Service
public class RegistroService {
	
	 @Autowired
	    private RegistroRepository registroRepository;

	    public List<RegistroModel> listarTodos() {
	        return registroRepository.findAll();
	    }

	    public Optional<RegistroModel> buscarPorId(Long idUsuario) {
	        return registroRepository.findById(idUsuario);
	    }

	    public RegistroModel salvar(RegistroModel registro) {
	        return registroRepository.save(registro);
	    }

	    public void excluir(Long idUsuario) {
	        registroRepository.deleteById(idUsuario);
	    }
	
}
