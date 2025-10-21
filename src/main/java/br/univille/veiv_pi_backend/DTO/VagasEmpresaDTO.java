package br.univille.veiv_pi_backend.DTO;

public class VagasEmpresaDTO {

    private Long id;
    private String empresa;
    private String descricao;
    private String requisitos;
    private String tituloVaga;
    private String endereco;

    public VagasEmpresaDTO (){}

    

    public VagasEmpresaDTO(Long id, String empresa, String descricao, String requisitos, String tituloVaga,
            String endereco) {
        this.id = id;
        this.empresa = empresa;
        this.descricao = descricao;
        this.requisitos = requisitos;
        this.tituloVaga = tituloVaga;
        this.endereco = endereco;
    }



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



    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((empresa == null) ? 0 : empresa.hashCode());
        result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
        result = prime * result + ((requisitos == null) ? 0 : requisitos.hashCode());
        result = prime * result + ((tituloVaga == null) ? 0 : tituloVaga.hashCode());
        result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
        return result;
    }



    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        VagasEmpresaDTO other = (VagasEmpresaDTO) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (empresa == null) {
            if (other.empresa != null)
                return false;
        } else if (!empresa.equals(other.empresa))
            return false;
        if (descricao == null) {
            if (other.descricao != null)
                return false;
        } else if (!descricao.equals(other.descricao))
            return false;
        if (requisitos == null) {
            if (other.requisitos != null)
                return false;
        } else if (!requisitos.equals(other.requisitos))
            return false;
        if (tituloVaga == null) {
            if (other.tituloVaga != null)
                return false;
        } else if (!tituloVaga.equals(other.tituloVaga))
            return false;
        if (endereco == null) {
            if (other.endereco != null)
                return false;
        } else if (!endereco.equals(other.endereco))
            return false;
        return true;
    }

    

}
