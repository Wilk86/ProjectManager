package pl.anita.taskmanager.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Anita Mueller
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long project_id;
    @NotBlank
    private String acronim;
    @NotBlank
    @Column(columnDefinition = "text")
    private String description;
    @NotNull
    private LocalDate dateStart;
    @NotNull
    private LocalDate dateStop;
    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,
            mappedBy = "project")
    private List<Task> tasks = new ArrayList<>();

    public Project(@NotBlank String acronim, @NotBlank String description, @NotBlank LocalDate dateStart, @NotBlank LocalDate dateStop) {
        this.acronim = acronim;
        this.description = description;
        this.dateStart = dateStart;
        this.dateStop = dateStop;
    }


}
