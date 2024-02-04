package com.blogs.grpcclient.config;

import io.grpc.Channel;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.blogs.user.UserServiceGrpc.UserServiceBlockingStub;

@Configuration
public class GrpcServerConfig {

    @Bean
    public ManagedChannel createChannel() {
        return ManagedChannelBuilder.forAddress("127.0.0.1", 9090).usePlaintext().build();
    }

}
