package br.univille.veiv_pi_backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_curriculo_aluno")
public class CurriculoAluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String sobre;
    private String habilidadesTecnicas;
    private String experienciaProfissional;
    private String previsaoDeConclusao;
    private String projetos;

    @OneToOne(mappedBy = "curriculo")
    private Aluno aluno;

    public CurriculoAluno() {}

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

    public String getSobre() {
        return sobre;
    }

    public void setSobre(String sobre) {
        this.sobre = sobre;
    }

    public String getHabilidadesTecnicas() {
        return habilidadesTecnicas;
    }

    public void setHabilidadesTecnicas(String habilidadesTecnicas) {
        this.habilidadesTecnicas = habilidadesTecnicas;
    }

    public String getExperienciaProfissional() {
        return experienciaProfissional;
    }

    public void setExperienciaProfissional(String experienciaProfissional) {
        this.experienciaProfissional = experienciaProfissional;
    }

    public String getPrevisaoDeConclusao() {
        return previsaoDeConclusao;
    }

    public void setPrevisaoDeConclusao(String previsaoDeConclusao) {
        this.previsaoDeConclusao = previsaoDeConclusao;
    }

    public String getProjetos() {
        return projetos;
    }

    public void setProjetos(String projetos) {
        this.projetos = projetos;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
}
