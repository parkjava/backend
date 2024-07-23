package com.parkjava.controller;

import com.parkjava.DTO.JwtToken;
import com.parkjava.DTO.SecurityUtil;
import com.parkjava.DTO.SignInDto;
import com.parkjava.JWT.JwtAuthenticationFilter;
import com.parkjava.model.Member;
import com.parkjava.model.adminModel;
import com.parkjava.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
class MemberController {

    private final MemberService memberService;

    @PostMapping("/signIn")
    public JwtToken signIn(@RequestBody SignInDto signInDto) {
        String username = signInDto.getUsername();
        String password = signInDto.getPassword();
        JwtToken jwtToken = memberService.signIn(username, password);
        log.info("request username = {}, password = {}", username, password);
        log.info("jwtToken accessToken = {}, refreshToken = {}", jwtToken.getAccessToken(), jwtToken.getRefreshToken());
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.add(httpHeaders.AUTHORIZATION, "Bearer" + jwtToken);
        return jwtToken;
    }

    @GetMapping("/test")
    public String test() {
        return "안녕하세요! " + SecurityUtil.getCurrentUsername() + "님" ;
    }

}
