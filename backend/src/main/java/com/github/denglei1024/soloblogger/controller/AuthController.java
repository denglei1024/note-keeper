package com.github.denglei1024.soloblogger.controller;

import com.github.denglei1024.soloblogger.domain.user.User;
import com.github.denglei1024.soloblogger.dto.request.ChangePasswordRequest;
import com.github.denglei1024.soloblogger.dto.request.LoginRequest;
import com.github.denglei1024.soloblogger.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * AuthController
 *
 * @author dengl
 * @since 2024-06-01 21:47
 */
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Resource
    private PasswordEncoder passwordEncoder;
    @Resource
    private UserRepository userRepository;
    @Resource
    private AuthenticationManager authenticationManager;

    @RequestMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request){
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword());
        Authentication authentication = authenticationManager.authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return ResponseEntity.ok("登录成功");
    }

    @RequestMapping("/change-password")
    public ResponseEntity<String> changePassword(@RequestBody ChangePasswordRequest request){
        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(!passwordEncoder.matches(request.getOldPassword(), currentUser.getPassword())){
            return ResponseEntity.badRequest().body("原密码错误");
        }
        currentUser.setPassword(passwordEncoder.encode(request.getNewPassword()));
        userRepository.save(currentUser);
        return ResponseEntity.ok("密码修改成功");
    }

}