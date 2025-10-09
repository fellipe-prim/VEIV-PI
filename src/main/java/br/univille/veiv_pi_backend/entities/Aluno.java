package br.univille.veiv_pi_backend.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "tb_aluno")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeCompleto;
    private String cpf;
    private String telefone;
    private String email;
    private String endereco;
    private String curso;

    @OneToOne(mappedBy = "aluno", cascade = CascadeType.ALL)
    private CurriculoAluno curriculo;

    @OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL)
    private List<VagasEmpresa> vagasEmprego;

    public Aluno() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public CurriculoAluno getCurriculo() {
        return curriculo;
    }

    public void setCurriculo(CurriculoAluno curriculo) {
        this.curriculo = curriculo;
    }

    public List<VagasEmpresa> getVagasEmprego() {
        return vagasEmprego;
    }

    public void setVagasEmprego(List<VagasEmpresa> vagasEmprego) {
        this.vagasEmprego = vagasEmprego;
    }
}
