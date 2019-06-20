package br.ufjf.dcc193.trabalho03.Models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Item
 */
@Entity
@Table(name = "item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String titulo;
    @OneToMany(fetch = FetchType.LAZY)
    private List<Anotacao> anotacao;
    @OneToMany(fetch = FetchType.LAZY)
    private List<Etiqueta> etiqueta;
    @OneToMany(fetch = FetchType.LAZY)
    private List<Vinculo> vinculo;

    public Item(Long id, String titulo) {
        this.id = id;
        this.titulo = titulo;
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

    public List<Anotacao> getAnotacao() {
        return anotacao;
    }

    public void setAnotacao(List<Anotacao> anotacao) {
        this.anotacao = anotacao;
    }

    public List<Etiqueta> getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(List<Etiqueta> etiqueta) {
        this.etiqueta = etiqueta;
    }

    public List<Vinculo> getVinculo() {
        return vinculo;
    }

    public void setVinculo(List<Vinculo> vinculo) {
        this.vinculo = vinculo;
    }

    @Override
    public String toString() {
        return "Item [id=" + id + ", titulo=" + titulo + ", vinculo=" + vinculo + "]";
    }

}