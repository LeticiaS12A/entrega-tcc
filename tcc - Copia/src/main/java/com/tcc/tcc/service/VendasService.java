package com.tcc.tcc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcc.tcc.model.VendasModel;
import com.tcc.tcc.repository.VendasRepository;

@Service
public class VendasService {
	
	 @Autowired
	    private VendasRepository vendasRepository;

	    public List<VendasModel> listarTodos() {
	        return vendasRepository.findAll();
	    }

	    public Optional<VendasModel> buscarPorId(Long idVendas) {
	        return vendasRepository.findById(idVendas);
	    }

	    public VendasModel salvar(VendasModel vendas) {
	        return vendasRepository.save(vendas);
	    }

	    public void excluir(Long idVendas) {
	    	vendasRepository.deleteById(idVendas);
	    }
	
}
