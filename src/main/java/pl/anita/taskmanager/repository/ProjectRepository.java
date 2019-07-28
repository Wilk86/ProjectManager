package pl.anita.taskmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.anita.taskmanager.model.Project;

/**
 * @author Anita Mueller
 */
@Repository
public interface ProjectRepository extends JpaRepository<Project,Long > {



}
