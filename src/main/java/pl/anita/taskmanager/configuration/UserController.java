package pl.anita.taskmanager.configuration;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Anita Mueller
 */

// naslochiwanie na zadania projektu http
@RestController
public class UserController {

    //zadania http GET, POST, PUT, DELETE
    @GetMapping("/")
    public String getName() {
        return "Hallo";


    }
    @GetMapping("/")
    public String getUserName(){
        
    }



}
