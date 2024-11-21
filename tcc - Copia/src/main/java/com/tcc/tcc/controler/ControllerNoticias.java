package com.tcc.tcc.controler;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcc.tcc.model.NoticiasModel;
import com.tcc.tcc.service.NoticiasService;

@RestController
@RequestMapping("/noticias")
public class ControllerNoticias {
	 
	@Autowired
	    private NoticiasService noticiasService;

	    // Listar todos os produtos
	    @GetMapping
	    public List<NoticiasModel> listarNoticias() {
	        return noticiasService.listarTodos();
	    }

	    // Buscar produto por ID
	    @GetMapping("/{id}")
	    public ResponseEntity<NoticiasModel> buscarNoticias(@PathVariable Long idNoticias) {
	        Optional<NoticiasModel> noticias = noticiasService.buscarPorId(idNoticias);
	        return noticias.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	    }

	    // Criar um novo produto
	    @PostMapping
	    public NoticiasModel criarNoticias(@RequestBody NoticiasModel noticias) {
	        return noticiasService.salvar(noticias);
	    }

	    // Atualizar um produto
	    @PutMapping("/{id}")
	    public ResponseEntity<NoticiasModel> atualizarNoticias(@PathVariable Long idNoticias, @RequestBody NoticiasModel noticias) {
	        Optional<NoticiasModel> noticiasExistente = noticiasService.buscarPorId(idNoticias);
	        if (noticiasExistente.isPresent()) {
	        	noticias.setIdNoticias(idNoticias);
	            return ResponseEntity.ok(noticiasService.salvar(noticias));
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    // Excluir um produto
	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> excluirNoticias(@PathVariable Long idNoticias) {
	        Optional<NoticiasModel> noticias = noticiasService.buscarPorId(idNoticias);
	        if (noticias.isPresent()) {
	        	noticiasService.excluir(idNoticias);
	            return ResponseEntity.noContent().build();
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
}
