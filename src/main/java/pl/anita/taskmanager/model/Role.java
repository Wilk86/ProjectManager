package pl.anita.taskmanager.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Anita Mueller
 */
@Entity
public class Role {
    @Id                                                      //PK
    @GeneratedValue(strategy = GenerationType.IDENTITY)      //AutoImp
    private Long role_id;
    private String roleName;

}
