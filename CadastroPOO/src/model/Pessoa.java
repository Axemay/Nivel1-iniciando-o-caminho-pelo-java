package model;

import java.io.Serializable;

public class Pessoa implements Serializable {
    private int id;
    private String nome;

    public Pessoa(int id, String nome){
        this.nome = nome;
        this.id = id;
    }

    public void exibir(){
        System.out.println("Id: "+this.getId());
        System.out.println("Nome: "+this.getNome());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
