package br.com.totemti.livraria.controllers.dto;

import java.util.List;

public class LivroDTO {

    // Variaveis da entidade
    private Long id;

    private String nome;

    private String descricao;

    private EditoraDTO editora;

    private List<AutorDTO> autores;

    // Getters e Setters
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public EditoraDTO getEditora() {
        return this.editora;
    }

    public void setEditora(EditoraDTO editora) {
        this.editora = editora;
    }


    public List<AutorDTO> getAutores() {
        return this.autores;
    }

    public void setAutores(List<AutorDTO> autores) {
        this.autores = autores;
    }

}
