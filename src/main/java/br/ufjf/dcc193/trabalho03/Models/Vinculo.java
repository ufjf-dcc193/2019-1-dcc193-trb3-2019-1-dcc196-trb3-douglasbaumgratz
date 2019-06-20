package br.ufjf.dcc193.trabalho03.Models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Vinculo
 */
@Entity
@Table(name = "vinculo")
public class Vinculo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @OneToOne(fetch = FetchType.LAZY)
    private Item itemOrigem;
    @OneToOne(fetch = FetchType.LAZY)
    private Item itemDestino;
    @OneToMany(fetch = FetchType.LAZY)
    private List<Etiqueta> etiqueta;
    @OneToMany(fetch = FetchType.LAZY)
    private List<Anotacao> anotacao;

    public Vinculo(Long id, Item itemOrigem, Item itemDestino) {
        this.id = id;
        this.itemOrigem = itemOrigem;
        this.itemDestino = itemDestino;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Item getItemOrigem() {
        return itemOrigem;
    }

    public void setItemOrigem(Item itemOrigem) {
        this.itemOrigem = itemOrigem;
    }

    public Item getItemDestino() {
        return itemDestino;
    }

    public void setItemDestino(Item itemDestino) {
        this.itemDestino = itemDestino;
    }

    public List<Etiqueta> getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(List<Etiqueta> etiqueta) {
        this.etiqueta = etiqueta;
    }

    public List<Anotacao> getAnotacao() {
        return anotacao;
    }

    public void setAnotacao(List<Anotacao> anotacao) {
        this.anotacao = anotacao;
    }

    @Override
    public String toString() {
        return "Vinculo [id=" + id + ", itemDestino=" + itemDestino + ", itemOrigem=" + itemOrigem + "]";
    }

}