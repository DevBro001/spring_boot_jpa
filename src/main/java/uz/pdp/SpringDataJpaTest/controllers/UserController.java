package uz.pdp.SpringDataJpaTest.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import uz.pdp.SpringDataJpaTest.dto.ErrorBodyDto;
import uz.pdp.SpringDataJpaTest.exception.UsernameOrPasswordWrong;
import uz.pdp.SpringDataJpaTest.model.User;
import uz.pdp.SpringDataJpaTest.repositories.UserRepository;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/register")
    public User register(@RequestBody User user){
        User save = userRepository.save(user);
        return user;
    }
    @PostMapping("/login")
    public User register(@RequestParam("username")String username, @RequestParam("password")String password){
        User user = userRepository.findFirstByUsernameAndPassword(username, password)
                .orElseThrow(()->
                        new UsernameOrPasswordWrong("Your username or password not correct.",HttpStatus.NOT_FOUND));
        return user;
    }



    /**
     * Per Exception
     * Controller Exception Handler
     * Global Exception Handler
     */
}
