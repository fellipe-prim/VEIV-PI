package br.univille.veiv_pi_backend.repositories;

import br.univille.veiv_pi_backend.entities.CurriculoAluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurriculoAlunoRepository extends JpaRepository<CurriculoAluno, Long> { }
