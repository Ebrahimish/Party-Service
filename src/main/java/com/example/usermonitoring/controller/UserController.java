package com.example.usermonitoring.controller;


import com.example.usermonitoring.dto.UserRequest;
import jakarta.validation.Valid;
import java.util.List;
import com.example.usermonitoring.entity.User;
import com.example.usermonitoring.service.UserService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
public class UserController {


    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/native/{nationalId}")
    public User findNative(
            @PathVariable String nationalId){

        return userService.findNativeByNationalId(nationalId);

    }


   @GetMapping("/national/{nationalId}")
   public User findByNationalId(
            @PathVariable String nationalId){

        return userService.findByNationalId(nationalId);

    }


    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {

       return userService.findById(id);

    }

    @PostMapping
    public User createUser(
            @Valid @RequestBody UserRequest request) {

        return userService.saveUser(request);
    }
    @GetMapping
    public List<User> getAllUsers() {
        return userService.findAllUsers();
    }


}