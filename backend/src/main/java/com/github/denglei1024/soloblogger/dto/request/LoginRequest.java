package com.github.denglei1024.soloblogger.dto.request;

import com.github.denglei1024.soloblogger.infrastructure.BaseRequest;
import lombok.Getter;

/**
 * LoginRequest
 *
 * @author dengl
 * @since 2024-06-01 21:49
 */
@Getter
public class LoginRequest extends BaseRequest {
    private String username;
    private String password;
}