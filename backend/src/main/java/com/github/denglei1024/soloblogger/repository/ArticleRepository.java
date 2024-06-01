package com.github.denglei1024.soloblogger.repository;

import com.github.denglei1024.soloblogger.domain.article.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

/**
 * ArticleRepository
 *
 * @author denglei
 * @since 2024-06-01 23:03
 */
public interface ArticleRepository extends MongoRepository<Article, String> {
    @Query("{ 'tags' : { $regex: ?0, $options: 'i' } }")
    Page<Article> findByTagsContaining(String tag, Pageable pageable);

    @Query("{ '$text': { $search: ?0 } }")
    List<Article> searchArticles(String text);
}