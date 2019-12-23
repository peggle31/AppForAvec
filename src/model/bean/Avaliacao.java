/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import java.util.Date;

/**
 *
 * @author Gustavo Crispim
 * 22/12/2019
 */


public class Avaliacao {
    
    private String nome;
    private String sobrenome;
    private long cpf;
    private Date dt_nascimento;
    private String desc_cidade;
    public String desc_categoria;
    private String comentario;
    private int nota;
    private int id_avaliacao;
    private String created_at;

    public int getId_avaliacao() {
        return id_avaliacao;
    }

    public void setId_avaliacao(int id_avaliacao) {
        this.id_avaliacao = id_avaliacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public Date getDt_nascimento() {
        return dt_nascimento;
    }

    public void setDt_nascimento(Date dt_nascimento) {
        this.dt_nascimento = dt_nascimento;
    }

    public String getDesc_cidade() {
        return desc_cidade;
    }

    public void setDesc_cidade(String desc_cidade) {
        this.desc_cidade = desc_cidade;
    }

    public String getDesc_categoria() {
        return desc_categoria;
    }

    public void setDesc_categoria(String desc_categoria) {
        this.desc_categoria = desc_categoria;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }
    
    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String Created_at) {
        this.created_at = Created_at;
    }
    
    @Override
    public String toString() {
        return getDesc_categoria();
    }
    
}
