package com.dat.LaLa_shop.service.impl;

import com.dat.LaLa_shop.dto.UserDto;
import com.dat.LaLa_shop.exceptions.AlreadyExistsException;
import com.dat.LaLa_shop.exceptions.ResourceNotFoundException;
import com.dat.LaLa_shop.model.User;
import com.dat.LaLa_shop.repository.UserRepository;
import com.dat.LaLa_shop.request.CreateUserRequest;
import com.dat.LaLa_shop.request.UserUpdateRequest;
import com.dat.LaLa_shop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User not found"));
    }

    @Override
    public User createUser(CreateUserRequest request) {
        return Optional.of(request)
                .filter(user -> !userRepository.existsByEmail(request.getEmail()))
                .map(req-> {
                    User user = new User();
                    user.setEmail(req.getEmail());
                    user.setPassword(passwordEncoder.encode(req.getPassword()));
                    user.setFirstName(req.getFirstName());
                    user.setLastName(req.getLastName());
                    return userRepository.save(user);
                })
                .orElseThrow(()-> new AlreadyExistsException("error"+ request.getEmail()+ "already exist"));
    }

    @Override
    public User updateUser(UserUpdateRequest updateRequest, Long userId) {
        return userRepository.findById(userId)
                .map(existUser-> {
                    existUser.setFirstName(updateRequest.getFirstName());
                    existUser.setLastName(updateRequest.getLastName());
                    return userRepository.save(existUser);
                }).orElseThrow(()-> new ResourceNotFoundException("user not found"));
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.findById(userId).ifPresentOrElse(userRepository ::delete, ()-> {
            throw  new ResourceNotFoundException("User not found");
        });

    }

    @Override
    public UserDto convertUserToDto(User user) {
        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public User getAuthenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        return userRepository.findByEmail(email);
    }


}
