package io.github.untalsanders.afrominga.application.service;

import io.github.untalsanders.afrominga.domain.Task;
import io.github.untalsanders.afrominga.domain.service.TaskService;

import java.util.ArrayList;
import java.util.List;

public class TaskServiceImpl implements TaskService {

    @Override
    public List<Task> getAll() {
        List<Task> taskList = new ArrayList<>();
        taskList.add(new Task(1L, "Primera tarea"));
        taskList.add(new Task(2L, "Segunda tarea"));
        return taskList;
    }
}
