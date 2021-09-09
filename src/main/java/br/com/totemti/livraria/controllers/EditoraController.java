package br.com.totemti.livraria.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.totemti.livraria.dto.EditoraDTO;
import br.com.totemti.livraria.models.Editora;
import br.com.totemti.livraria.services.EditoraService;

@RestController
@RequestMapping(value = "/editoras")
public class EditoraController {

    private ModelMapper modelMapper;
    private EditoraService editoraService;

    @Autowired
    public EditoraController(ModelMapper modelMapper, EditoraService editoraService) {
        this.modelMapper = modelMapper;
        this.editoraService = editoraService;
    }
    
    @GetMapping
    public ResponseEntity<Page<EditoraDTO>> index(@PageableDefault(sort = "nome") Pageable pageable) {
        Page editoras = editoraService
            .listar(pageable)
            .map(editora -> modelMapper.map(editora, EditoraDTO.class));
        return ResponseEntity.ok(editoras);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EditoraDTO> show(@PathVariable(name = "id") Long id) {
        Editora editora = editoraService.buscar(id);

        EditoraDTO editoraDTO = modelMapper.map(editora, EditoraDTO.class);
        return ResponseEntity.ok(editoraDTO);
    }

}