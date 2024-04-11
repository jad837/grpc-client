package com.blogs.grpcclient.clients;

import com.blogs.user.GetUserRequest;
import com.blogs.user.User;
import com.blogs.user.UserServiceGrpc;
import io.grpc.ManagedChannel;
import org.springframework.stereotype.Component;

@Component
public class UserServiceClient {

    ManagedChannel userServiceChannel;
    UserServiceGrpc.UserServiceBlockingStub userServiceBlockingStub;

    public UserServiceClient(ManagedChannel userServiceChannel) {
        this.userServiceChannel = userServiceChannel;
        userServiceBlockingStub = UserServiceGrpc.newBlockingStub(userServiceChannel);
    }

    public User getUser(Long id) {
        var getUserRequest = GetUserRequest.newBuilder().setId(id).build();
        return userServiceBlockingStub.get(getUserRequest);
    }
}
