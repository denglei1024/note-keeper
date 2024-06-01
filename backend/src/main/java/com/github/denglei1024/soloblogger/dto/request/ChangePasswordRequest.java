package com.github.denglei1024.soloblogger.dto.request;

import com.github.denglei1024.soloblogger.infrastructure.BaseRequest;
import lombok.Getter;

/**
 * ChangePasswordRequest
 *
 * @author denglei
 * @since 2024-06-01 22:34
 */
@Getter
public class ChangePasswordRequest extends BaseRequest {
    private String oldPassword;
    private String newPassword;
}