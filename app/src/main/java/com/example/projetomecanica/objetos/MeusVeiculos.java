package com.example.projetomecanica.objetos;

import java.io.Serializable;
import java.util.ArrayList;

public class MeusVeiculos implements Serializable {
    private ArrayList<Veiculo> meusVeiculos;
    private Integer totalVeiculos;

    public MeusVeiculos() {
    }

    public MeusVeiculos(ArrayList<Veiculo> meusVeiculos) {
        this.meusVeiculos = meusVeiculos;
        this.totalVeiculos = meusVeiculos.size();
    }

    public Veiculo getVeiculoByIndex(Integer index){
        return this.meusVeiculos.get(index);
    }

    public ArrayList<Veiculo> getMeusVeiculos() {
        return meusVeiculos;
    }

    public void setMeusVeiculos(ArrayList<Veiculo> meusVeiculos) {
        this.meusVeiculos = meusVeiculos;
    }

    public Integer getTotalVeiculos() {
        return totalVeiculos;
    }

    public void setTotalVeiculos(Integer totalVeiculos) {
        this.totalVeiculos = totalVeiculos;
    }
}


