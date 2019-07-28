package pl.anita.taskmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.anita.taskmanager.model.Project;
import pl.anita.taskmanager.model.Task;
import pl.anita.taskmanager.model.dto.ProjectDto;
import pl.anita.taskmanager.model.dto.TaskDto;
import pl.anita.taskmanager.repository.ProjectRepository;
import pl.anita.taskmanager.service.ProjectService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * @author Anita Mueller
 */
@RestController
public class ProjectController {


    private ProjectService projectService;
    private ProjectRepository projectRepository;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }


    @GetMapping("/project/{acronim}&{description}&{dateStart}&{dateStop}")
    public Project createNewProject(
            @PathVariable String acronim,
            @PathVariable String description,
            @PathVariable @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate dateStart,
            @PathVariable @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate dateStop

    ) {
        return projectService.createProject(new ProjectDto(acronim,
                description,
                dateStart,
                dateStop));
    }

    @GetMapping("/project/all")
    private List<Project> getAllProjects() {
        return projectService.getAllProjects();
    }

    @PostMapping("/project/update/{project_id}&{dateStop}")
    public Project changeProjectDeadline(

            @PathVariable Long project_id,
            @PathVariable @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate dateStop
    ) {

        return projectService.updateProjectStopDate(project_id, dateStop);
    }

    @PostMapping("/task/create/{titel}&{message}&{dateStart}&{interval}&{project_id}")
    public Task addTaskProject(
            @PathVariable String title,
            @PathVariable String message,
            @PathVariable @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate dateStart,
            @PathVariable Integer interval,
            @PathVariable Long project_id
    ) {
        return projectService.createTask(new TaskDto(
                title,message,dateStart,interval),project_id);
    }


}
