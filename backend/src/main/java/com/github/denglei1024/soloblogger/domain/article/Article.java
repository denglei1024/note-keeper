package com.github.denglei1024.soloblogger.domain.article;

import com.github.denglei1024.soloblogger.infrastructure.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Article
 *
 * @author denglei
 * @since 2024-06-01 22:51
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "articles")
public class Article extends BaseModel {
    @Id
    private String id;
    private String title;
    private String tag;
    private String content;
    private String author;
}