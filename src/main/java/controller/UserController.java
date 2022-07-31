package controller;

import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import services.UserService;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<HashMap<String, User>> getUsers(){
        return ResponseEntity.ok().body((userService.getUsers()));
    }

    @PostMapping("/new")
    public ResponseEntity<?> SignUp(@RequestBody User user){
        try {
            URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/newsave").toUriString());
            return ResponseEntity.created(uri).body(userService.signUp(user));
        } catch (RuntimeException exception){
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }
}
