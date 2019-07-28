package pl.anita.taskmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.anita.taskmanager.model.User;

/**
 * @author Anita Mueller
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findFirstByEmailAndPassword(String email, String password);

}
