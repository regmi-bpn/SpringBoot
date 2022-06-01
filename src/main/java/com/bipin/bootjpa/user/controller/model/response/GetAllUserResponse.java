package com.bipin.bootjpa.user.controller.model.response;

import java.util.List;

public class GetAllUserResponse {

    public GetAllUserResponse() {
    }

    public GetAllUserResponse(List<GetUserResponse> users) {
        this.users = users;
    }

    private List<GetUserResponse> users;

    public List<GetUserResponse> getUsers() {
        return users;
    }

    public void setUsers(List<GetUserResponse> users) {
        this.users = users;
    }
}
