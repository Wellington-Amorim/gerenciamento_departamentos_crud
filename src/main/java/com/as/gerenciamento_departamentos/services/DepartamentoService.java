package com.as.gerenciamento_departamentos.services;

import com.as.gerenciamento_departamentos.models.DepartamentoModel;
import com.as.gerenciamento_departamentos.repositories.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartamentoService {

    @Autowired
    private DepartamentoRepository departamentoRepository;

    public DepartamentoModel criar(DepartamentoModel departamentoModel) {
        return departamentoRepository.save(departamentoModel);
    }

    public List<DepartamentoModel> listar() {
        return departamentoRepository.findAll();
    }

    public Optional<DepartamentoModel> buscarId(Long id) {
        return departamentoRepository.findById(id);
    }

    public DepartamentoModel atualizar(Long id, DepartamentoModel departamentoModel) {
        DepartamentoModel model = departamentoRepository.findById(id).get();
        model.setNome(departamentoModel.getNome());
        model.setLocalizacao(departamentoModel.getLocalizacao());
        return departamentoRepository.save(model);
    }

    public void deletar(Long id) {
        departamentoRepository.deleteById(id);
    }
}