package br.univille.veiv_pi_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.veiv_pi_backend.entity.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long>{
    
}
