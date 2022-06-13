package com.matilhadeestudos.mensageiroqualquer.Model;

public class Contato {
    private String Nome, email;
    private int imagem;

    public Contato(){
    }

    public Contato (String Nome, String Email, int imagem) {
        this.Nome = Nome;
        this.email = Email;
        this.imagem = imagem;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }
}
