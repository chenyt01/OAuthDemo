package com.demo.userservice.client.hystrix;


import com.demo.userservice.client.AuthServiceClient;
import com.demo.userservice.entity.JWT;
import org.springframework.stereotype.Component;

@Component
public class AuthServiceHystrix implements AuthServiceClient {
    @Override
    public JWT getToken(String authorization, String type, String username, String password) {
        return null;
    }
}
