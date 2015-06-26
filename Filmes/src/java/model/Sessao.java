/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Calendar;

/**
 *
 * @author aluno
 */
public class Sessao {
    private long id;

    public Sessao(long id, Filme filme, Calendar horario, double valorAdulto, double valorEstudante, double valorIdoso, boolean is3d, boolean isLegendado, int sala) {
        this.id = id;
        this.filme = filme;
        this.horario = horario;
        this.valorAdulto = valorAdulto;
        this.valorEstudante = valorEstudante;
        this.valorIdoso = valorIdoso;
        this.is3d = is3d;
        this.isLegendado = isLegendado;
        this.sala = sala;
    }

    @Override
    public String toString() {
        return "Sessao{" + "id=" + id + ", filme=" + filme + ", horario=" + horario + ", valorAdulto=" + valorAdulto + ", valorEstudante=" + valorEstudante + ", valorIdoso=" + valorIdoso + ", is3d=" + is3d + ", isLegendado=" + isLegendado + ", sala=" + sala + '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    private Filme filme;
    private Calendar horario;
    private double valorAdulto, valorEstudante, valorIdoso;
    private boolean is3d;
    private boolean isLegendado;
    private int sala;

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public Calendar getHorario() {
        return horario;
    }

    public void setHorario(Calendar horario) {
        this.horario = horario;
    }

    public Sessao() {
    }

    public double getValorAdulto() {
        return valorAdulto;
    }

    public void setValorAdulto(double valorAdulto) {
        this.valorAdulto = valorAdulto;
    }

    public double getValorEstudante() {
        return valorEstudante;
    }

    public void setValorEstudante(double valorEstudante) {
        this.valorEstudante = valorEstudante;
    }

    public double getValorIdoso() {
        return valorIdoso;
    }

    public void setValorIdoso(double valorIdoso) {
        this.valorIdoso = valorIdoso;
    }

    public boolean isIs3d() {
        return is3d;
    }

    public void setIs3d(boolean is3d) {
        this.is3d = is3d;
    }

    public boolean isIsLegendado() {
        return isLegendado;
    }

    public void setIsLegendado(boolean isLegendado) {
        this.isLegendado = isLegendado;
    }

    public int getSala() {
        return sala;
    }

    public void setSala(int sala) {
        this.sala = sala;
    }
}
