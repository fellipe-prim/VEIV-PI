package br.univille.veiv_pi_backend.service;
import br.univille.veiv_pi_backend.DTO.CurriculoAlunoDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CurriculoAlunoService {
    CurriculoAlunoDTO insert (CurriculoAlunoDTO dto);
    CurriculoAlunoDTO update (Long id,CurriculoAlunoDTO dto);
    void delete (Long id);

    Page<CurriculoAlunoDTO> findAll(Pageable pageable);
    CurriculoAlunoDTO findById (Long id);

}
