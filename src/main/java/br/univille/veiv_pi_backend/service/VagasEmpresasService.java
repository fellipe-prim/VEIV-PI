package br.univille.veiv_pi_backend.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.univille.veiv_pi_backend.DTO.VagasEmpresaDTO;

public interface VagasEmpresasService {
    VagasEmpresaDTO insert (VagasEmpresaDTO dto);
    VagasEmpresaDTO update (long id, VagasEmpresaDTO dto);
    void delete (long id);
    
    VagasEmpresaDTO findById (Long id);
    Page <VagasEmpresaDTO> findAll (Pageable pageable);


}
