package br.univille.veiv_pi_backend.controller;
import br.univille.veiv_pi_backend.DTO.EmpresaDTO;
import br.univille.veiv_pi_backend.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/empresas")
public class EmpresaController {

    @Autowired
    EmpresaService empresaService;

    @GetMapping
    public ResponseEntity<Page<EmpresaDTO>> findAll (Pageable pageable){
        Page<EmpresaDTO> empresa = empresaService.findAll(pageable);
        return ResponseEntity.ok(empresa);

    }

    @GetMapping(value = "/{id}")
    public ResponseEntity <EmpresaDTO> findById (@PathVariable Long id){

        EmpresaDTO dto = empresaService.findById(id);
        return ResponseEntity.ok(dto);

    }

    @PostMapping
    public ResponseEntity<EmpresaDTO> insert (@RequestBody EmpresaDTO dto){

        dto = empresaService.insert(dto);
        return ResponseEntity.ok(dto);

    }

    @PutMapping(value =  "/{id}")
    public ResponseEntity<EmpresaDTO> update (@PathVariable Long id, @RequestBody EmpresaDTO dto){
        EmpresaDTO atualizado = empresaService.update(id, dto);
        return ResponseEntity.ok(atualizado);

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id){
        empresaService.delete(id);
        return ResponseEntity.noContent().build();

    }


}
