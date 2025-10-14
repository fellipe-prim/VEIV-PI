package br.univille.veiv_pi_backend.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "tb_curriculo_aluno")
public class CurriculoAluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String sobre;
    private String habilidadesTecnicas;
    private String experienciaProfissional;
    private String previsaoDeConclusao;
    private String Projetos;
    
    @OneToOne
    private Aluno aluno;

    public CurriculoAluno() {}

    public CurriculoAluno(long id, String nome, String sobre, String habilidadesTecnicas, String experienciaProfissional, String previsaoDeConclusao, String projetos, Aluno aluno) {
        this.id = id;
        this.nome = nome;
        this.sobre = sobre;
        this.habilidadesTecnicas = habilidadesTecnicas;
        this.experienciaProfissional = experienciaProfissional;
        this.previsaoDeConclusao = previsaoDeConclusao;
        Projetos = projetos;
        this.aluno = aluno;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
        return Projetos;
    }

    public void setProjetos(String projetos) {
        Projetos = projetos;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
}

