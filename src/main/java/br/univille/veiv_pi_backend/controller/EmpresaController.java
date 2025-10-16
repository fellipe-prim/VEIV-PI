package br.univille.veiv_pi_backend.controller;


import br.univille.veiv_pi_backend.DTO.EmpresaDTO;

import br.univille.veiv_pi_backend.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpresaController {

    @Autowired
    EmpresaService empresaService;

    public ResponseEntity<Page<EmpresaDTO>> findAll (Pageable pageable){
        Page<EmpresaDTO> empresa = empresaService.findAll(pageable);
        return ResponseEntity.ok(empresa);

    }

    public ResponseEntity <EmpresaDTO> findById (@PathVariable Long id){

        EmpresaDTO dto = empresaService.findById(id);
        return ResponseEntity.ok(dto);

    }

    public ResponseEntity<EmpresaDTO> insert (@RequestBody EmpresaDTO dto){

        dto = empresaService.insert(dto);
        return ResponseEntity.ok(dto);

    }


    public ResponseEntity<EmpresaDTO> update (@PathVariable Long id, @RequestBody EmpresaDTO dto){
        EmpresaDTO atualizado = empresaService.update(id, dto);
        return ResponseEntity.ok(atualizado);

    }

    public ResponseEntity<Void> delete (@PathVariable Long id){
        empresaService.delete(id);
        return ResponseEntity.noContent().build();

    }


}
