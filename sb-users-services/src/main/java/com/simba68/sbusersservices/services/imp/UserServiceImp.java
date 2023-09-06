package com.simba68.sbusersservices.services.imp;

import com.simba68.sbusersservices.dto.requests.RequestLoginDto;
import com.simba68.sbusersservices.dto.requests.RequestRegisterDto;
import com.simba68.sbusersservices.dto.responses.ResponseLoginDto;
import com.simba68.sbusersservices.entity.Role;
import com.simba68.sbusersservices.entity.User;
import com.simba68.sbusersservices.repo.RoleRepo;
import com.simba68.sbusersservices.repo.UserRepo;
import com.simba68.sbusersservices.services.JwtService;
import com.simba68.sbusersservices.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImp implements UserService {
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final UserRepo userRepo;
    private final RoleRepo roleRepo;
    @Override
    public ResponseLoginDto login(RequestLoginDto requestLoginDto) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                requestLoginDto.getUsername(),
                requestLoginDto.getPassword()
        ));
        return ResponseLoginDto
                .builder()
                .token(jwtService.generateJwtToken(requestLoginDto.getUsername()))
                .build();
    }

    @Override
    public Object register(RequestRegisterDto requestRegisterDto) {
        User user = new User();
        user.setUsername(requestRegisterDto.getUsername());
        user.setPassword(passwordEncoder.encode(requestRegisterDto.getPassword()));
        user.setFirstName(requestRegisterDto.getFirstName());
        user.setLastName(requestRegisterDto.getLastName());

        Role role1 = roleRepo.findById(1L).get();
        Role role2 = roleRepo.findById(2L).get();
        Set<Role> roleSet= new HashSet<>();
        roleSet.add(role1);
        roleSet.add(role2);
        user.setRoles(roleSet);
        try {
            userRepo.save(user);
            return true;
        }catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("register got some error!!!");
        }

    }
}
