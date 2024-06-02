package com.github.denglei1024.soloblogger.request;

import com.github.denglei1024.soloblogger.infrastructure.BaseRequest;
import lombok.Getter;

/**
 * AdminSetupRequest
 *
 * @author dengl
 * @since 2024-06-01 15:51
 */
@Getter
public class AdminSetupRequest extends BaseRequest {
    private String password;
}