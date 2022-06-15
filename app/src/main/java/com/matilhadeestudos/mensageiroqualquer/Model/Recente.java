package com.matilhadeestudos.mensageiroqualquer.Model;

public class Recente {
    private String nome, mensagem, hora;
    private int imagem;

    public Recente() {}

    public Recente(String nome, String mensagem, int imagem, String hora) {
        this.nome = nome;
        this.mensagem = mensagem;
        this.imagem = imagem;
        this.hora = hora;
    }

    public String getNome() {
        return nome;
    }


    public String getMensagem() {
        return mensagem;
    }


    public int getImagem() {
        return imagem;
    }

    public String getHora() {
        return hora;
    }
}
