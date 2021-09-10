package br.com.totemti.livraria.controllers.dto;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LivroFormDTO {

     // Variaveis da entidade
     private Long id;

     @NotNull
     @Size(min = 3)
     private String nome;
 
     @NotNull
     private String descricao;

     private Long editora;

     private List<Long> autores;


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

    public Long getEditora() {
        return this.editora;
    }

    public void setEditora(Long editora) {
        this.editora = editora;
    }

    public List<Long> getAutores() {
        return this.autores;
    }

    public void setAutores(List<Long> autores) {
        this.autores = autores;
    }

    
}
