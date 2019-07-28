package pl.anita.taskmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.anita.taskmanager.model.User;
import pl.anita.taskmanager.model.dto.UserDto;
import pl.anita.taskmanager.service.UserService;

import java.util.List;

/**
 * @author Anita Mueller
 */

// naslochiwanie na zadania projektu http
@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //zadania http GET, POST, PUT, DELETE
    @GetMapping("/")
    public String getName() {
        return "Hallo";


    }

    @GetMapping("/user/{user_name}")
    public String getUserName(@PathVariable String user_name) {

        return "Hallo " + user_name;
    }

    @GetMapping("/user")
    private List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/register/{name}&{lastname}&{email}&{password}")
    private User addUser(
            @PathVariable String name,
            @PathVariable String lastname,
            @PathVariable String email,
            @PathVariable String password
    ) {
        return userService.addUser(new UserDto(name, lastname, email, password));
    }

    @GetMapping("/login_user/{email}&{password}")
    private String login(
            @PathVariable String email,
            @PathVariable String password
    ) {
        return userService.loginUser(email, password);
    }



}
