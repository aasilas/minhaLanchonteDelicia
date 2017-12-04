package com.example.adm.minhalanchonetedelicia;

/**
 * Created by adm on 04/12/2017.
 */

import java.io.Serializable;

public class Item implements Serializable {

    private String nome;
    private String valor;
    private String descricao;
    private Categoria categoria;

    public Item(String nome, String valor, String descricao,String categoria){
        this.nome=nome;
        this.valor=valor;
        this.descricao=descricao;
        Categoria c = Categoria.valueOf(categoria);
        this.categoria = c;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    @Override
    public String toString() {
        return nome;
    }
}