package pl.anita.taskmanager.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Anita Mueller
 */
@Entity
@Table(name = "employee")
@Data // gettery i settery
@AllArgsConstructor // konstuktor
@NoArgsConstructor // konstuktor domysline
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employee_id;
    // dane wprowadzane przez user


    @NotBlank     // NN
    private String name;
    @NotBlank
    private String lastname;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    @Size(min = 6)
    @Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[0-9])(?=.*?[#]).{1,}$")
    private String password;

    //Kostuktor do rejestracje User
    public User(@NotBlank String name, @NotBlank String lastname, @NotBlank @Email String email, @NotBlank @Size(min = 6) @Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[0-9])(?=.*?[#]).{1,}$") String password) {
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
    }

    // dane generowane automatycznie
    private LocalDateTime registratin_datetime = LocalDateTime.now();
    //Relacja n:m user to role
    @ManyToMany
    @JoinTable( //adnotacia zlaczajne table na posdstawie id
            name = "employee_role",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    @JsonIgnore
    private Set<Role> roles = new HashSet<>();

    public void addRole(Role role) {
        this.roles.add(role);


    }
}
