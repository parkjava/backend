package com.parkjava.controller;

import com.parkjava.DTO.JwtToken;
import com.parkjava.DTO.SecurityUtil;
import com.parkjava.DTO.SignInDto;
import com.parkjava.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

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

        return jwtToken;
    }

    @GetMapping("/test")
    public String test() {
        return SecurityUtil.getCurrentUsername();
    }

    @GetMapping("/info")
    public String info() {
        return SecurityUtil.getCurrentUsername();
    }

}
