package com.example.anafl.projetofirebase.Entidades;

public class Prato {

    private String idVendedor; // id do prato é o mesmo id do vendedor
    private String nome;
    private float preco;
    private String descricao;

    public Prato (){

    }
    public Prato(String nome){
        this.nome = nome;
        this.preco = (float) 13.5;
        this.descricao = "Arroz e feijão";

    }

    public String getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(String idVendedor) {
        this.idVendedor = idVendedor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


}
