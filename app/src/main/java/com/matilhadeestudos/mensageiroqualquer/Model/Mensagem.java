package com.matilhadeestudos.mensageiroqualquer.Model;

public class Mensagem {
    Boolean destinatario;
    String mensagem, nome;

    public Mensagem() {
    }

    public Boolean getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(Boolean destinatario) {
        this.destinatario = destinatario;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
