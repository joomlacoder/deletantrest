package xyz.ignatev.deletantrest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.ignatev.deletantrest.entity.User;
import xyz.ignatev.deletantrest.service.UserService;

@RestController
@RequestMapping(value = "/subscription")
public class SubscriptionController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> sub(@RequestBody User user) {
        System.out.println(user);
        userService.addUser(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/{code}")
    public ResponseEntity<String> activete(@PathVariable String code) {
        ResponseEntity<String> response;
        if (userService.activateUser(code))
            response = new ResponseEntity<>("ok", HttpStatus.OK);
        else
            response = new ResponseEntity<>("no user", HttpStatus.NOT_FOUND);
        return response;
    }
}
