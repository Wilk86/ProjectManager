package pl.anita.taskmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.anita.taskmanager.model.Task;

/**
 * @author Anita Mueller
 */
@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {


}
