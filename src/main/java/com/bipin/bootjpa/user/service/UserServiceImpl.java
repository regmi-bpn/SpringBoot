package com.bipin.bootjpa.user.service;

import com.bipin.bootjpa.user.controller.model.request.AddUserRequest;
import com.bipin.bootjpa.user.controller.model.request.UpdateUserRequest;
import com.bipin.bootjpa.user.controller.model.response.AddUserResponse;
import com.bipin.bootjpa.user.controller.model.response.GetAllUserResponse;
import com.bipin.bootjpa.user.controller.model.response.GetUserResponse;
import com.bipin.bootjpa.user.controller.model.response.UpdateUserResponse;
import com.bipin.bootjpa.user.dao.UserEntity;
import com.bipin.bootjpa.user.dao.UserRepository;
import com.bipin.bootjpa.user.service.mapper.UserMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;

    public UserServiceImpl(UserMapper userMapper, UserRepository userRepository) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
    }

    @Override
    public AddUserResponse addUser(AddUserRequest request) {
        return userMapper.toAddResponse(userRepository.save(userMapper.toEntity(request)));
    }

    @Override
    public UpdateUserResponse updateUser(UpdateUserRequest request, Integer id) {
        UserEntity user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User with id:" + id + " not found"));
        return userMapper.toUpdateResponse(userRepository.save(userMapper.toEntity(request, user)));
    }

    @Override
    public GetUserResponse getUserById(Integer id) {
        UserEntity user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User with id:" + id + " not found"));
        return userMapper.toGetResponse(user);
    }

    @Override
    public GetAllUserResponse getAllUser() {
        return userMapper.toGetAllResponse(userRepository.findAll());
    }

    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }
}
