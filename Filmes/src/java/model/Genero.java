/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author aluno
 */
public class Genero {
    private long id;
    private String nome;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public Genero() {
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Genero(long id, String nome) {
        this.id = id;
        this.nome = nome;
    }
}
