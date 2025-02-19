package io.github.untalsanders.afrominga.domain.repository;

import io.github.untalsanders.afrominga.domain.model.Afro;

import java.util.List;

public interface AfroRepository {
    List<Afro> findAll();
}
