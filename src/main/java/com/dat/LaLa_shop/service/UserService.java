package com.dat.LaLa_shop.service;

import com.dat.LaLa_shop.dto.UserDto;
import com.dat.LaLa_shop.model.User;
import com.dat.LaLa_shop.request.CreateUserRequest;
import com.dat.LaLa_shop.request.UserUpdateRequest;

public interface UserService {
    User getUserById(Long userId);

    User createUser(CreateUserRequest request);

    User updateUser(UserUpdateRequest updateRequest, Long userId);

    void deleteUser(Long userId);

    UserDto convertUserToDto(User user);

    User getAuthenticatedUser();


}
