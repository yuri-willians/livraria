package br.com.totemti.livraria.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.totemti.livraria.models.Editora;
import br.com.totemti.livraria.services.EditoraService;

@RestController
@RequestMapping(value = "/editoras")
public class EditoraController {

    private EditoraService editoraService;

    @Autowired
    public EditoraController(EditoraService editoraService) {
        this.editoraService = editoraService;
    }
    
    @GetMapping
    public ResponseEntity<Page<Editora>> index(@PageableDefault(sort = "nome") Pageable pageable) {
        return ResponseEntity.ok(editoraService.listar(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Editora> show(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(editoraService.buscar(id));
    }

}