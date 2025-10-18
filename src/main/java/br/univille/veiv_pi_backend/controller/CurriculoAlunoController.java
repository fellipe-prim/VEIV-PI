package br.univille.veiv_pi_backend.controller;
import br.univille.veiv_pi_backend.DTO.CurriculoAlunoDTO;
import br.univille.veiv_pi_backend.service.CurriculoAlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/curriculos")
public class CurriculoAlunoController {

    @Autowired
    CurriculoAlunoService curriculoAlunoService;

    @GetMapping
    public ResponseEntity<Page<CurriculoAlunoDTO>> findAll (Pageable pageable){
        Page<CurriculoAlunoDTO> dto = curriculoAlunoService.findAll(pageable);
        return ResponseEntity.ok(dto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CurriculoAlunoDTO> findById (@PathVariable Long id) {

        CurriculoAlunoDTO dto = curriculoAlunoService.findById(id);
        return ResponseEntity.ok(dto);

    }

    @PostMapping
    public ResponseEntity<CurriculoAlunoDTO> insert (@RequestBody CurriculoAlunoDTO dto){

        dto = curriculoAlunoService.insert(dto);
        return ResponseEntity.ok(dto);

    }
    @PutMapping(value =  "/{id}")
    public ResponseEntity<CurriculoAlunoDTO> update (@PathVariable Long id,@RequestBody CurriculoAlunoDTO dto){

        CurriculoAlunoDTO atualizado = curriculoAlunoService.update(id, dto);
        return ResponseEntity.ok(atualizado);

    }
    @DeleteMapping(value =  "/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id){

        curriculoAlunoService.delete(id);
        return ResponseEntity.noContent().build();

    }



}
