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

import com.tcc.tcc.model.VendasModel;
import com.tcc.tcc.service.VendasService;

@RestController
@RequestMapping("/vendas")
public class ControllerVendas {
	 
	@Autowired
	    private VendasService vendasService;

	    // Listar todos os produtos
	    @GetMapping
	    public List<VendasModel> listarVendas() {
	        return vendasService.listarTodos();
	    }

	    // Buscar produto por ID
	    @GetMapping("/{id}")
	    public ResponseEntity<VendasModel> buscarVendas(@PathVariable Long idVendas) {
	        Optional<VendasModel> vendas = vendasService.buscarPorId(idVendas);
	        return vendas.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	    }

	    // Criar um novo produto
	    @PostMapping
	    public VendasModel criarVendas(@RequestBody VendasModel vendas) {
	        return vendasService.salvar(vendas);
	    }

	    // Atualizar um produto
	    @PutMapping("/{id}")
	    public ResponseEntity<VendasModel> atualizarVendas(@PathVariable Long idVendas, @RequestBody VendasModel vendas) {
	        Optional<VendasModel> vendasExistente = vendasService.buscarPorId(idVendas);
	        if (vendasExistente.isPresent()) {
	        	vendas.setIdVendas(idVendas);
	            return ResponseEntity.ok(vendasService.salvar(vendas));
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    // Excluir um produto
	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> excluirVendas(@PathVariable Long idVendas) {
	        Optional<VendasModel> vendas = vendasService.buscarPorId(idVendas);
	        if (vendas.isPresent()) {
	        	vendasService.excluir(idVendas);
	            return ResponseEntity.noContent().build();
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
}
