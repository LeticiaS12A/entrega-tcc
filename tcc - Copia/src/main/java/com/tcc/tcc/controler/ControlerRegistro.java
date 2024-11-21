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

import com.tcc.tcc.model.RegistroModel;
import com.tcc.tcc.service.RegistroService;

@RestController
@RequestMapping("/registro")
public class ControlerRegistro {
	 
	@Autowired
	    private RegistroService registroService;

	    // Listar todos os produtos
	    @GetMapping
	    public List<RegistroModel> listarRegistros() {
	        return registroService.listarTodos();
	    }

	    // Buscar produto por ID
	    @GetMapping("/{id}")
	    public ResponseEntity<RegistroModel> buscarRegistros(@PathVariable Long idUsuario) {
	        Optional<RegistroModel> registro = registroService.buscarPorId(idUsuario);
	        return registro.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	    }

	    // Criar um novo produto
	    @PostMapping
	    public RegistroModel criarProduto(@RequestBody RegistroModel registro) {
	        return registroService.salvar(registro);
	    }

	    // Atualizar um produto
	    @PutMapping("/{id}")
	    public ResponseEntity<RegistroModel> atualizarProduto(@PathVariable Long idUsuario, @RequestBody RegistroModel registro) {
	        Optional<RegistroModel> registroExistente = registroService.buscarPorId(idUsuario);
	        if (registroExistente.isPresent()) {
	        	registro.setId(idUsuario);
	            return ResponseEntity.ok(registroService.salvar(registro));
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    // Excluir um produto
	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> excluirProduto(@PathVariable Long idUsuario) {
	        Optional<RegistroModel> registro = registroService.buscarPorId(idUsuario);
	        if (registro.isPresent()) {
	        	registroService.excluir(idUsuario);
	            return ResponseEntity.noContent().build();
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
}