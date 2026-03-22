package com.as.gerenciamento_departamentos.repositories;

import com.as.gerenciamento_departamentos.models.DepartamentoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartamentoRepository extends JpaRepository<DepartamentoModel, Long> {
}
