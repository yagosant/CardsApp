package com.yago.cardsapp;

public class DadosPersonagens {
    private int incone;
    private String titulo;
    private String descricao;

    public DadosPersonagens(int incone, String titulo, String descricao) {
        this.incone = incone;
        this.titulo = titulo;
        this.descricao = descricao;
    }

    public int getIncone() {
        return incone;
    }

    public void setIncone(int incone) {
        this.incone = incone;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
