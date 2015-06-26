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
public class Filme {
    private long id;
    private String titulo, direcao, elenco, sinopse, linkTrailer;
    private int duracaoMinutos;
    private Genero genero;
    private Classificacao classificacao;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDirecao() {
        return direcao;
    }

    public void setDirecao(String direcao) {
        this.direcao = direcao;
    }

    public String getElenco() {
        return elenco;
    }

    public void setElenco(String elenco) {
        this.elenco = elenco;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public String getLinkTrailer() {
        return linkTrailer;
    }

    public void setLinkTrailer(String linkTrailer) {
        this.linkTrailer = linkTrailer;
    }

    public int getDuracaoMinutos() {
        return duracaoMinutos;
    }

    public void setDuracaoMinutos(int duracaoMinutos) {
        this.duracaoMinutos = duracaoMinutos;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Filme{" + "id=" + id + ", titulo=" + titulo + ", direcao=" + direcao + ", elenco=" + elenco + ", sinopse=" + sinopse + ", linkTrailer=" + linkTrailer + ", duracaoMinutos=" + duracaoMinutos + ", genero=" + genero.getNome() + ", classificacao=" + classificacao.getDescricao() + '}';
    }

    public Classificacao getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(Classificacao classificacao) {
        this.classificacao = classificacao;
    }

    public Filme(long id, String titulo, String direcao, String elenco, String sinopse, String linkTrailer, int duracaoMinutos, Genero genero, Classificacao classificacao) {
        this.id = id;
        this.titulo = titulo;
        this.direcao = direcao;
        this.elenco = elenco;
        this.sinopse = sinopse;
        this.linkTrailer = linkTrailer;
        this.duracaoMinutos = duracaoMinutos;
        this.genero = genero;
        this.classificacao = classificacao;
    }

    public Filme() {
    }
    
}
