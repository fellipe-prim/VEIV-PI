package br.univille.veiv_pi_backend.service;

import br.univille.veiv_pi_backend.DTO.AlunoDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AlunoService {

    AlunoDTO insert(AlunoDTO dto);
    AlunoDTO update (Long id, AlunoDTO dto);
    void delete (Long id);

    Page <AlunoDTO> findAll(Pageable pageable);
    AlunoDTO findById(Long id);
}
