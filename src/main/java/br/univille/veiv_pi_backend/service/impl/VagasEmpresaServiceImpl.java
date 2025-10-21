package br.univille.veiv_pi_backend.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import br.univille.veiv_pi_backend.DTO.VagasEmpresaDTO;
import br.univille.veiv_pi_backend.entity.VagasEmpresa;
import br.univille.veiv_pi_backend.repository.VagasEmpresaRepository;
import br.univille.veiv_pi_backend.service.VagasEmpresasService;


@Service
public class VagasEmpresaServiceImpl implements VagasEmpresasService {

    @Autowired
    VagasEmpresaRepository vagasEmpresaRepository;

    public Page<VagasEmpresaDTO> findAll (Pageable pageable){

    Page<VagasEmpresa> vagaEmpresa = vagasEmpresaRepository.findAll(pageable);
    return vagaEmpresa.map(x -> toDTO(x));
    }

    public VagasEmpresaDTO findById(Long id){

        VagasEmpresa empresa = vagasEmpresaRepository.findById(id).orElseThrow();
        return toDTO(empresa);

    }

    public VagasEmpresaDTO insert(VagasEmpresaDTO dto) {
       
        VagasEmpresa empresa = toEntity(dto);
        return toDTO(vagasEmpresaRepository.save(empresa));
    }

    public VagasEmpresaDTO update (long id, VagasEmpresaDTO dto){

        VagasEmpresa empresa = vagasEmpresaRepository.findById(id).orElseThrow();
        copyDtoToEntity(empresa, dto);
        return toDTO(vagasEmpresaRepository.save(empresa));

    }

    
    public void delete (long id){

        if (!vagasEmpresaRepository.existsById(id)) {
            throw new RuntimeException("id nao encontrado");
        }
        vagasEmpresaRepository.deleteById(id);
            
        }



    


    private VagasEmpresaDTO toDTO (VagasEmpresa empresa){
        VagasEmpresaDTO dto = new VagasEmpresaDTO();

        dto.setId(empresa.getId());
        dto.setDescricao(empresa.getDescricao());
        dto.setEmpresa(empresa.getEmpresa());
        dto.setRequisitos(empresa.getRequisitos());
        dto.setTituloVaga(empresa.getTituloVaga());
        dto.setEndereco(empresa.getEndereco());
        
        return dto;

    }

    private VagasEmpresa toEntity (VagasEmpresaDTO dto){

        VagasEmpresa empresa = new VagasEmpresa();

        empresa.setEmpresa(dto.getEmpresa());
        empresa.setDescricao(dto.getDescricao());
        empresa.setRequisitos(dto.getRequisitos());
        empresa.setTituloVaga(dto.getTituloVaga());
        empresa.setEndereco(dto.getEndereco());


        return empresa;
        

    }

    public void copyDtoToEntity (VagasEmpresa empresa, VagasEmpresaDTO dto){

        empresa.setEmpresa(dto.getEmpresa());
        empresa.setDescricao(dto.getDescricao());
        empresa.setRequisitos(dto.getRequisitos());
        empresa.setTituloVaga(dto.getTituloVaga());
        empresa.setEndereco(dto.getEndereco());

    }




    // private Long id;
    // private String empresa;
    // private String descricao;
    // private String requisitos;
    // private String tituloVaga;
    // private String endereco;
}
