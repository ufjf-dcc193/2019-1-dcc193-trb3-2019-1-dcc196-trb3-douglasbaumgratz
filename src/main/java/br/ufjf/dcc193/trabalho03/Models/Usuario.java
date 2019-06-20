package br.ufjf.dcc193.trabalho03.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * Usuario
 */
@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;    
    private String nome;
    private int codigo;
    private String descricao;
    private String email;

    public Usuario(Long id, String nome, int codigo, String descricao, String email) {
        this.id = id;
        this.nome = nome;
        this.codigo = codigo;
        this.descricao = descricao;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Usuario [codigo=" + codigo + ", descricao=" + descricao + ", email=" + email + ", id=" + id + ", nome="
                + nome + "]";
    }

    
    
}