package br.ufjf.dcc193.trabalho03.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * Etiqueta
 */
@Entity
@Table(name = "etiqueta")
public class Etiqueta {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id; 
    private String titulo;
    private String descricao;
    private String url;

    public Etiqueta(Long id, String titulo, String descricao, String url) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.url = url;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Etiqueta [descricao=" + descricao + ", id=" + id + ", titulo=" + titulo + ", url=" + url + "]";
    }

    
    
}