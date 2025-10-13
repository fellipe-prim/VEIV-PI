package br.univille.veiv_pi_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.univille.veiv_pi_backend.entity.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long>{
    

}
