package br.com.fiap.clickconnect.model;

import java.util.Random;

public record Mouse(Long id, String nome, String descricao, double preco) {
    public Mouse(Long id, String nome, String descricao, double preco){
        this.id = Math.abs(new Random().nextLong());
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
    }
}
