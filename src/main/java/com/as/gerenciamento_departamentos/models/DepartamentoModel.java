package com.as.gerenciamento_departamentos.models;

import jakarta.persistence.*;

@Entity
@Table(name = "TBL_DEPARTAMENTO")
public class DepartamentoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome_departamento")
    private String nome;
    @Column(name = "localizacao_departamento")
    private String localizacao;

    public DepartamentoModel() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }
}
