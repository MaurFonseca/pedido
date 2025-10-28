package com.api.pedido.service;


import com.api.pedido.exception.DataBaseException;
import com.api.pedido.exception.ResourceNotFoundException;
import com.api.pedido.model.User;
import com.api.pedido.model.dto.UserRequest;
import com.api.pedido.model.dto.UserResponse;
import com.api.pedido.model.dto.UserUpdateRequest;
import com.api.pedido.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public UserResponse toResponse(User user){
        return new UserResponse(
                user.getId(), user.getName(), user.getEmail(), user.getPhone()
        );
    }

    public List<UserResponse> findAll(){
        return userRepository.findAll().stream().map(this::toResponse).toList();
    }

    public UserResponse findById(Long id){
        return toResponse(userRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Resource not found, ID: "+ id + " Not Found")));
    }

    public UserResponse insert(UserRequest request){
        User user = User.builder()
                .name(request.name())
                .email(request.email())
                .phone(request.phone())
                .password(request.password())
                .build();
        userRepository.save(user);
        return toResponse(user);
    }

    public void delete(Long id){
        try {
            userRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException("Resource not found, ID: "+ id + " Not Found");
        }catch (DataIntegrityViolationException e){
            throw new DataBaseException(e.getMessage());
        }
    }

    public UserResponse update(Long id, UserUpdateRequest request){
        try {
            User user = userRepository.getReferenceById(id);
            updateUser(user, request);
            userRepository.save(user);
            return toResponse(user);
        }catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Resource not found, ID: "+ id + " Not Found");
        }
    }

    private User updateUser(User user, UserUpdateRequest request){
        user.setName(request.name());
        user.setEmail(request.email());
        user.setPhone(request.phone());
        return user;
    }

}
