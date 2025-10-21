package br.univille.veiv_pi_backend.service.impl;
import br.univille.veiv_pi_backend.DTO.CurriculoAlunoDTO;
import br.univille.veiv_pi_backend.entity.CurriculoAluno;
import br.univille.veiv_pi_backend.repository.CurriculoAlunoRepository;
import br.univille.veiv_pi_backend.service.CurriculoAlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CurriculoAlunoImpl implements CurriculoAlunoService {

    @Autowired
    CurriculoAlunoRepository curriculoAlunoRepository;



    public Page<CurriculoAlunoDTO> findAll (Pageable pageable){
        Page<CurriculoAluno> curriculo = curriculoAlunoRepository.findAll(pageable);
        return curriculo.map(x->toDTO(x));

    }

    public CurriculoAlunoDTO findById (Long id){
        CurriculoAluno curriculo = curriculoAlunoRepository.findById(id).orElseThrow();
        return toDTO(curriculo);
    }

    public CurriculoAlunoDTO insert (CurriculoAlunoDTO dto){

        CurriculoAluno curriculoAluno = toEntity(dto);
        return toDTO(curriculoAlunoRepository.save(curriculoAluno));

    }

    public CurriculoAlunoDTO update (Long id, CurriculoAlunoDTO dto){
        CurriculoAluno curriculoAluno = curriculoAlunoRepository.findById(id).orElseThrow();
        copyDtoToEntity(dto,curriculoAluno);
        return toDTO(curriculoAlunoRepository.save(curriculoAluno));

    }

    public void delete (Long id){

        if (!curriculoAlunoRepository.existsById(id)){
            throw new RuntimeException("id nao encontrado");

        }
        curriculoAlunoRepository.deleteById(id);

    }

    private void copyDtoToEntity (CurriculoAlunoDTO dto, CurriculoAluno curriculoAluno){

        curriculoAluno.setNome(dto.getNome());
        curriculoAluno.setSobre(dto.getSobre());
        curriculoAluno.setExperienciaProfissional(dto.getExperienciaProfissional());
        curriculoAluno.setPrevisaoDeConclusao(dto.getPrevisaoDeConclusao());
        curriculoAluno.setHabilidadesTecnicas(dto.getHabilidadesTecnicas());
        curriculoAluno.setProjetos(dto.getProjetos());


    }

    private CurriculoAluno toEntity (CurriculoAlunoDTO dto){


        CurriculoAluno curriculoAluno = new CurriculoAluno();

        curriculoAluno.setId(dto.getId());
        curriculoAluno.setNome(dto.getNome());
        curriculoAluno.setSobre(dto.getSobre());
        curriculoAluno.setExperienciaProfissional(dto.getExperienciaProfissional());
        curriculoAluno.setHabilidadesTecnicas(dto.getHabilidadesTecnicas());
        curriculoAluno.setPrevisaoDeConclusao(dto.getPrevisaoDeConclusao());
        curriculoAluno.setProjetos(dto.getProjetos());

        return curriculoAluno;
    }

    private CurriculoAlunoDTO toDTO (CurriculoAluno curriculoAluno){
        CurriculoAlunoDTO dto = new CurriculoAlunoDTO();

        dto.setId(curriculoAluno.getId());
        dto.setNome(curriculoAluno.getNome());
        dto.setSobre(curriculoAluno.getSobre());
        dto.setExperienciaProfissional(curriculoAluno.getExperienciaProfissional());
        dto.setHabilidadesTecnicas(curriculoAluno.getHabilidadesTecnicas());
        dto.setPrevisaoDeConclusao(curriculoAluno.getPrevisaoDeConclusao());
        dto.setProjetos(curriculoAluno.getProjetos());

        return dto;
    }

}
