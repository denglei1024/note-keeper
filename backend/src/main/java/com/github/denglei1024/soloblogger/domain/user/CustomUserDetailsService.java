package com.github.denglei1024.soloblogger.domain.user;

import com.github.denglei1024.soloblogger.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * CustomUserDetailsService
 *
 * @author dengl
 * @since 2024-06-01 21:33
 */
@Service
@Slf4j
public class CustomUserDetailsService implements UserDetailsService {

    @Resource
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if(Objects.isNull(user)){
            throw new UsernameNotFoundException("用户不存在");
        }
        return new CustomUserDetails(user);
    }
}