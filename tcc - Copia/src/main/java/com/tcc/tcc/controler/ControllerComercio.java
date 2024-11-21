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

import com.tcc.tcc.model.ComercioModel;
import com.tcc.tcc.service.ComercioService;

@RestController
@RequestMapping("/comercio")
public class ControllerComercio {
	 
	@Autowired
	    private ComercioService comercioService;

	    // Listar todos os produtos
	    @GetMapping
	    public List<ComercioModel> listarComercio() {
	        return comercioService.listarTodos();
	    }

	    // Buscar produto por ID
	    @GetMapping("/{id}")
	    public ResponseEntity<ComercioModel> buscarComercio(@PathVariable Long idComercio) {
	        Optional<ComercioModel> comercio = comercioService.buscarPorId(idComercio);
	        return comercio.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	    }

	    // Criar um novo produto
	    @PostMapping
	    public ComercioModel criarComercio(@RequestBody ComercioModel comercio) {
	        return comercioService.salvar(comercio);
	    }

	    // Atualizar um produto
	    @PutMapping("/{id}")
	    public ResponseEntity<ComercioModel> atualizarComercio(@PathVariable Long idComercio, @RequestBody ComercioModel comercio) {
	        Optional<ComercioModel> comercioExistente = comercioService.buscarPorId(idComercio);
	        if (comercioExistente.isPresent()) {
	        	comercio.setIdComercio(idComercio);
	            return ResponseEntity.ok(comercioService.salvar(comercio));
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    // Excluir um produto
	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> excluirComercio(@PathVariable Long idComercio) {
	        Optional<ComercioModel> comercio = comercioService.buscarPorId(idComercio);
	        if (comercio.isPresent()) {
	        	comercioService.excluir(idComercio);
	            return ResponseEntity.noContent().build();
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
}
