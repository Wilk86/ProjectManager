package pl.anita.taskmanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.anita.taskmanager.repository.RoleRepository;
import pl.anita.taskmanager.repository.UserRepository;
import pl.anita.taskmanager.model.User;
import pl.anita.taskmanager.model.dto.UserDto;

import java.util.List;

/**
 * @author Anita Mueller
 */
@Service
public class UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;

    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }


    //wypis wszyskich uzytkownikwow
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // rejestracja user
    public User addUser(UserDto user){
        // utwórz obiekt User
        User registered_user = new User(user.getName(), user.getLastname(), user.getEmail(), user.getPassword());
        registered_user.addRole(roleRepository.getOne(1L));
        return userRepository.save(registered_user);
    }

    // logowanie user
    public String loginUser(String email, String password) {
        User user = userRepository.findFirstByEmailAndPassword(email, password);
        if (user == null) {
            return "Blad Logowania";
        }
        return "zarejstrowano" + user.toString();
    }

    // nowe Project



}
