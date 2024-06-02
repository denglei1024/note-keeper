package com.github.denglei1024.soloblogger.request;

import com.github.denglei1024.soloblogger.infrastructure.BaseRequest;
import lombok.Getter;

/**
 * ArticleRequest
 *
 * @author denglei
 * @since 2024-06-01 23:07
 */
@Getter
public class ArticleRequest extends BaseRequest {
    private String title;
    private String content;
    private String author;
}