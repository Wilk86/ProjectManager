package pl.anita.taskmanager.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * @author Anita Mueller
 */
@Data
@AllArgsConstructor
public class UserDto {

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

}
