package br.univille.veiv_pi_backend.service.impl;
import br.univille.veiv_pi_backend.DTO.EmpresaDTO;
import br.univille.veiv_pi_backend.entity.Empresa;
import br.univille.veiv_pi_backend.repository.EmpresaRepository;
import br.univille.veiv_pi_backend.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EmpresaServiceImpl implements EmpresaService {

    @Autowired
    EmpresaRepository empresaRepository;


    public Page<EmpresaDTO> findAll (Pageable pageable) {
        Page<Empresa> empresa = empresaRepository.findAll(pageable);
        return empresa.map(x -> toDTO(x));
    }


    public EmpresaDTO findById (Long id){

        Empresa empresa = empresaRepository.findById(id).orElseThrow();
        return toDTO(empresa);

    }

    public EmpresaDTO insert (EmpresaDTO dto){
        Empresa empresa = toEntity(dto);
        return toDTO(empresaRepository.save(empresa));

    }

    public EmpresaDTO update (Long id, EmpresaDTO dto){

        Empresa empresa = empresaRepository.findById(id).orElseThrow();
        copyDtoToEntity(empresa,dto);
        return toDTO(empresaRepository.save(empresa));
    }

    public void delete (Long id){
        if (!empresaRepository.existsById(id)){

            throw new RuntimeException("id nao encontrado");
        }
        empresaRepository.deleteById(id);

    }


    private void copyDtoToEntity (Empresa empresa, EmpresaDTO dto){

        empresa.setNomeEmpresa(dto.getNomeEmpresa());
        empresa.setEndereco(dto.getEndereco());
        empresa.setTelefone(dto.getTelefone());
        empresa.setEmail(dto.getEmail());
        empresa.setCnpj(dto.getCnpj());

    }

    private Empresa toEntity (EmpresaDTO dto){
        Empresa empresa = new Empresa();

        empresa.setNomeEmpresa(dto.getNomeEmpresa());
        empresa.setCnpj(dto.getCnpj());
        empresa.setEmail(dto.getEmail());
        empresa.setTelefone(dto.getTelefone());
        empresa.setEndereco(dto.getEndereco());
        return  empresa;
    }

    private EmpresaDTO toDTO (Empresa empresa){
        EmpresaDTO dto = new EmpresaDTO();

        dto.setId(empresa.getId());
        dto.setNomeEmpresa(empresa.getNomeEmpresa());
        dto.setCnpj(empresa.getCnpj());
        dto.setEmail(empresa.getEmail());
        dto.setTelefone(empresa.getTelefone());
        dto.setEndereco(empresa.getEndereco());
        return dto;

    }
}
//    private Long id;
//    private String nomeEmpresa;
//    private String cnpj;
//    private String email;
//    private String telefone;
//    private String endereco;