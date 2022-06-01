package com.bipin.bootjpa.user.service;

import com.bipin.bootjpa.user.controller.model.request.AddUserRequest;
import com.bipin.bootjpa.user.controller.model.request.UpdateUserRequest;
import com.bipin.bootjpa.user.controller.model.response.AddUserResponse;
import com.bipin.bootjpa.user.controller.model.response.GetAllUserResponse;
import com.bipin.bootjpa.user.controller.model.response.GetUserResponse;
import com.bipin.bootjpa.user.controller.model.response.UpdateUserResponse;

public interface UserService {
    AddUserResponse addUser(AddUserRequest request);

    UpdateUserResponse updateUser(UpdateUserRequest request, Integer id);

    GetUserResponse getUserById(Integer id);

    GetAllUserResponse getAllUser();

    void deleteUser(Integer id);
}
