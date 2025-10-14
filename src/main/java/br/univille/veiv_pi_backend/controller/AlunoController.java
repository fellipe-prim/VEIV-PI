package br.univille.veiv_pi_backend.controller;
import br.univille.veiv_pi_backend.DTO.AlunoDTO;
import br.univille.veiv_pi_backend.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    public ResponseEntity<Page<AlunoDTO>> findAll( Pageable pageable) {
        Page<AlunoDTO> dto = alunoService.findAll(pageable);
        return ResponseEntity.ok(dto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<AlunoDTO> findById(@PathVariable Long id) {
        AlunoDTO dto = alunoService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping(value = "/{id}")
    public ResponseEntity<AlunoDTO> insert(@RequestBody AlunoDTO dto){

        dto = alunoService.insert(dto);
        return ResponseEntity.ok(dto);
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<AlunoDTO> update (@PathVariable Long id,@RequestBody AlunoDTO dto){
        AlunoDTO atualizado = alunoService.update(id,dto);
        return ResponseEntity.ok(atualizado);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void>delete (@PathVariable Long id){
        alunoService.delete(id);
        return ResponseEntity.noContent().build();

    }



}
