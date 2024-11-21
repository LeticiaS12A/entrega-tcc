package com.tcc.tcc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcc.tcc.model.NoticiasModel;
import com.tcc.tcc.repository.NoticiasRepository;

@Service
public class NoticiasService {
	
	 @Autowired
	    private NoticiasRepository noticiasRepository;

	    public List<NoticiasModel> listarTodos() {
	        return noticiasRepository.findAll();
	    }

	    public Optional<NoticiasModel> buscarPorId(Long idNoticias) {
	        return noticiasRepository.findById(idNoticias);
	    }

	    public NoticiasModel salvar(NoticiasModel noticias) {
	        return noticiasRepository.save(noticias);
	    }

	    public void excluir(Long idNoticias) {
	    	noticiasRepository.deleteById(idNoticias);
	    }
	
}
