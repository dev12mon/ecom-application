
package com.app.ecom;

import java.util.List;
import org.springframework.http.HttpStatus;

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
    public ResponseEntity<String> createUser(@RequestBody User user){
        userService.addUser(user);
        return ResponseEntity.ok("User added Successsfully");
    }

    @GetMapping("api/user/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id){
          /* User user = UserService.fetchAllUser(id);
           if(user == null){
            return ResponseEntity.notFound().build();
           }
        return ResponseEntity.ok(user);*/

        return userService.fetchAllUser(id)
                        .map(ResponseEntity::ok)
                        .orElseGet(retrn ResponseEntity.notFound().build());
    }

}
