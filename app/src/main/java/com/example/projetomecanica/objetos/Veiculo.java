package com.example.projetomecanica.objetos;

import androidx.annotation.NonNull;

import java.io.Serializable;
import java.util.Locale;

public class Veiculo implements Serializable {
    private Integer id;
    private String apelido;
    private String marca;
    private String modelo;
    private String placa;
    private String ano;
    private String quilometragem;


    public Veiculo(){

    }

    public Veiculo(String apelido, String marca, String modelo, String placa, String ano, String quilometragem) {
        this.apelido = apelido;
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa.toUpperCase(Locale.ROOT);
        this.ano = ano;
        this.quilometragem = quilometragem;
        this.id = null;
    }




    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(String quilometragem) {
        this.quilometragem = quilometragem; }


    @NonNull
    @Override
    public String toString() {

        return getApelido() + " - " + getMarca() + " - " + getModelo() + " - " + getPlaca();


    }
}
