package com.simba68.sbusersservices.services;

import com.simba68.sbusersservices.dto.requests.RequestLoginDto;
import com.simba68.sbusersservices.dto.requests.RequestRegisterDto;
import com.simba68.sbusersservices.dto.responses.ResponseLoginDto;

public interface UserService {
    ResponseLoginDto login(RequestLoginDto requestLoginDto);

    Object register(RequestRegisterDto requestRegisterDto);
}
