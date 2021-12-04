package com.example.projetomecanica.objetos;

import java.io.Serializable;

public class Usuario implements Serializable {

    Integer id;
    String nome;
    String user;
    String senha;
    boolean isAdministrator;
    boolean isActive;


    public Usuario(){

    }

    public Usuario(String nome, String user, String senha, boolean isAdministrator) {
        this.id = null;
        this.nome = nome;
        this.user = user;
        this.senha = senha;
        this.isAdministrator = isAdministrator;
        this.isActive = true;
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

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isAdministrator() {
        return isAdministrator;
    }

    public void setAdministrator(boolean administrator) {
        isAdministrator = administrator;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
