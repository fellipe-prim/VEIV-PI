package br.univille.veiv_pi_backend.service;

import br.univille.veiv_pi_backend.DTO.EmpresaDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface EmpresaService {

    EmpresaDTO insert (EmpresaDTO dto);
    EmpresaDTO update (Long id,EmpresaDTO dto);
    void delete (Long id);

    Page<EmpresaDTO> findAll (Pageable pageable);
    EmpresaDTO findById (Long id);

}
