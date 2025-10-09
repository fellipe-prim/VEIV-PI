package br.univille.veiv_pi_backend.repositories;

import br.univille.veiv_pi_backend.entities.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> { }
