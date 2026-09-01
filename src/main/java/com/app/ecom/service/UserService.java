package com.app.ecom.service;

import java.util.Optional;
import java.util.stream.Stream; 
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;
import com.app.ecom.model.User;
import com.app.ecom.model.Address;
import com.app.ecom.model.UserRole;
import com.app.ecom.repository.UserRepository;
import com.app.ecom.dto.UserRequest;
import com.app.ecom.dto.UserResponse;
import com.app.ecom.dto.AddressDTO;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<UserResponse> fetchAllUsers() {
        return userRepository.findAll().stream()
                            .map(this::mapToUserResponse)
                            .collect(Collectors.toList());
    }

    public void  addUser(UserRequest userRequest){
        User user = new User();
        updateUserFromRequest(user, userRequest);
        userRepository.save(user);

    }

   public Optional<UserResponse> fetchAllUser(Long id) {
    return userRepository.findById(id)
                        .map(this::mapToUserResponse);
  
}

public Boolean  updateUser(Long id, UserRequest updatedUserRequest){
        return userRepository.findById(id)
                .map(existingUser -> {
                    updateUserFromRequest(existingUser, updatedUserRequest);
                    userRepository.save(existingUser);
                    return true;
                })
                .orElse(false);

    }
private void updateUserFromRequest(User user, UserRequest userRequest) {
    user.setFname(userRequest.getFname());
    user.setLname(userRequest.getLname());
    user.setEmail(userRequest.getEmail());
    user.setPhone(userRequest.getPhone());
    if (userRequest.getAddress() != null) {
        Address address = new Address();
        address.setStreet(userRequest.getAddress().getStreet());
        address.setCity(userRequest.getAddress().getCity());
        address.setState(userRequest.getAddress().getState());
        address.setZipcode(userRequest.getAddress().getZipcode());
        user.setAddress(address);
    }
    
}
private UserResponse mapToUserResponse(User user){
    UserResponse userResponse = new UserResponse();
    userResponse.setId(String.valueOf(user.getId()));
    userResponse.setFname(user.getFname());
    userResponse.setLname(user.getLname());
    userResponse.setEmail(user.getEmail());
    userResponse.setPhone(user.getPhone());
    userResponse.setRole(user.getRole());
    if(user.getAddress() != null){
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setStreet(user.getAddress().getStreet());
        addressDTO.setCity(user.getAddress().getCity());
        addressDTO.setState(user.getAddress().getState());
        addressDTO.setZipcode(user.getAddress().getZipcode());
        userResponse.setAddress(addressDTO);
    }
    return userResponse;
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