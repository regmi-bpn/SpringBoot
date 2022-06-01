package com.bipin.bootjpa.user.controller;

import com.bipin.bootjpa.user.controller.model.request.AddUserRequest;
import com.bipin.bootjpa.user.controller.model.request.UpdateUserRequest;
import com.bipin.bootjpa.user.controller.model.response.AddUserResponse;
import com.bipin.bootjpa.user.controller.model.response.GetAllUserResponse;
import com.bipin.bootjpa.user.controller.model.response.GetUserResponse;
import com.bipin.bootjpa.user.controller.model.response.UpdateUserResponse;
import com.bipin.bootjpa.user.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public GetAllUserResponse getAllUser() {
        return userService.getAllUser();
    }

    @GetMapping("/{id}")
    public GetUserResponse getUserById(@PathVariable("id") Integer id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public AddUserResponse saveUser(@RequestBody AddUserRequest request) {
        return userService.addUser(request);
    }

    @PutMapping("/{id}")
    public UpdateUserResponse updateUser(@RequestBody UpdateUserRequest request, @PathVariable("id") Integer id) {
        return userService.updateUser(request, id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Integer id) {
        userService.deleteUser(id);
    }
}
