package com.example.projetomecanica.objetos;

import java.io.Serializable;

public class Chamados implements Serializable {


    Integer id_moto;
    Integer id;
    String descricao;

    public Chamados(String descricao) {
        this.descricao = descricao;
        this.id = null;

    }

    public Integer getId_moto() {
        return id_moto;
    }

    public void setId_moto(Integer id_moto) {
        this.id_moto = id_moto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {

        return getDescricao();


    }
}
