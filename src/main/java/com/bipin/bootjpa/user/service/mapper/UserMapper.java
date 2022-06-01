package com.bipin.bootjpa.user.service.mapper;

import com.bipin.bootjpa.user.controller.model.request.AddUserRequest;
import com.bipin.bootjpa.user.controller.model.request.UpdateUserRequest;
import com.bipin.bootjpa.user.controller.model.response.AddUserResponse;
import com.bipin.bootjpa.user.controller.model.response.GetAllUserResponse;
import com.bipin.bootjpa.user.controller.model.response.GetUserResponse;
import com.bipin.bootjpa.user.controller.model.response.UpdateUserResponse;
import com.bipin.bootjpa.user.dao.UserEntity;
import org.h2.security.SHA256;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Component
public class UserMapper {

    public UserEntity toEntity(AddUserRequest request) {
        UserEntity user = new UserEntity();
        user.setUsername(request.getUsername());
        user.setPassword(Base64.getEncoder().encodeToString(SHA256.getHash(request.getPassword().getBytes(), false)));
        return user;
    }

    public AddUserResponse toAddResponse(UserEntity user) {
        AddUserResponse response = new AddUserResponse();
        response.setId(user.getId());
        response.setUsername(user.getUsername());
        return response;
    }

    public UserEntity toEntity(UpdateUserRequest request, UserEntity user) {
        user.setPassword(Base64.getEncoder().encodeToString(SHA256.getHash(request.getPassword().getBytes(), false)));
        return user;
    }

    public UpdateUserResponse toUpdateResponse(UserEntity user) {
        UpdateUserResponse response = new UpdateUserResponse();
        response.setId(user.getId());
        response.setUsername(user.getUsername());
        return response;
    }

    public GetUserResponse toGetResponse(UserEntity user) {
        GetUserResponse response = new GetUserResponse();
        response.setId(user.getId());
        response.setUsername(user.getUsername());
        return response;

    }

    public GetAllUserResponse toGetAllResponse(List<UserEntity> users) {
        List<GetUserResponse> responseList = new ArrayList<>();
        for (UserEntity user : users) responseList.add(toGetResponse(user));
        return new GetAllUserResponse(responseList);
    }

}
