package pl.anita.taskmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.anita.taskmanager.model.Role;

/**
 * @author Anita Mueller
 */
public interface RoleRepository extends JpaRepository<Role, Long> {


}
