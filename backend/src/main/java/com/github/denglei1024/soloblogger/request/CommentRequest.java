package com.github.denglei1024.soloblogger.request;

import com.github.denglei1024.soloblogger.infrastructure.BaseRequest;
import lombok.Getter;

/**
 * CommentRequest
 *
 * @author denglei
 * @since 2024-06-02 11:05
 */
@Getter
public class CommentRequest extends BaseRequest {
    private String content;
    private String author;
}