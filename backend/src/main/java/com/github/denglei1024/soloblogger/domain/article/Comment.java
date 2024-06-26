package com.github.denglei1024.soloblogger.domain.article;

import com.github.denglei1024.soloblogger.infrastructure.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Comment
 *
 * @author denglei
 * @since 2024-06-02 10:51
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "comments")
public class Comment extends BaseModel {
    @Id
    private String id;
    private String content;
    private String author;
    private String articleId;
}