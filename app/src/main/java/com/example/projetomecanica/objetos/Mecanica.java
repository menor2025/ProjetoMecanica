package com.example.projetomecanica.objetos;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Mecanica implements Serializable {

    Integer id;
    String nome;
    String endereco;
    String atendimento;

    public Mecanica( String nome, String endereco, String atendimento) {
        this.id = null;
        this.nome = nome;
        this.endereco = endereco;
        this.atendimento = atendimento;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getAtendimento() {
        return atendimento;
    }

    public void setAtendimento(String atendimento) {
        this.atendimento = atendimento;
    }


    @NonNull
    @Override
    public String toString() {

        return getNome() + " - " + getEndereco();


    }
}
