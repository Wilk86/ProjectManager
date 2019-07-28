package pl.anita.taskmanager.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.anita.taskmanager.model.Project;
import pl.anita.taskmanager.model.Task;
import pl.anita.taskmanager.model.dto.ProjectDto;
import pl.anita.taskmanager.model.dto.TaskDto;
import pl.anita.taskmanager.repository.ProjectRepository;
import pl.anita.taskmanager.repository.TaskRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * @author Anita Mueller
 */
@Service
public class ProjectService {

    private ProjectRepository projectRepository;
    private TaskRepository taskRepository;

    @Autowired
    public ProjectService(ProjectRepository projectRepository, TaskRepository taskRepository) {
        this.projectRepository = projectRepository;
        this.taskRepository = taskRepository;
    }

    //utworz project
    public Project createProject(ProjectDto projectDto) {
        return projectRepository.save(new Project(
                projectDto.getAcronim(),
                projectDto.getDescription(),
                projectDto.getDateStart(),
                projectDto.getDateStop()
        ));
    }

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }
    //zmien data konca projektu

    public Project updateProjectStopDate(Long project_id, LocalDate dateStop){
        // pytamy o obiekt projektu po id
        Optional<Project> projectToUpdate = projectRepository.findById(project_id);
        if(projectToUpdate.isPresent()) {
            Project project = projectToUpdate.get();
            // zmieniamy deadline
            project.setDateStop(dateStop);
            // zapisujemy na tym samym obiekcie / update
            return projectRepository.save(project);
        }
        return new Project();
    }

    // dodaj nowego taska do projektu
    public Task createTask(TaskDto taskDto, Long project_id){
        // obiekt taska z przypisaniem do projektu
        Task task = new Task(
                taskDto.getTitle(),
                taskDto.getMessage(),
                taskDto.getDateStart(),
                taskDto.getInterval(),
                projectRepository.getOne(project_id));
        return taskRepository.save(task);

    }
    // usuń taska z projektu
    public Task removeTask(Long task_id){
        // wyszukaj task po id
        Task deleteTask =taskRepository.getOne(task_id);
        // usuwam obiekt
        taskRepository.delete(deleteTask);
        // zwracam usunięty obiekt
        return deleteTask;
    }

    // usuń  projektu i taska
    public Project removeProjectByRecursivle(long project_id){
        Project deleteProject = projectRepository.getOne(project_id);
        projectRepository.delete(deleteProject);

        return deleteProject;
    }

}
