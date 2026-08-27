
package com.app.ecom;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
     

    @GetMapping("/api/user")
    public ResponseEntity<List<User>> getAllUsers(){
        //return ResponseEntity.ok(userService.fetchAllUsers());
        return new ResponseEntity<>(userService.fetchAllUsers(), HttpStatus.OK);    
    }

    @PostMapping("api/user")
    public List<User> createUser(@RequestBody User user){
        userService.addUser(user);
        return userService.fetchAllUsers();
    }

    @GetMapping("api/user/{id}")
    public User createdUser(@PathVariable Long id){
            return userService.fetchAllUser(id);
    }

}
