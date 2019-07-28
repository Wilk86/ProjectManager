package pl.anita.taskmanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.anita.taskmanager.model.Task;
import pl.anita.taskmanager.model.dto.TaskDto;
import pl.anita.taskmanager.repository.TaskRepository;

/**
 * @author Anita Mueller
 */
@Service
public class TaskService {

    private TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    //utworz nowy Task




}
