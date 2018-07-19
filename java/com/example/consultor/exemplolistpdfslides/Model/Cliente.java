package com.example.consultor.exemplolistpdfslides.Model;

/**
 * Created by Consultor on 19/07/2018.
 */

public class Cliente {
    private Integer id;
    private String nome;
    private String endereco;
    private String cidade;

    public Cliente(Integer id, String nome, String endereco, String cidade) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.cidade = cidade;
    }

    public Integer getId(){
        return id;
    }
    public String getNome(){
        return nome;
    }
    public String getEndereco(){
        return endereco;
    }
    public String getCidade(){
        return cidade;
    }
}
