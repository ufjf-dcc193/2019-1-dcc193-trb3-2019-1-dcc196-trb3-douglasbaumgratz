package br.ufjf.dcc193.trabalho03.Models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Anotacao
 */
@Entity
@Table(name = "anotacao")
public class Anotacao {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String titulo;
    private String descricao;
    private String url;
    @OneToOne(fetch = FetchType.LAZY)
    private Usuario usuario;
    private String dataInclusao;
    private String dataAlteracao;

    public Anotacao(Long id, String titulo, String descricao, String url, String dataInclusao, String dataAlteracao) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.url = url;
        this.dataInclusao = dataInclusao;
        this.dataAlteracao = dataAlteracao;
    }

    public Anotacao(Long id, String titulo, String descricao, String dataInclusao, String dataAlteracao) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataInclusao = dataInclusao;
        this.dataAlteracao = dataAlteracao;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getDataInclusao() {
        return dataInclusao;
    }

    public void setDataInclusao(String dataInclusao) {
        this.dataInclusao = dataInclusao;
    }

    public String getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(String dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }

    @Override
    public String toString() {
        return "Anotacao [dataAlteracao=" + dataAlteracao + ", dataInclusao=" + dataInclusao + ", descricao="
                + descricao + ", id=" + id + ", titulo=" + titulo + ", url=" + url + "]";
    }

}