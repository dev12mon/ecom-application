package com.app.ecom;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
// Add these exact lines at the top:
import java.util.Optional;
import java.util.stream.Stream; 
import java.util.stream.Collectors; // (Include this if you are collecting streams to lists)

@Service
public class UserService {

    private List<User> userList = new ArrayList<User>();
    private  Long nextId = 1L;

    public List<User> fetchAllUsers() {
        return userList;
    }

    public void  addUser(User user){
        user.setId(nextId++);
        userList.add(user);

    }

   public Optional<User> fetchAllUser(Long id) {
    return userList.stream()
                    .filter(user -> user.getId().equals(id)) //  Fixed syntax
                    .findFirst();
}

public Boolean  updateUser(Long id, User user){
        return userList.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst()
                .map(exitingUser -> {
                    exitingUser.setFname(user.getFname());
                    exitingUser.setLname(user.getLname());
                    return true;
                })
                .orElse(false);


    }
    
}
