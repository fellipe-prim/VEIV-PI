package br.univille.veiv_pi_backend.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "tb_vaga_empresa")
public class VagasEmpresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String empresa;
    private String descricao;
    private String requisitos;
    private String tituloVaga;
    private String endereco;

    
    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresaEntity;

    public VagasEmpresa() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getRequisitos() {
        return requisitos;
    }

    public void setRequisitos(String requisitos) {
        this.requisitos = requisitos;
    }

    public String getTituloVaga() {
        return tituloVaga;
    }

    public void setTituloVaga(String tituloVaga) {
        this.tituloVaga = tituloVaga;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Empresa getEmpresaEntity() {
        return empresaEntity;
    }

    public void setEmpresaEntity(Empresa empresaEntity) {
        this.empresaEntity = empresaEntity;
    }


    
}
