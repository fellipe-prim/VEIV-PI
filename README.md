
#

```mermaid
---
title: Diagrama de Entidades - Sistema de Currículos e Vagas
---

classDiagram
    Empresa "1" --> "*" VagaDeEmprego : oferece
    Aluno "1" --> "1" Curriculo : possui
    Aluno "1" --> "*" ContratoDeEmprego : celebra
    VagaDeEmprego "*" --> "1" ContratoDeEmprego : gera

    namespace entity {

      class Empresa {
          -cnpj : String
          -nome : String
          -endereco : String
          -email : String
          -telefone : String

          +getCnpj() String
          +setCnpj(cnpj:String) void
          +getNome() String
          +setNome(nome:String) void
          +getEndereco() String
          +setEndereco(endereco:String) void
          +getEmail() String
          +setEmail(email:String) void
          +getTelefone() String
          +setTelefone(telefone:String) void
      }

      class VagaDeEmprego {
          -codVaga : Long
          -titulo : String
          -areaDepartamento : String
          -cargaHoraria : String
          -duracao : String
          -endereco : String
          -descricaoAtividade : String
          -requisitosVaga : String

          +getCodVaga() Long
          +setCodVaga(codVaga:Long) void
          +getTitulo() String
          +setTitulo(titulo:String) void
          +getAreaDepartamento() String
          +setAreaDepartamento(areaDepartamento:String) void
          +getCargaHoraria() String
          +setCargaHoraria(cargaHoraria:String) void
          +getDuracao() String
          +setDuracao(duracao:String) void
          +getEndereco() String
          +setEndereco(endereco:String) void
          +getDescricaoAtividade() String
          +setDescricaoAtividade(descricaoAtividade:String) void
          +getRequisitosVaga() String
          +setRequisitosVaga(requisitosVaga:String) void
      }

      class Aluno {
          -cpf : String
          -nomeCompleto : String
          -endereco : String
          -email : String
          -telefone : String
          -curso : String

          +getCpf() String
          +setCpf(cpf:String) void
          +getNomeCompleto() String
          +setNomeCompleto(nomeCompleto:String) void
          +getEndereco() String
          +setEndereco(endereco:String) void
          +getEmail() String
          +setEmail(email:String) void
          +getTelefone() String
          +setTelefone(telefone:String) void
          +getCurso() String
          +setCurso(curso:String) void
      }

      class Curriculo {
          -codCv : Long
          -sobreMim : String
          -periodoLetivo : String
          -previsaoConclusao : String
          -habilidadesTecnicas : String
          -habilidadesInterpessoais : String
          -experienciaProfissional : String
          -projetosAcademicosOuPessoais : String

          +getCodCv() Long
          +setCodCv(codCv:Long) void
          +getSobreMim() String
          +setSobreMim(sobreMim:String) void
          +getPeriodoLetivo() String
          +setPeriodoLetivo(periodoLetivo:String) void
          +getPrevisaoConclusao() String
          +setPrevisaoConclusao(previsaoConclusao:String) void
          +getHabilidadesTecnicas() String
          +setHabilidadesTecnicas(habilidadesTecnicas:String) void
          +getHabilidadesInterpessoais() String
          +setHabilidadesInterpessoais(habilidadesInterpessoais:String) void
          +getExperienciaProfissional() String
          +setExperienciaProfissional(experienciaProfissional:String) void
          +getProjetosAcademicosOuPessoais() String
          +setProjetosAcademicosOuPessoais(projetosAcademicosOuPessoais:String) void
      }

      class ContratoDeEmprego {
          -id : Long
          -aluno : Aluno
          -vaga : VagaDeEmprego
          -dataInicio : LocalDate
          -dataFim : LocalDate
          -status : String

          +getId() Long
          +setId(id:Long) void
          +getAluno() Aluno
          +setAluno(aluno:Aluno) void
          +getVaga() VagaDeEmprego
          +setVaga(vaga:VagaDeEmprego) void
          +getDataInicio() LocalDate
          +setDataInicio(dataInicio:LocalDate) void
          +getDataFim() LocalDate
          +setDataFim(dataFim:LocalDate) void
          +getStatus() String
          +setStatus(status:String) void
      }
    }