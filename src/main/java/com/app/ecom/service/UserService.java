package com.app.ecom.service;

// Add these exact lines at the top:
import java.util.Optional;
import java.util.stream.Stream; 
import java.util.stream.Collectors; // (Include this if you are collecting streams to lists)
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;
import com.app.ecom.model.User;
import com.app.ecom.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> fetchAllUsers() {
        return userRepository.findAll();
    }

    public void  addUser(User user){
       userRepository.save(user);

    }

   public Optional<User> fetchAllUser(Long id) {
    return userRepository.findById(id);
  
}

public Boolean  updateUser(Long id, User user){
        return userRepository.findById(id)
                .map(exitingUser -> {
                    exitingUser.setFname(user.getFname());
                    exitingUser.setLname(user.getLname());
                    userRepository.save(exitingUser);
                    return true;
                })
                .orElse(false);


    }
    
}
/***
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


****/