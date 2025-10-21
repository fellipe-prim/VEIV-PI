package br.univille.veiv_pi_backend.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.univille.veiv_pi_backend.DTO.VagasEmpresaDTO;
import br.univille.veiv_pi_backend.service.VagasEmpresasService;

@RestController
@RequestMapping("/api/v1/vagasEmpresa")
public class VagasEmpresaController {

    @Autowired
    VagasEmpresasService vagasEmpresasService;

     @GetMapping
    public ResponseEntity<Page<VagasEmpresaDTO>> findAll (Pageable pageable){

        Page <VagasEmpresaDTO> dto = vagasEmpresasService.findAll(pageable);
        return ResponseEntity.ok(dto);

    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<VagasEmpresaDTO> findById (@PathVariable Long id){

        VagasEmpresaDTO dto = vagasEmpresasService.findById(id);
        return ResponseEntity.ok(dto);

    }

    @PostMapping
    public ResponseEntity <VagasEmpresaDTO> insert (@RequestBody VagasEmpresaDTO dto){

        dto = vagasEmpresasService.insert(dto);
        return ResponseEntity.ok(dto);

    }

    @PutMapping(value =  "/{id}")
    public ResponseEntity <VagasEmpresaDTO> update (@PathVariable long id, @RequestBody VagasEmpresaDTO dto){

        VagasEmpresaDTO atualizado = vagasEmpresasService.update(id, dto);
        return ResponseEntity.ok(atualizado);

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id){

        vagasEmpresasService.delete(id);
        return ResponseEntity.noContent().build();

    }
    

}
