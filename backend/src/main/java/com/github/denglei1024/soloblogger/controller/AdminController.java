package com.github.denglei1024.soloblogger.controller;

import com.github.denglei1024.soloblogger.dto.request.AdminSetupRequest;
import com.github.denglei1024.soloblogger.domain.user.User;
import com.github.denglei1024.soloblogger.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * AdminController
 *
 * @author denglei
 * @since 2024-05-31 18:01
 */
@RestController
@RequestMapping("/api/admin")
public class AdminController {
    @Resource
    private UserRepository userRepository;

    @Resource
    private PasswordEncoder passwordEncoder;

    public ResponseEntity<String> setupAdmin(@RequestBody AdminSetupRequest request){
        //检查是否存在博主账户
        User admin = userRepository.findByUsername("admin");
        if(!Objects.isNull(admin)){
            return ResponseEntity.badRequest().body("博主账户已存在");
        }

        //创建博主账户
        User newAdmin = new User();
        newAdmin.setUsername("admin");
        newAdmin.setPassword(passwordEncoder.encode(request.getPassword()));
        newAdmin.setAdmin(true);
        userRepository.save(newAdmin);

        return ResponseEntity.ok("创建成功");
    }
}