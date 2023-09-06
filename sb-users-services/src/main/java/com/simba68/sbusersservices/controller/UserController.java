package com.simba68.sbusersservices.controller;

import com.simba68.sbusersservices.dto.requests.RequestLoginDto;
import com.simba68.sbusersservices.dto.requests.RequestRegisterDto;
import com.simba68.sbusersservices.dto.responses.ResponseLoginDto;
import com.simba68.sbusersservices.dto.responses.ResponseRegisterDto;
import com.simba68.sbusersservices.entity.User;
import com.simba68.sbusersservices.factory.ResponseFactory;
import com.simba68.sbusersservices.repo.UserRepo;
import com.simba68.sbusersservices.services.JwtService;
import com.simba68.sbusersservices.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final ResponseFactory responseFactory;
    private final UserService userService;
    private final UserRepo userRepo;

    @GetMapping
    public ResponseEntity<?> test(){
        return responseFactory.success(userRepo.findAll(), List.class);
    }

    @PostMapping
    public ResponseEntity<?> login(@RequestBody RequestLoginDto requestLoginDto){
        return responseFactory.success(userService.login(requestLoginDto), ResponseLoginDto.class);
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RequestRegisterDto requestRegisterDto){
        return responseFactory.success(userService.register(requestRegisterDto), Boolean.class);
    }

}
