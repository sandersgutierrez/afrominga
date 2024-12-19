package io.github.untalsanders.afrominga.domain.usecase;

import io.github.untalsanders.afrominga.domain.model.Task;

import java.util.List;

public interface RetrieveTaskUseCase {
    List<Task> getAll();
}
