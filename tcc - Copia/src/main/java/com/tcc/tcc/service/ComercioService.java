package com.tcc.tcc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcc.tcc.model.ComercioModel;
import com.tcc.tcc.repository.ComercioRepository;

@Service
public class ComercioService {
	
	 @Autowired
	    private ComercioRepository comercioRepository;

	    public List<ComercioModel> listarTodos() {
	        return comercioRepository.findAll();
	    }

	    public Optional<ComercioModel> buscarPorId(Long idComercio) {
	        return comercioRepository.findById(idComercio);
	    }

	    public ComercioModel salvar(ComercioModel comercio) {
	        return comercioRepository.save(comercio);
	    }

	    public void excluir(Long idComercio) {
	    	comercioRepository.deleteById(idComercio);
	    }
	
}
