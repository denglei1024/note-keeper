package com.github.denglei1024.soloblogger.repository;

import com.github.denglei1024.soloblogger.domain.article.Comment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * CommnetRepository
 *
 * @author dengl
 * @since 2024-06-02 10:52
 */
@Repository
public interface CommentRepository extends MongoRepository<Comment, String> {
    List<Comment> findByArticleId(String articleId);
}
