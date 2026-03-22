package com.as.gerenciamento_departamentos.controllers;

import com.as.gerenciamento_departamentos.models.DepartamentoModel;
import com.as.gerenciamento_departamentos.services.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/departamentos")
public class DepartamentoController {

    @Autowired
    private DepartamentoService departamentoService;

    @PostMapping
    public ResponseEntity<DepartamentoModel> criar(@RequestBody DepartamentoModel departamentoModel){
        DepartamentoModel departamento = departamentoService.criar(departamentoModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(departamentoModel.getId())
                .toUri();
        return ResponseEntity.created(uri).body(departamento);
    }

    @GetMapping
    public ResponseEntity<List<DepartamentoModel>> listar() {
        List<DepartamentoModel> departamentos = departamentoService.listar();
        return ResponseEntity.ok().body(departamentos);
    }

    @GetMapping("/{id}")
    public Optional<DepartamentoModel> buscarId(@PathVariable Long id) {
        return departamentoService.buscarId(id);
    }

    @PutMapping("/{id}")
    public DepartamentoModel atualizar(@PathVariable Long id, @RequestBody DepartamentoModel departamentoModel) {
        return departamentoService.atualizar(id, departamentoModel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        departamentoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
