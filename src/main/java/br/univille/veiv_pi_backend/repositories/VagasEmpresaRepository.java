package br.univille.veiv_pi_backend.repositories;

import br.univille.veiv_pi_backend.entities.VagasEmpresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VagasEmpresaRepository extends JpaRepository<VagasEmpresa, Long> { }
