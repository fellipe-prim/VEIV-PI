package br.univille.veiv_pi_backend.service.impl;


import br.univille.veiv_pi_backend.DTO.AlunoDTO;
import br.univille.veiv_pi_backend.entity.Aluno;
import br.univille.veiv_pi_backend.repository.AlunoRepository;
import br.univille.veiv_pi_backend.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AlunoServiceImpl implements AlunoService {


    @Autowired
    AlunoRepository alunoRepository;


    public Page<AlunoDTO> findAll (Pageable pageable) {
        Page<Aluno> result = alunoRepository.findAll(pageable);
        return result.map(x-> toDTO(x));
    }

    public AlunoDTO findById(Long id) {
        Aluno aluno =  alunoRepository.findById(id).orElseThrow();
        return toDTO(aluno);
    }

    public AlunoDTO insert (AlunoDTO dto){

        Aluno aluno = toEntity(dto);
        return toDTO(alunoRepository.save(aluno));
    }

    public AlunoDTO update (Long id, AlunoDTO dto){
        Aluno aluno = alunoRepository.findById(id).orElseThrow();
        copyToEntity(aluno,dto);
        return toDTO(alunoRepository.save(aluno));

    }

    public void delete (Long id) {

        if (!alunoRepository.existsById(id)) {
            throw new RuntimeException("id nao encontrado");

        } alunoRepository.deleteById(id);
    }


    private AlunoDTO toDTO(Aluno aluno) {
        AlunoDTO dto = new AlunoDTO();

        dto.setId(aluno.getId());
        dto.setCpf(aluno.getCpf());
        dto.setEmail(aluno.getEmail());
        dto.setTelefone(aluno.getTelefone());
        dto.setEndereco(aluno.getEndereco());
        dto.setCurso(aluno.getCurso());

        return dto;
    }

    private Aluno toEntity(AlunoDTO dto){

        Aluno aluno = new Aluno();

        aluno.setId(dto.getId());
        aluno.setNomeCompleto(dto.getNomeCompleto());
        aluno.setCpf(dto.getCpf());
        aluno.setTelefone(dto.getTelefone());
        aluno.setEmail(dto.getEmail());
        aluno.setEndereco(aluno.getEndereco());
        aluno.setCurso(dto.getCurso());
        return aluno;

    }

    private void copyToEntity (Aluno aluno, AlunoDTO dto){

        aluno.setNomeCompleto(dto.getNomeCompleto());
        aluno.setCpf(dto.getCpf());
        aluno.setTelefone(dto.getTelefone());
        aluno.setEmail(dto.getEmail());
        aluno.setEndereco(dto.getEndereco());
        aluno.setCurso(dto.getCurso());

    }

}
//    private Long id;
//    private String nomeCompleto;
//    private String cpf;
//    private String telefone;
//    private String email;
//    private String endereco;
//    private String curso;
